package com.chungrim.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chungrim.service.MappingService;
import com.chungrim.vo.CleanerVO;
import com.chungrim.vo.MappingPageVO;
import com.chungrim.vo.MappingVO;
import com.chungrim.vo.RaspberrypiVO;


@Controller
@RequestMapping("/mapping/*")
public class MappingController {
	
		@Inject
		private MappingService mappingService;
		
		@RequestMapping(value = "" ,method = { RequestMethod.GET})
		public String home(Model model,@RequestParam(value = "piPageNum",required = false) String piPageNum) throws Exception {
			//pi,cleaner list 페이징
			List<RaspberrypiVO> pilist = new ArrayList<RaspberrypiVO>();
			List<CleanerVO> clist = new ArrayList<CleanerVO>();
			int cPageNum = 1;
			System.out.println("****************"+piPageNum+"================");
			if(piPageNum != null) {
				cPageNum = Integer.parseInt(piPageNum);
			}
			MappingPageVO pageVO = new MappingPageVO();
			System.out.println("****************"+cPageNum+"***1****************");
			pageVO.setTotalCount(mappingService.piCount());
			pageVO.setPageNum(cPageNum-1);
			System.out.println("****************"+cPageNum+"***2****************");
			pageVO.setCurrentBlock(cPageNum);
			pageVO.setLastBlock(pageVO.getTotalCount());
			pageVO.prevNext(cPageNum);
			pageVO.setStartPage(pageVO.getCurrentBlock());
			pageVO.setEndPage(pageVO.getLastBlock(), pageVO.getCurrentBlock());
			System.out.println("****************"+pageVO.getStartPage()+"***3****************");
			System.out.println("****************"+pageVO.getEndPage()+"***4****************");
			pilist = mappingService.selectPI(pageVO.getPageNum()*5);
			clist = mappingService.selectClean();
			System.out.println("****************"+mappingService.piCount()+"***5****************");
			model.addAttribute("piList", pilist);
			model.addAttribute("page",pageVO);
			model.addAttribute("cList", clist);
			
			int piCount = mappingService.piCount();
			int cleanCount = mappingService.cleanCount();
			int mapCount = mappingService.mapCount();
			model.addAttribute("piCount", piCount);
			model.addAttribute("cleanCount", cleanCount);
			model.addAttribute("mapCount", mapCount);
			
			return "mapping/mapHome";
		}
		
		@RequestMapping(value = "reg", method = { RequestMethod.POST })
		@ResponseBody
		public int reg( @RequestParam(value = "piValues[]")List<String> piValues,
						@RequestParam(value = "cleanID")String cleanID) throws Exception {
			int success = 0;
			MappingVO mapVO = new MappingVO();
			
			for (String str : piValues) {
				mapVO.setRaspberrypiIp(str); 
				mapVO.setCleanerId(cleanID);
				success = mappingService.insertMap(mapVO);
			}
			
			if(success == 1) {
				success = 0;
				for (String str:piValues)
					success = mappingService.mapComp(str);
			}
			return success;
		}
		
		@RequestMapping(value = "mappingList")
		public String mapList(Model model) throws Exception{
			List<MappingVO> maplist = new ArrayList<MappingVO>();
			maplist = mappingService.selectMap();
			model.addAttribute("maplist",maplist);
			
			int piCount = mappingService.piCount();
			int cleanCount = mappingService.cleanCount();
			int mapCount = mappingService.mapCount();
			model.addAttribute("piCount", piCount);
			model.addAttribute("cleanCount", cleanCount);
			model.addAttribute("mapCount", mapCount);
			
			return "mapping/mapList";
		}
		
		@RequestMapping(value = "delete" , method = {RequestMethod.POST})
		@ResponseBody
		public int delete(@RequestParam(value = "deleteValues[]")List<String> deleteValues,HttpServletResponse response) throws Exception {
			int success = 0;
			for(String str : deleteValues) {
				success = mappingService.deleteMap(str);
			}
			if (success > 0) 
				for(String str : deleteValues) {
					success = 0;
					success = mappingService.updateMap(str);
				}
			return success;
		}
}