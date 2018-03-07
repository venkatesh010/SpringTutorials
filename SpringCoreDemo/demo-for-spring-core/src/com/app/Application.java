package com.app;

import com.aspects.Monitor;
import com.bean.CustomerService;
import com.bean.CustomerServiceImpl;
import com.bean.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Application {

    @Autowired
    private CustomerService custService;

    public Application(CustomerService custService) {
        this.custService = custService;
        System.out.println("Application");

    }

    //@Monitor
    public void printCustomerName(){

        System.out.println("CustomerName: " + custService.getFullName());
    }



    public static void main(String[] args) {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("context.xml");

        Hello hello = (Hello) appContext.getBean("helloImpl");


        System.out.println("Type of Hello: "+ hello.getClass().getName());
        System.out.println("Result: " + hello.sayHello());

        Application app = appContext.getBean(Application.class);
        System.out.println("Type of Application: " + app.getClass().getName());
        app.printCustomerName();


    }
}
