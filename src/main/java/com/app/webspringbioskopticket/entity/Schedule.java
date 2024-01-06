package com.app.webspringbioskopticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theater_id")
    private Theater theater_id;
    private Date date;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime time;
}
