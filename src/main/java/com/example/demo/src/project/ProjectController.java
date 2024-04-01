package com.example.demo.src.project;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.dto.AddProjectRequestDto;
import com.example.demo.src.dto.ProjectListResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "Project Controller")
@RequestMapping("/app/project")
public class ProjectController {
    private final ProjectService projectService;

    /**
     * 프로젝트 추가 API
     * @param addProjectRequestDto
     * @return
     */
    @ApiOperation(value = "프로젝트 추가하는 메서드")
    @PostMapping("")
    public BaseResponse<String> addProject(@RequestBody AddProjectRequestDto addProjectRequestDto){
        projectService.addProject(addProjectRequestDto);
        return new BaseResponse<>("등록 완료");
    }

    /**
     * 프로젝트 조회 API
     * @return <List<ProjectListResponseDto>>
     */
    @GetMapping("")
    public BaseResponse<List<ProjectListResponseDto>> getProject(){
        List<ProjectListResponseDto> projectListResponseDtos = projectService.getProject();
        return new BaseResponse<>(projectListResponseDtos);
    }
}
