package com.bigdata.ant.update.controller;

import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.bigdata.ant.entity.ActivitySum;
import com.bigdata.ant.update.service.UpdateServiceImpl;

/**
 * 
 * @ClassName:UpdateController
 * @Description:修改参并将结果存到汇总表
 * @Author xujunmei
 * @Date:2018年12月24日
 *
 */
@Controller
public class UpdateController {

	@Resource
	private UpdateServiceImpl updateServiceImpl;

	/**
	 * 
	 * @Title: update
	 * @Description: 将excel插入到数据库
	 * @param:@param request
	 * @param:@return (参数)
	 * @return:String(返回类型)
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload1")
	public String update(HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile f = multipartRequest.getFile("upfile");
		CommonsMultipartFile cf = (CommonsMultipartFile) f;
		DiskFileItem fi = (DiskFileItem) cf.getFileItem();
		File file = fi.getStoreLocation();
		List<ActivitySum> listExcel = this.updateServiceImpl.getAllByExcel(file);
		try {
			this.updateServiceImpl.delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ActivitySum a : listExcel) {
			this.updateServiceImpl.setAS(a.getStudent(), a.getActivityName(), a.getScore(), a.getType());
		}
		return "monitor_awardstudy";
	}

}
