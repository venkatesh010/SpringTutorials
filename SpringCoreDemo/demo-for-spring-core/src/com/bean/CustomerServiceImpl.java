package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    @Qualifier("repo2")
    CustomerRepo repo;


    public CustomerServiceImpl() {
        System.out.println("CustomerServiceImpl");
    }

    @Override
    public String getFullName(){
        return repo.getFirstName() + " " + repo.getLastName();
    }

}
