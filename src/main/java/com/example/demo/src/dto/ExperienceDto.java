package com.example.demo.src.dto;

import com.example.demo.src.enums.Resume;
import com.example.demo.src.experience.Experience;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExperienceDto {
    private String name;
    private String place;
    private String content;
    private String timeLine;
    private Resume resumeType;



    public static ExperienceDto toExperienceReq(Experience experience) {
        return new ExperienceDto(
                experience.getName(),
                experience.getPlace(),
                experience.getContent(),
                experience.getTimeLine(),
                experience.getResume()
        );
    }
}
