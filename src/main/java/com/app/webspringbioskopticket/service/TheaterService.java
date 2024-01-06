package com.app.webspringbioskopticket.service;

import com.app.webspringbioskopticket.entity.Theater;
import com.app.webspringbioskopticket.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TheaterService {
    @Autowired
    private TheaterRepository repository;
    public void save(Theater data) {
        repository.save(data);
    }
    public List<Theater> get() {
        return repository.findAll();
    }
    public Theater getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
