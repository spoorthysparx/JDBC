package com.java.dao;

public interface DaoInterface {
	boolean signUp(String pass,String email);

    boolean deleteAccount(int id);

    void showAccount(int id);

    boolean updatePassword(int id);

    boolean signIn(int id, String password);
}
