package com.example.demo.src.skills;

import com.example.demo.src.dto.AddSkillRequestDto;
import com.example.demo.src.skills.domain.Skills;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SkillsService {
    private final SkillsRepository skillsRepository;

    public List<Skills> getAllSkills() {
        return skillsRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void addSkill(AddSkillRequestDto addSkillRequestDto) {
        Skills skills = new Skills();
        skills.setSkill(addSkillRequestDto.getName(), addSkillRequestDto.getSkillLevel());
        skillsRepository.save(skills);
    }


    @Transactional(readOnly = false)
    public void deleteSkill(Long skillId) {
        Skills skills = skillsRepository.getReferenceById(skillId);
        skillsRepository.delete(skills);
    }
}
