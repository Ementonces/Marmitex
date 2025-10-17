package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Marmita;
import com.example.demo.repository.MarmitaRepository;

@Service
public class MarmitaService {
  private final MarmitaRepository marmitaRepository;
  
  public MarmitaService(MarmitaRepository marmitaRepository) {
    this.marmitaRepository = marmitaRepository;
  }
  
  public List<Marmita> getAll(){return marmitaRepository.findAll();}
  
  public void save(Marmita marmita){marmitaRepository.save(marmita);}
}
