package com.example.mvc.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mvc.StudyApplicationTests;
import com.example.mvc.vo.entity.Partner;

public class PartnerRepositoryTest extends StudyApplicationTests{
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Test
	public void create() {
		String name = "Partner01";
		String status = "REGISTRERED";
		String address = "서울시 강남구";
		String callCenter = "070-1111-2222";
		String partnerNumber = "010-1111-2222";
		String businessNumber = "123456789123";
		String ceoName = "홍길동";
		LocalDateTime registeredAt = LocalDateTime.now();
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		Long categoryId= 1L;
		
		Partner partner = new Partner();
		partner.setName(name);
		partner.setStatus(status);
		partner.setAddress(address);
		partner.setCallCenter(callCenter);
		partner.setPartnerNumber(partnerNumber);
		partner.setBusinessNumber(businessNumber);
		partner.setCeoName(ceoName);
		partner.setRegisteredAt(registeredAt);
		partner.setCreatedAt(createdAt);
		partner.setCreatedBy(createdBy);
//		partner.setCategoryId(categoryId);
		
		
		Partner newPartner = partnerRepository.save(partner);
		Assertions.assertNotNull(newPartner);
		Assertions.assertEquals(partner.getName(), name);
	}
	
	@Test
	public void read() {
		
		Optional<Partner> paOptional = partnerRepository.findById(1L);
		
		paOptional.ifPresent(c ->{
			Assertions.assertEquals(c.getAddress(), "서울시 강남구");
			System.out.println(c);
		});
		
	}
	

}
