package com.example.hello.employee;

public class EmployeeResponse{
	private int id;
	private String name;
	private String email;

	public EmployeeResponse() {
	}

	public EmployeeResponse(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}
}
