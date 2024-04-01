package com.example.demo.src.user;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.dto.HomeResponseDto;
import com.example.demo.src.dto.ProfileRequestDto;
import com.example.demo.src.dto.ResumeResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"User Controller"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
public class UserController {
    private final UserService userService;

    /**
     * 메인 홈페이지 화면 조회 API
     * @return HomeResponseDto
     * @throws BaseException
     */
    @ApiOperation(value = "메인 홈페이지 정보 조회하는 메서드")
    @GetMapping("/home")
    public BaseResponse<HomeResponseDto> myHomePage() throws BaseException {
        HomeResponseDto homeResponseDto = userService.getHome();
        return new BaseResponse<>(homeResponseDto);
    }

    /**
     * 유저 정보 수정용 API
     * @param userId
     * @param profileRequestDto
     * @return
     */
    @ApiOperation(value = "유저 정보 수정하는 메서드")
    @PatchMapping("/user/{userId}")
    public BaseResponse<String> updateProfile(@PathVariable Long userId, @RequestBody ProfileRequestDto profileRequestDto){
        userService.updateProfile(userId, profileRequestDto);

        return new BaseResponse<>("수정완료");
    }

    /**
     * 경험, 교육, 스킬 정보 화면 조회 API
     * @return
     */
    @ApiOperation(value = "resume 화면 정보 조회 하는 메서드")
    @GetMapping("/resume")
    public BaseResponse<ResumeResponseDto> getResume(){
        ResumeResponseDto resumeReqs = userService.getResume();
        return new BaseResponse<>(resumeReqs);

    }

}
