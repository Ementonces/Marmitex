package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Product;
import com.example.demo.model.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_oder")
public class Oder{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @joinColumn(name="client_id")
  private Client client;
  @OneToMany
  (mappegBy ="order", cascade = CascadeType.ALL)
  private List<Product> product = New ArrayList<>();

  public Order(){
  }
  public Order(Long id, Client client, List<Product> product){
    this.id = id;
    this.client = client;
    this.product = product;
  }
  public void setId(Long id){
    this.id = id;
  }
  public Long getId(){
    return id;
  }
  public void setClient(Client client){
    this.client = client;
  }
  public Client getClient(){
    return client;
  }
  public void setProduct(List<Product> product){
    this.product = product;
  }
  public List<Product> getProduct(){
    return product;
  }
}