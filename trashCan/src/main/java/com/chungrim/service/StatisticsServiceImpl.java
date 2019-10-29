package com.chungrim.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chungrim.dao.StatisticsDAO;
import com.chungrim.vo.StatisticsVO;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	
	@Inject 
	private StatisticsDAO StatisticsDAO;
	
	/**
	 * 일간 통계 service implements
	 */ 
	
	@Override // 일간 통계   View
	public List<StatisticsVO> dayView() throws Exception {

		return StatisticsDAO.dayView();
	}
	
	@Override // 일간 통계 최대값 가져오기
	public StatisticsVO dayMax() throws Exception {
		
		return StatisticsDAO.dayMax();
	}
	
	@Override // 일간 통계  selectBox Month 가져오기
	public List<StatisticsVO> daySelectMonth() throws Exception {
		
		return StatisticsDAO.daySelectMonth();
	}
	
	@Override // 일간 통계  selectBox Day 가져오기
	public List<StatisticsVO> daySelectDay(String day) throws Exception {
		
		return StatisticsDAO.daySelectDay(day);
	}
	
	@Override // 일간 통계 View SelectBox Place 가져오기 및 Place 일간 통계
	public List<StatisticsVO> daySelectPlace(String date) throws Exception {
		
		return StatisticsDAO.daySelectPlace(date);
	}
	
	@Override // 일간 통계 View SelectBox Place 가져오기 및 Place 일간 통계 최대값 
	public StatisticsVO dayViewPlaceMax(String date) throws Exception {
		
		return StatisticsDAO.dayViewPlaceMax(date);
	}

	@Override // 일간 통계 View SelectBox Detail 가져오기 및 Detail 일간 통계
	public List<StatisticsVO> daySelectDetail(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.daySelectDetail(statisticsVO);
	}

	@Override // 일간 통계 View SelectBox Detail 가져오기 및 Detail 일간 통계 최대값 
	public StatisticsVO dayViewDetailMax(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.dayViewDetailMax(statisticsVO);
	}
	
	@Override // 일간 통계 View SelectBox Floor 가져오기 및 Floor 일간 통계
	public List<StatisticsVO> daySelectFloor(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.daySelectFloor(statisticsVO);
	}

	@Override // 일간 통계 View SelectBox Floor 가져오기 및 Floor 일간 통계 최대값 
	public StatisticsVO dayViewFloorMax(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.dayViewFloorMax(statisticsVO);
	}
	
	@Override // 일간 통계 View SelectBox Gender 가져오기 및 Gender 일간 통계
	public List<StatisticsVO> daySelectGender(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.daySelectGender(statisticsVO);
	}

	@Override // 일간 통계 View SelectBox Gender 가져오기 및 Gender 일간 통계 최대값 
	public StatisticsVO dayViewGenderMax(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.dayViewGenderMax(statisticsVO);
	}
	
	@Override // 일간 통계 View SelectBox All
	public List<StatisticsVO> daySelectAll(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.daySelectAll(statisticsVO);
	}
	
	@Override // 일간 통계 View SelectBox All 일간 통계 최대값 
	public StatisticsVO dayViewAllMax(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.dayViewAllMax(statisticsVO);
	}
	
	/**
	 * 월간 통계 service implements
	 */ 
	
	@Override // 월간 통계 View
	public List<StatisticsVO> monthView() throws Exception {
		
		return StatisticsDAO.monthView();
	}

	@Override // 월간 통계 View 어제 최대값
	public StatisticsVO monthMax() throws Exception {
		
		return StatisticsDAO.monthMax();
	}
	
	@Override // 월간 통계 View SelectBox Place
	public List<StatisticsVO> monthSelectPlace(String month) throws Exception {
		
		return StatisticsDAO.monthSelectPlace(month);
	}

	@Override // 월간 통계 View Place 최대값
	public StatisticsVO monthViewPlaceMax(String month) throws Exception {
		
		return StatisticsDAO.monthViewPlaceMax(month);
	}

	@Override // 월간 통계 View SelectBox Detail
	public List<StatisticsVO> monthSelectDetail(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.monthSelectDetail(statisticsVO);
	}

	@Override // 월간 통계 View Detail 최대값
	public StatisticsVO monthViewDetailMax(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.monthViewDetailMax(statisticsVO);
	}

	@Override // 월간 통계 View SelectBox Floor
	public List<StatisticsVO> monthSelectFloor(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.monthSelectFloor(statisticsVO);
	}

	@Override // 월간 통계 View Floor 최대값
	public StatisticsVO monthViewFloorMax(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.monthViewFloorMax(statisticsVO);
	}

	@Override // 월간 통계 View SelectBox Gender
	public List<StatisticsVO> monthSelectGender(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.monthSelectGender(statisticsVO);
	}
	
	@Override // 월간 통계 View Gender 최대값 
	public StatisticsVO monthViewGenderMax(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.monthViewGenderMax(statisticsVO);
	}
	@Override // 월간 통계 View SelectBox All
	public List<StatisticsVO> monthSelectAll(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.monthSelectAll(statisticsVO);
	}

	@Override // 월간 통계 View All 최대값
	public StatisticsVO monthViewAllMax(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.monthViewAllMax(statisticsVO);
	}
	
	/**
	 * 실시간 통계 service implements
	 */ 

	@Override // 실시간 통계 View 
	public List<StatisticsVO> liveView() throws Exception {

		return StatisticsDAO.liveView();
	}

	@Override // 실시간 통계 View SelectBox Detail
	public List<StatisticsVO> liveSelectDetail(int placeSeq) throws Exception {
		
		return StatisticsDAO.liveSelectDetail(placeSeq);
	}

	@Override // 실시간 통계 View SelectBox Floor
	public List<StatisticsVO> liveSelectFloor(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.liveSelectFloor(statisticsVO);
	}

	@Override // 실시간 통계 View SelectBox Gender
	public List<StatisticsVO> liveSelectGender(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.liveSelectGender(statisticsVO);
	}

	@Override // 실시간 통계 View SelectBox All
	public List<StatisticsVO> liveSelectAll(StatisticsVO statisticsVO) throws Exception {
		
		return StatisticsDAO.liveSelectAll(statisticsVO);
	}
}
