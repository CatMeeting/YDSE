package dao;

import java.sql.*;
import java.util.*;

import org.apache.log4j.*;

import vo.*;

public class DeckDAO {

	private Logger logger = (Logger) Logger.getInstance( this.getClass().getName() );

	public ArrayList<DeckVO> selectDeck(String deckName) throws Exception{
		//returnするための変数を用意
		ArrayList<DeckVO> deck = new ArrayList<DeckVO>();

		//デバックログの出力
		logger.debug(deckName);

		//エスケープ文字の設定
		String[] strArray = deckName.split("");
		deckName = "";
		for(int i=0; i<strArray.length; i++){
			if(strArray[i].equals("\\") || strArray[i].equals("_") || strArray[i].equals("%")){
				deckName += "\\";
			}
			deckName += strArray[i];
		}

		//DBに接続するためのインスタンス生成
		DBHelper dbh = new DBHelper();
		//SQL文の実行
		PreparedStatement pstmt = dbh.open().prepareStatement("SELECT * FROM deck WHERE deck_name LIKE ? ESCAPE '\'");
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
		return deck;
	}

	public int insertDeck(String deckName) throws Exception{
		/*
		//エスケープ文字の設定
		String[] strArray = deckName.split("");
		deckName = "";
		for(int i=0; i<strArray.length; i++){
			if(strArray[i].equals("\\") || strArray[i].equals("_") || strArray[i].equals("%")){
				deckName += "\\";
			}
			deckName += strArray[i];
		}
		*/

		//デバックログの出力
		logger.debug(deckName);

		//DBに接続するためのインスタンス生成
		DBHelper dbh = new DBHelper();
		//SQL文の実行
		PreparedStatement pstmt = dbh.open().prepareStatement("INSERT INTO deck (deck_name) VALUES ( ? )");
		pstmt.setString(1, deckName);
		int i = pstmt.executeUpdate();

		//DBから切断します
		dbh.close();
		//検索結果を返す
		return i;
	}


}
