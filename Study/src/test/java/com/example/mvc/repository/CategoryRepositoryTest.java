package com.example.mvc.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mvc.StudyApplicationTests;
import com.example.mvc.vo.entity.Category;

public class CategoryRepositoryTest extends StudyApplicationTests{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void create() {
		String type = "computer";
		String title = "컴퓨터";
		LocalDateTime careatedAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		
		Category category = new Category();
		category.setType(type);
		category.setCreatedAt(careatedAt);
		category.setTitle(title);
		category.setCreatedBy(createdBy);
		
		
		Category newCategory = categoryRepository.save(category);
		
		
		Assertions.assertNotNull(newCategory);
		Assertions.assertEquals(newCategory.getType(), type);
		Assertions.assertEquals(newCategory.getTitle(), title);
		
	}
	
	@Test
	public void read() {
		
		String type = "computer2";
		
		Optional<Category> optionalCategory = categoryRepository.findByType("computer");
		
		// select * from category where type = "computer";
		
		optionalCategory.ifPresent(c -> {
			Assertions.assertEquals(c.getType(), type);
			System.out.println(c.getId());
			System.out.println(c.getType());
			System.out.println(c.getTitle());
		});
		
	}

}
