package com.iu.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

	//Add_mybatis

	//Add_Board

	
	//home
	// / 주소가 왔을 때 실행, index.jsp
	
	//BankBookController
	//MemberController, GET
	//주소 .do 삭제
	// /member/login
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
