package com.example.account;

import com.example.account.client.CustomerClient;
import com.example.account.entities.Account;
import com.example.account.enums.CurrencyType;
import com.example.account.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerClient customerClient) {
        return args -> {
            customerClient.getAll().forEach(
                    customer -> {
                        Account account = Account.builder()
                                .customerId(customer.getId())
//                                .id(UUID.randomUUID().toString())
                                .balance(Math.random() * 1000)
                                .currency(CurrencyType.EUR)
                                .dateCreated(LocalDate.now())
                                .build();
                        accountRepository.save(account);
                    }
            );

        };
    }
}
