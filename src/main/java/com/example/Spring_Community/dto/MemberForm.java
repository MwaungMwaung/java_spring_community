package com.example.Spring_Community.dto;

import com.example.Spring_Community.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class MemberForm {
    private Long id;
    private String email;
    private String password;

    public Member toEntity() {
        return new Member(id, this.email, this.password);
    }
}
