package com.example.mvc.vo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@SequenceGenerator(
		name = "category_seq",
		sequenceName = "seq_category_id",
		initialValue = 1,
		allocationSize = 1
)
@ToString(exclude = {"partnerList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_seq")
	private Long id;
	
	private String type;
	
	private String title;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<Partner> partnerList;
	
}
