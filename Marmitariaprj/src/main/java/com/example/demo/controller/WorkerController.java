package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Worker;
import com.example.demo.service.ProductService;
import com.example.demo.service.WorkerService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Product;

@Controller
@RequestMapping("/worker")
public class WorkerController {
  ProductService productService;
  WorkerService workerService;

    public WorkerController(ProductService productService, WorkerService workerService) {
        this.productService = productService;
        this.workerService = workerService;
    }
  
  @GetMapping("/produtos")
  public ModelAndView ProdMan(){
    ModelAndView mv = new ModelAndView("worker/produtos");
    mv.addObject("marmitas", productService.getAll());
    mv.addObject("cadMarmita", new Product());
    return mv;
  }

  @GetMapping("/funcionarios")
  public ModelAndView workersControllPanel(){
    ModelAndView mv = new ModelAndView("worker/funcionarios");
    mv.addObject("funcionarios", workerService.getAll());
    mv.addObject("cadFuncionario", new Worker());
    return mv;
  }

  @GetMapping("/login")
  public ModelAndView loginview(){
    workerService.saveDefault();
    ModelAndView mv = new ModelAndView("worker/login");
    mv.addObject("worker",new Worker());
    return mv;
  }
  
  @PostMapping("/login")
  @ResponseBody
  public Worker login(@RequestBody Worker worker){
    List<Worker> clients= workerService.getAll();
    System.out.println("usuario recebido "+worker.toString());
    for (Worker i : clients) {
      if (i.getEmail().equals(worker.getEmail()) && i.getPassword().equals(worker.getPassword())){
        System.out.println(i.toString());
        return i;
      }
    }
    return null;
  }

  @PostMapping("/funcionarios")
    public String singUp(Worker worker){
    List<Worker> workers= workerService.getAll(); 
    for (Worker i : workers) {
        if(i.getEmail().equals(worker.getEmail())){
          return "redirect:/worker/funcionarios";
        }
    }
    workerService.save(worker);
    return "redirect:/worker/funcionarios";
  }

  @PostMapping("/produtos")
  public String createProduct(Product product){
    productService.save(product);
    return "redirect:/worker/produtos";
  }

  @DeleteMapping("/produtos/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
    productService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
