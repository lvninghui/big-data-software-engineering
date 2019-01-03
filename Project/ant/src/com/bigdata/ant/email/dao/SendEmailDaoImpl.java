package com.bigdata.ant.email.dao;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Repository;

import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.BaseDao;

/**
 * 
 * @ClassName:SendEmailDaoImpl
 * @Description:忘记密码，邮箱找回
 * @Author xujunmei
 * @Date:2018年12月10日
 *
 */
@Repository
public class SendEmailDaoImpl extends BaseDao<Student, Integer> {

	/**
	 * 
	 * @Title: SearchByEmail
	 * @Description: 通过email找到用户
	 * @param:@param hql
	 * @param:@param params
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param hql
	 * @param params
	 * @return
	 */
	public boolean SearchByEmail(String email) {
		String hql = "from Student s where s.email = ?0";
		Student s = null;
		try {
			s = this.findOne1(hql, email);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (s != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: SendEmail
	 * @Description: 发送邮件
	 * @param:@param email (参数)
	 * @return:void(返回类型)
	 *
	 * @param email
	 */
	public void SendEmail(String email) {
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.163.com");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("15226567668@163.com", "xjm123456");
			}
		});
		MimeMessage message = new MimeMessage(session);
		try {

			message.setFrom(new InternetAddress("15226567668@163.com"));
			message.addRecipients(Message.RecipientType.TO, new InternetAddress().parse(email));
			message.setSubject("重置密码");
			message.setContent(
					"<a href='http://localhost:8080/ant/three_resetpassword.jsp?email=" + email + "''>点此链接，重置密码</a>",
					"text/html;charset=GBK");
			message.setHeader("X-Mailer", "smtpsend");
			message.setSentDate(new Date());
			message.saveChanges();
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
