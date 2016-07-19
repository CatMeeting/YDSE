package test;

import java.sql.*;

public class MyDBAccess {

	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;

	/**
	 * �R���X�g���N�^
	 * @param driver �h���C�o�[
	 * @param url URL
	 * @param user ���[�U�[��
	 * @param password �p�X���[�h
	 */
	public MyDBAccess(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * �����Ȃ��̃R���X�g���N�^
	 * ����l���g�p����
	 */
	public MyDBAccess() {
		driver = "org.postgresql.Driver";
		url = "jdbc:postgresql://localhost:5432/postgres";
		user = "postgres";
		password = "postgres";
	}

	/**
	 * �f�[�^�x�[�X�ւ̐ڑ����s��
	 */
	public synchronized void open() throws Exception {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement();
	}

	/**
	 * SQL �������s�������ʂ� ResultSet ��Ԃ�
	 * @param sql SQL ��
	 */
	public ResultSet getResultSet(String sql) throws Exception  {
		if ( statement.execute(sql) )  {
			return statement.getResultSet();
		}
		return null;
	}

	/**
	 * SQL ���̎��s
	 * @param sql SQL ��
	 */
	public void execute(String sql) throws Exception  {
		statement.execute(sql);
	}

	/**
	 * �f�[�^�x�[�X�ւ̃R�l�N�V�����̃N���[�Y
	 */
	public synchronized void close() throws Exception {
		if ( resultset  != null ) resultset.close();
		if ( statement  != null ) statement.close();
		if ( connection != null ) connection.close();
	}
}
