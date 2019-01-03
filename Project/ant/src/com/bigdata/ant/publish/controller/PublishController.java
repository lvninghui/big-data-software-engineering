package com.bigdata.ant.publish.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bigdata.ant.entity.Activity;
import com.bigdata.ant.entity.Organization;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.publish.service.PublishServiceImpl;

import sun.misc.BASE64Decoder;

/**
 * @ClassName:PublishController
 * @Description:TODO（发布活动页面的功能实现）
 * @Author 成琼
 * @Date:2018年12月18日
 *
 *
 */
@Controller
public class PublishController {
	@Resource
	public PublishServiceImpl publishServiceImpl;
	private String imageUrl;

	public PublishController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @Title: listHotActivities
	 * @Description: TODO(查询热门活动)
	 * @param:@param model (参数)
	 * @return:void(展示发布活动页面)
	 */
	@RequestMapping("/listHotActivities")
	public String listHotActivities(Model model) {
		List<Object[]> activities = publishServiceImpl.listHotActivities();
		model.addAttribute("hotActivities", activities);
		// System.out.println("已传递热门活动"+activities.size());

		return "organization_publishactivity";
	}

	/**
	 * 
	 * @Title: uploadImage
	 * @Description: TODO(上传活动图片)
	 * @param:@param sortPicImg 活动图片文件
	 * @param:@param request
	 * @param:@param response (参数)
	 * @return:void(返回类型)
	 */
	@RequestMapping("/imageUpload")
	public void uploadImage(@RequestParam("file") MultipartFile sortPicImg, HttpServletRequest request,
			HttpServletResponse response) {
		String rootPath = request.getServletContext().getRealPath("images/");
		Date date = new Date();
		System.out.println(rootPath);
		try {
			FileCopyUtils.copy(sortPicImg.getBytes(),
					new File(rootPath, date.getTime() + sortPicImg.getOriginalFilename()));
			System.out.println("成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imageUrl = "images/" + date.getTime() + sortPicImg.getOriginalFilename();

	}

	/**
	 * 
	 * @Title: uploadImage1
	 * @Description: TODO(学生个人中心的修改头像)
	 * @param:@param imgStr1 图片的base64码
	 * @param:@param request
	 * @param:@param response (参数)
	 * @return:void(返回类型)
	 */
	@RequestMapping(value = "/imageUpload1", method = RequestMethod.POST)
	public void uploadImage1(@RequestParam("file") String imgStr1, HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("s");
		System.out.println("进入上传图片的controller");
		String imgStr = imgStr1.substring(23);
		// System.out.println(imgStr);
		if (imgStr == null) // 图像数据为空
			// return false;
			System.out.println("图片为空");
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			Date date = new Date();
			String rootPath = request.getServletContext().getRealPath("images/");
			String imgFilePath = rootPath + date.getTime() + ".jpg";// 新生成的图片
			System.out.println(imgFilePath);
			System.out.println(rootPath);
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			System.out.println("保存成功");
			// return true;
			String imageUrlStr = "images/" + date.getTime() + ".jpg";
			student.setPhoto(imageUrlStr);
			session.setAttribute("s", student);
			publishServiceImpl.updateStudent(student);
		} catch (Exception e) {
			// return false;
			System.out.println("保存失败");
		}
	}

	/**
	 * 
	 * @Title: saveActivity
	 * @Description: TODO(向数据库插入活动)
	 * @param:@param activity 活动
	 * @param:@param score 分数
	 * @param:@param stage 阶段
	 * @param:@return (参数)
	 * @return:String(发布成功到成功页面，失败回到本页重新发布)
	 */
	@RequestMapping(value = "/saveActivity", method = RequestMethod.POST)
	public String saveActivity(Activity activity, @RequestParam("score") String score,
			@RequestParam("stage") String stage, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Organization organization = (Organization) session.getAttribute("o");
		activity.setImage(imageUrl);
		if (publishServiceImpl.saveActivity(activity, stage, score, organization.getId())) {
			System.out.println("保存活动成功");
			return "organization_successfulpublish";
		} else {
			System.out.println("保存活动未成功");
			return "organization_publishactivity";
		}
	}

}
