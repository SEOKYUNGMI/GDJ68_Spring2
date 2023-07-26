package com.iu.main.bankBook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.Mytest;


public class BankBookDAOTest extends Mytest {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void addTest()throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0;i<30;i++) {
		
		bankBookDTO.setBookName("희망적금"+i);
		bankBookDTO.setBookContents("희망적금 내용"+i);
		bankBookDTO.setBookRate(2.3);
		bankBookDTO.setBookSale(1);
		bankBookDAO.setAdd(bankBookDTO);
	    }	
		System.out.println("Finish");

	}


}
