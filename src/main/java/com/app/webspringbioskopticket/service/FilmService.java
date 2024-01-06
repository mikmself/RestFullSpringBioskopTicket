package com.app.webspringbioskopticket.service;

import com.app.webspringbioskopticket.entity.Film;
import com.app.webspringbioskopticket.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository repository;
    public void save(Film data) {
        repository.save(data);
    }
    public List<Film> get() {
        return repository.findAll();
    }
    public Film getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
