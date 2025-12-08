package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.ProductService;
import com.example.demo.service.RatingService;


@Controller
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;
    private final ProductService productService;

    public RatingController(ProductService productService, RatingService ratingService) {
        this.productService = productService;
        this.ratingService = ratingService;
    }

    @GetMapping("/rate/{id}")
    public ModelAndView rating(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("user/avaliacoes");
        // load product
        var product = productService.getById(id);
        // try find existing rating for this product, otherwise create one
        var rating = ratingService.findByProductId(id);
        if (rating == null) {
            rating = new com.example.demo.model.Rating();
            rating.setProduct(product);
            rating.calc();
            ratingService.save(rating);
            // associate to product
            product.setRating(rating);
            productService.save(product);
        }
        mv.addObject("rating", rating);
        mv.addObject("product", product);
        return mv;
    }

    private static class RatingDTO {
        public Long productId;
        public Short value;

        public Long getProductId() { return productId; }
        public void setProductId(Long productId) { this.productId = productId; }
        public Short getValue() { return value; }
        public void setValue(Short value) { this.value = value; }
    }

    @PostMapping(path = "/rate", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addRating(@RequestBody RatingDTO dto) {
        if (dto == null || dto.productId == null || dto.value == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error","invalid payload"));
        }
        long productId = dto.productId;
        short value = dto.value;

        var product = productService.getById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error","product not found"));
        }

        var rating = ratingService.findByProductId(productId);
        if (rating == null) {
            rating = new com.example.demo.model.Rating();
            rating.setProduct(product);
        }
        // append new rating
        rating.getRatings().add(value);
        // recalc average
        rating.calc();
        // save rating
        ratingService.save(rating);
        // ensure product points to rating
        product.setRating(rating);
        productService.save(product);

        Map<String,Object> resp = new HashMap<>();
        resp.put("value", rating.getValue());
        resp.put("count", rating.getRatings().size());
        return ResponseEntity.ok(resp);
    }
}
