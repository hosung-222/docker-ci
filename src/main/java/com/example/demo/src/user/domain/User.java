package com.example.demo.src.user.domain;

import static javax.persistence.GenerationType.IDENTITY;

import com.example.demo.config.BaseEntity;
import com.example.demo.src.dto.ProfileRequestDto;
import com.example.demo.src.enums.UserPermission;
import com.example.demo.src.project.domain.ProjectMembers;
import com.example.demo.src.skills.domain.Skills;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String bio;
    private String content;

    @Enumerated(EnumType.STRING)
    private UserPermission userPermission;

    @OneToMany(mappedBy = "user")
    private List<ProjectMembers> projectMembers;

    @OneToMany(mappedBy = "user")
    private List<Skills> skills;

    public void setProfile(ProfileRequestDto profileRequestDto) {
        this.name = profileRequestDto.getName();
        this.bio = profileRequestDto.getBio();
        this.content = profileRequestDto.getContent();
    }
}
