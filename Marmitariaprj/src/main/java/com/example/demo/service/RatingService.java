package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Rating;
import com.example.demo.repository.RatingRepository;

@Service
public class RatingService{
  private final RatingRepository ratingRepository;

  public RatingService(RatingRepository ratingRepository) {
    this.ratingRepository = ratingRepository;
  }
  
  public void save(Rating rating){ratingRepository.save(rating);}
  public List<Rating> getAll(){return ratingRepository.findAll();}
  public Rating findByProductId(Long productId){
    return ratingRepository.findByProductId(productId);
  }
}
