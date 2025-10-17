package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.LoggedClient;
import com.example.demo.service.MarmitaService;

@Controller
public class MarmitaController {
  public final MarmitaService marmitaService;

  public MarmitaController(MarmitaService marmitaService) {
    this.marmitaService = marmitaService;
  }
  
  @GetMapping("/produtos")
  public ModelAndView showMarmitas(){
    ModelAndView mv = new ModelAndView("produtos");
    mv.addObject("marmitas", marmitaService.getAll());
    mv.addObject("logged", LoggedClient.getlogged());
    return mv;
  }
}
