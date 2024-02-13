package com.example.mvc.ifs;

import com.example.mvc.vo.network.Header;
import com.example.mvc.vo.network.request.MemberApiRequest;
import com.example.mvc.vo.network.response.MemberApiResponse;

public interface CrudInterface {
	
	Header<MemberApiResponse> create(MemberApiRequest request); // todo request object 추가
	
	Header read(Long id);
	
	Header update();
	
	Header delete(Long id);

}
