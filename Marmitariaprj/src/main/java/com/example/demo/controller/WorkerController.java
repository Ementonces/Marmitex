package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.ProductService;

@Controller
public class WorkerController {
  ProductService productService;

    public WorkerController(ProductService productService) {
        this.productService = productService;
    }
  
  @GetMapping("/prodlog")
  public ModelAndView ProdMan(){
    ModelAndView mv = new ModelAndView("prodlog");
    mv.addObject("marmitas", productService.getAll());
    return mv;
  }
}
