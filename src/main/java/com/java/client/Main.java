package com.java.client;

import java.util.Scanner;
import com.java.service.*;

public class Main {
	public static void main(String [] args) {
		
		Scanner sc=new Scanner(System.in);
		Service s=new Service();
		
		while(true) {
			System.out.println("1. Sign Up");
			System.out.println("2. Sign In");
			System.out.println("3. Delete Account");
			System.out.println("4. search Account by id.");
			System.out.println("5. Update password");
			System.out.println("6. Exit");
			
			System.out.println("enter your choice");
			int ch = sc.nextInt();
			
			if(ch==1) {
				if(s.SignUp()) {
					System.out.println("Sign up succesful");
				}
				else {
					System.out.println("please try again");
				}
				
			}
			
			else if(ch==2) {
				if(s.SignIn()) {
					System.out.println("Sign In succesful");
				}
				else {
					System.out.println("sign In failed");
				}
			}
			
			else if(ch==3) {
				if(s.DeleteAccount()) {
					System.out.println("Account deleted succesfully");
				}
			}
			
			else if(ch==4) {
				s.ShowAccount();
			}
			
			else if(ch==5) {
				s.UpdatePassword();
			}
			
			else {
				break;
			}
		}
		
	}
}
