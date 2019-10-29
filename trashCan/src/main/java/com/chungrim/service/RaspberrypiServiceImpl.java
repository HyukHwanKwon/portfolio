package com.chungrim.service;

import java.util.*;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chungrim.dao.RaspberrypiDAO;
import com.chungrim.vo.RaspberrypiVO;

@Service
public class RaspberrypiServiceImpl implements RaspberrypiService {

	@Inject
	private RaspberrypiDAO RaspberrypiDAO;

	@Override // Place 가져오기
	public List<RaspberrypiVO> managementPlace() throws Exception {

		return RaspberrypiDAO.managementPlace();
	}
	
	@Override // 관리 VIEW Place 가져오기
	public List<RaspberrypiVO> getPlaceList() throws Exception {

		return RaspberrypiDAO.getPlaceList();
	}

	@Override // Detail 가져오기
	public List<RaspberrypiVO> getDetailList(int fkPlaceSeq) throws Exception {

		return RaspberrypiDAO.getDetailList(fkPlaceSeq);
	}
	
	@Override // 관리 VIEW Detail 가져오기
	public List<RaspberrypiVO> managementDetail(int fkPlaceSeq) throws Exception {

		return RaspberrypiDAO.managementDetail(fkPlaceSeq);
	}

	@Override // Floor 가져오기
	public List<RaspberrypiVO> getFloorList() throws Exception {

		return RaspberrypiDAO.getFloorList();
	}
	
	@Override // 관리 VIEW Floor 가져오기
	public List<RaspberrypiVO> managementFloor(int fkDetailSeq) throws Exception {

		return RaspberrypiDAO.managementFloor(fkDetailSeq);
	}

	@Override // Gender 가져오기
	public List<RaspberrypiVO> getGenderList() throws Exception {

		return RaspberrypiDAO.getGenderList();
	}
	
	@Override // 관리 VIEW Gender 가져오기
	public List<RaspberrypiVO> managementGender(RaspberrypiVO piVO) throws Exception {

		return RaspberrypiDAO.managementGender(piVO);
	}

	@Override // 라즈베리파이IP등록
	public boolean insertRaspberrypi(RaspberrypiVO piVO) throws Exception {

		return RaspberrypiDAO.insertRaspberrypi(piVO);
	}

	@Override // 관리 view 라즈베리파이 정보 가져오기(전체 다 선택)
	public List<RaspberrypiVO> managementPi(RaspberrypiVO piVO) throws Exception {
		
		return RaspberrypiDAO.managementPi(piVO);
	}
	
	@Override // 관리 view 라즈베리파이 정보 가져오기(place만 선택)
	public List<RaspberrypiVO> managementPiPlace(int fkPlaceSeq) throws Exception {
		
		return RaspberrypiDAO.managementPiPlace(fkPlaceSeq);
	}
	
	@Override // 관리 view 라즈베리파이 정보 가져오기(place, detail 선택)
	public List<RaspberrypiVO> managementPiDetail(RaspberrypiVO piVO) throws Exception {
		
		return RaspberrypiDAO.managementPiDetail(piVO);
	}
	
	@Override // 관리 view 라즈베리파이 정보 가져오기(place, detail, floor 선택)
	public List<RaspberrypiVO> managementPiFloor(RaspberrypiVO piVO) throws Exception {
		
		return RaspberrypiDAO.managementPiFloor(piVO);
	}
	
	@Override // 라즈베리파이 정보 가져오기
	public RaspberrypiVO getPiInfomation(String ip) throws Exception {
		
		return RaspberrypiDAO.getPiInfomation(ip);
	}

	@Override
	public boolean updateRaspberrypi(RaspberrypiVO piVO) throws Exception {
		
		return RaspberrypiDAO.updateRaspberrypi(piVO);
	}
}
