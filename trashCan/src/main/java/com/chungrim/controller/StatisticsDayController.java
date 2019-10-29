package com.chungrim.controller;

import java.util.ArrayList;
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
public class StatisticsDayController {
	
	@Inject
	private StatisticsService statisticsService;
	
	@Inject
	private MappingService mappingService;
	
	// 일간 통계  View 및 selectBox Month + 최대값 
	@RequestMapping(value = "/statistics/statisticsDay.do")
	public ModelAndView dayView() throws Exception {
		List<StatisticsVO> dayView = new ArrayList<StatisticsVO>();
		List<StatisticsVO> selectMonth = new ArrayList<StatisticsVO>();
		ModelAndView mav = new ModelAndView();
		
		StatisticsVO dayMax = statisticsService.dayMax();
		dayView = statisticsService.dayView();
		selectMonth = statisticsService.daySelectMonth();
		
		mav.setViewName("statistics/statisticsDay");
		mav.addObject("dayView", dayView);
		mav.addObject("dayMax", dayMax);
		mav.addObject("month", selectMonth);
		
		int piCount = mappingService.piCount();
		int cleanCount = mappingService.cleanCount();
		int mapCount = mappingService.mapCount();
		mav.addObject("piCount", piCount);
		mav.addObject("cleanCount", cleanCount);
		mav.addObject("mapCount", mapCount);
		
		return mav;
	}
	
	// 일간 통계 View SelectBox Month
	@RequestMapping(value = "/statistics/daySelectMonth.do")
	public @ResponseBody List<StatisticsVO> daySelectMonth() throws Exception {

		List<StatisticsVO> dayView = statisticsService.dayView();
		StatisticsVO dayMax = statisticsService.dayMax();
		
		dayView.add(dayMax);
		
		return dayView;
	}
	
	// 일간 통계 View SelectBox Day
	@RequestMapping(value = "/statistics/daySelectDay.do")
	public @ResponseBody List<StatisticsVO> daySelectDay(@RequestParam(value = "month") String month) throws Exception {
		
//		if (month.equals("1")||month.equals("2")||month.equals("3")||month.equals("4")||month.equals("5")||month.equals("6")||
//				month.equals("7")||month.equals("8")||month.equals("9")) {
//			month = "%-0" + month +"-%";
//		} else {
//			month = "%-" + month + "-%";
//		}
		System.out.println("=================="+month+"%%%%%%%%%%%%%%%");
		List<StatisticsVO> day = statisticsService.daySelectDay(month);
		
		return day;
	}
	
	// 일간 통계 View SelectBox Place + 최대값
	@RequestMapping(value = "/statistics/daySelectPlace.do")
	public @ResponseBody List<StatisticsVO> daySelectPlace(@RequestParam(value = "month") String month,
			@RequestParam(value = "day") String day) throws Exception {
		
		if (month.equals("1")||month.equals("2")||month.equals("3")||month.equals("4")||month.equals("5")||month.equals("6")||
				month.equals("7")||month.equals("8")||month.equals("9")) {
			month = "%0" + month + "-";
		} else {
			month = "%" + month + "-";
		}
		
		if (day.equals("1")||day.equals("2")||day.equals("3")||day.equals("4")||day.equals("5")||day.equals("6")||
				day.equals("7")||day.equals("8")||day.equals("9")) {
			day = "0" + day + "%";
		} else {
			day = day + "%";
		}
		
		String date = month + day;
		
		List<StatisticsVO> placeView = statisticsService.daySelectPlace(date);
		StatisticsVO placeMax = statisticsService.dayViewPlaceMax(date);
		
		placeView.add(placeMax);
		
		return placeView;
	}
	
	// 일간 통계 View SelectBox Detail + 최대값
	@RequestMapping(value = "/statistics/daySelectDetail.do")
	public @ResponseBody List<StatisticsVO> daySelectDetail(@RequestParam(value = "month") String month,
			@RequestParam(value = "day") String day,
			@RequestParam(value = "placeSeq") int placeSeq) throws Exception {
		
		if (month.equals("1")||month.equals("2")||month.equals("3")||month.equals("4")||month.equals("5")||month.equals("6")||
				month.equals("7")||month.equals("8")||month.equals("9")) {
			month = "%0" + month + "-";
		} else {
			month = "%" + month + "-";
		}
		
		if (day.equals("1")||day.equals("2")||day.equals("3")||day.equals("4")||day.equals("5")||day.equals("6")||
				day.equals("7")||day.equals("8")||day.equals("9")) {
			day = "0" + day + "%";
		} else {
			day = day + "%";
		}
		
		String date = month + day;
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setDate(date);
		statisticsVO.setPlaceSeq(placeSeq);
		
		List<StatisticsVO> detailView = statisticsService.daySelectDetail(statisticsVO);
		StatisticsVO detailMax = statisticsService.dayViewDetailMax(statisticsVO);
		
		detailView.add(detailMax);
		
		return detailView;
	}
	
	// 일간 통계 View SelectBox Floor + 최대값
	@RequestMapping(value = "/statistics/daySelectFloor.do")
	public @ResponseBody List<StatisticsVO> daySelectFloor(@RequestParam(value = "month") String month,
			@RequestParam(value = "day") String day,
			@RequestParam(value = "placeSeq") int placeSeq,
			@RequestParam(value = "detailSeq") int detailSeq) throws Exception {
		
		if (month.equals("1")||month.equals("2")||month.equals("3")||month.equals("4")||month.equals("5")||month.equals("6")||
				month.equals("7")||month.equals("8")||month.equals("9")) {
			month = "%0" + month + "-";
		} else {
			month = "%" + month + "-";
		}
		
		if (day.equals("1")||day.equals("2")||day.equals("3")||day.equals("4")||day.equals("5")||day.equals("6")||
				day.equals("7")||day.equals("8")||day.equals("9")) {
			day = "0" + day + "%";
		} else {
			day = day + "%";
		}
		
		String date = month + day;
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setDate(date);
		statisticsVO.setPlaceSeq(placeSeq);
		statisticsVO.setDetailSeq(detailSeq);
		
		List<StatisticsVO> floorView = statisticsService.daySelectFloor(statisticsVO);
		StatisticsVO floorMax = statisticsService.dayViewFloorMax(statisticsVO);
		
		floorView.add(floorMax);
		
		return floorView;
	}
	
	// 일간 통계 View SelectBox Gender + 최대값
	@RequestMapping(value = "/statistics/daySelectGender.do")
	public @ResponseBody List<StatisticsVO> daySelectGender(@RequestParam(value = "month") String month,
			@RequestParam(value = "day") String day,
			@RequestParam(value = "placeSeq") int placeSeq,
			@RequestParam(value = "detailSeq") int detailSeq,
			@RequestParam(value = "floorSeq") int floorSeq) throws Exception {
		
		if (month.equals("1")||month.equals("2")||month.equals("3")||month.equals("4")||month.equals("5")||month.equals("6")||
				month.equals("7")||month.equals("8")||month.equals("9")) {
			month = "%0" + month + "-";
		} else {
			month = "%" + month + "-";
		}
		
		if (day.equals("1")||day.equals("2")||day.equals("3")||day.equals("4")||day.equals("5")||day.equals("6")||
				day.equals("7")||day.equals("8")||day.equals("9")) {
			day = "0" + day + "%";
		} else {
			day = day + "%";
		}
		
		String date = month + day;
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setDate(date);
		statisticsVO.setPlaceSeq(placeSeq);
		statisticsVO.setDetailSeq(detailSeq);
		statisticsVO.setFloorSeq(floorSeq);
		
		List<StatisticsVO> genderView = statisticsService.daySelectGender(statisticsVO);
		StatisticsVO genderMax = statisticsService.dayViewGenderMax(statisticsVO);
		
		genderView.add(genderMax);
		
		return genderView;
	}
	
	// 일간 통계 View SelectBox All + 최대값
	@RequestMapping(value = "/statistics/daySelectAll.do")
	public @ResponseBody List<StatisticsVO> daySelectAll(@RequestParam(value = "month") String month,
			@RequestParam(value = "day") String day,
			@RequestParam(value = "placeSeq") int placeSeq,
			@RequestParam(value = "detailSeq") int detailSeq,
			@RequestParam(value = "floorSeq") int floorSeq,
			@RequestParam(value = "genderNum") int genderNum) throws Exception {
		
		if (month.equals("1")||month.equals("2")||month.equals("3")||month.equals("4")||month.equals("5")||month.equals("6")||
				month.equals("7")||month.equals("8")||month.equals("9")) {
			month = "%0" + month + "-";
		} else {
			month = "%" + month + "-";
		}
		
		if (day.equals("1")||day.equals("2")||day.equals("3")||day.equals("4")||day.equals("5")||day.equals("6")||
				day.equals("7")||day.equals("8")||day.equals("9")) {
			day = "0" + day + "%";
		} else {
			day = day + "%";
		}
		
		String date = month + day;
		StatisticsVO statisticsVO = new StatisticsVO();
		
		statisticsVO.setDate(date);
		statisticsVO.setPlaceSeq(placeSeq);
		statisticsVO.setDetailSeq(detailSeq);
		statisticsVO.setFloorSeq(floorSeq);
		statisticsVO.setGenderNum(genderNum);
		
		List<StatisticsVO> allView = statisticsService.daySelectAll(statisticsVO);
		StatisticsVO allMax = statisticsService.dayViewAllMax(statisticsVO);
		
		allView.add(allMax);
		
		return allView;
	}
}
