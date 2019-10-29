package com.chungrim.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chungrim.vo.CleanerDetailVO;
import com.chungrim.vo.CleanerVO;

@Repository
public class CleanerDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.chungrim.mapper.cleanerMapper";
	
	// 
	public List<CleanerVO> cleanerList() throws Exception{
	
		return sqlSession.selectList(Namespace+".cleanerList");
		
	}
	
	public CleanerVO selectCleanerInfo(CleanerVO cleaner) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectCleanerInfo", cleaner);
	}
	
	public int cleanerDelete(String id) throws Exception{
		
		int x = 0;
		x = sqlSession.delete(Namespace + ".cleanerDelete", id);
		
		return x;
	}
	public int cleanerInsert(CleanerVO cleanerVO) throws Exception{
		int state= sqlSession.insert(Namespace + ".cleanerInsert", cleanerVO); 
		
		int x = 0;
		
		if(state >0) {
			x = 1;
			return x;
		}
		
		return x;
	}
	
	public int cleanerLicenseUpdate(CleanerVO cleanerVO) throws Exception{
		int state= sqlSession.update(Namespace + ".cleanerLicenseUpdate", cleanerVO);
		
		int x = 0;
		
		if(state >0) {
			x = 1;
			return x;
		}
		
		return x;
	}
	
	public List<CleanerVO> cleanerLicenseList() throws Exception{
		
		return sqlSession.selectList(Namespace+".cleanerLicenseList");
		
	}
	
	public CleanerVO checkCleanerInfo(CleanerVO cleaner) {
		return sqlSession.selectOne(Namespace + ".checkCleanerInfo");
	}
	
	public List<CleanerDetailVO> selectCleanerDetailInfo(CleanerVO cleanerVO) {
		
		return sqlSession.selectList(Namespace + ".selectCleanerDetailInfo", cleanerVO);
	}
	
	public CleanerVO selectToken() throws Exception {
		
		return sqlSession.selectOne(Namespace + ".selectToken");
	}
	
}
