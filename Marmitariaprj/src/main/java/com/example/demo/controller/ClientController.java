package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Client;
import com.example.demo.model.LoggedClient;
import com.example.demo.service.ClientService;

@Controller
public class ClientController{
  
  private final ClientService clientService;
  
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }
  
  @GetMapping("/")
  public ModelAndView create(){
    ModelAndView mv = new ModelAndView("index");
    mv.addObject("client", new Client());
    return mv;
  }

  @PostMapping("/")
  public String singUp(Client client){
    List<Client> clients= clientService.getAll(); 
    for (Client i : clients) {
        if(i.getEmail().equals(client.getEmail())){
          return "/";
        }
    }
    clientService.save(client);
    return "redirect:/login";
  }

  @GetMapping("/login")
  public ModelAndView loginpage(){
    ModelAndView mv = new ModelAndView("login");
    mv.addObject("client",new Client());
    return mv;
  }
  
  @PostMapping("/login")
  public String login(Client client){
    List<Client> clients= clientService.getAll();
    for (Client i : clients) {
      if (i.getEmail().equals(client.getEmail()) && i.getPassword().equals(client.getPassword())){
        System.out.println(i.toString());
        LoggedClient.setlogged(i);
        return "redirect:/produtos";
      }
      System.out.println("usuario registrado "+i.toString());
    }
    System.out.println("usuario não registrado "+client.toString());
    return "/login";
  }

  @GetMapping("/logout")
  public String logout(){
    LoggedClient.setlogged(new Client());
    return "redirect:/login";
  } 
  
  @GetMapping("/carrinho")
  public ModelAndView cart(){
    ModelAndView mv = new ModelAndView("carrinho");
    mv.addObject("logged", LoggedClient.getlogged());
    return mv;
  }
}
