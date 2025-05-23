package com.example.account.services;

import com.example.account.dto.AccountMirrorDto;
import com.example.account.entities.Account;
import com.example.account.models.Customer;

import java.util.List;

public interface IAccountService {
    List<AccountMirrorDto> getAll();
    AccountMirrorDto getById(String id);

}
