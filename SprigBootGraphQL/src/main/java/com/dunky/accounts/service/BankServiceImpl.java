package com.dunky.accounts.service;

import com.dunky.accounts.domain.BankAccount;
import com.dunky.accounts.domain.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class BankServiceImpl implements BankService {

    private static final List<BankAccount> bankAccounts = Arrays.asList(
            new BankAccount("A100A0", "C100", Currency.USD, 106.00f, "ACTIVE"),
            new BankAccount("A101BB", "C200", Currency.CAD, 250.00f, "ACTIVE"),
            new BankAccount("A102CC", "C300", Currency.CAD, 333.00f, "INACTIVE"),
            new BankAccount("A103DE", "C400", Currency.EUR, 4000.00f, "ACTIVE"),
            new BankAccount("A1044G", "C500", Currency.UGX, 4000.00f, "INACTIVE")
        );

    @Override
    public List<BankAccount> getAccounts() {
        return bankAccounts;
    }

}


