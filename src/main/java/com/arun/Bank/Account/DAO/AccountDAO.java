package com.arun.Bank.Account.DAO;

import com.arun.Bank.Account.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {
}
