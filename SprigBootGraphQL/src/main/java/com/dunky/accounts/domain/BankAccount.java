package com.dunky.accounts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccount {
    private  String id;
    private String clientId;
    private Currency currency;
    private Float balance;
    private String status;
}

