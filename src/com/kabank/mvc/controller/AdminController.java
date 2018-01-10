package com.kabank.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.enums.Path;
import com.kabank.mvc.serviceImpl.AdminServiceImpl;

@WebServlet({"/admin/main.do","/admin/create_table.do","/admin/member_list.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir=request.getServletPath().split("/")[1];
		String path=request.getServletPath().split("/")[2].split(".do")[0];
		switch(path) {
		case "main":
			break;
		case "create_table":
			new AdminServiceImpl().creatTable(request.getParameter("admin_tname"));
			path="main";
			break;
		case "member_list":
			break;
		}
		
		request.getRequestDispatcher(Path.VIEW.toString()+dir+Path.SEPARATOR.toString()+path+Path.EXTENSION)
		.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*doGet(request, response);*/
	}

}
