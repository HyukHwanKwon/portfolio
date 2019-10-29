package com.chungrim.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chungrim.service.CleanerService;
import com.chungrim.service.RaspberrypiService;
import com.chungrim.vo.CleanerDetailVO;
import com.chungrim.vo.CleanerVO;
import com.chungrim.vo.RaspberrypiVO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class AndroidURLConnection {
	
	@Inject
	private CleanerService cleanerService;
	
	@Inject
	private RaspberrypiService raspberrypiService;
	
	@RequestMapping(value = "/androidConnection.do")
	public String URLConnection(HttpServletRequest request) throws Exception {
		String result = "{\"resultCode\" : \"404\"}";
		
		String id = String.valueOf(request.getParameter("id"));
		String password = String.valueOf(request.getParameter("password"));
		CleanerVO cleaner = new CleanerVO();
		cleaner.setCleanerId(id);
		cleaner.setCleanerPassword(password);
		
		cleaner = cleanerService.selectCleanerInfo(cleaner);
		
		if(cleaner != null) {
			if("2".equals(cleaner.getCleanerStatus())) {
				result = "{\"resultCode\" : \"303\"}";
			} else if("0".equals(cleaner.getCleanerStatus())) {
				result = "{\"resultCode\" : \"304\"}";
			} else {
				result = "{\"resultCode\" : \"200\", \"cleanerName\" : \"" + cleaner.getCleanerName() + "\", \"cleanerId\" : \"" + cleaner.getCleanerId()+ "\"}";
			}
		}
		
		request.setAttribute("result", result);
		
		
		return "android/login";
	}
	
	@RequestMapping("/registAction.do")
	public String registAction(HttpServletRequest request) throws Exception {
		String result = "{\"resultCode\" : \"404\"}";
		
		String id = String.valueOf(request.getParameter("id"));
		String uName = String.valueOf(request.getParameter("uName"));
		String password = String.valueOf(request.getParameter("password"));
		String phoneNum = String.valueOf(request.getParameter("phoneNum"));
		String token = String.valueOf(request.getParameter("token"));
		
		CleanerVO cleaner = new CleanerVO();
		cleaner.setCleanerId(id);
		
		cleaner = cleanerService.checkCleanerInfo(cleaner);
		
		if(cleaner == null) {
			result = "{\"resultCode\" : \"200\"}";
			
			CleanerVO obj = new CleanerVO();
			
			obj.setCleanerId(id);
			obj.setCleanerName(uName);
			obj.setCleanerPassword(password);
			obj.setCleanerPhone(phoneNum);
			obj.setCleanerToken(token);
			
			cleanerService.insertCleaner(obj);
		}
		
		request.setAttribute("result", result);
		
		return "android/regist";
	}
	
	@RequestMapping("/selectCleanerMainView.do")
	public String selectCleanerMainView(HttpServletRequest request) throws Exception {
		
		String id = String.valueOf(request.getParameter("id")); 
		CleanerVO cleaner = new CleanerVO();
		cleaner.setCleanerId(id);
		
		List<CleanerDetailVO> list = cleanerService.selectCleanerDetailInfo(cleaner);
		
		JsonArray arr = new JsonArray();
		
		for(int i = 0; i < list.size(); i++) {
			JsonObject obj = new JsonObject();
			obj.addProperty("cleanerName", list.get(i).getCleanerName());
			obj.addProperty("detailName", list.get(i).getDetailName());
			obj.addProperty("floorName", list.get(i).getFloorName());
			obj.addProperty("genderName", list.get(i).getGenderName());
			obj.addProperty("placeName", list.get(i).getPlaceName());
			obj.addProperty("trashAmount", list.get(i).getTrashAmount());
			arr.add(obj);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("resultCode", "200");
		json.add("list", arr);
		
		request.setAttribute("result", json);
		
		return "android/main";
	}
	
	@RequestMapping("/testSelect.do")
	public String selectPlace(HttpServletRequest request) throws Exception {
		
		List<RaspberrypiVO> list = raspberrypiService.getPlaceList();
		
		JsonArray arr = new JsonArray();
		
		for(int i = 0; i < list.size(); i++) {
			JsonObject obj = new JsonObject();
			obj.addProperty("raspberryPiIp", list.get(i).getRaspberrypiIp());
			obj.addProperty("placeName", list.get(i).getPlaceName());
			arr.add(obj);
		}
		JsonObject json = new JsonObject();
		json.addProperty("resultCode", "200");
		json.add("list", arr);
		
		request.setAttribute("result", json);
		String result = "{\"resultCode\" : \"200\", {\"list\" : \"" + list + "\"}}";
		//request.setAttribute("result", result);
		return "android/main";
	}
}
