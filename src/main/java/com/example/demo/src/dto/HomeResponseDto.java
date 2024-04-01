package com.example.demo.src.dto;

import com.example.demo.src.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeResponseDto {
    private String userName;
    private String bio;
    private String content;


    public void setHomeResponseDto(User user) {
        this.userName = user.getName();
        this.bio = user.getBio();
        this.content = user.getContent();

    }
}
