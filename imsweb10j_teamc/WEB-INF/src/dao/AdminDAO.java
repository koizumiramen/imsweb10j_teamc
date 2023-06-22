package dao;

import java.sql.*;
import bean.Admin;

public class AdminDAO {

	/**
	 * JDBCドライバ内部のDriverクラスパス
	 */
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	/**
	 * 接続するMySQLデータベースパス
	 */
	private static final String URL = "jdbc:mysql://localhost/imsdb";
	/**
	 * データベースのユーザー名
	 */
	private static final String USER = "root";
	/**
	 * データベースのパスワード
	 */
	private static final String PASSWD = "root123";

	/**
	 * フィールド変数の情報を基に、DB接続をおこなうメソッド
	 *
	 * @return データベース接続情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public Admin selectByAdmin(String AdminId, String password) {

		Connection con = null;
		Statement smt = null;

		Admin admin = new Admin();

		try {

			// 引数の情報を利用し、検索用のSQL文を文字列として定義
			String sql = "SELECT * FROM admin WHERE admin_id ='" + AdminId + "' AND password ='" + password + "'";

			// BookDAOクラスに定義した、getConnection()メソッドを利用してConnectionオブジェクトを生成
			con = getConnection();
			// ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成
			smt = con.createStatement();

			// Statementオブジェクトの、executeQuery（）メソッドを利用して、SQL文を発行し結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {

				admin.setAdminId(AdminId);
				admin.setPassword(password);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return admin;
	}
}