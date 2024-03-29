package com.example.mvc.vo.network;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {
	
	//api 통신시간
	private LocalDateTime transactionTime;
	
	//api 응답 코드
	private String resultCode;
	
	//api 부가 설명
	private String description;
	
	
	private T data;
	
	//OK
	public static <T> Header<T> OK(){
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.build();
	}
	//DATA OK
	public static <T> Header<T> OK(T data){
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.build();
	}
	
	//ERROR
	
	public static <T> Header<T> ERROR(String description){
		return (Header<T>) Header.builder()
				.transactionTime(LocalDateTime.now())
				.resultCode("OK")
				.description("OK")
				.build();
	}

}
