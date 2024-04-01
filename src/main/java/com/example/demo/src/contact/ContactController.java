package com.example.demo.src.contact;

import com.example.demo.config.BaseResponse;
import com.example.demo.src.dto.ContactRequestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = {"Contact Controller"})
@RequestMapping("/app/contact")
public class ContactController {
    private final ContactService contactService;

    /**
     * 전송된 Form 을 DB에 저장하는 API
     * @param contactReq
     * @return
     */
    @ApiOperation("연락 정보 받는 API")
    @PostMapping("")
    public BaseResponse<String> postContact(@RequestBody ContactRequestDto contactReq){
        contactService.postContact(contactReq);
        System.out.println("폼 동작 완료");
        return new BaseResponse<>("contact 완료");
    }

}
