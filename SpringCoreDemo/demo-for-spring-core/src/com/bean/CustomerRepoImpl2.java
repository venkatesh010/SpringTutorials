package com.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("repo2")
@Lazy
public class CustomerRepoImpl2 implements CustomerRepo {

    String firstName;
    String lastName;
    public CustomerRepoImpl2() {
        System.out.println("CustomerRepo2");
    }

    @Override
    public String getFirstName() {
        firstName = "Virat2";
        return firstName;
    }

    @Override
    public String getLastName() {
        lastName="kohli2";
        return lastName;
    }
}
