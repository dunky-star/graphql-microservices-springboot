package com.dunky.accounts.controller;

import com.dunky.accounts.domain.BankAccount;
import com.dunky.accounts.domain.Client;
import com.dunky.accounts.service.BankService;
import com.dunky.accounts.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AccountsControllerREST {

    private final BankService bankService;
    private final ClientService clientService;

    public AccountsControllerREST(BankService bankService, ClientService clientService) {
        this.bankService = bankService;
        this.clientService = clientService;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<List<BankAccount>> getAllAccounts() {
        log.info("Getting all accounts");
        List<BankAccount> accounts = bankService.getAccounts();
        return ResponseEntity.ok(accounts); // Returns the list of accounts with an HTTP 200 status
    }

    @RequestMapping(value = "/accounts/{accountId}/client", method = RequestMethod.GET)
    public ResponseEntity<Client> getClientByAccountId(@PathVariable String accountId) {
        log.info("Getting client for account with ID: {}", accountId);
        Client client = clientService.getClientByAccountId(accountId);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build(); // Returns an HTTP 404 status if the client is not found
        }
    }
}
