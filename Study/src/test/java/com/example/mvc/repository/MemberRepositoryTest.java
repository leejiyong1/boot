package com.example.mvc.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.StudyApplicationTests;
import com.example.mvc.vo.entity.Item;
import com.example.mvc.vo.entity.Member;


public class MemberRepositoryTest extends StudyApplicationTests{
	// Dependency Injection (DI)
	@Autowired
	private MemberRepository memberRepository;
	@Test
	public void create() {
		
		String account = "Test03";
		String password = "Test03";
		String status = "REGISTERED";
		String email ="Test03@gamil.com";
		String phonNumber = "010-1111-3333";
		LocalDateTime registeredAt = LocalDateTime.now();
		
		Member member = new Member();
		member.setAccount(account);
		member.setPassword(password);
		member.setStatus(status);
		member.setEmail(email);
		member.setPhoneNumber(phonNumber);
		member.setRegisteredAt(registeredAt);
		
		Member m = Member.builder().account(account).
				password(password).
				status(status).
				email(email).
				build();
		
		Member newMember = memberRepository.save(member);
		Assertions.assertNotNull(newMember);
		
	}
	@Test
	@Transactional
	public void read() {
		Member member = memberRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
		
		
		member.getOrderGroupList().stream().forEach(orderGroup -> {
			
			
			System.out.println("-----------------주문묶음------------------");
			System.out.println("수령인: " + orderGroup.getRevName());
			System.out.println("수령지: " + orderGroup.getRevAddress());
			System.out.println("총금액: " + orderGroup.getTotalPrice());
			System.out.println("총수량: " + orderGroup.getTotalQuantity());
			
			System.out.println("-----------------주문묶음------------------");
			
			orderGroup.getOrderDetailList().forEach(orderDetail -> {
					
				System.out.println("파트너사 이름: " + orderDetail.getItem().getPartner().getName());
				System.out.println("파트너사 카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
				System.out.println("주문상품: " + orderDetail.getItem().getName());
				System.out.println("고객센터 번호: " + orderDetail.getItem().getPartner().getCallCenter());
				System.out.println("주문의 상태: " + orderDetail.getStatus());
				System.out.println("도착예정일자: " + orderDetail.getArrivalDate());
				
					
			});
			
		});
	}
	@Test
	@Transactional
	public void update() {
		Optional<Member> member = memberRepository.findById(2L);
		
		member.ifPresent(selectMember ->{
			selectMember.setAccount("pppp");
			selectMember.setUpdatedAt(LocalDateTime.now());
			selectMember.setUpdatedBy("update method()");
			
			memberRepository.save(selectMember);
		});
	}
	
	@Test
	@Transactional
	public void delete() {
		Optional<Member> member = memberRepository.findById(3L);
		
		Assertions.assertTrue(member.isPresent());//true
		
		member.ifPresent(selectMember ->{
				memberRepository.delete(selectMember);
		});
		
		Optional<Member> deletemember = memberRepository.findById(3L);
		
		Assertions.assertFalse(deletemember.isPresent());//false
	}

}
