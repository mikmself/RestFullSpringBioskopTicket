package com.app.webspringbioskopticket.controller;

import com.app.webspringbioskopticket.entity.Schedule;
import com.app.webspringbioskopticket.service.FilmService;
import com.app.webspringbioskopticket.service.ScheduleService;
import com.app.webspringbioskopticket.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService service;

    @Autowired
    private FilmService filmService;

    @Autowired
    private TheaterService theaterService;

    @GetMapping("")
    public ModelAndView get() {
        List<Schedule> list = service.get();
        return new ModelAndView("schedule/index","schedules",list);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("films",filmService.get());
        model.addAttribute("theaters",theaterService.get());
        model.addAttribute("schedule", new Schedule());
        return "schedule/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("schedule") Schedule data) {
        service.save(data);
        return "redirect:/schedule";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Schedule data = service.getById(id);
        model.addAttribute("data", data);
        model.addAttribute("films",filmService.get());
        model.addAttribute("theaters",theaterService.get());
        return "schedule/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/schedule";
    }
}
