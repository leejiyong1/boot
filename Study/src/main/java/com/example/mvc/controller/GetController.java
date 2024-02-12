package com.example.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.vo.network.Header;


@RestController
@RequestMapping("/api")
public class GetController {
	
//	//localhost:9093/api/getMultiParameter?account=abc&email=study@gmail.com&page=10
//	@GetMapping("/getMultiParameter")
//	public SearchParam getMultiParameter(SearchParam searchParam) {
//		System.out.println(searchParam.getAccount());
//		System.out.println(searchParam.getEmail());
//		System.out.println(searchParam.getPage());
//		
//		return searchParam;
//	}
	
	@GetMapping("/header")
	public Header getHeader() {
		
		//{resultCode: "OK" , "description" : "OK"}
		return Header.builder().resultCode("OK").description("OK").build();
	}

}
