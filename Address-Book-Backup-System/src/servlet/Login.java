package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	public Login() {
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
		UserDAO u = new UserDAO();
		int id = u.checkPwdByNameReturnId(user_name, user_pwd);
		if (id != 0) { // 密码正确，进入主页面
			HttpSession session = request.getSession(); // 保存session
			session.setAttribute("user_id", id);
			response.sendRedirect("../main.jsp");
		} else { // 密码错误，返回登录页面，并提示密码错误
			response.sendRedirect("../login.jsp?error=1");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init() throws ServletException {

	}

}
