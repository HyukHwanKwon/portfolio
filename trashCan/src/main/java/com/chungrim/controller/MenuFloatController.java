package com.chungrim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chungrim.service.MappingService;

@Controller
@RequestMapping(value = "/")
public class MenuFloatController {
	@Autowired
	MappingService mappingService;
	
	@RequestMapping(value = "/menuFloat")
	public String menuFloat(Model model) throws Exception {
		int piCount = mappingService.piCount();
		int cleanCount = mappingService.cleanCount();
		int mapCount = mappingService.mapCount();
		model.addAttribute("piCount",piCount);
		model.addAttribute("cleanCount",cleanCount);
		model.addAttribute("mapCount", mapCount);
		return "include/floatMenu";
	}
}
