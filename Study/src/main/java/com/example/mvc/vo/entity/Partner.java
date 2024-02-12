package com.example.mvc.vo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
		name = "partner_seq",
		sequenceName = "seq_partner_id",
		initialValue = 1, // 시작값
		allocationSize = 1 // 증가값
)
@ToString(exclude = {"itemList","category"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Partner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator  = "partner_seq")
	private Long id;
	
	private String name;
	private String status;
	private String address;
	private String callCenter;
	private String businessNumber;
	private String ceoName;
	private String partnerNumber;
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
	
	//partner n : 1 category
	@ManyToOne
	private Category category;
	
	//partner 1 : n item
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
	private List<Item> itemList;

}
