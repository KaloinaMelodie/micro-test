package com.example.client.dto;

import lombok.*;
import org.springframework.context.annotation.Bean;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMirrorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
