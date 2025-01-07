package com.example.BankingProject.BankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.InsufficientResourcesException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repository;



    public ModelAndView table()
    {
       return new ModelAndView("table","accounts",repository.findAll());
    }



    public ModelAndView add()
    {
        return new ModelAndView("addaccount","account",new Model());
    }

    public ModelAndView added( Model m)
    {
       repository.save(m);
        return table();
    }



}
