package com.example.Spring_Community.controller;

import com.example.Spring_Community.dto.MemberForm;
import com.example.Spring_Community.entity.Member;
import com.example.Spring_Community.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUp() {
        return "/members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form) {
        log.info(form.toString());

        Member member = form.toEntity();
        log.info(member.toString());

        Member saved = memberRepository.save(member);
        log.info(saved.toString());

        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        // 레퍼지토리에서 엔티티 불러오기
        Member memberEntitiy = memberRepository.findById(id).orElse(null);
        // 엔티티를 모델에 등록하기
        model.addAttribute("member", memberEntitiy);

        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        List<Member> memberEntityList = (List<Member>) memberRepository.findAll();
        model.addAttribute("memberList", memberEntityList);
        return "members/index";
    }
}
