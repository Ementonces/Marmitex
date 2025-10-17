package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbmarmitas")
public class Product {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private long id;
  private String name;
  private String description;
  private float price;
  
  public Product() {
  }
  
  public Product(String description, String name, float price) {
    this.description = description;
    this.name = name;
    this.price = price;
  }
  
  public long getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public float getPrice() {
    return price;
  }
  
  public void setPrice(float price) {
    this.price = price;
  }
}
