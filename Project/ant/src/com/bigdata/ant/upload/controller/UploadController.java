package com.bigdata.ant.upload.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bigdata.ant.upload.service.UploadServiceImpl;

/**
 * 
 * @ClassName:UploadController 接收请求
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月20日
 *
 */
@Controller
public class UploadController {
	@Resource
	private UploadServiceImpl uploadServiceImpl;

	@RequestMapping(value = "/addressSubmitStudy")
	public String addressSubmitStudy(HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("upfile");
		// 判断文件是否为空
		if (file == null)
			return null;
		// 获取文件名
		String name = file.getOriginalFilename();
		System.out.println(name);
		// 进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
		long size = file.getSize();
		if (name == null || ("").equals(name) && size == 0)
			return null;

		// 批量导入 参数：文件名，文件。
		boolean b = uploadServiceImpl.batchImport(name, file);
		if (b) {
			System.out.println("批量导入EXCEL成功!");
		} else {
			System.out.println("批量导入EXCEL失败！");
			return "monitor_awardstudy";// 返回该页面
		}
		return "monitor_awardcharacter";// 调到上传品德成绩页面
	}

	@RequestMapping(value = "/addressSubmitMoral")
	public String addressSubmitMoral(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("upfile");
		// 判断文件是否为空
		if (file == null)
			return null;
		// 获取文件名
		String name = file.getOriginalFilename();
		System.out.println(name);
		// 进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
		long size = file.getSize();
		if (name == null || ("").equals(name) && size == 0)
			return null;

		// 批量导入，参数：文件名，文件。
		boolean b = uploadServiceImpl.moralImport(name, file);
		if (b) {
			System.out.println("批量导入EXCEL成功!");
		} else {
			System.out.println("批量导入EXCEL失败！");
			return "monitor_awardcharacter";
		}
//		request.getRequestDispatcher("addressComprehensive").forward(request, response);
		return "monitor_comprehensive";
		
	}
}
