package com.example.Spring_Community.controller;

import com.example.Spring_Community.dto.MemberForm;
import com.example.Spring_Community.entity.Member;
import com.example.Spring_Community.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUp() {
        return "/members/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm form) {
        Member member = form.toEntity();

        Member saved = memberRepository.save(member);
        return "greetings";
    }

}
