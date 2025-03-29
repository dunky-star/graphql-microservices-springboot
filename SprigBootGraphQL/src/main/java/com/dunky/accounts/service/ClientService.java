package com.dunky.accounts.service;

import com.dunky.accounts.domain.Client;

public interface ClientService {
    Client getClientByAccountId(String accountId);
}