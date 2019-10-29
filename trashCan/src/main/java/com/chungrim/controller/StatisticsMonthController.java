package com.chungrim.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chungrim.service.MappingService;
import com.chungrim.service.StatisticsService;
import com.chungrim.vo.*;

@Controller
public class StatisticsMonthController {
	
	@Inject
	private StatisticsService statisticsService;
	
	@Inject
	private MappingService mappingService;
	
	// 월간 통계  View 및 selectBox Month + 최대값 
	@RequestMapping(value = "/statistics/statisticsMonth.do")
	public ModelAndView monthView() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		StatisticsVO monthMax = statisticsService.monthMax();
		List<StatisticsVO> monthView = statisticsService.monthView();
		List<StatisticsVO> selectMonth = statisticsService.daySelectMonth();
		
		mav.setViewName("statistics/statisticsMonth");
		mav.addObject("monthView", monthView);
		mav.addObject("monthMax", monthMax);
		mav.addObject("month", selectMonth);
		
		int piCount = mappingService.piCount();
		int cleanCount = mappingService.cleanCount();
		int mapCount = mappingService.mapCount();
		mav.addObject("piCount", piCount);
		mav.addObject("cleanCount", cleanCount);
		mav.addObject("mapCount", mapCount);
		
		return mav;
	}
	
	// 월간 통계 View SelectBox Month
	@RequestMapping(value = "/statistics/monthSelectMonth.do")
	public @ResponseBody List<StatisticsVO> monthSelectMonth() throws Exception {

		List<StatisticsVO> monthView = statisticsService.monthView();
		StatisticsVO monthMax = statisticsService.monthMax();
		
		monthView.add(monthMax);
		
		return monthView;
	}
		
	// 월간 통계 View SelectBox Place + 최대값
	@RequestMapping(value = "/statistics/monthSelectPlace.do")
	public @ResponseBody List<StatisticsVO> monthSelectPlace(@RequestParam(value = "month") String month) throws Exception {
				
		List<StatisticsVO> placeView = statisticsService.monthSelectPlace(month);
		StatisticsVO placeMax = statisticsService.monthViewPlaceMax(month);
		
		placeView.add(placeMax);
		
		return placeView;
	}
	
	// 월간 통계 View SelectBox Detail + 최대값
	@RequestMapping(value = "/statistics/monthSelectDetail.do")
	public @ResponseBody List<StatisticsVO> monthSelectDetail(@RequestParam(value = "month") String month,
			@RequestParam(value = "placeSeq") int placeSeq) throws Exception {
		
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setMonth(month);
		statisticsVO.setPlaceSeq(placeSeq);
		
		List<StatisticsVO> detailView = statisticsService.monthSelectDetail(statisticsVO);
		StatisticsVO detailMax = statisticsService.monthViewDetailMax(statisticsVO);
		
		detailView.add(detailMax);
		
		return detailView;
	}
	
	// 월간 통계 View SelectBox Floor + 최대값
	@RequestMapping(value = "/statistics/monthSelectFloor.do")
	public @ResponseBody List<StatisticsVO> monthSelectFloor(@RequestParam(value = "month") String month,
			@RequestParam(value = "placeSeq") int placeSeq,
			@RequestParam(value = "detailSeq") int detailSeq) throws Exception {

		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setMonth(month);
		statisticsVO.setPlaceSeq(placeSeq);
		statisticsVO.setDetailSeq(detailSeq);
		
		List<StatisticsVO> floorView = statisticsService.monthSelectFloor(statisticsVO);
		StatisticsVO floorMax = statisticsService.monthViewFloorMax(statisticsVO);
		
		floorView.add(floorMax);
		
		return floorView;
	}
	
	// 월간 통계 View SelectBox Gender + 최대값
	@RequestMapping(value = "/statistics/monthSelectGender.do")
	public @ResponseBody List<StatisticsVO> monthSelectGender(@RequestParam(value = "month") String month,
			@RequestParam(value = "placeSeq") int placeSeq,
			@RequestParam(value = "detailSeq") int detailSeq,
			@RequestParam(value = "floorSeq") int floorSeq) throws Exception {
		
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setMonth(month);
		statisticsVO.setPlaceSeq(placeSeq);
		statisticsVO.setDetailSeq(detailSeq);
		statisticsVO.setFloorSeq(floorSeq);
		
		List<StatisticsVO> genderView = statisticsService.monthSelectGender(statisticsVO);
		StatisticsVO genderMax = statisticsService.monthViewGenderMax(statisticsVO);
		
		genderView.add(genderMax);
		
		return genderView;
	}
	
	// 월간 통계 View SelectBox All + 최대값
	@RequestMapping(value = "/statistics/monthSelectAll.do")
	public @ResponseBody List<StatisticsVO> monthSelectAll(@RequestParam(value = "month") String month,
			@RequestParam(value = "placeSeq") int placeSeq,
			@RequestParam(value = "detailSeq") int detailSeq,
			@RequestParam(value = "floorSeq") int floorSeq,
			@RequestParam(value = "genderNum") int genderNum) throws Exception {

		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setMonth(month);
		statisticsVO.setPlaceSeq(placeSeq);
		statisticsVO.setDetailSeq(detailSeq);
		statisticsVO.setFloorSeq(floorSeq);
		statisticsVO.setGenderNum(genderNum);
		
		List<StatisticsVO> allView = statisticsService.monthSelectAll(statisticsVO);
		StatisticsVO allMax = statisticsService.monthViewAllMax(statisticsVO);
		
		allView.add(allMax);
		
		return allView;
	}
}