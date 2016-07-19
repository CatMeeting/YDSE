package dao;

import java.sql.*;

public class DBHelper {

	//BDに接続するための情報
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/ydsedb";
    private String user = "postgres";
    private String password = "postgres";
	//接続情報を保持するConnectionの宣言
    Connection connection;


    //DBに接続するメソッド
	public Connection open() throws Exception{

    	//DBに接続する
		System.out.println(driver);
		Class.forName(driver);		//ClassNotFoundExceptionの可能性あり
        connection = DriverManager.getConnection(url, user, password);	//SQLExceptionの可能性あり
        return connection;
	}

	//BDから切断するメソッド
	public void close() throws Exception{
        if ( connection != null ) connection.close();
	}
}
