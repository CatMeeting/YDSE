package test;

import java.util.*;

import org.apache.log4j.*;

import dao.*;
import vo.*;

public class DeckDAOTest {


	private Logger logger = (Logger) Logger.getInstance(this.getClass().getName());

	public static void main(String[] args) throws Exception {
		new DeckDAOTest().start();
	}

	void start() throws Exception {
		//DAOのインスタンスを生成
				DeckDAO dDAO = new DeckDAO();
				//デッキ名を引数に検索結果を受け取る
				ArrayList<DeckVO> deckList = dDAO.selectDeck("ブルーアイズ");
				//ArrayList<DeckVO> deckList = dDAO.selectDeck("%");

				logger.debug("ブルーアイズ");
				logger.error("ブルーアイズ01");

				for(int i=0; i<deckList.size(); i++){
					DeckVO deck = deckList.get(i);
					System.out.print("<tr>"+deck.getDeckName()+"</tr>");
				}
	}

}
