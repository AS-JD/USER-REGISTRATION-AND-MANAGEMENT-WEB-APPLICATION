package com.example.javaeeproject;
import java.io.Serializable;
public class user  implements Serializable{




    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private int number;
    private String email;
    private long id;
    
    public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(String username, String password, String email,int number) {
		super();
		this.username = username;
		this.password = password;
		this.number = number;
		this.email = email;
	}
	public user( String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}
	public long getIduser() {
		return id;
	}
	public void setIduser(long iduser) {
		this.id = iduser;
	}
	public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		// TODO Auto-generated method stub
		return "user [iduser="+ id + ",nom="+ username+ ",passwors="+password+",email="+email+",number="+number+"]";
	}
}
