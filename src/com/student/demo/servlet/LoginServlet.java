package com.student.demo.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.demo.dao.UserDAO;
import com.student.demo.pojo.UserDTO;
import com.student.demo.service.LoginService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService = new LoginService();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		Boolean status;
		try {
			status = loginService.validateUser(username, password);
			if (status) {
				UserDAO userDAO = new UserDAO();
				List<UserDTO> userList = new ArrayList<UserDTO>();
				userList = userDAO.selectAll();
				req.setAttribute("userList", userList);
				req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
	}
}
