package com.java.service;

import java.util.Scanner;
import com.java.dao.DaoInterface;
import com.java.dao.Dao;

public class Service {
	DaoInterface  di;
	Scanner sc;
	
	public Service(){
		di = new Dao();
		sc=new Scanner(System.in);
	}
	
	public boolean SignIn() {
		System.out.println("enter user id:");
		int id=sc.nextInt();
		System.out.println("enter password:");
		String pass = sc.next();
		
		if(di.signIn(id, pass)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean SignUp() {
		
		//System.out.println("enter user id:");
		//int id=sc.nextInt();
		System.out.println("enter password:");
		sc.nextLine();
		String pass = sc.nextLine();
		System.out.println("enter email:");
		String email = sc.next();
		
		
		if(di.signUp(pass,email)) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public void ShowAccount() {
		System.out.println("enter user id:");
		int id=sc.nextInt();
		di.showAccount(id);
	}
	
	public boolean DeleteAccount() {
		
		System.out.println("enter user id:");
		int id=sc.nextInt();
		if(di.deleteAccount(id)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean UpdatePassword() {
		
		System.out.println("enter user Id");
		int id=sc.nextInt();
		
		
		if(di.updatePassword(id)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
