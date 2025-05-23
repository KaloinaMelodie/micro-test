package com.example.account.mapper;

import com.example.account.dto.AccountMirrorDto;
import com.example.account.entities.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public Account toAccount(AccountMirrorDto accountMirrorDto) {
        return new Account(accountMirrorDto.getId(), accountMirrorDto.getBalance(), accountMirrorDto.getDateCreated(),accountMirrorDto.getCurrency(),accountMirrorDto.getCustomer(),accountMirrorDto.getCustomerId());
    }

    public AccountMirrorDto toAccountMirrorDto(Account account) {
        return new AccountMirrorDto(account.getId(), account.getBalance(), account.getDateCreated(), account.getCurrency(), account.getCustomer(), account.getCustomerId());
    }

    public List<AccountMirrorDto> toAccountMirrorDtoList(List<Account> accounts) {
        return accounts.stream().map(this::toAccountMirrorDto).collect(Collectors.toList());
    }
}
