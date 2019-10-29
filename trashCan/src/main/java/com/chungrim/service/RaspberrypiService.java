package com.chungrim.service;

import java.util.*;

import com.chungrim.vo.RaspberrypiVO;

public interface RaspberrypiService {

	// Place 가져오기
	public List<RaspberrypiVO> getPlaceList() throws Exception;
	
	// 관리 view Place 가져오기
	public List<RaspberrypiVO> managementPlace() throws Exception;

	// Detail 가져오기
	public List<RaspberrypiVO> getDetailList(int fkPlaceSeq) throws Exception;
	
	// 관리 view Detail 가져오기
	public List<RaspberrypiVO> managementDetail(int fkPlaceSeq) throws Exception;

	// Floor 가져오기
	public List<RaspberrypiVO> getFloorList() throws Exception;
	
	// 관리 view Floor 가져오기
	public List<RaspberrypiVO> managementFloor(int fkDetailSeq) throws Exception;

	// Gender 가져오기
	public List<RaspberrypiVO> getGenderList() throws Exception;
	
	// 관리 view Gender 가져오기
	public List<RaspberrypiVO> managementGender(RaspberrypiVO piVO) throws Exception;

	// 라즈베리파이IP 등록
	public boolean insertRaspberrypi(RaspberrypiVO piVO) throws Exception;
	
	// 관리 view 라즈베리파이 정보 가져오기(전체 다 선택)
	public List<RaspberrypiVO> managementPi(RaspberrypiVO piVO) throws Exception;
	
	// 관리 view 라즈베리파이 정보 가져오기(place만 선택)
	public List<RaspberrypiVO> managementPiPlace(int fkPlaceSeq) throws Exception;
	
	// 관리 view 라즈베리파이 정보 가져오기(place, detail 선택)
	public List<RaspberrypiVO> managementPiDetail(RaspberrypiVO piVO) throws Exception;
	
	// 관리 view 라즈베리파이 정보 가져오기(place, detail, floor 선택)
	public List<RaspberrypiVO> managementPiFloor(RaspberrypiVO piVO) throws Exception;
	
	// 라즈베리파이 정보 가져오기
	public RaspberrypiVO getPiInfomation(String ip) throws Exception;
	
	// 라즈베리파이 상태 값 수정
	public boolean updateRaspberrypi(RaspberrypiVO piVO) throws Exception;
}
