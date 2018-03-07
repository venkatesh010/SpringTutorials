package com.bean;

import com.aspects.Monitor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class HelloImpl implements Hello {

    private String message;

    @Override
    @Monitor
    public String sayHello(){
        return "Hello" + message;
    }

    public String getMessage() {
        return message;
    }

    public String setMessage(String message) {
        System.out.println("Before Setter parameter : " + message);
        System.out.println("Before Class Variable: " + this.message);
        this.message = message;


        System.out.println("After Setter parameter : " + message);
        System.out.println("After Class Variable: " + this.message);

        return message;

    }

}
