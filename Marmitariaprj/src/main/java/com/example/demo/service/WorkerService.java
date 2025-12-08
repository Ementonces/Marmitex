package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;

@Service
public class WorkerService {
  public final WorkerRepository workerRepository;

  public WorkerService(WorkerRepository workerRepository) {
    this.workerRepository = workerRepository;
  }

  public List<Worker> getAll(){ return workerRepository.findAll(); }

  public void save(Worker worker){ workerRepository.save(worker); }

  public void saveDefault(){
    if (workerRepository.count() == 0) { // cria só se não existir
    Worker w = new Worker();
    w.setCpf("000.000.000-00");
    w.setEmail("admin@admin.adm");
    w.setManager(true);
    w.setName("admin");
    w.setPassword("admin");
    workerRepository.save(w);  }
  } 
}
