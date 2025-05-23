package com.example.account.dto;

import com.example.account.enums.CurrencyType;
import com.example.account.models.Customer;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountMirrorDto {
    private String id;
    private Double balance;
    private LocalDate dateCreated;
    private CurrencyType currency;
    private Customer customer;
    private Long customerId;
}
