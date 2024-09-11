package com.java.connect;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.java.model.Login;

public class Connect {
	public static SessionFactory fac;
	
	public Connect(){
		fac = new Configuration().configure("hiber.Config.xml").addAnnotatedClass(Login.class).buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		
		Connect c = new Connect();
		return fac;
	}
}
