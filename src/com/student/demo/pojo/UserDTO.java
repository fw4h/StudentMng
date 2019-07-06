package com.student.demo.pojo;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDTO {
	private int id;
	private String name;
	private String phone_no;
	private Date dob;
	private String username;
	private String password;

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

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date date) {
		this.dob = date;
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

	public void resultSetSetAll(UserDTO userDTO, ResultSet resultSet) {
		try {
			userDTO.setId(resultSet.getInt("id"));
			userDTO.setName(resultSet.getString("name"));
			userDTO.setPhone_no(resultSet.getString("phone_no"));
			userDTO.setDob(resultSet.getDate("dob"));
			userDTO.setUsername(resultSet.getString("username"));
			userDTO.setPassword(resultSet.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
