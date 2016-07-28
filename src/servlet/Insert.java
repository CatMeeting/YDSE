package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.*;

import dao.*;

public class Insert extends HttpServlet{

	private Logger logger = (Logger) Logger.getInstance( this.getClass().getName() );

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/registerResult.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//リクエストからデッキ名を受け取る
		req.setCharacterEncoding("UTF-8");
		String deckName = req.getParameter("deckName");

		//検索条件のログ出力
		logger.debug(deckName);

		//DAOのインスタンスを生成
		DeckDAO dDAO = new DeckDAO();

		//デッキ名を引数に検索結果を受け取る
		int resultNum = 0;
		try {
			resultNum = dDAO.insertDeck(deckName);
		} catch (Exception e) {
			//デバックログの出力
			logger.error(e);
		}

		//リクエストに検索結果をセットする
		req.setAttribute("insertResult", resultNum);
		//リクエストに検索条件も保持させる
		HttpSession session = req.getSession();
		session.setAttribute("deckNameIn", deckName);

		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/registerResult.jsp");
		rd.forward(req, resp);
	}

}
