package com.example.mvc.vo.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberApiRequest {
	
	private Long id;
	
	private String account;
	private String password;
	private String status;
	private String email;
	private String phoneNumber;
	

}
