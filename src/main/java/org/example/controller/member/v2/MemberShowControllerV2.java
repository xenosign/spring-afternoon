package org.example.controller.member.v2;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.member.MemberDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MemberShowControllerV2 {
    private MemberDtoListV2 memberList;

    @Autowired
    public MemberShowControllerV2(MemberDtoListV2 memberDtoList) {
        this.memberList = memberDtoList;
    }

    @GetMapping("/member/v2/show")
    public String process(Model model) {
        log.info("=======> 회원 목록 조회 페이지 호출, /member/show");

        model.addAttribute("memberList", memberList.getList());
        return "member-show2";
    }
}




