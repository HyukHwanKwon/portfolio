package com.chungrim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chungrim.service.MappingService;
import com.chungrim.service.StatisticsService;
import com.chungrim.vo.StatisticsVO;

@Controller
public class MainController {

	@Inject
	private StatisticsService statisticsService;
	
	@Inject
	private MappingService mappingService;
	
	// 메인화면  + 일별 통계  View
	@RequestMapping(value = "/main/statisticsDayMain.do")
	public ModelAndView dayView() throws Exception {
		List<StatisticsVO> dayViewList = new ArrayList<StatisticsVO>();
		ModelAndView mav = new ModelAndView();
		StatisticsVO dayMax = statisticsService.dayMax();
		dayViewList = statisticsService.dayView();
		mav.addObject("dayView", dayViewList);
		mav.addObject("dayMax", dayMax);
		
		int piCount = mappingService.piCount();
		int cleanCount = mappingService.cleanCount();
		int mapCount = mappingService.mapCount();
		mav.addObject("piCount", piCount);
		mav.addObject("cleanCount", cleanCount);
		mav.addObject("mapCount", mapCount);
		
		mav.setViewName("main/statisticsDayMain");
		
		return mav;
	}
}
