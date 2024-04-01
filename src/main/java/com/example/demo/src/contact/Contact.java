package com.example.demo.src.contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.config.BaseEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Contact extends BaseEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String message;
}
