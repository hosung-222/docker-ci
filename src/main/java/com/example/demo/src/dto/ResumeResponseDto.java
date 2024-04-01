package com.example.demo.src.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeResponseDto {
    private List<SkillsDto> skillsDtos;
    private List<ExperienceDto> experienceAndEducationReqs;


}
