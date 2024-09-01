package com.sirfeeky.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO  {

    @Override
    public void addAccount() {
      System.out.println(this.getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");
    }
    
}
