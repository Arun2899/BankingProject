package com.example.BankingProject.BankAccount;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String s)
    {
        super(s);
    }
}
