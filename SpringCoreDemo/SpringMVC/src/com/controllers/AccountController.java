package com.controllers;

import com.model.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/add")
    public String addAccount(Model model){
        System.out.println("Inside Add Account Model Method");
        model.addAttribute("account", new Account());
        return "addAccount";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute @Valid Account account, BindingResult result){

        if(result.hasErrors()){
            return "addAccount";
        }

        System.out.println("AccountController.saveAccount");

        accountService.save(account);
        return "index";
    }

    @RequestMapping(value = "/showList")
    public String getListOfAccount(Model model){
        List<Account> temp =  accountService.fetchAll();

//        fetch(model);
        model.addAttribute("listOfAccounts", temp);
        return "showAccounts";
    }
/*

    @ModelAttribute
    private List<Account> fetch(Model model) {
        List<Account> listOfAccounts =  accountService.fetchAll();
        return listOfAccounts;
    }
*/

    @RequestMapping(value = "/transfer/{fId}/{tId}/{amount}")
    @ResponseBody
    public String transfer(@PathVariable("fId") int fromId,
                           @PathVariable("tId") int toId,
                           @PathVariable("amount") double amount){

        try {

            accountService.transfer(fromId, toId, amount);
            return "Transfer Complete";
        }catch(Exception e){
            e.printStackTrace();
            return "Transfer Failed";
        }

    }
}
