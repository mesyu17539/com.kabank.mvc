package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.constants.Path;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;

@WebServlet({"/user/login.do","/user/join_form.do","/user/auth.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서블릿 내부===================================================");
		/*response.getWriter().append("<h1>에휴</h1>").append(request.getContextPath());*/
		String dir=request.getServletPath().split("/")[1];
		String path=request.getServletPath()
				.split("/")[2]
						.split(Path.DOT)[0]; 
		if(path.equals("auth")) {
			if(new MemberServiceImpl().login(request.getParameter("id"),request.getParameter("pass"))) {
				dir="bitcamp";
				path="main";
			}else {
				path="login";
			}
		}
		request.getRequestDispatcher(Path.VIEW+dir+Path.SEPARATOR+path+Path.EXTENSION)
		.forward(request, response);
		
		/*System.out.println("내가 찾는 것들"+path[2]);
		switch (path[2]) {
		case "login":
			str+="login.jsp";
			
			break;
		case "join":
			str+="join_form.jsp";
			break;
		case "auth":
		default:
			str+="login.jsp";
			break;
		}*/
/*		switch (path) {
		case "/member/login.do":
			Str="/WEB-INF/view/user/login.jsp";
			
			break;
		case "/member/join.do":
			Str="/WEB-INF/view/user/join_form.jsp";
			break;
		default:
			break;
		}
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/view/user/"+path[2]+".jsp");
		rd.forward(request, response);
 */	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
