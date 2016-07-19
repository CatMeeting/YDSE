package dao;

import java.sql.*;
import java.util.*;

import vo.*;

public class DeckDAO {



	public ArrayList<DeckVO> selectDeck(String deckName) throws Exception{
		ArrayList<DeckVO> deck = new ArrayList<DeckVO>();

		//DBに接続するためのインスタンス生成
		DBHelper dbh = new DBHelper();
		//SQL文の実行
		PreparedStatement pstmt = dbh.open().prepareStatement("SELECT * FROM deck WHERE deck_name LIKE ?");
		pstmt.setString(1, "%"+deckName+"%");
		ResultSet rs = pstmt.executeQuery();

		//検索結果を格納
		while(rs.next()){
			DeckVO deckVO = new DeckVO(rs.getInt("deck_id"), rs.getString("deck_name"));
			deck.add(deckVO);
		}
		//DBから切断します
		dbh.close();
		//検索結果を返す
		throw new Exception();
		//return deck;
	}
}
