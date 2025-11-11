package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientService {
  
  private final ClientRepository clientRepository;
  
  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }
  
  public List<Client> getAll(){return clientRepository.findAll();}
  public Optional<Client> getById(long id){return clientRepository.findById(id);}
  public void save(Client client){clientRepository.save(client);}
}
