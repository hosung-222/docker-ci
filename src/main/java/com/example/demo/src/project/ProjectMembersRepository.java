package com.example.demo.src.project;

import com.example.demo.src.project.domain.ProjectMembers;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMembersRepository extends JpaRepository<ProjectMembers, Long> {
    List<ProjectMembers> findAllByUserId(Long userId);
}
