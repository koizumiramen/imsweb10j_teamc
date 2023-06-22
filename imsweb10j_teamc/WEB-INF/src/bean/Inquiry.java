package bean;

public class Inquiry {


	//お問い合わせ番号
	int inquiry_id;

	//日時
	String date;

	//名前
	String name;

	//年齢
	int age;

	//住所
	String address;

	//性別
	String gender;

	//メール
	String email;

	//質問項目
	String category;

	//質問内容
	String contents;

	//回答状況
	int status;


	//コンストラクタ
	public Inquiry() {

		this.inquiry_id = 0;
		this.date = null;
		this.name = null;
		this.age = 0;
		this.address = null;
		this.gender = null;
		this.email = null;
		this.category = null;
		this.contents = null;
		this.status = 0;
	}

	// お問い合わせ番号取得
	public int getInquiry_id() {
		return inquiry_id;
	}

	// 年齢セット
	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id =inquiry_id;
	}

	// 名前取得
	public String getDate() {
		return date;
	}

	// 名前セット
	public void setDate(String date) {
		this.date = date;
	}


	// 名前取得
	public String getName() {
		return name;
	}

	// 名前セット
	public void setName(String name) {
		this.name = name;
	}

	// 年齢取得
	public int getAge() {
		return age;
	}

	// 年齢セット
	public void setAge(int age) {
		this.age = age;
	}

	// アドレス取得
	public String getAddress() {
		return address;
	}

	// アドレスセット
	public void setAddress(String address) {
		this.address = address;
	}

	// 性別取得
	public String getGender() {
		return gender;
	}

	// 性別セット
	public void setGender(String gender) {
		this.gender = gender;
	}

	//メール取得
	public String getEmail() {
		return email;
	}
	//メールセット
	public void setEmail(String email) {
		this.email = email;
	}

	//お問い合わせ項目取得
	public String getCategory() {
		return category;
	}

	//お問い合わせ項目セット
	public void setCategory(String category) {
		this.category = category;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}