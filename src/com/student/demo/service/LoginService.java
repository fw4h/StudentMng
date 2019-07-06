package com.student.demo.service;

import java.util.List;

import com.student.demo.dao.UserDAO;
import com.student.demo.pojo.UserDTO;

public class LoginService {
	private UserDAO userDAO = new UserDAO();

	public boolean validateUser(String username, String password) throws Exception {

		UserDTO userDTO = userDAO.getUserByUsernameAndPassword(username, password);

		if (userDTO == null) {
			return false;
		} else {
			return true;
		}
	}

	public List<UserDTO> selectAll() throws Exception {
		return userDAO.selectAll();
	}
}
