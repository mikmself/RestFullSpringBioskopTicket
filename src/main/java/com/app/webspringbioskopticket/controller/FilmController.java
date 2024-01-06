package com.app.webspringbioskopticket.controller;

import com.app.webspringbioskopticket.entity.Film;
import com.app.webspringbioskopticket.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService service;

    @GetMapping("")
    public ModelAndView get() {
        List<Film> list = service.get();
        return new ModelAndView("film/index","films",list);
    }

    @GetMapping("/create")
    public String create() {
        return "film/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Film data) {
        service.save(data);
        return "redirect:/film";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Film data = service.getById(id);
        model.addAttribute("data", data);
        return "film/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/film";
    }
}
