package com.example.mvc.vo.network.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberApiResponse {
	
	private Long id;
	private String account;
	private String password;
	private String status;
	private String email;
	private String phoneNumber;
	private LocalDateTime registeredAt;
	private LocalDateTime unregisteredAt;

}
