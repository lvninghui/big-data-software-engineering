package com.bigdata.ant.register.service;

import java.util.Date;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.entity.Monitor;
import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.register.dao.RegisterOrganizationDaoImpl;
import com.bigdata.ant.utils.IncreaseTimeUtil;
import com.bigdata.ant.utils.MD5Util;
import com.bigdata.ant.utils.MailUtil;

@Service
@Transactional(readOnly = false)
public class RegisterOrganizationServiceImpl {

	@Resource
	private RegisterOrganizationDaoImpl registerOrganizationDaoImpl;
	
	/**
	 * 
	 * @Title: findStudentByEmail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param:@param email
	 * @param:@return (参数)
	 * @return:Boolean(返回类型)
	 *
	 * @param email
	 * @return
	 */
	public Boolean findOrganizationByEmail(String email) {
		try {
			Organization organization = registerOrganizationDaoImpl.findOrganizationByEmail(email);
			if (organization != null) {
				return true;// 该邮箱已经注册过组织
			} else {
				return false;// 不存在该班委
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @Title: admitMonitorRegister
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param:@param monitor
	 * @param:@param college
	 * @param:@param profession
	 * @param:@param grade
	 * @param:@param classes
	 * @param:@param againpsd
	 * @param:@return (参数)
	 * @return:String(返回类型)
	 *
	 * @param monitor
	 * @param college
	 * @param profession
	 * @param grade
	 * @param classes
	 * @param againpsd
	 * @return
	 */
	public String admitOrganizationRegister(Organization organization, String belong, String orgName,String againpsd) {
		if(belong.equals("0")) {
			return "请选择所属单位";
		}
		if(orgName.equals("0")) {
			return "请选择组织名";
		}
		if (organization.getPassword().equals("")||organization.getPassword() == null) {
			return "密码不能为空";
		}
		if (againpsd.equals("") || againpsd == null) {
			return "确认密码不能为空";
		}
		if (organization.getEmail() == null) {
			return "邮箱不能为空";
		}
		Pattern pattern = Pattern.compile("^[a-zA-Z]\\w{5,17}$");
		if (!(pattern.matcher(organization.getPassword()).matches())) {
			return "密码以字母开头，长度在6~18之间，只能包含字母、数字和下划线";
		}
		if (!(organization.getPassword().equals(againpsd))) {
			return "确认密码填写不一致";
		}
		pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		if (!(pattern.matcher(organization.getEmail()).matches())) {
			return "请填写正确的邮箱地址";
		}
		if (findOrganizationByEmail(organization.getEmail()) == true) {
			return "该邮箱已经注册过一个组织了";
		}
		return "0";
	}

	/**
	 * 
	 * @Title: saveMonitor
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param:@param monitor (参数)
	 * @return:void(返回类型)
	 *
	 * @param monitor
	 */
	public void saveOrganization(Organization organization) {
		try {
			registerOrganizationDaoImpl.save(organization);
		} catch (Exception e) {
		}
	}
	/**
	 * 
	 * @Title: processMonitorRegister
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param:@param monitor
	 * @param:@return (参数)
	 * @return:String(返回类型)
	 *
	 * @param monitor
	 * @return
	 */
	public String processOrganizationRegister(Organization organization,String school, String orgName,String againpsd) {
		// 激活码由email产生
		String validateCode = MD5Util.encode2hex(organization.getEmail());
		// 发送邮件
		StringBuffer sb = new StringBuffer("点击下面链接激活账号，24小时内有效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
		sb.append("<a href=\"http://localhost:8080/ant/activeOrganization?email=").append(organization.getEmail())
				.append("&validateCode=").append(validateCode).append("\">点此链接激活账户").append("</a>");
		MailUtil.send(organization.getEmail(), sb.toString());
		
		organization.setName(school+orgName);
		organization.setStatus(0);
		organization.setValidateCode(validateCode);
		organization.setRegisterTime(new Date());
		organization.setPassword(MD5Util.encode2hex(organization.getPassword()));// 密码加密
		saveOrganization(organization);
		return validateCode;
	}

	public String VolidateOrganizationRegister(String email, String validateCode) {
		Organization organization = registerOrganizationDaoImpl.findOrganizationByEmail(email);
		if (organization != null) {
			if (organization.getStatus() == 0) {
				Date currentTime = new Date();
				// 验证链接是否过期
				if (currentTime.before(IncreaseTimeUtil.addDateMinut(organization.getRegisterTime(), 24))) {
					if (organization.getValidateCode().equals(validateCode)) {
						registerOrganizationDaoImpl.updateStatus();
						return "激活成功";
					}
				} else {
					return "激活码已过期";
				}
			} else {
				return "邮箱已激活，请登录";
			}
		}
		return "该邮箱未注册";
	}
}
