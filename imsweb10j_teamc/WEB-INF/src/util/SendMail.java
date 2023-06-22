package util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

/**
 * メールの文字コード、送信先、件名、本文を設定し、設定した内容を送信するクラス
 */
public class SendMail {

	private static final String SMTP_HOST = "mail.smtp.host";
	private static final String IP_ADDRESS = "sv5215.xserver.jp";
	private static final String DEFAULT_CODE_TYPE = "iso-2022-jp";

	private final Properties props = System.getProperties();
	private final Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			// メールサーバにログインするメールアドレスとパスワードを設定
			return new PasswordAuthentication("test.sender@kanda-it-school-system.com", "kandaSender202208");
		}
	});
	private final MimeMessage mimeMessage = new MimeMessage(session);

	private String codeType;
	private String text = "";

	/**
	 * コンストラクタ<br>
	 * ホスト名、IPアドレス、標準文字コードを設定
	 */

	public SendMail() {// コンストラクタ
		// 送信サーバーの設定
		props.put(SMTP_HOST, IP_ADDRESS);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.debug", "true");
		this.codeType = DEFAULT_CODE_TYPE;

	}

	// 文字コードの指定
	// 文字コードの指定を引数にしてそれを送信元の文字コードとするメソッド
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	// 送信元メールアドレスと送信者名を指定するメソッドsetFromInfo
	/*
	 * @param address 送信元のアドレス
	 *
	 * @param sender 送信者名
	 */
	public void setFromInfo(String adress, String sender) {

		try {
			mimeMessage.setFrom(new InternetAddress(adress, sender, this.codeType));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	// 送信先メールアドレスの指定
	// adress = 送信先メールアドレス
	public void setRecipients(String address) {
		try {
			mimeMessage.setRecipients(Message.RecipientType.TO, address);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	// メールタイトルの指定
	// subject = メールの件名
	public void setSubject(String subject) {
		try {
			mimeMessage.setSubject(subject);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void setText(String text) {
		this.text += "\n" + text;
		try {
			mimeMessage.setText(this.text, "iso-2022-jp");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/*
	 * メール送信に伴う形式や日付の指定と 成功、失敗の判断
	 */
	public void forwardMail() {
		try {
			// メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/plain; charset=" + this.codeType);
			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");
		} catch (MessagingException e) {
			// 送信失敗
			e.printStackTrace();
			System.out.println("送信に失敗しました。");
		}

	}
}