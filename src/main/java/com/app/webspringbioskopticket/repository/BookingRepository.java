package com.app.webspringbioskopticket.repository;

import com.app.webspringbioskopticket.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
