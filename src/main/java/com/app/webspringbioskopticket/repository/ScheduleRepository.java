package com.app.webspringbioskopticket.repository;

import com.app.webspringbioskopticket.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
