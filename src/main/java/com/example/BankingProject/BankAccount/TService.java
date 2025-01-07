package com.example.BankingProject.BankAccount;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class TService {

    @Autowired
    private Repository repository;

    @Transactional
    public void transaction(int fromaccno, int toaccno, long amount) throws Exception {

        if (fromaccno==toaccno) {
            throw new SameAccountNumberException("Can't transfer money to the same account.");
        }


        Model fromAccount = repository.findById(fromaccno).orElse(null);
        Model toAccount = repository.findById(toaccno).orElse(null);


        if (fromAccount == null) {
            throw new AccountNotFoundException("From account not found: " + fromaccno);
        }
        if (toAccount == null) {
            throw new AccountNotFoundException("To account not found: " + toaccno);
        }


        long fromBalance = fromAccount.getBalance();
        long toBalance = toAccount.getBalance();


        if (amount > fromBalance) {
            throw new InsufficientBalanceException("Amount exceeds the balance in the from account.");
        }


        long updatedFromBalance = fromBalance - amount;
        long updatedToBalance = toBalance + amount;

        fromAccount.setBalance(updatedFromBalance);
        toAccount.setBalance(updatedToBalance);


        repository.save(fromAccount);
        repository.save(toAccount);
    }
}
