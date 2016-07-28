package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterPage extends HttpServlet{


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		//リクエストからデッキ名を受け取る
		req.setCharacterEncoding("UTF-8");
		String result = req.getParameter("insertResult");

		if(result.equals("1")){
			HttpSession session = req.getSession();
			if(session != null){
				session.invalidate();
			}
		}
		*/

		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/register.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/register.jsp");
		rd.forward(req, resp);
	}
}
