package com.student.demo.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.demo.dao.UserDAO;
import com.student.demo.pojo.UserDTO;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String idString = req.getParameter("id");
			int id = Integer.parseInt(idString);
			UserDAO userDAO = new UserDAO();
			userDAO.deleteUserById(id);
			List<UserDTO> userList = new ArrayList<UserDTO>();
			userList = userDAO.selectAll();
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
