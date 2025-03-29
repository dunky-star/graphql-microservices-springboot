package com.dunky.accounts.controller;

import com.dunky.accounts.domain.BankAccount;
import com.dunky.accounts.domain.Client;
import com.dunky.accounts.service.BankService;
import com.dunky.accounts.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountsControllerGraphQL {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountsControllerGraphQL.class);

    private final BankService bankService;
    private final ClientService clientService;

    public AccountsControllerGraphQL(BankService bankService, ClientService clientService) {
        this.bankService = bankService;
        this.clientService = clientService;
    }

    @QueryMapping(name = "accounts")
    public List<BankAccount> getAccounts() {
        LOGGER.info("Fetching all bank accounts...");
        return bankService.getAccounts();
    }

    @SchemaMapping(typeName = "BankAccount", field = "client")
    Client getClient(BankAccount account){
        LOGGER.info("Getting client for {}", account.getId());
        return clientService.getClientByAccountId(account.getId());
    }

}
