package com.example.mvc.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mvc.StudyApplicationTests;
import com.example.mvc.vo.entity.OrderGroup;

public class OrderGroupRepositoryTest extends StudyApplicationTests{
	
	@Autowired
	OrderGroupRepository orderGroupRepository;
	
	@Test
	public void create() {
		
		OrderGroup orderGroup = new OrderGroup();
		orderGroup.setStatus("COMPLETE");
		orderGroup.setOrderType("ALL");
		orderGroup.setRevAddress("서울시 강남구");
		orderGroup.setRevName("홍길동");
		orderGroup.setPaymentType("CARD");
		orderGroup.setTotalPrice(900000);
		orderGroup.setTotalQuantity(1);
		orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
		orderGroup.setArrivalDate(LocalDateTime.now());
		orderGroup.setCreatedAt(LocalDateTime.now());
		orderGroup.setCreatedBy("AdminServer");
//		orderGroup.setMemberId(1L);
		OrderGroup newordGroup = orderGroupRepository.save(orderGroup);
		
		Assertions.assertNotNull(newordGroup);
	}
	
	@Test
	public void read() {
		Optional<OrderGroup> optionalOrderGroup = orderGroupRepository.findById(1L);
		
		optionalOrderGroup.ifPresent(org -> {
			Assertions.assertEquals(org.getTotalQuantity(), 1);
			System.out.println(org);
		});
	}

}
