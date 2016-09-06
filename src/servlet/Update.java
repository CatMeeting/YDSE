package servlet;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.*;

import dao.*;
import vo.*;

public class Update extends HttpServlet{

	private Logger logger = (Logger) Logger.getInstance(this.getClass().getName());

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forwardメソッドでJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/result.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//リクエストからデッキ名を受け取る
		req.setCharacterEncoding("UTF-8");
		int listNum = Integer.parseInt(req.getParameter("listNum"));
		String button = req.getParameter("button");
		logger.debug(button+":"+listNum);

		//DAOのインスタンスを生成
		DeckDAO dDAO = new DeckDAO();
		//変更後のデータを格納する
		HttpSession session = req.getSession();
		String deckName = (String) session.getAttribute("deckName");
		ArrayList<DeckVO> deckList = new ArrayList<DeckVO>();

		try {
			if(button.equals("編集")){
				String deckNameUp = req.getParameter("deckNameUp");
				DeckVO newdVO = new DeckVO(listNum, deckNameUp);
				dDAO.updateDeck(newdVO);
			}else if(button.equals("削除")){
				dDAO.deleteDeck(listNum);
			}
			deckList = dDAO.selectDeck(deckName);
		} catch (Exception e) {
			logger.error(e);
			throw new exception.MyException(e, "DB周りでのエラーですね＾＾");
		}

		//リクエストに検索結果をセットする
		req.setAttribute("deckList", deckList);
		req.setAttribute("button", button);

		// forwardメソッドで検索結果を表示するJSPに遷移
		RequestDispatcher rd = req.getRequestDispatcher("/page/select.jsp");
		rd.forward(req, resp);
	}

}
