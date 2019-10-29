package com.chungrim.service;

import java.util.List;

import com.chungrim.vo.CleanerVO;
import com.chungrim.vo.MappingVO;
import com.chungrim.vo.RaspberrypiVO;

public interface MappingService {
	List<RaspberrypiVO >selectPI(int i) throws Exception;

	List<CleanerVO> selectClean() throws Exception;

	int insertMap(MappingVO mapVO) throws Exception;

	int mapComp(String string) throws Exception;

	List<MappingVO> selectMap() throws Exception;

	int deleteMap(String str) throws Exception;

	int updateMap(String str) throws Exception;

	int cleanCount() throws Exception;

	int piCount() throws Exception;

	int mapCount() throws Exception;
	
	
}
