package com.example.demo.src.experience;

import com.example.demo.src.dto.ExperienceDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public List<ExperienceDto> getExperiences() {
        List<Experience> experiences = experienceRepository.findAll();
        List<ExperienceDto> experienceReqs = experiences.stream().map(ExperienceDto::toExperienceReq).collect(Collectors.toList());
        return experienceReqs;
    }
}
