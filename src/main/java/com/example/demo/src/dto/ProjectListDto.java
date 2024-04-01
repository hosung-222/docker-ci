package com.example.demo.src.dto;

import com.example.demo.src.project.domain.Project;
import com.example.demo.src.project.domain.ProjectMembers;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProjectListDto {
    private String projectName;
    private String projectContent;
    private String startDay;
    private String endDay;

    public static ProjectListDto toProjectListDto(ProjectMembers projectMembers) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDay = projectMembers.getProject().getStartDay().format(formatter);
        String endDay = projectMembers.getProject().getEndDay().format(formatter);

        return new ProjectListDto(
                projectMembers.getProject().getName(),
                projectMembers.getProject().getContent(),
                startDay,
                endDay
        );
    }
    public static ProjectListDto makeProjectListDto(Project project) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDay = project.getStartDay().format(formatter);
        String endDay = project.getEndDay().format(formatter);

        return new ProjectListDto(
                project.getName(),
                project.getContent(),
                startDay,
                endDay
        );
    }
}
