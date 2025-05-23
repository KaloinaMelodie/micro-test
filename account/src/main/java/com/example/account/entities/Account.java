package com.example.account.entities;

import com.example.account.enums.CurrencyType;
import com.example.account.models.Customer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double balance;
    @CreationTimestamp
    private LocalDate dateCreated;
    private CurrencyType currency;
    @Transient
    private Customer customer;
    private Long customerId;

}
