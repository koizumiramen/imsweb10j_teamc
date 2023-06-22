package dao;

import java.sql.*;
import java.util.*;

import bean.Inquiry;

public class InquiryDAO {

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

	/**
	 * DBの書籍情報を格納するinquiryテーブルから全お問い合わせ情報を取得するメソッド
	 *
	 * @return 全お問い合わせ情報のリスト
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public ArrayList<Inquiry> selectAll() {

		ArrayList<Inquiry> list = new ArrayList<Inquiry>();
		String sql = "SELECT * FROM inquiry ORDER BY inquiry_id";

		Connection con = null;
		Statement smt = null;
		try {
			con = InquiryDAO.getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Inquiry inq = new Inquiry();
				inq.setInquiry_id(rs.getInt("inquiry_id"));
				inq.setDate(rs.getString("date"));
				inq.setName(rs.getString("name"));
				inq.setAge(rs.getInt("age"));
				inq.setAddress(rs.getString("address"));
				inq.setGender(rs.getString("gender"));
				inq.setEmail(rs.getString("email"));
				inq.setCategory(rs.getString("category"));
				inq.setContents(rs.getString("contents"));
				inq.setStatus(rs.getInt("status"));

				list.add(inq);
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
		return list;

	}

	// お問い合わせデータを追加するメソッド
	public void insert(Inquiry inq) {

		Connection con = null;
		Statement smt = null;

		String sql = "insert into inquiry(name,age,address,gender,email,category,contents,date) values('"
				+ inq.getName() + "','" + inq.getAge() + "','" + inq.getAddress() + "','" + inq.getGender() + "','"
				+ inq.getEmail() + "','" + inq.getCategory() + "','" + inq.getContents() + "',NOW())";

		try {

			con = getConnection();
			smt = con.createStatement();

			// sqlをDBへ発行
			smt.executeUpdate(sql);

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
	}

	// 指定したinquiry_idのお問い合わせデータを返すメソッド
	public Inquiry selectByInquiry_id(int inquiry_id) {

		Connection con = null;
		Statement smt = null;

		Inquiry inq = new Inquiry();

		String sql = "select * from inquiry where inquiry_id = '" + inquiry_id + "'";

		try {

			con = getConnection();
			smt = con.createStatement();

			// sqlをDBへ発行
			ResultSet rs = smt.executeQuery(sql);
			if (rs.next()) {
				inq.setInquiry_id(rs.getInt("inquiry_id"));
				inq.setDate(rs.getString("date"));
				inq.setName(rs.getString("name"));
				inq.setAge(rs.getInt("age"));
				inq.setAddress(rs.getString("address"));
				inq.setGender(rs.getString("gender"));
				inq.setEmail(rs.getString("email"));
				inq.setCategory(rs.getString("category"));
				inq.setContents(rs.getString("contents"));
				inq.setStatus(rs.getInt("status"));
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
		return inq;
	}

	public void replyUpdate(Inquiry inq) {

		Connection con = null;
		Statement smt = null;

		String sql = "UPDATE inquiry SET status =" + 1 + " WHERE inquiry_id='" + inq.getInquiry_id() + "'";

		try {
			con = getConnection();
			smt = con.createStatement();

			// SQL文発行
			smt.executeUpdate(sql);

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
	}
}