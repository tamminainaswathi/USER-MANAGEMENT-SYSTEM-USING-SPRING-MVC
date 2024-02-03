package com.techpalle.model;

public class Student {
	private int id;
	private String name;
	private String email;
	private String pass;
	private long mobile;
	public Student(int id, String name, String email, String pass, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
	}
	public Student(String name, String email, String pass, long mobile) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
	

}
