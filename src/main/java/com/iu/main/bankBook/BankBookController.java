package com.iu.main.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList(Model model)throws Exception{
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail")
	public ModelAndView getDetail(BankBookDTO bankBookDTO, ModelAndView mv)throws Exception{
		
		//bankBookDTO.setBookNum(Long.parseLong(requestMapping.getParameter("bookNum"));
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		System.out.println(bankBookDTO.getBookName());
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
	}

}
