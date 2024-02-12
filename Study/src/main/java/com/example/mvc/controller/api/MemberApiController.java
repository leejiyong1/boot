package com.example.mvc.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.ifs.CrudInterface;
import com.example.mvc.vo.network.Header;

@RestController
@RequestMapping("/api/member")
public class MemberApiController implements CrudInterface{
	
	
	
	@Override
	public Header create() {
		return null;
	}

	@Override
	public Header read(Long id) {
		return null;
	}

	@Override
	public Header update() {
		return null;
	}

	@Override
	public Header delete(Long id) {
		return null;
	}
	
}
