package com.arun.Bank.Account.Controller;

import com.arun.Bank.Account.Model.Account;
import com.arun.Bank.Account.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService service;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return service.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable int id){
        return service.getAccountById(id);
    }

    @PostMapping("/accounts")
    public void createAccount(@RequestBody Account account){
        service.createAccount(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteStudentById(@PathVariable int id){
        service.deleteAccountById(id);
    }

    @PutMapping("/accounts/{id}/deposit")
    public void depositMoney(@PathVariable int id, @RequestParam double amount){
        service.depositMoney(id,amount);
    }

    @PutMapping("/accounts/{id}/withdraw")
    public void withdrawMoney(@PathVariable int id, @RequestParam double amount){
        service.withdrawMoney(id,amount);
    }

    @PutMapping("/accounts/transfer")
    public void transferMoney(@RequestParam int from,@RequestParam int to, @RequestParam double amount){
        service.transferMoney(from, to, amount);
    }
}
