package com.arun.Bank.Account.Service;

import com.arun.Bank.Account.DAO.AccountDAO;
import com.arun.Bank.Account.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDAO dao;

    public List<Account> getAllAccounts() {
        return dao.findAll();
    }

    public Account getAccountById(int id) {
        return dao.findAll().stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public void createAccount(Account account) {
        dao.save(account);
    }

    public void deleteAccountById(int id) {
        dao.deleteById(id);
    }

    public void depositMoney(int id, double amount) {
        Account account = dao.findAll().stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if(account != null && amount > 0) {
            account.setBalance(amount + account.getBalance());
            dao.save(account);
        }
    }

    public void withdrawMoney(int id, double amount) {
        Account account = dao.findAll().stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if(account != null && account.getBalance() - amount >= 0) {
            account.setBalance(account.getBalance() - amount);
            dao.save(account);
        }
    }

    public void transferMoney(int from, int to, double amount) {
        Account fromAccount = dao.findAll().stream().filter(a -> a.getId() == from).findFirst().orElse(null);
        Account toAccount = dao.findAll().stream().filter(a -> a.getId() == to).findFirst().orElse(null);
        if(fromAccount != null && toAccount != null && fromAccount.getBalance() - amount > 0 && amount > 0) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            dao.save(toAccount);
            dao.save(fromAccount);
        }
    }
}
