package com.example.account.services;

import com.example.account.dto.AccountMirrorDto;
import com.example.account.entities.Account;
import com.example.account.mapper.AccountMapper;
import com.example.account.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountMirrorDto> getAll() {
        return accountMapper.toAccountMirrorDtoList(accountRepository.findAll());
    }

    @Override
    public AccountMirrorDto getById(String id) {
        Account account = accountRepository.findById(id).orElse(null);
        if(account !=null){
            return accountMapper.toAccountMirrorDto(account);
        }
        return null;
    }
}
