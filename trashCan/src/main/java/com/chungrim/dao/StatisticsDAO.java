package com.chungrim.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.chungrim.vo.*;


@Repository
public class StatisticsDAO {
	@Inject
	private SqlSession sqlSession;

	private static final String Namespace = "com.chungrim.mapper.StatisticsMapper";
	
	/**
	 * 일간 통계 DAO
	 */
	
	// 일간 통계  View
	public List<StatisticsVO> dayView() throws Exception {
		
		return sqlSession.selectList(Namespace + ".dayView");
	}
	
	// 일간 통계 View 어제 최대값 
	public StatisticsVO dayMax() throws Exception {
		
		return sqlSession.selectOne(Namespace + ".dayMax");
	}
	
	// 일간 통계 View selectBox Month
	public List<StatisticsVO> daySelectMonth() throws Exception {
		
		return sqlSession.selectList(Namespace + ".daySelectMonth");
	}
	
	// 일간 통계 View selectBox Day
	public List<StatisticsVO> daySelectDay(String day) throws Exception {
		
		return sqlSession.selectList(Namespace + ".daySelectDay", day);
	}
	
	// 일간 통계 View SelectBox Place
	public List<StatisticsVO> daySelectPlace(String date) throws Exception {
		
		return sqlSession.selectList(Namespace + ".daySelectPlace", date);
	}
	
	// 일간 통계 View Place 최대값 
	public StatisticsVO dayViewPlaceMax(String date) throws Exception {
		
		return sqlSession.selectOne(Namespace + ".dayViewPlaceMax", date);
	}
	
	// 일간 통계 View SelectBox Detail
	public List<StatisticsVO> daySelectDetail(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectList(Namespace + ".daySelectDetail", statisticsVO);
	}
	
	// 일간 통계 View Detail 최대값 
	public StatisticsVO dayViewDetailMax(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectOne(Namespace + ".dayViewDetailMax", statisticsVO);
	}
	
	// 일간 통계 View SelectBox Floor
	public List<StatisticsVO> daySelectFloor(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectList(Namespace + ".daySelectFloor", statisticsVO);
	}
	
	// 일간 통계 View Floor 최대값 
	public StatisticsVO dayViewFloorMax(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectOne(Namespace + ".dayViewFloorMax", statisticsVO);
	}
	
	// 일간 통계 View SelectBox Gender
	public List<StatisticsVO> daySelectGender(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectList(Namespace + ".daySelectGender", statisticsVO);
	}
	
	// 일간 통계 View Gender 최대값 
	public StatisticsVO dayViewGenderMax(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectOne(Namespace + ".dayViewGenderMax", statisticsVO);
	}
	
	// 일간 통계 View SelectBox All
	public List<StatisticsVO> daySelectAll(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectList(Namespace + ".daySelectAll", statisticsVO);
	}
	
	// 일간 통계 View All 최대값 
	public StatisticsVO dayViewAllMax(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectOne(Namespace + ".dayViewAllMax", statisticsVO);
	}
	
	/**
	 * 월간 통계 DAO
	 */
	
	// 월간 통계 View
	public List<StatisticsVO> monthView() throws Exception {

		return sqlSession.selectList(Namespace + ".monthView");
	}

	// 월간 통계 View 어제 최대값
	public StatisticsVO monthMax() throws Exception {

		return sqlSession.selectOne(Namespace + ".monthMax");
	}

	// 월간 통계 View SelectBox Place
	public List<StatisticsVO> monthSelectPlace(String month) throws Exception {

		return sqlSession.selectList(Namespace + ".monthSelectPlace", month);
	}

	// 월간 통계 View Place 최대값
	public StatisticsVO monthViewPlaceMax(String month) throws Exception {

		return sqlSession.selectOne(Namespace + ".monthViewPlaceMax", month);
	}

	// 월간 통계 View SelectBox Detail
	public List<StatisticsVO> monthSelectDetail(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectList(Namespace + ".monthSelectDetail", statisticsVO);
	}

	// 월간 통계 View Detail 최대값
	public StatisticsVO monthViewDetailMax(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectOne(Namespace + ".monthViewDetailMax", statisticsVO);
	}

	// 월간 통계 View SelectBox Floor
	public List<StatisticsVO> monthSelectFloor(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectList(Namespace + ".monthSelectFloor", statisticsVO);
	}

	// 월간 통계 View Floor 최대값
	public StatisticsVO monthViewFloorMax(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectOne(Namespace + ".monthViewFloorMax", statisticsVO);
	}

	// 월간 통계 View SelectBox Gender
	public List<StatisticsVO> monthSelectGender(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectList(Namespace + ".monthSelectGender", statisticsVO);
	}
	
	// 월간 통계 View Gender 최대값 
	public StatisticsVO monthViewGenderMax(StatisticsVO statisticsVO) throws Exception {
		
		return sqlSession.selectOne(Namespace + ".monthViewGenderMax", statisticsVO);
	}

	// 월간 통계 View SelectBox All
	public List<StatisticsVO> monthSelectAll(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectList(Namespace + ".monthSelectAll", statisticsVO);
	}

	// 월간 통계 View All 최대값
	public StatisticsVO monthViewAllMax(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectOne(Namespace + ".monthViewAllMax", statisticsVO);
	}
	
	/**
	 * 실시간 통계 DAO
	 */
	
	// 실시간 통계 View 
	public List<StatisticsVO> liveView() throws Exception {

		return sqlSession.selectList(Namespace + ".liveView");
	}

	// 실시간 통계 View SelectBox Detail
	public List<StatisticsVO> liveSelectDetail(int placeSeq) throws Exception {

		return sqlSession.selectList(Namespace + ".liveSelectDetail", placeSeq);
	}

	// 실시간 통계 View SelectBox Floor
	public List<StatisticsVO> liveSelectFloor(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectList(Namespace + ".liveSelectFloor", statisticsVO);
	}

	// 실시간 통계 View SelectBox Gender
	public List<StatisticsVO> liveSelectGender(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectList(Namespace + ".liveSelectGender", statisticsVO);
	}
	
	// 실시간 통계 View SelectBox All
	public List<StatisticsVO> liveSelectAll(StatisticsVO statisticsVO) throws Exception {

		return sqlSession.selectList(Namespace + ".liveSelectAll", statisticsVO);
	}
}
