package com.app.webspringbioskopticket.repository;

import com.app.webspringbioskopticket.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
