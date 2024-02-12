package com.example.mvc.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mvc.StudyApplicationTests;
import com.example.mvc.vo.entity.OrderDetail;
import com.example.mvc.vo.entity.OrderGroup;

public class OrderDetailTest extends StudyApplicationTests{
	
	@Autowired
	private OrderDetailRepository orderRepository;
	
	
	@Test
	public void create() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setStatus("WAITING");
		orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
		orderDetail.setQuantity(1);
		orderDetail.setTotalPrice(900000);
//		orderDetail.setItemId(1L);//어떠한 상품
//		orderDetail.setOrderGroup();//어떠한 장바구니에
		orderDetail.setCreatedAt(LocalDateTime.now());
		orderDetail.setCreatedBy("AdminServer");
		
		OrderDetail newOrderDetail = orderRepository.save(orderDetail);
		Assertions.assertNotNull(newOrderDetail);
	}
	
	@Test
	public void read() {
		Optional<OrderDetail> orderGroup = orderRepository.findById(2L);
		
		orderGroup.ifPresent(or -> {
			assertEquals(or.getCreatedBy(), "AdminServer");
			System.out.println(or);
		});
		
	}
	

}
