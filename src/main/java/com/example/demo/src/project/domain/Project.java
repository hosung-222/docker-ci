package com.example.demo.src.project.domain;

import static javax.persistence.GenerationType.IDENTITY;

import com.example.demo.config.BaseEntity;
import com.example.demo.src.dto.AddProjectRequestDto;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;

@Getter
@Entity
public class Project extends BaseEntity {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String link;
    private LocalDate startDay;
    private LocalDate endDay;

    @OneToMany(mappedBy = "project")
    private List<ProjectMembers> projectMembers;

    public void setProject(AddProjectRequestDto addProjectRequestDto) {
        name = addProjectRequestDto.getName();
        content = addProjectRequestDto.getContent();
        link = addProjectRequestDto.getLink();
        startDay =addProjectRequestDto.getStartDay();
        endDay = addProjectRequestDto.getEndDay();
    }
}
