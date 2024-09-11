package com.java.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.connect.Connect;
import com.java.model.Login;

public class Dao implements DaoInterface {
	
	Scanner sc;
	SessionFactory f;
	public Dao()
	{
		f=Connect.getSessionFactory();
		
		sc= new Scanner (System.in);
			
	}
	
	public void showAccount(int id) {
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
    	Login b= ses.find(Login.class,id);
    	if(b!=null)
    	{	
    		System.out.println(b.toString());
    		tx.commit();
    		
    	}
    	else
    	{
    		System.out.println("Account Not Found");
    	}
		
	}

	@Override
	public boolean deleteAccount(int id) {
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
    	Login b= ses.find(Login.class,id);
    	if(b!=null) {
    		ses.delete(b);;
			tx.commit();
			ses.close();
			return true;
    	}
    	else {
    		System.out.println("user Not found");
    		return false;
    	}
	}


	public boolean updatePassword(int id) {
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
		Login l= ses.find(Login.class,id);
		
		if(l!=null) {
			System.out.println("enter new password");
			String pass = sc.next();
			
			l.setUserPassword(pass);
			ses.update(l);
			tx.commit();
			ses.close();
			
			System.out.println("password updated");
			return true;
			
		}
		else {
			System.out.println("updation failed");
		return false;}
	}

	@Override
	public boolean signIn(int id, String password) {
		Session ses=f.openSession();
		Transaction tx=ses.beginTransaction();
		Login l= ses.find(Login.class,id);
		
		if(l!=null) {
			if(l.getUserPassword().equals(password)) {
				System.out.println("sign-in successful");
			}
			else {
				System.out.println("incorrect password");
			}
		}
		else {
			System.out.println("wrong credentials");
		}
		
		return false;
		
	}

	@Override
	public boolean signUp(String pass,String email) {
			try{Session ses=f.openSession();
			Transaction tx=ses.beginTransaction();
			
			Login l = new Login();
			l.setEmail(email);
			//l.setUserID(id);
			l.setUserPassword(pass);
			ses.save(l);
			tx.commit();
			ses.close();
			return true;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
			
		}
}
