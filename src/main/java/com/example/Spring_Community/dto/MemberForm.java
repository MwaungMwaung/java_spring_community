package com.example.Spring_Community.dto;

import com.example.Spring_Community.entity.Member;

public class MemberForm {
    private String email;
    private String password;

    public MemberForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Member toEntity() {
        return new Member(null, this.email, this.password);
    }
}
