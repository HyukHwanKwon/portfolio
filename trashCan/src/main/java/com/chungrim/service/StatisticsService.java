package com.chungrim.service;

import java.util.List;

import com.chungrim.vo.StatisticsVO;

public interface StatisticsService {
	
	/**
	 * 일간 통계 service
	 */
	
	// 일간 통계  View
	public List<StatisticsVO> dayView() throws Exception;
	
	// 일간 통계 View 어제 최대값 
	public StatisticsVO dayMax() throws Exception;
	
	// 일간 통계 View selectBox Month
	public List<StatisticsVO> daySelectMonth() throws Exception;
	
	// 일간 통계 View selectBox Day
	public List<StatisticsVO> daySelectDay(String day) throws Exception;
	
	// 일간 통계 View SelectBox Place
	public List<StatisticsVO> daySelectPlace(String date) throws Exception;
	
	// 일간 통계 View Place 최대값 
	public StatisticsVO dayViewPlaceMax(String date) throws Exception;
	
	// 일간 통계 View SelectBox Detail
	public List<StatisticsVO> daySelectDetail(StatisticsVO statisticsVO) throws Exception;
	
	// 일간 통계 View Detail 최대값 
	public StatisticsVO dayViewDetailMax(StatisticsVO statisticsVO) throws Exception;
	
	// 일간 통계 View SelectBox Floor
	public List<StatisticsVO> daySelectFloor(StatisticsVO statisticsVO) throws Exception;
	
	// 일간 통계 View Floor 최대값 
	public StatisticsVO dayViewFloorMax(StatisticsVO statisticsVO) throws Exception;
	
	// 일간 통계 View SelectBox Gender
	public List<StatisticsVO> daySelectGender(StatisticsVO statisticsVO) throws Exception;
	
	// 일간 통계 View Detail 최대값 
	public StatisticsVO dayViewGenderMax(StatisticsVO statisticsVO) throws Exception;
	
	// 일간 통계 View SelectBox All
	public List<StatisticsVO> daySelectAll(StatisticsVO statisticsVO) throws Exception;
	
	// 일간 통계 View All 최대값 
	public StatisticsVO dayViewAllMax(StatisticsVO statisticsVO) throws Exception;
	
	
	/**
	 * 월간 통계 service
	 */ 
	
	// 월간 통계 View
	public List<StatisticsVO> monthView() throws Exception;

	// 월간 통계 View 어제 최대값
	public StatisticsVO monthMax() throws Exception;

	// 월간 통계 View SelectBox Place
	public List<StatisticsVO> monthSelectPlace(String month) throws Exception;

	// 월간 통계 View Place 최대값
	public StatisticsVO monthViewPlaceMax(String month) throws Exception;

	// 월간 통계 View SelectBox Detail
	public List<StatisticsVO> monthSelectDetail(StatisticsVO statisticsVO) throws Exception;

	// 월간 통계 View Detail 최대값
	public StatisticsVO monthViewDetailMax(StatisticsVO statisticsVO) throws Exception;

	// 월간 통계 View SelectBox Floor
	public List<StatisticsVO> monthSelectFloor(StatisticsVO statisticsVO) throws Exception;

	// 월간 통계 View Floor 최대값
	public StatisticsVO monthViewFloorMax(StatisticsVO statisticsVO) throws Exception;

	// 월간 통계 View SelectBox Gender
	public List<StatisticsVO> monthSelectGender(StatisticsVO statisticsVO) throws Exception;
	
	// 월간 통계 View Gender 최대값 
	public StatisticsVO monthViewGenderMax(StatisticsVO statisticsVO) throws Exception;

	// 월간 통계 View SelectBox All
	public List<StatisticsVO> monthSelectAll(StatisticsVO statisticsVO) throws Exception;

	// 월간 통계 View All 최대값
	public StatisticsVO monthViewAllMax(StatisticsVO statisticsVO) throws Exception;
	
	/**
	 * 실시간 통계 service
	 */ 
	
	// 실시간 통계 View 
	public List<StatisticsVO> liveView() throws Exception;

	// 실시간 통계 View SelectBox Detail
	public List<StatisticsVO> liveSelectDetail(int placeSeq) throws Exception;

	// 실시간 통계 View SelectBox Floor
	public List<StatisticsVO> liveSelectFloor(StatisticsVO statisticsVO) throws Exception;

	// 실시간 통계 View SelectBox Gender
	public List<StatisticsVO> liveSelectGender(StatisticsVO statisticsVO) throws Exception;
	
	// 실시간 통계 View SelectBox All
	public List<StatisticsVO> liveSelectAll(StatisticsVO statisticsVO) throws Exception;
}
