package com.example.demo.src.user;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.dto.ExperienceDto;
import com.example.demo.src.dto.HomeResponseDto;
import com.example.demo.src.dto.ProfileRequestDto;
import com.example.demo.src.dto.ResumeResponseDto;
import com.example.demo.src.dto.SkillsDto;
import com.example.demo.src.experience.ExperienceService;
import com.example.demo.src.project.ProjectMembersService;
import com.example.demo.src.project.ProjectService;
import com.example.demo.src.skills.SkillsService;
import com.example.demo.src.skills.domain.Skills;
import com.example.demo.src.user.domain.User;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final ProjectService projectService;
    private final ProjectMembersService projectMembersService;
    private final SkillsService skillsService;
    private final ExperienceService experienceService;

    public HomeResponseDto getHome() throws BaseException {
        try {
            Long userId = 1L;
            HomeResponseDto homeResponseDto = new HomeResponseDto();
            User user = userRepository.getReferenceById(userId);

            homeResponseDto.setHomeResponseDto(user);
            return homeResponseDto;
        }catch (EntityNotFoundException e){
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }

    @Transactional(readOnly = false)
    public void updateProfile(Long userId, ProfileRequestDto profileRequestDto) {
        User user = userRepository.getReferenceById(userId);
        user.setName(profileRequestDto.getName());
        user.setBio(profileRequestDto.getBio());
        user.setContent(profileRequestDto.getContent());
        userRepository.save(user);
    }

    public ResumeResponseDto getResume() {
        List<Skills> skills = skillsService.getAllSkills();
        List<SkillsDto> skillsDtos = skills.stream()
                .map(SkillsDto::toSkillsDto).collect(Collectors.toList());

        List<ExperienceDto> experienceReqs = experienceService.getExperiences();
        ResumeResponseDto resumeReqs = new ResumeResponseDto();
        resumeReqs.setSkillsDtos(skillsDtos);
        resumeReqs.setExperienceAndEducationReqs(experienceReqs);
        return resumeReqs;
    }
}
