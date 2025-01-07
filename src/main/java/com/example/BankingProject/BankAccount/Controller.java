package com.example.BankingProject.BankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @GetMapping
    public String view()
    {
        return "index";
    }

    @GetMapping("/table")
    public ModelAndView table()
    {
        return service.table();
    }

    @GetMapping("/add")
    public ModelAndView add()
    {
        return service.add();
    }

    @PostMapping("/createaccount")
    public ModelAndView addAccount(@ModelAttribute Model m)
    {
        return service.added(m);
    }


}
