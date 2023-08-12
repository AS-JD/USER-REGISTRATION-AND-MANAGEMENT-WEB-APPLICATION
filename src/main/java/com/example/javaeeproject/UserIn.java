package com.example.javaeeproject;

import java.util.List;
public interface UserIn {
	public List<user> getuserParMotCle(String mc);
	public user adduser(user p);
	public user getuser(long id);
	public user updateuser(user p);
	public void deleteuser( long id) ; 
	public List<user> selectALLUsers();
	public user insertUser(user c);

    public  user getuser(String email, String password);
}


