package com.example.mvc.repository;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mvc.StudyApplicationTests;
import com.example.mvc.vo.entity.Admin;

public class AdminRepositoryTest extends StudyApplicationTests{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Test
	public void create() {
		Admin admin = new Admin();
		admin.setAccount("AdminUser03");
		admin.setPassword("AdminUser03");
		admin.setStatus("REGISTERED");
		admin.setRole("PARTNER");
//		admin.setCreatedAt(LocalDateTime.now());
//		admin.setCreatedBy("SERVER");
		
		Admin newAdmin = adminRepository.save(admin);
		Assertions.assertNotNull(newAdmin);
		
		newAdmin.setAccount("CHANGE");
		adminRepository.save(newAdmin);
	}

}
