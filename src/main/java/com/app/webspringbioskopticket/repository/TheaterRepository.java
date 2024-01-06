package com.app.webspringbioskopticket.repository;

import com.app.webspringbioskopticket.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
