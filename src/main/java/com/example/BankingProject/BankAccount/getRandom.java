package com.example.BankingProject.BankAccount;

import java.security.SecureRandom;

public class getRandom
{
    private static SecureRandom random = new SecureRandom();
    public static String generateAccNo()
    {
        long acc_no = 1000000000L + random.nextLong(9000000000L);
        return String.valueOf(acc_no);
    }
}
