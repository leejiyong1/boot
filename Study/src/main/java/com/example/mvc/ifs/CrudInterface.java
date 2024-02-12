package com.example.mvc.ifs;

import com.example.mvc.vo.network.Header;

public interface CrudInterface {
	
	Header create(); // todo request object 추가
	
	Header read(Long id);
	
	Header update();
	
	Header delete(Long id);

}
