package com.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Login {
	
	@Id
	@GeneratedValue
	int UserID;
	@Column
	String UserPassword;
	@Column
	String Email;
	
	public Login(){
		
	}
	
	public Login(int userID, String userPassword, String email) {
		super();
		UserID = userID;
		UserPassword = userPassword;
		Email = email;
	}

	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Login [UserID=" + UserID + ", UserPassword=" + UserPassword + ", Email=" + Email + "]";
	}
	
}
