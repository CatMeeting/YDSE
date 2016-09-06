package servlet;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.*;

import dao.*;
import vo.*;

public class SelectDeck extends HttpServlet{

	private Logger logger = (Logger) Logger.getInstance(this.getClass().getName());

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/result.jsp");
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
		ArrayList<DeckVO> dVO = new ArrayList<DeckVO>();
		try {
			dVO = dDAO.selectDeck(deckName);
		} catch (Exception e) {
			logger.error(e);
			throw new exception.MyException(e, "DB周りでのエラーですね＾＾");
		}

		//リクエストに検索結果をセットする
		req.setAttribute("deckList", dVO);
		//セッションに検索条件も保持させる
		HttpSession session = req.getSession();
		session.setAttribute("deckName", deckName);

		// forwardメソッドで検索結果を表示するJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/select.jsp");
		rd.forward(req, resp);
	}

}
