package com.chungrim.service;

import com.chungrim.vo.AdminVO;

public interface AdminService {
	
	// 로그인 처리
	public AdminVO adminLogin(AdminVO adminVO) throws Exception;
}
