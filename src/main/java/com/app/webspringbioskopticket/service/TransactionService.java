package com.app.webspringbioskopticket.service;

import com.app.webspringbioskopticket.entity.Transaction;
import com.app.webspringbioskopticket.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TransactionService {
    @Autowired
    private TransactionRepository repository;
    public void save(Transaction data) {
        repository.save(data);
    }
    public List<Transaction> get() {
        return repository.findAll();
    }
    public Transaction getById(int id) {
        return repository.findById(id).get();
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
