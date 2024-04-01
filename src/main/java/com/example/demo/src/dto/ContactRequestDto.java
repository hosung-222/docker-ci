package com.example.demo.src.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactRequestDto {
    private String name;
    private String email;
    private String phone;
    private String message;
}
