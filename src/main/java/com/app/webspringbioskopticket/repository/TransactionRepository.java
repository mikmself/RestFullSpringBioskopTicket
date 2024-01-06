package com.app.webspringbioskopticket.repository;

import com.app.webspringbioskopticket.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
