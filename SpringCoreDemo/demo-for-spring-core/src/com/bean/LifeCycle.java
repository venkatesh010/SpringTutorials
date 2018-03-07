package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycle {

    @Autowired
    private Hello hello;

    public LifeCycle() {
        System.out.println("LifeCycle.lifecycle: " + hello);
    }

    @PostConstruct
    public void init(){
        System.out.println("Lifecycle.init: " + hello);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Lifecycle.destroy: " + hello );
    }
}
