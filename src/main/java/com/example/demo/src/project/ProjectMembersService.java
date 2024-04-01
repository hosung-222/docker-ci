package com.example.demo.src.project;

import com.example.demo.src.project.domain.ProjectMembers;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMembersService {
    private final ProjectMembersRepository projectMembersRepository;

    public List<ProjectMembers> getAllProject(Long userId) {
        return projectMembersRepository.findAllByUserId(userId);
    }
}
