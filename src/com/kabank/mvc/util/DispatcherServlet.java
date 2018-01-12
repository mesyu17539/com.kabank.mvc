package com.kabank.mvc.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.InitCommand;

public class DispatcherServlet {
	public static void send(
			HttpServletRequest request, HttpServletResponse response/*, Command cmd*/)
				throws ServletException, IOException {//여기서 Instance를 죽이지 않는다
		request
		.getRequestDispatcher(InitCommand.cmd.getView()/*cmd.execute()*/)
		.forward(request, response);
	}
}
