package com.dunky.accounts.service;


import com.dunky.accounts.domain.BankAccount;

import java.util.List;

public interface BankService {
   List<BankAccount> getAccounts();
}
