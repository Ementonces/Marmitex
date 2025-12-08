package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tborder")
public class Order{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name="client_id")
  private Client client;

  @OneToMany(mappedBy ="order", cascade = CascadeType.ALL)
  private List<Product> product = new ArrayList<>();

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