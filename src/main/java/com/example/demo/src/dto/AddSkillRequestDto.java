package com.example.demo.src.dto;

import com.example.demo.src.enums.SkillLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSkillRequestDto {
    private String name;
    private SkillLevel skillLevel;
}
