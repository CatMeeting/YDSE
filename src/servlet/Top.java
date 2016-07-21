package servlet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Top extends HttpServlet{


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/main.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/main.jsp");
		rd.forward(req, resp);
	}

}
