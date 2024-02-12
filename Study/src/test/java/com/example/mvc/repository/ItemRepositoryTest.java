package com.example.mvc.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mvc.StudyApplicationTests;
import com.example.mvc.vo.entity.Item;

public class ItemRepositoryTest extends StudyApplicationTests{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void create() {
		
		Item item = new Item();
		item.setStatus("UNREGISTERED");
		item.setName("삼성 노트북");
		item.setTitle("삼성 노트북 A100");
		item.setContent("2024년형 노트북");
		item.setPrice(900000);
		item.setBrandName("삼성");
		item.setCreatedAt(LocalDateTime.now());
		item.setCreatedBy("Partner01");
//		item.setPartnerId(1L);
		
		Item newItem = itemRepository.save(item);
		Assertions.assertNotNull(newItem);
		
	}
	
	@Test
	public void read() {
		Optional<Item> itemoOptional = itemRepository.findById(1L);
		
		itemoOptional.ifPresent(i ->{
//			Assertions.assertEquals(i.getName(), "삼성컴퓨터");
			System.out.println(i);
		});
	}

}
