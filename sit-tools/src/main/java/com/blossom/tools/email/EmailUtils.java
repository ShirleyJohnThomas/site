package com.blossom.tools.email;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 邮件发送工具类
 * @author Blossom
 * @time 2016年9月7日
 */
public class EmailUtils {

	/**
	 * 邮件发送
	 * @author Blossom
	 * @time 2016年9月7日
	 * @param sender
	 * @param password
	 * @param receivers
	 * @param title
	 * @param mailContent
	 * @param attachements
	 * @param mimetype
	 * @param charset
	 * @return_type void
	 *
	 */
	public static void sendEmail(final String sender, final String password,
			String receivers, String title, String mailContent,
			File[] attachements, String mimetype, String charset) {
		Properties props = new Properties();
		// 设置smtp服务器地址
		// 这里使用QQ邮箱，记得关闭独立密码保护功能和在邮箱中设置POP3/IMAP/SMTP服务
		props.put("mail.smtp.host", "smtp.163.com");
		// 需要验证
		props.put("mail.smtp.auth", "true");
		// 创建验证器
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, password);
			}
		};
		// 使用Properties创建Session
		Session session = Session.getDefaultInstance(props, authenticator);
		// Set the debug setting for this Session
		session.setDebug(true);
		try {
			// 使用session创建MIME类型的消息
			MimeMessage mimeMessage = new MimeMessage(session);
			// 设置发件人邮件
			mimeMessage.setFrom(new InternetAddress(sender));
			// 获取所有收件人邮箱地址
			// InternetAddress[] receiver = new
			// InternetAddress[receivers.length];
			// for (int i=0; i<receivers.length; i++) {
			// receiver[i] = new InternetAddress(receivers[i]);
			// }
			// 设置收件人邮件
			mimeMessage.setRecipients(Message.RecipientType.TO, receivers);
			// 设置标题
			mimeMessage.setSubject(title, charset);
			// 设置邮件发送时间
			// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			// mimeMessage.setSentDate(format.parse("2011-12-1"));
			mimeMessage.setSentDate(new Date());
			// 创建附件
			Multipart multipart = new MimeMultipart();
			// 创建邮件内容
			MimeBodyPart body = new MimeBodyPart();
			// 设置邮件内容
			body.setContent(mailContent,
					(mimetype != null && !"".equals(mimetype) ? mimetype
							: "text/plain") + ";charset=" + charset);
			multipart.addBodyPart(body);// 发件内容
			// 设置附件
			if (attachements != null) {
				for (File attachement : attachements) {
					MimeBodyPart attache = new MimeBodyPart();
					attache.setDataHandler(new DataHandler(new FileDataSource(
							attachement)));
					String fileName = getLastName(attachement.getName());
					attache.setFileName(MimeUtility.encodeText(fileName,
							charset, null));
					multipart.addBodyPart(attache);
				}
			}
			// 设置邮件内容（使用Multipart方式）
			mimeMessage.setContent(multipart);
			// 发送邮件
			Transport.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getLastName(String fileName) {
		int pos = fileName.lastIndexOf("\\");
		if (pos > -1) {
			fileName = fileName.substring(pos + 1);
		}
		pos = fileName.lastIndexOf("/");
		if (pos > -1) {
			fileName = fileName.substring(pos + 1);
		}
		return fileName;
	}
	
}
