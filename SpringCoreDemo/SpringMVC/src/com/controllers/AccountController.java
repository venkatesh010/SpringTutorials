package com.controllers;

import com.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
public class AccountController {


    @RequestMapping("/add")
    public String addAccount(Model model){
        System.out.println("Inside Add Account Model Method");
        model.addAttribute("account", new Account());
        return "addAccount";
    }

    @RequestMapping("/save")
    public String saveAccount(@ModelAttribute Account account){
        System.out.println("AccountController.saveAccount");
        return "index";
    }

}
