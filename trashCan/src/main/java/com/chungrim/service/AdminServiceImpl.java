package com.chungrim.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chungrim.dao.AdminDAO;
import com.chungrim.vo.AdminVO;

@Service
public class AdminServiceImpl implements AdminService{
	@Inject
	private AdminDAO adminDAO;
	
	
	@Override // 로그인 처리
	public AdminVO adminLogin(AdminVO adminVO) throws Exception {
		return adminDAO.adminLogin(adminVO);
	}
}
