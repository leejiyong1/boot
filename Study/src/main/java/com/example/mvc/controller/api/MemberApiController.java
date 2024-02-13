package com.example.mvc.controller.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.ifs.CrudInterface;
import com.example.mvc.vo.network.Header;
import com.example.mvc.vo.network.request.MemberApiRequest;
import com.example.mvc.vo.network.response.MemberApiResponse;

@RestController
@RequestMapping("/api/member")
public class MemberApiController implements CrudInterface{
	
	
	
	@Override
	@PostMapping("")// /api/member
	public Header<MemberApiResponse> create(@RequestBody MemberApiRequest memberApiRequest) {
		return null;
	}

	@Override
	@GetMapping("{id}")//api/member/{id}
	public Header read(@PathVariable(name = "id") Long id) {
		return null;
	}

	@Override
	@PutMapping("") // /api/member
	public Header update() {
		return null;
	}

	@Override
	@DeleteMapping("{id}")// /api/member/{id}
	public Header delete(Long id) {
		return null;
	}
	
}
