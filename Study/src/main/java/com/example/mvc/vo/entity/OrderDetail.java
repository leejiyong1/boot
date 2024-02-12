package com.example.mvc.vo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
		name = "orderdetail_seq",
		sequenceName = "seq_order_detail_id",
		initialValue = 1,
		allocationSize = 1
)
@ToString(exclude = {"orderGroup","item"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderdetail_seq")
	private Long id;
	
	private String status;
	private LocalDateTime arrivalDate;
	private int quantity;
	private int totalPrice;
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;
	
	//orderDetail n :1 item
	@ManyToOne
	private Item item;
	
	//orderDetail n : 1 orderGroup
	@ManyToOne
	private OrderGroup orderGroup;
	
	
	
	
}
