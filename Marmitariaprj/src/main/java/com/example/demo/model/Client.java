package com.example.demo.model;

public class Client {
  private String email;
  private String password;
  private String adress;

  public Client(){
    
  }
  public Client(String email, String password, String adress){
    this.email = email;
    this.password = password;
    this.adress = adress;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getAdress() {
    return adress;
  }
  public void setAdress(String adress) {
    this.adress = adress;
  }
}
