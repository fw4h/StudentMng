package com.student.demo.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.demo.dao.UserDAO;
import com.student.demo.pojo.UserDTO;

public class DisplayEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			UserDAO userDAO = new UserDAO();
			UserDTO userDTO = new UserDTO();
			int id = Integer.parseInt(req.getParameter("id"));
			userDTO = userDAO.getUserById(id);
			List<UserDTO> userList = new ArrayList<UserDTO>();
			userList = userDAO.selectAll();
			req.setAttribute("userList", userList);
			req.setAttribute("userDTO", userDTO);
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
