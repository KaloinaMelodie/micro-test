package com.example.account.controller;

import com.example.account.client.CustomerClient;
import com.example.account.dto.AccountMirrorDto;
import com.example.account.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final IAccountService accountService;
    private final CustomerClient customerClient;

    @Autowired
    public AccountController(IAccountService accountService, CustomerClient customerClient) {
        this.accountService = accountService;
        this.customerClient = customerClient;
    }

    @GetMapping("/account")
    public List<AccountMirrorDto> getAccount() {
        List<AccountMirrorDto> accounts = accountService.getAll();
        accounts.forEach(account ->
        {
            account.setCustomer(customerClient.getById(account.getCustomerId()));
        });
        return accounts;
    }

    @GetMapping("/account/{id}")
    public AccountMirrorDto getAccount(@PathVariable String id) {
        AccountMirrorDto account = accountService.getById(id);
        account.setCustomer(customerClient.getById(account.getCustomerId()));

        return account;
    }
}
