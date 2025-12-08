package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/rating")
public class RatingController {
    @PostMapping("/rate")
    public String AddRating(@RequestBody short rate) {
        return "redirect:/user/produtos";
    }
}
