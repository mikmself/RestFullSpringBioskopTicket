package com.app.webspringbioskopticket.service;
import com.app.webspringbioskopticket.entity.Booking;
import com.app.webspringbioskopticket.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository repository;
    public void save(Booking data) {
        repository.save(data);
    }
    public List<Booking> get() {
        return repository.findAll();
    }
    public Booking getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
