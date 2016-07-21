package servlet;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.*;
import test.*;
import vo.*;

public class Serch extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/result.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//リクエストからデッキ名を受け取る
		//req.setCharacterEncoding("Shift-JIS");
		req.setCharacterEncoding("UTF-8");
		String deckName = req.getParameter("deckName");

		LogTest log = new LogTest();
		log.logText(deckName);

		//DAOのインスタンスを生成
		DeckDAO dDAO = new DeckDAO();

		//デッキ名を引数に検索結果を受け取る
		ArrayList<DeckVO> dVO = new ArrayList<DeckVO>();
		try {
			dVO = dDAO.selectDeck(deckName);
		} catch (Exception e) {
			throw new exception.MyException(e, "DB周りでのエラーですね＾＾");
		}
		//リクエストに検索結果をセットする
		req.setAttribute("deck", dVO);

		// forwardメソッドで検索結果を表示するJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/result.jsp");
		rd.forward(req, resp);
	}

}
