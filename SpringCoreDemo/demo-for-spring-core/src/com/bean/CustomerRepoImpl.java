package com.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("repo1")
public class CustomerRepoImpl implements CustomerRepo {

    String firstName;
    String lastName;

    public CustomerRepoImpl() {
        System.out.println("CustomerRepo1");
    }

    public String getFirstName() {
        firstName = "Virat";
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        lastName = "Kohli";
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
