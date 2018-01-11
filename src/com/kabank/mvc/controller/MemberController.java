package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.membership.MemberImpl;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.Action;
import com.kabank.mvc.enums.Path;
import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.factory.CommandFactory;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet("/user.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService service=MemberServiceImpl.getInstance();
		System.out.println("서블릿 내부===================================================");
		/*response.getWriter().append("<h1>에휴</h1>").append(request.getContextPath());*/
		HttpSession session=request.getSession();
		InitCommand.init(request,response);
		MemberBean bean;
		String path="";
				/*dir=request.getServletPath().split(".do")[0]
				request.getServletPath().substring(1,5),*/
				/*path="",*/
				/*page=request.getParameter("page");*/
		/*Action action=ActionFactory.create(request.getParameter("cmd"));*/
		/*Command cmd=CommandFactory.create(dir, page, action);*/
		switch(InitCommand.cmd.getAction()) {
		case MOVE:
			System.out.println("=========Member: Move=============");
			DispatcherServlet.send(request, response);break;
			/*case MOVE:DispatcherServlet.send(request, response, cmd);*/			
			/*path=request.getParameter("page");
			System.out.printf("경로 %s page %s\n",dir,path);*/
			/*break;*/
		case JOIN:
			System.out.println("=========Member: JOIN=============");
			bean=new MemberBean();
			bean.setId(request.getParameter("id"));
			bean.setPass(request.getParameter("pass"));
			MemberBean member=service.findById(bean);
/*			MemberBean member=new MemberServiceImpl().findById(bean);
*/			if(member!=null) {
				/*dir=request.getParameter("page");*/
				path="main";
				/*request.setAttribute("user", member);//일회용*/
				session.setAttribute("user", member);//브라우져
			}else {
				path="login";
			}
			break;
		case ADD:
			System.out.println("=========Member: ADD=============");
			System.out.println("컨트롤진입");
			/*dir="user";*/
			path="login";
			bean=new MemberBean();
			bean.setAddr(request.getParameter("addr"));
			bean.setSsn(request.getParameter("ssn1").concat(request.getParameter("ssn2")));
			bean.setEmail(request.getParameter("email"));
			bean.setId(request.getParameter("id"));
			bean.setName(request.getParameter("name"));
			bean.setPass(request.getParameter("pass"));
			bean.setPhone(request.getParameter("phone1").concat("-").concat(request.getParameter("phone2")).concat("-").concat(request.getParameter("phone3")));
			bean.setEmail(request.getParameter("email").concat(request.getParameter("url")));
			bean.setAddr(request.getParameter("addr"));
			System.out.println("id : "+request.getParameter("id"));
			service.join(bean);
			break;
		case LOGIN:
			System.out.println("=========Member: Login IN=============");
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String dir=request.getParameter("dir");
			String page=request.getParameter("page");
			bean=new MemberBean();
			bean.setId(request.getParameter("id"));
			bean.setPass(request.getParameter("pass"));
			MemberBean result=null;
			result=service.findById(bean);
			if(result==null) {
				InitCommand.cmd.setDir("user");
				InitCommand.cmd.setPage("login");
				InitCommand.cmd.execute();
				DispatcherServlet.send(request, response);
			}else {
				DispatcherServlet.send(request, response);
			}
			System.out.println("=========Member: Login OUT=============");
			break;
		default:
			/*dir="user";*/
			path="login";
			System.out.println("기타");
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
/* Command pattern 쓰기 전 상태.
 * @WebServlet({"/user/login.do","/user/join_form.do","/user/auth.do","/user/memberjoin.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService service=MemberServiceImpl.getInstance();
		System.out.println("서블릿 내부===================================================");
		response.getWriter().append("<h1>에휴</h1>").append(request.getContextPath());
		HttpSession session=request.getSession();
		MemberBean bean;
		String dir=request.getServletPath().split("/")[1],
				path=request.getServletPath()
				.split("/")[2]
						.split(".do")[0],
						cmd=request.getParameter("cmd");
		switch(path) {
		case "auth":
			bean=new MemberBean();
			bean.setId(request.getParameter("id"));
			bean.setPass(request.getParameter("pass"));
			MemberBean member=service.findById(bean);
						MemberBean member=new MemberServiceImpl().findById(bean);
			 			if(member!=null) {
				 dir="bitcamp";
				 path="main";
				 request.setAttribute("user", member);//일회용
				 session.setAttribute("user", member);//브라우져
			 }else {
				 path="login";
			 }
			 break;
		case "memberjoin":
			System.out.println("컨트롤진입");
			dir="user";
			path="login";
			bean=new MemberBean();
			bean.setAddr(request.getParameter("addr"));
			bean.setSsn(request.getParameter("ssn1").concat(request.getParameter("ssn2")));
			bean.setEmail(request.getParameter("email"));
			bean.setId(request.getParameter("id"));
			bean.setName(request.getParameter("name"));
			bean.setPass(request.getParameter("pass"));
			bean.setPhone(request.getParameter("phone1").concat("-").concat(request.getParameter("phone2")).concat("-").concat(request.getParameter("phone3")));
			bean.setEmail(request.getParameter("email").concat(request.getParameter("url")));
			bean.setAddr(request.getParameter("addr"));
			System.out.println("id : "+request.getParameter("id"));
			service.join(bean);
			break;
		case "join_form":
			break;
		default:
			dir="user";
			path="login";
			break;
		}
		request.getRequestDispatcher(Path.VIEW.toString()+dir+Path.SEPARATOR.toString()+path+Path.EXTENSION)
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
*/
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
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
} */	
