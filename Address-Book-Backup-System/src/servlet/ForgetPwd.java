package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;

@SuppressWarnings("serial")
public class ForgetPwd extends HttpServlet {

	public ForgetPwd() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String user_name = request.getParameter("user_name");
		String user_safe = request.getParameter("user_safe");
		String user_pwd = request.getParameter("user_pwd");
		UserDAO u = new UserDAO();
		int id = u.changePwdByNameAndSafe(user_name, user_safe, user_pwd);
		if (id != 0) { // 密码正确，进入登录页面
			response.sendRedirect("../login.jsp");
		} else { // 密码错误，返回修改密码页面，并提示密码错误
			response.sendRedirect("../forgetPwd.jsp?error=1");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init() throws ServletException {

	}

}
