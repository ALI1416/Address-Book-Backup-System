package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;

@SuppressWarnings("serial")
public class Register extends HttpServlet {

	public Register() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		String user_safe = request.getParameter("user_safe");
		UserDAO u = new UserDAO();
		int id = u.registerAccount(user_name, user_pwd, user_safe);
		if (id != 0) { // 注册成功，进入登录页面
			response.sendRedirect("../login.jsp");
		} else { // 注册失败，返回注册页面，提示该用户已存在
			response.sendRedirect("../register.jsp?error=1");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init() throws ServletException {

	}

}
