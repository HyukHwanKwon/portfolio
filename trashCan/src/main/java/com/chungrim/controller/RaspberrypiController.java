package com.chungrim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chungrim.service.MappingService;
import com.chungrim.service.RaspberrypiService;
import com.chungrim.vo.RaspberrypiVO;

@Controller
public class RaspberrypiController {

	@Inject
	private RaspberrypiService piService;
	@Inject
	private MappingService mappingService;
		
	// 라즈베리파이 등록 Form
	@RequestMapping(value = "/raspberrypi/RegisterForm.do")
	public ModelAndView registerForm() throws Exception {
		List<RaspberrypiVO> place = new ArrayList<RaspberrypiVO>();
		List<RaspberrypiVO> floor = new ArrayList<RaspberrypiVO>();
		List<RaspberrypiVO> gender = new ArrayList<RaspberrypiVO>();
		floor = piService.getFloorList();
		gender = piService.getGenderList();
		place = piService.getPlaceList();
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("raspberrypi/raspberrypiRegisterForm");
		mav.addObject("place", place);
		mav.addObject("gender", gender);
		mav.addObject("floor", floor);
		
		int piCount = mappingService.piCount();
		int cleanCount = mappingService.cleanCount();
		int mapCount = mappingService.mapCount();
		mav.addObject("piCount", piCount);
		mav.addObject("cleanCount", cleanCount);
		mav.addObject("mapCount", mapCount);

		return mav;
	}

	// 등록 Form selectBox Detail 가져오기
	@RequestMapping(value = "/raspberrypi/detailList.do")
	public @ResponseBody List<RaspberrypiVO> detailList(@RequestParam(value = "fkPlaceSeq") Integer fkPlaceSeq) throws Exception {
		List<RaspberrypiVO> detail = piService.getDetailList(fkPlaceSeq);
		return detail;
	}

	// 라즈베리파이 등록
	@RequestMapping(value = "/raspberrypi/Insert.do", method = RequestMethod.POST)
	public ModelAndView insertRaspberrypi(HttpServletRequest request) throws Exception {
		boolean success;
		RaspberrypiVO piVO = new RaspberrypiVO();
		
		piVO.setRaspberrypiIp(request.getParameter("raspberrypiIP"));
		piVO.setFloorSeq(Integer.parseInt(request.getParameter("floor")));
		piVO.setDetailSeq(Integer.parseInt(request.getParameter("detail")));
		piVO.setPlaceSeq(Integer.parseInt(request.getParameter("place")));
		piVO.setGenderNum(Integer.parseInt(request.getParameter("gender")));
		
		success = piService.insertRaspberrypi(piVO);
		ModelAndView mav = new ModelAndView();

		if (success == true) {
			mav.setViewName("raspberrypi/registerIndex");
			mav.addObject("msg", "insertSuccess");
		} else {
			mav.setViewName("raspberrypi/registerIndex");
			mav.addObject("msg", "insertFail");
		}
		return mav;
	}
	
	// 관리 view 라즈베리파이 정보 가져오기(전체 다 선택)
	@RequestMapping(value = "/raspberrypi/managementPi.do")
	public @ResponseBody List<RaspberrypiVO> managementPi(@RequestParam(value = "fkFloorSeq") Integer fkFloorSeq, 
			@RequestParam(value = "fkDetailSeq") Integer fkDetailSeq, @RequestParam(value = "fkGenderNum") Integer fkGenderNum, 
			@RequestParam(value = "fkPlaceSeq") Integer fkPlaceSeq) throws Exception {
		RaspberrypiVO piVO = new RaspberrypiVO();
		
		piVO.setPlaceSeq(fkPlaceSeq);
		piVO.setDetailSeq(fkDetailSeq);
		piVO.setFloorSeq(fkFloorSeq);
		piVO.setGenderNum(fkGenderNum);
		
		List<RaspberrypiVO> raspberrypi = piService.managementPi(piVO);

		return raspberrypi;
	}
	
	// 관리 view 라즈베리파이 정보 가져오기(place만 선택)
	@RequestMapping(value = "/raspberrypi/managementPiPlace.do")
	public @ResponseBody List<RaspberrypiVO> managementPiPlace(@RequestParam(value = "fkPlaceSeq") Integer fkPlaceSeq) throws Exception {
		
		List<RaspberrypiVO> raspberrypi = piService.managementPiPlace(fkPlaceSeq);

		return raspberrypi;
	}
	
	// 관리 view 라즈베리파이 정보 가져오기(place, detail 선택)
	@RequestMapping(value = "/raspberrypi/managementPiDetail.do")
	public @ResponseBody List<RaspberrypiVO> managementPiDetail(@RequestParam(value = "fkDetailSeq") Integer fkDetailSeq, 
			@RequestParam(value = "fkPlaceSeq") Integer fkPlaceSeq) throws Exception {
		RaspberrypiVO piVO = new RaspberrypiVO();
		
		piVO.setPlaceSeq(fkPlaceSeq);
		piVO.setDetailSeq(fkDetailSeq);
		
		List<RaspberrypiVO> raspberrypi = piService.managementPiDetail(piVO);

		return raspberrypi;
	}
	
	// 관리 view 라즈베리파이 정보 가져오기(place, detail, floor 선택)
	@RequestMapping(value = "/raspberrypi/managementPiFloor.do")
	public @ResponseBody List<RaspberrypiVO> managementPiFloor(@RequestParam(value = "fkFloorSeq") Integer fkFloorSeq, 
			@RequestParam(value = "fkDetailSeq") Integer fkDetailSeq, @RequestParam(value = "fkPlaceSeq") Integer fkPlaceSeq) throws Exception {
		RaspberrypiVO piVO = new RaspberrypiVO();
		
		piVO.setPlaceSeq(fkPlaceSeq);
		piVO.setDetailSeq(fkDetailSeq);
		piVO.setFloorSeq(fkFloorSeq);
		
		List<RaspberrypiVO> raspberrypi = piService.managementPiFloor(piVO);

		return raspberrypi;
	}
	
	// 라즈베리파이 관리 view
	@RequestMapping(value = "/raspberrypi/Management.do")
	public ModelAndView ManagementView() throws Exception {
		List<RaspberrypiVO> piPlace = new ArrayList<RaspberrypiVO>();
		piPlace = piService.managementPlace();
		ModelAndView mav = new ModelAndView();

		mav.setViewName("raspberrypi/raspberrypiManagement");
		mav.addObject("place", piPlace);
		
		int piCount = mappingService.piCount();
		int cleanCount = mappingService.cleanCount();
		int mapCount = mappingService.mapCount();
		mav.addObject("piCount", piCount);
		mav.addObject("cleanCount", cleanCount);
		mav.addObject("mapCount", mapCount);
		
		return mav;
	}
	
	// 라즈베리파이 정보 가져오기
	@RequestMapping(value = "/raspberrypi/infomation.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView piInfomation(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String ip = request.getParameter("ip");
		RaspberrypiVO piVO = new RaspberrypiVO();
		
		piVO = piService.getPiInfomation(ip);

		mav.setViewName("raspberrypi/raspberrypiStatus");
		mav.addObject("raspberrypi", piVO);
		
		return mav;
	}
	
	// 라즈베리파이 상태 값 수정
	@RequestMapping(value = "/raspberrypi/update.do",  method = RequestMethod.POST)
	public ModelAndView piUpdate(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		RaspberrypiVO piVO = new RaspberrypiVO();
		
		piVO.setRaspberrypiIp(request.getParameter("ip"));
		piVO.setRaspberrypiStatus(request.getParameter("status"));
		
		boolean update;
		
		System.out.println(piVO);
		
		update = piService.updateRaspberrypi(piVO);
		
		if (update == true) {
			mav.setViewName("raspberrypi/registerIndex");
			mav.addObject("msg", "updateSuccess");
			mav.addObject("raspberrypi", piVO);
			System.out.println(piVO);
		} else {
			mav.setViewName("raspberrypi/registerIndex");
			mav.addObject("msg", "updateFail");
			mav.addObject("raspberrypi", piVO);
		}
		
		return mav;
	}
	
	// 관리 selectBox Detail 가져오기
	@RequestMapping(value = "/raspberrypi/managementDetail.do")
	public @ResponseBody List<RaspberrypiVO> managementDetail(@RequestParam(value = "fkPlaceSeq") Integer fkPlaceSeq) throws Exception {
		List<RaspberrypiVO> detail = piService.managementDetail(fkPlaceSeq);
		return detail;
	}
	
	// 관리 selectBox Floor 가져오기
	@RequestMapping(value = "/raspberrypi/managementFloor.do")
	public @ResponseBody List<RaspberrypiVO> managementFloor(@RequestParam(value = "fkDetailSeq") Integer fkDetailSeq) throws Exception {
		List<RaspberrypiVO> floor = piService.managementFloor(fkDetailSeq);
		return floor;
	}
	
	// 관리 selectBox Gender 가져오기
	@RequestMapping(value = "/raspberrypi/managementGender.do")
	public @ResponseBody List<RaspberrypiVO> managementGender(@RequestParam(value = "fkFloorSeq") Integer fkFloorSeq, 
			@RequestParam(value = "fkDetailSeq") Integer fkDetailSeq) throws Exception {
		RaspberrypiVO piVO = new RaspberrypiVO();
		
		piVO.setDetailSeq(fkDetailSeq);
		piVO.setFloorSeq(fkFloorSeq);
		List<RaspberrypiVO> gender = piService.managementGender(piVO);
		return gender;
	}
}
