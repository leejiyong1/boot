package com.example.mvc.vo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SequenceGenerator(
		name = "seq_admin",
		sequenceName = "seq_admin_id",
		initialValue = 1,
		allocationSize = 1
)
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_admin")
	private Long id;
	
	private String account;
	private String password;
	private String status;
	private String role;
	private LocalDateTime lastLoginAt;
	private LocalDateTime passwordUpdateAt;
	private int loginFailCount;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;

}
