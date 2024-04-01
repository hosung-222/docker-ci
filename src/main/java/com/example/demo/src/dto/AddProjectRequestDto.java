package com.example.demo.src.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProjectRequestDto {
    private String name;
    private String content;
    private String link;
    private LocalDate startDay;
    private LocalDate endDay;
    private List<ProjectUserDto> projectUser;
}
