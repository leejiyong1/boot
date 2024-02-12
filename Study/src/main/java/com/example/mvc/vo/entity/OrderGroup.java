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
		name = "seq_order_group",
		sequenceName = "seq_order_group_id",
		initialValue = 1,
		allocationSize = 1
)
@ToString(exclude = {"member","orderDetailList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_order_group")
	private Long id;
	
	private String status;
	private String orderType; //주문의 형태 + 일관/ 개별
	
	private String revAddress;//수신주소
	private String revName;//수신인
	private String paymentType;
	private int totalPrice;
	private int totalQuantity;
	private LocalDateTime orderAt;
	private LocalDateTime arrivalDate;
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;
	
	@ManyToOne
	private Member member;
	
	//OrderGroup 1 : n OrderDetail
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
	private List<OrderDetail> orderDetailList;
	

}
