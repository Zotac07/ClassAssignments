package com.lti.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.model.Users;
import com.lti.service.UserService;
import com.lti.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-content.xml");
		UserService services = context.getBean("service",UserServiceImpl.class);
		Users user=context.getBean("Users",Users.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		boolean result = services.checkLogin(username, password);
		if(result){
			System.out.println("You've Logged in Succesfully");
				SwitchMain.SwitchCase(services,user);
		}
		else{
			System.out.println("Invalid Credentials");
		}
			
		
	}

}
