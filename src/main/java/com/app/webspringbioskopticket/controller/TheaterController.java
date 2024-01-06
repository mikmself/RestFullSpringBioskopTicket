package com.app.webspringbioskopticket.controller;

import com.app.webspringbioskopticket.entity.Theater;
import com.app.webspringbioskopticket.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    private TheaterService service;

    @GetMapping("")
    public ModelAndView get() {
        List<Theater> list = service.get();
        return new ModelAndView("theater/index","theaters",list);
    }

    @GetMapping("/create")
    public String create() {
        return "theater/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Theater data) {
        service.save(data);
        return "redirect:/theater";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Theater data = service.getById(id);
        model.addAttribute("data", data);
        return "theater/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/theater";
    }
}
