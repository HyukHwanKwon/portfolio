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
import com.chungrim.vo.StatisticsVO;

@Controller
public class StatisticsLiveController {
	
	@Inject
	private StatisticsService statisticsService;
	
	@Inject
	private MappingService mappingService;
	
	// 실시간 통계 View 
	@RequestMapping(value = "/statistics/statisticsLive.do")
	public ModelAndView registerForm() throws Exception {
		List<StatisticsVO> liveView = statisticsService.liveView();
		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("statistics/statisticsLive");
		mav.addObject("place", liveView);
		
		int piCount = mappingService.piCount();
		int cleanCount = mappingService.cleanCount();
		int mapCount = mappingService.mapCount();
		mav.addObject("piCount", piCount);
		mav.addObject("cleanCount", cleanCount);
		mav.addObject("mapCount", mapCount);
		
		return mav;
	}
	
	// 실시간 통계 View SelectBox Detail
	@RequestMapping(value="/statistics/liveSelectDetail.do")
	public @ResponseBody List<StatisticsVO> liveSelectDetail(@RequestParam(value = "placeSeq") Integer placeSeq) throws Exception {
		List<StatisticsVO> detail = statisticsService.liveSelectDetail(placeSeq);
		
		return detail;
	}
	
	// 실시간 통계 View SelectBox Floor
	@RequestMapping(value = "/statistics/liveSelectFloor.do")
	public @ResponseBody List<StatisticsVO> liveSelectFloor(@RequestParam(value = "placeSeq") Integer placeSeq,
			@RequestParam(value = "detailSeq") Integer detailSeq) throws Exception {
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setDetailSeq(detailSeq);
		statisticsVO.setPlaceSeq(placeSeq);
		
		List<StatisticsVO> floor = statisticsService.liveSelectFloor(statisticsVO);
		
		return floor;
	}
	
	// 실시간 통계 View SelectBox Gender
	@RequestMapping(value = "/statistics/liveSelectGender.do")
	public @ResponseBody List<StatisticsVO> liveSelectGender(@RequestParam(value = "placeSeq") Integer placeSeq,
			@RequestParam(value = "detailSeq") Integer detailSeq,
			@RequestParam(value = "floorSeq") Integer floorSeq) throws Exception {
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setDetailSeq(detailSeq);
		statisticsVO.setPlaceSeq(placeSeq);
		statisticsVO.setFloorSeq(floorSeq);
		
		List<StatisticsVO> gender = statisticsService.liveSelectGender(statisticsVO);
		
		return gender;
	}
	
	// 실시간 통계 View SelectBox All
	@RequestMapping(value="/statistics/liveSelectAll.do")
	public @ResponseBody List<StatisticsVO> liveSelectAll(@RequestParam(value = "placeSeq") Integer placeSeq,
			@RequestParam(value = "detailSeq") Integer detailSeq,
			@RequestParam(value = "floorSeq") Integer floorSeq,
			@RequestParam(value = "genderNum") Integer genderNum) throws Exception {
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setDetailSeq(detailSeq);
		statisticsVO.setPlaceSeq(placeSeq);
		statisticsVO.setFloorSeq(floorSeq);
		statisticsVO.setGenderNum(genderNum);
		
		List<StatisticsVO> liveView = statisticsService.liveSelectAll(statisticsVO);
		
		return liveView;
	}
}
