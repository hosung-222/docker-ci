package com.example.demo.src.dto;

import com.example.demo.src.enums.SkillLevel;
import com.example.demo.src.skills.domain.Skills;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SkillsDto {
    private String skillName;
    private SkillLevel skillLevel;



    public static SkillsDto toSkillsDto(Skills skills) {
        return new SkillsDto(
                skills.getName(),
                skills.getSkillLevel()
        );
    }
}
