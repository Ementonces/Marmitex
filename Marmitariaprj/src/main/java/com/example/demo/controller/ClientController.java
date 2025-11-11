package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

@Controller
public class ClientController{
  
    private final ClientService clientService;
  
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping("/")
  public String index(){
    return "index";
  }
  
  @GetMapping("/cadastro")
  public ModelAndView create(){
    ModelAndView mv = new ModelAndView("singup");
    mv.addObject("client", new Client());
    return mv;
  }

  @PostMapping("/cadastro")
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
  @ResponseBody
  public Client login(@RequestBody Client client){
    List<Client> clients= clientService.getAll();
    System.out.println("usuario recebido "+client.toString());
    for (Client i : clients) {
      if (i.getEmail().equals(client.getEmail()) && i.getPassword().equals(client.getPassword())){
        System.out.println(i.toString());
        return i;
      }
    }
    return null;
  }

  @GetMapping("/logout")
  public String logout(){
    return "redirect:/login";
  } 
  
  @GetMapping("/carrinho")
  public ModelAndView cart(){
    ModelAndView mv = new ModelAndView("carrinho");
    return mv;
  }
}
