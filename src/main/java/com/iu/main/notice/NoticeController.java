package com.iu.main.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.main.util.Pager;

@Controller
@RequestMapping("./board/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model)throws Exception{
		List<NoticeDTO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	@RequestMapping(value = "detail")
	public ModelAndView getDetail(NoticeDTO noticeDTO, ModelAndView mv)throws Exception{
		
		//bankBookDTO.setBookNum(Long.parseLong(requestMapping.getParameter("bookNum"));
		noticeDTO = noticeService.getDetail(noticeDTO);
		System.out.println(noticeDTO.getNoticeName());
		mv.addObject("dto", noticeDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	//form
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void setAdd()throws Exception{
		
	}
	
	//db insert
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setAdd(noticeDTO);
		return "redirect:./list";
	}
	
	//수정form
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setUpdate(NoticeDTO noticeDTO,Model model)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/update");
		mv.addObject("dto", noticeDTO);
		return mv;
	}
	
	//update
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO)throws Exception{
		int result = noticeService.setUpdate(noticeDTO);
		//return "redirect:./list";
		return "redirect:./detail?bookNum="+noticeDTO.getNoticeNum();
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String setDelete(@RequestParam(name = "noticeNum") Long num)throws Exception{
		int result = noticeService.setDelete(num);
		
		return "redirect:./list";
	}
	
}
