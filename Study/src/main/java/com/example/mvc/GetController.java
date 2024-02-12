package com.example.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
