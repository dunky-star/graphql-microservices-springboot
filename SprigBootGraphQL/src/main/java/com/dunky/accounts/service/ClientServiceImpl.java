package com.dunky.accounts.service;

import com.dunky.accounts.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl  implements ClientService{

    private static final List<Client> clients = Arrays.asList(
            new Client("C100", "A100A0", "Geoffrey", "Duncan", "Op"),
            new Client("C200", "A101BB", "James", "Robert", "Smith"),
            new Client("C300", "A102CC", "Army", "Lama", "LLama"),
            new Client("C400", "A103DE", "Linh", "Lang", "Lang"),
            new Client("C500", "A1044G", "Oli", "Olive", "Johny")
    );


    @Override
    public Client getClientByAccountId(String accountId) {
        return clients.stream()
                .filter(client -> client.getAccountId().equals(accountId))
                .findFirst()
                .orElse(null);
    }
}
