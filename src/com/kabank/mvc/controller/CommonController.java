package com.kabank.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.enums.Path;
import com.kabank.mvc.service.CommonService;
import com.kabank.mvc.serviceImpl.CommonServiceImpl;

@WebServlet("/common/jdbc_test.do")
public class CommonController extends HttpServlet {
	CommonService commonService;
	public CommonController() {
		commonService=new CommonServiceImpl();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath()
				.split("/")[2]
				.split(".do")[0];
		String dir=request.getServletPath().split("/")[1];
		request.setAttribute("count", commonService.callCount());//맵핑구조 주소, 벨류 && 키, 벨류
		System.out.println(Path.VIEW.toString()+dir+Path.SEPARATOR.toString()+path+Path.EXTENSION);
		request.getRequestDispatcher(Path.VIEW.toString()+dir+Path.SEPARATOR.toString()+path+Path.EXTENSION)
		.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
