package com.bo.user;

import com.bo.server.core.Request;
import com.bo.server.core.Response;
import com.bo.server.core.Servlet;

public class RegisterServlet implements Servlet {
	@Override
	public void service(Request request,Response response) {
		response.print("注册成功");
	}
}
