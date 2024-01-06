package com.app.webspringbioskopticket.controller;

import com.app.webspringbioskopticket.entity.Booking;
import com.app.webspringbioskopticket.service.BookingService;
import com.app.webspringbioskopticket.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService service;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("")
    public ModelAndView get() {
        List<Booking> list = service.get();
        return new ModelAndView("booking/index","bookings",list);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("schedules",scheduleService.get());
        return "booking/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Booking data) {
        service.save(data);
        return "redirect:/booking";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Booking data = service.getById(id);
        model.addAttribute("schedules",scheduleService.get());
        model.addAttribute("data", data);
        return "booking/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/booking";
    }
}
