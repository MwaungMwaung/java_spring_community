package com.example.Spring_Community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
@내용 = 어노테이션(annotation)은 컴퓨터를 위한 주석이다.
개발자가 주석을 통해 코드의 용도, 방향을 알 수 있듯이, 어노테이션은 컴파일러에게 이러한 정보를 준다고 나는 이해했다.
 */

@Controller
public class FirstController {
    @GetMapping("/hi") // URL 연결 요청 접수
    public String niceToMeetYou(Model model) {
        // 모델 객체의 username 변수에 값을 넣어줌
        model.addAttribute("username", "hongpark");
        return "greetings"; // greetings.mustache 파일 반환
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "HongPark");
        return "goodbye";
    }
}
