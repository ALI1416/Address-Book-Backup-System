package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

@SuppressWarnings("serial")
public class ChangeSafe extends HttpServlet {

	public ChangeSafe() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String user_old_safe = request.getParameter("user_old_safe");
		String user_pwd = request.getParameter("user_safe");
		HttpSession session = request.getSession(); // 获取session
		int user_id = (Integer) session.getAttribute("user_id");
		UserDAO u = new UserDAO();
		int id = u.changeSafeBySafe(user_id, user_old_safe, user_pwd);
		if (id != 0) { // 密码正确，进入登录页面
			response.sendRedirect("../main.jsp");
		} else { // 密码错误，返回修改密码页面，并提示密码错误
			response.sendRedirect("../changeSafe.jsp?error=1");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void init() throws ServletException {

	}

}
