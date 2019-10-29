package com.chungrim.controller;



import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chungrim.service.AdminService;
import com.chungrim.service.MappingService;
import com.chungrim.vo.AdminVO;

@Controller
public class AdminController {

	@Inject
	private AdminService adminService;
	@Inject
	MappingService mappingService;
	
	// 로그인 FORM
	@RequestMapping(value = "/")
	public String index() throws Exception {

		return "administrator/adminLoginForm";
	}

	// 로그인 처리
	@RequestMapping(value = "/adminLogin.do", method = RequestMethod.POST)
	public ModelAndView adminLogin(HttpServletRequest request, AdminVO adminVO) throws Exception {
		adminVO = adminService.adminLogin(adminVO);
		ModelAndView mav = new ModelAndView();
		
		if (adminVO != null) {
			mav.setViewName("main/main");
			mav.addObject("msg", "loginOk");
			request.getSession().setAttribute("admin", adminVO);
			request.getSession().setMaxInactiveInterval(60*30);
		} else {
			mav.setViewName("administrator/loginFail");
		}
		return mav;
	}
	
	// 로그아웃 처리
	@RequestMapping(value = "/adminLogOut.do")
	public ModelAndView adminLogOut(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.getSession().invalidate();
		
		mav.setViewName("administrator/adminLoginForm");
		
		return mav;
	}
}
