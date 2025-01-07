package com.example.BankingProject.BankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tcontroller {

    @Autowired
    private TService tservice;

    @PutMapping("/transaction/{s}/{s1}/{a}")
    public String transaction(@PathVariable("s") int fromacc, @PathVariable("s1") int toacc, @PathVariable("a") long amnt ) throws Exception
    {
        tservice.transaction(fromacc,toacc,amnt);
        return "Transaction successful";
    }
}
