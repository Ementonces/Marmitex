package com.example.demo.model;

public class LoggedClient {
  private static Client logged;

    public static Client getlogged() {
        return logged;
    }

    public static void setlogged(Client loggedC) {
        logged = loggedC;
    }
  
}
