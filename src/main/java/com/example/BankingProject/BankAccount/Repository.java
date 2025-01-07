package com.example.BankingProject.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Model,Integer> {

    @Query(value = "select * from account_details where account_number=?1",nativeQuery = true)
    Optional<Model> findByAccNo(String accno);
}
