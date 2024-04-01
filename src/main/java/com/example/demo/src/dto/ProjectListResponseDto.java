package com.example.demo.src.dto;

import com.example.demo.src.project.domain.Project;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectListResponseDto {
    private String projectName;
    private String projectContent;
    private String startDay;
    private String endDay;
    private String link;

    public static ProjectListResponseDto makeProjectListDto(Project project) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDay = project.getStartDay().format(formatter);
        String endDay = project.getEndDay().format(formatter);

        return new ProjectListResponseDto(
                project.getName(),
                project.getContent(),
                startDay,
                endDay,
                project.getLink()
        );
    }
}
