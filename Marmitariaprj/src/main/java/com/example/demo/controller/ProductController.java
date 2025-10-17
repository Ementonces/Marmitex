package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.ProductService;

@Controller
public class ProductController {
  public final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }
  
  @GetMapping("/produtos")
  public ModelAndView showProducts(){
    ModelAndView mv = new ModelAndView("produtos");
    mv.addObject("products", productService.getAll());
    return mv;
  }
}
