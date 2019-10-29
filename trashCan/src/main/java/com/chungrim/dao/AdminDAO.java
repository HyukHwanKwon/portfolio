package com.chungrim.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chungrim.vo.AdminVO;

@Repository
public class AdminDAO {
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.chungrim.mapper.adminMapper";
	
	// 로그인 처리
	public AdminVO adminLogin(AdminVO adminVO) throws Exception {
		
		return sqlSession.selectOne(Namespace+".loginCheck", adminVO);
	}
}
