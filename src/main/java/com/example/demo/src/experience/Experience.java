package com.example.demo.src.experience;


import com.example.demo.config.BaseEntity;
import com.example.demo.src.enums.Resume;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Experience extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String place;
    private String content;
    private String timeLine;
    @Enumerated(EnumType.STRING)
    private Resume resume;
}
