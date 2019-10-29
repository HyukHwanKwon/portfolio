package com.chungrim.service;

import java.util.List;

import com.chungrim.vo.CleanerDetailVO;
import com.chungrim.vo.CleanerVO;

public interface CleanerService {
	
	public List<CleanerVO> cleanerList() throws Exception;
	
	public CleanerVO selectCleanerInfo(CleanerVO cleaner) throws Exception;
	
	public List<CleanerVO> cleanerLicenseList() throws Exception;
	
	public int cleanerLicenseUpdate(CleanerVO cleanerVO) throws Exception;
	
	public int deleteCleaner(String id) throws Exception;
	
	public int insertCleaner(CleanerVO cleanerVO) throws Exception;

	int UpdateCleaner(CleanerVO cleanerVO) throws Exception;
	
	public CleanerVO checkCleanerInfo(CleanerVO cleaner) throws Exception;
	
	public List<CleanerDetailVO> selectCleanerDetailInfo(CleanerVO cleaner) throws Exception;
	
	public CleanerVO selectToken() throws Exception;
}
