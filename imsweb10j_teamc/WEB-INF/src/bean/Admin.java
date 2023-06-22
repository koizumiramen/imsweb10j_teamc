package bean;

/**
 * 管理者情報（管理者Id、パスワード）を一つのオブジェクトとしてまとめるためのDTOクラス
 *
 *
 */
public class Admin {

	/**
	 * 管理者のId
	 */
	private String adminId;
	/**
	 * 管理者のパスワード
	 */
	private String password;

	/**
	 *
	 * /** コンストラクタ<br>
	 * ユーザー情報（Id、パスワード）の初期設定をおこなう
	 */
	public Admin() {
		this.adminId = null;
		this.password = null;
	}

	/**
	 * 管理者のIdを取得する
	 *
	 */
	public String getAdminId() {
		return adminId;
	}

	/**
	 * 管理者のIdを設定する
	 *
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	/**
	 * 管理者のパスワードを取得する
	 *
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 管理者のパスワードを設定する
	 *
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}