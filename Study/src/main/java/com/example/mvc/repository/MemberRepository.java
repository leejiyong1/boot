package com.example.mvc.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.vo.entity.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Member findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);
	
}
