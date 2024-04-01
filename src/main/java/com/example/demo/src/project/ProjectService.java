package com.example.demo.src.project;

import com.example.demo.src.dto.AddProjectRequestDto;
import com.example.demo.src.dto.ProjectListResponseDto;
import com.example.demo.src.dto.ProjectUserDto;
import com.example.demo.src.project.domain.Project;
import com.example.demo.src.project.domain.ProjectMembers;
import com.example.demo.src.user.UserRepository;
import com.example.demo.src.user.domain.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMembersRepository projectMembersRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = false)
    public void addProject(AddProjectRequestDto addProjectRequestDto) {
        Project project = new Project();
        project.setProject(addProjectRequestDto);
        projectRepository.save(project);

        List<ProjectUserDto> projectUsers= addProjectRequestDto.getProjectUser();
        for (ProjectUserDto user : projectUsers){
            ProjectMembers projectMembers = new ProjectMembers();
            User projectUser = userRepository.getReferenceById(user.getUserId());
            projectMembers.setMembers(user, projectUser, project);
        }

    }

    public List<ProjectListResponseDto> getProject() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectListResponseDto> projectListResponseDtos = projects
                .stream()
                .map(ProjectListResponseDto::makeProjectListDto)
                .collect(Collectors.toList());

        return projectListResponseDtos;
    }
}
