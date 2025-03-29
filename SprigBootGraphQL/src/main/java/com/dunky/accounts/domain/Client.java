package com.dunky.accounts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Client {
    private String id;
    private String accountId;
    private String firstName;
    private String middleName;
    private String lastName;
}
