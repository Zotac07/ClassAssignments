package com.lti.main;

import java.util.List;
import java.util.Scanner;

import com.lti.model.Users;
import com.lti.service.UserService;

public class SwitchMain {

	public static void SwitchCase(UserService services, Users user) {
		Scanner sc = new Scanner(System.in);
		List<Users> list;
		String choose = null;
		do{
		System.out.println("1 To Get All Users \n2 To Insert User \n3 To Delete a User \n4 To Update a user \n5 Find by Username \n6 Exit");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			list = services.findAllUsers();
			for (Users user1 : list) {
				display(user1);
			}
			break;
		case 2:
			System.out.println("Enter Username: ");
			String usern = sc.next();
			System.out.println("Enter Password: ");
			String pass = sc.next();
			System.out.println("Enter FirstName: ");
			String firstn = sc.next();
			System.out.println("Enter LastName: ");
			String lastn = sc.next();
			System.out.println("Enter Mobile Number: ");
			String mobno = sc.next();
			user = new Users(usern, pass, firstn, lastn, mobno);
			boolean rs = services.addUser(user);
			if (rs) {
				System.out.println("Added Successfully");
			} else {
				System.out.println("Something went wrong");
			}
			break;
		case 3:
			System.out.println("Enter Username: ");
			usern = sc.next();
			rs = services.removeUser(usern);
			if (rs) {
				System.out.println("Deleted");
			} else {
				System.out.println("Something went wrong");
			}
			break;
		case 4:
			System.out.println("Enter Username: ");
			usern = sc.next();
			Users upuser = services.findUser(usern);
			display(upuser);
			System.out.println("Enter new Password: ");
			pass = sc.next();
			System.out.println("Enter new FirstName: ");
			firstn = sc.next();
			System.out.println("Enter new LastName: ");
			lastn = sc.next();
			System.out.println("Enter new Mobile Number: ");
			mobno = sc.next();
			user = new Users(upuser.getUsername(), pass, firstn, lastn, mobno);
			rs = services.updateUser(user);
			if (rs) {
				System.out.println("Updated");
				display(user);
			} else {
				System.out.println("Not updated");
			}
			break;
		case 5:
			System.out.println("Enter Username: ");
			usern = sc.next();
			user = services.findUser(usern);
			display(user);	
			break;
		case 6:
			System.exit(0);
			break;
		}
		System.out.println("Do you want to Continue? Y/N");
		choose=sc.next();
		}while(choose.equals("Y") || choose.equals("y"));
	}

	public static void display(Users user) {
		System.out.println("Username:" + user.getUsername());
		System.out.println("Firstname:" + user.getFirstname());
		System.out.println("Lastname:" + user.getLastname());
		System.out.println("Mobile Number:" + user.getMobilenumber());
		System.out.println("***********************************************************");
	}

}
