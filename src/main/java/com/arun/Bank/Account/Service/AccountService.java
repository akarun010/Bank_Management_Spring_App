package com.arun.Bank.Account.Service;

import com.arun.Bank.Account.DAO.AccountDAO;
import com.arun.Bank.Account.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountDAO dao;

    public List<Account> getAllAccounts() {
        return dao.findAll();
    }

    public Optional<Account> getAccountById(int id) {
        return dao.findById(id);
    }

    public void createAccount(Account account) {
        dao.save(account);
    }

    public void deleteAccountById(int id) {
        dao.deleteById(id);
    }

    public void depositMoney(int id, double amount) {
        Optional<Account> optionalAccount = dao.findById(id);
        if(optionalAccount.isPresent() && amount > 0) {
            Account account = optionalAccount.get();
            account.setBalance(amount + account.getBalance());
            dao.save(account);
        }
    }

    public void withdrawMoney(int id, double amount) {
        Optional<Account> optionalAccount = dao.findById(id);
        if(optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if(account.getBalance() - amount >= 0 && amount > 0){
                account.setBalance(account.getBalance() - amount);
                dao.save(account);
            }
        }
    }

    public void transferMoney(int from, int to, double amount) {
        Optional<Account> optionalFromAccount = dao.findById(from);
        Optional<Account> optionalToAccount = dao.findById(to);
        if(optionalFromAccount.isPresent() && optionalToAccount.isPresent()) {
            Account fromAccount = optionalFromAccount.get();
            Account toAccount = optionalToAccount.get();
            if(fromAccount.getBalance() - amount >= 0 && amount > 0) {
                fromAccount.setBalance(fromAccount.getBalance() - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                dao.save(fromAccount);
                dao.save(toAccount);
            }
        }
    }
}
