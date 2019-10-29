package com.chungrim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chungrim.service.CleanerService;
import com.chungrim.service.MappingService;
import com.chungrim.vo.CleanerVO;

@Controller
public class CleanerController {
	@Inject
	private CleanerService cleanerService;
	
	@Inject
	private MappingService mappingService;

	@RequestMapping(value = "cleaner/cleanerList.do")
	public ModelAndView cleanerList() throws Exception {
		List<CleanerVO> cleanerVO = new ArrayList<CleanerVO>();
		cleanerVO = cleanerService.cleanerList();
		ModelAndView mav = new ModelAndView();

		if (cleanerVO != null) {
			mav.setViewName("cleaner/cleanerList");
			mav.addObject("cleaner", cleanerVO);
			
			int piCount = mappingService.piCount();
			int cleanCount = mappingService.cleanCount();
			int mapCount = mappingService.mapCount();
			mav.addObject("piCount", piCount);
			mav.addObject("cleanCount", cleanCount);
			mav.addObject("mapCount", mapCount);
		} else {
			mav.addObject("msg", "cleanerListFail");
			mav.setViewName("main/main");
		}
		return mav;
	}

	@RequestMapping(value = "cleaner/cleanerDelete.do")
	public ModelAndView deleteCleanerInfo(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");	
		int x = cleanerService.deleteCleaner(id);
		
		if (x > 0) {
			mav.addObject("msg", "cleanerDeleteOk");
			mav.setViewName("main/main");
		} else {
			mav.setViewName("cleaner/cleanerList");
		}
		return mav;
	}
	
	@RequestMapping(value = "/cleaner/cleanerLicenseUpdate.do")
	public String updateForm(HttpServletRequest request) throws Exception {
	String result = "";
	CleanerVO cleanerVO = new CleanerVO();
	
	cleanerVO.setCleanerId(request.getParameter("id"));
	
	int update = cleanerService.cleanerLicenseUpdate(cleanerVO);
		if (update >0) {
			result = "redirect:cleanerList.do";
		} else {
			result = "redirect:cleanerLicense.do";
		}
		return result;
	}
	
	@RequestMapping(value = "/cleaner/cleanerLicenseList.do")
	public ModelAndView cleanerLicenseForm() throws Exception {
		List<CleanerVO> cleanerVO = new ArrayList<CleanerVO>();
		cleanerVO = cleanerService.cleanerLicenseList();	
		ModelAndView mav = new ModelAndView();

		if (cleanerVO != null) {
			mav.setViewName("cleaner/cleanerLicense");
			mav.addObject("cleaner", cleanerVO);
			
			int piCount = mappingService.piCount();
			int cleanCount = mappingService.cleanCount();
			int mapCount = mappingService.mapCount();
			mav.addObject("piCount", piCount);
			mav.addObject("cleanCount", cleanCount);
			mav.addObject("mapCount", mapCount);
			
		} else {
			mav.addObject("msg", "cleanerLicenseFail");
			mav.setViewName("main/main");
		}
		return mav;
	}
	
	@RequestMapping(value = "cleaner/cleanerInsert.do")
	public ModelAndView insertCleanerInfo(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		CleanerVO clv = new CleanerVO();
		
		clv.setCleanerId(request.getParameter("cleanerId"));
		clv.setCleanerPassword(request.getParameter("cleanerPassword"));
		clv.setCleanerName(request.getParameter("cleanerName"));
		clv.setCleanerPhone(request.getParameter("cleanerPhone"));
		
		int x = cleanerService.insertCleaner(clv);

		if (x > 0) {
			mav.addObject("msg", "cleanerInsertOk");
			mav.setViewName("main/main");
		} else {
			mav.setViewName("cleaner/cleanerList");
		}
		return mav;
	}

}

