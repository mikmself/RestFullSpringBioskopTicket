package com.app.webspringbioskopticket.service;

import com.app.webspringbioskopticket.entity.Schedule;
import com.app.webspringbioskopticket.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ScheduleService {
    @Autowired
    private ScheduleRepository repository;
    public void save(Schedule data) {
        repository.save(data);
    }
    public List<Schedule> get() {
        return repository.findAll();
    }
    public Schedule getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
