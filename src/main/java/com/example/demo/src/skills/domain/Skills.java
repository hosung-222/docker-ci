package com.example.demo.src.skills.domain;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.example.demo.config.BaseEntity;
import com.example.demo.src.enums.SkillLevel;
import com.example.demo.src.user.domain.User;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;


@Getter
@Entity
public class Skills extends BaseEntity {
    @Id@GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;
    @Enumerated(STRING)
    private SkillLevel skillLevel;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setSkill(String name, SkillLevel skillLevel){
        this.name = name;
        this.skillLevel = skillLevel;
    }
    public void updateLevel(String level) {
        skillLevel = SkillLevel.valueOf(level);
    }
}
