package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;
  
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
  public List<Product> getAll(){return productRepository.findAll();}
  
  public void save(Product product){productRepository.save(product);}
  
  public void deleteById(Long id){ productRepository.deleteById(id); }

  public List<Product> findByIds(Iterable<Long> ids){
    return productRepository.findAllById(ids);
  }
}
