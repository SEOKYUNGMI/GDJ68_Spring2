package com.iu.main.di;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Dependency Injection(의존성 주입)
		//1. method
		//2. 생성자
		
		
		Arm arm = new Arm();
		Robot robot = new Robot(arm);
		
		robot.setArm(arm);
		
		robot=null;
		
		
		

	}

}
