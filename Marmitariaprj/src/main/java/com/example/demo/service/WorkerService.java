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
}
