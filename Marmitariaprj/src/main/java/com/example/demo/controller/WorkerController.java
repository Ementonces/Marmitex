package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Worker;
import com.example.demo.service.ProductService;
import com.example.demo.service.WorkerService;

@Controller
public class WorkerController {
  ProductService productService;
  WorkerService workerService;

    public WorkerController(ProductService productService, WorkerService workerService) {
        this.productService = productService;
        this.workerService = workerService;
    }
  
  @GetMapping("/prodlog")
  public ModelAndView ProdMan(){
    ModelAndView mv = new ModelAndView("prodlog");
    mv.addObject("marmitas", productService.getAll());
    return mv;
  }
  
  @PostMapping("/logworker")
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
}
