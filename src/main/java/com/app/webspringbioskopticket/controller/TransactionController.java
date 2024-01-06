package com.app.webspringbioskopticket.controller;

import com.app.webspringbioskopticket.entity.Transaction;
import com.app.webspringbioskopticket.service.BookingService;
import com.app.webspringbioskopticket.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public ModelAndView get() {
        List<Transaction> list = service.get();
        return new ModelAndView("transaction/index","transactions",list);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bookings",bookingService.get());
        return "transaction/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Transaction data) {
        service.save(data);
        return "redirect:/transaction";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        Transaction data = service.getById(id);
        model.addAttribute("data", data);
        model.addAttribute("bookings",bookingService.get());
        return "transaction/edit";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/transaction";
    }
}
