package com.app.webspringbioskopticket.controller;

import com.app.webspringbioskopticket.entity.Schedule;
import com.app.webspringbioskopticket.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ScheduleService scervice;

    @GetMapping("/")
    public ModelAndView index() {
        List<Schedule> schedules = scervice.get();
        return new ModelAndView("index", "schedules", schedules);
    }
}
