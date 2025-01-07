package com.example.BankingProject.BankAccount;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account_details")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String account_number = getRandom.generateAccNo();
    private String account_holder_name;

    @Column(unique = true)
    private String aadhar_no;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone_no;

    private String location;
    private long balance;

}
