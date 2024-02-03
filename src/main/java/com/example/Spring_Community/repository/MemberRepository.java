package com.example.Spring_Community.repository;

import com.example.Spring_Community.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
