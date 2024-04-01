package com.example.demo.src.skills;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.dto.AddSkillRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = "Skill Controller")
@RequestMapping("/app/skills")
public class SkillController {
    private final SkillsService skillsService;

    /**
     * 스킬 추가 API
     * @param addSkillRequestDto
     * @return
     */
    @ApiOperation(value = "스킬 추가하는 메서드")
    @PostMapping("")
    public BaseResponse<String> addSkill(@RequestBody AddSkillRequestDto addSkillRequestDto){
        skillsService.addSkill(addSkillRequestDto);
        return new BaseResponse<>("등록 완료");
    }

    /**
     * 스킬 삭제 API
     * @param skillId
     * @return
     */
    @ApiOperation(value = "스킬 삭제하는 메서드")
    @DeleteMapping("/{skillId}")
    public BaseResponse<String> deleteSkill(@PathVariable("skillId")Long skillId){
        skillsService.deleteSkill(skillId);
        return new BaseResponse<>("삭제 완료");
    }
}
