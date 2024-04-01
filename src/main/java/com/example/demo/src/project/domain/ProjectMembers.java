package com.example.demo.src.project.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.example.demo.config.BaseEntity;
import com.example.demo.src.dto.ProjectUserDto;
import com.example.demo.src.enums.Part;
import com.example.demo.src.user.domain.User;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class ProjectMembers extends BaseEntity {
    @Id@GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Part part;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    public void setMembers(ProjectUserDto projectUser, User user, Project project) {
        this.user = user;
        this.part = Part.valueOf(projectUser.getPart());
        this.project = project;
    }
}
