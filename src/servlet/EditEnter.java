package servlet;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class EditEnter extends HttpServlet{


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session != null){
			session.invalidate();
		}
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/editerEnter.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//リクエストからデッキ名を受け取る
		req.setCharacterEncoding("UTF-8");
		String listNum = req.getParameter("listNum");
		String deckNameUp = req.getParameter("deckNameUp");

		req.setAttribute("listNum", listNum);
		req.setAttribute("deckNameUp", deckNameUp);
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/editerEnter.jsp");
		rd.forward(req, resp);
	}

}
