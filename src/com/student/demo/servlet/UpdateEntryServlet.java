package com.student.demo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.demo.dao.UserDAO;
import com.student.demo.pojo.UserDTO;

public class UpdateEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pattern = "MM/dd/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	UserDAO userDAO = new UserDAO();
	String name;
	String dob;
	String phone_no;
	String username;
	String password;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			UserDTO userDTO = new UserDTO();
			reqGetParameters(req);
			userDTOSetAttributes(userDTO);

			if (req.getParameter("id") == null || req.getParameter("id").isEmpty()) {
				userDAO.createUser(userDTO);
			} else {
				Integer id = Integer.parseInt(req.getParameter("id"));
				userDTO.setId(id);
				userDAO.updateUser(userDTO);
				req.setAttribute("userDTO", userDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			displayEntry(req, resp);
		} finally {
			displayEntry(req, resp);
		}
	}

	void displayEntry(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<UserDTO> userList = new ArrayList<UserDTO>();
			userList = userDAO.selectAll();
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void reqGetParameters(HttpServletRequest req) {
		name = req.getParameter("name");
		dob = req.getParameter("dob");
		phone_no = req.getParameter("phone_no");
		username = req.getParameter("username");
		password = req.getParameter("password");
	}

	void userDTOSetAttributes(UserDTO userDTO) throws Exception {
		userDTO.setName(name);
		userDTO.setDob(simpleDateFormat.parse(dob));
		userDTO.setPhone_no(phone_no);
		userDTO.setUsername(username);
		userDTO.setPassword(password);
	}
}
