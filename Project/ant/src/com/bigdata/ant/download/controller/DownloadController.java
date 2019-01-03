package com.bigdata.ant.download.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata.ant.entity.ActivitySum;
import com.bigdata.ant.entity.Monitor;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.utils.MakeExcel;

import jxl.write.WriteException;

/**
 * 
 * @ClassName:DownloadController
 * @Description:下载活动汇总表
 * @Author xujunmei
 * @Date:2018年12月18日
 *
 */

@Controller
public class DownloadController {
	/**
	 * 
	 * @Title: download
	 * @Description: 下载活动汇总表
	 * @param:@param response
	 * @param:@param request
	 * @param:@param session
	 * @param:@throws IOException (参数)
	 * @return:void(返回类型)
	 *
	 * @param response
	 * @param request
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/download")
	public void download(HttpServletResponse response, HttpServletRequest request, HttpSession session)
			throws IOException {
		Monitor m = (Monitor) session.getAttribute("m");
		// 获取当前时间
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		if (month < 9) {
			y = y - 1;
		}
		String year = String.valueOf(y);
		// 设置默认excel名
		String FILEPATH = "活动汇总表.xls";
		deleteFile(FILEPATH);
		// 设置表头
		List<String> ll = new ArrayList<>();
		ll.add("学号");
		ll.add("姓名");
		for (int j = 1; j < 16; j++) {
			ll.add("活动名称" + j);
			ll.add("分数" + j);
			ll.add("类别" + j);
		}
		Set<Student> set = m.getClassInfo().getStudents();
		int n = set.size();
		Iterator<Student> it = set.iterator();
		List<Map<String, Object>> list = new ArrayList<>();
		while (it.hasNext()) {
			Student str = it.next();
			List<ActivitySum> li = str.getSumActivities();
			int size = li.size() + 1;
			Map<String, Object> map = new HashMap<>();
			for (int i = 1; i < size; i++) {
				int r = i - 1;
				String s1 = "活动名称" + i;
				String s2 = "分数" + i;
				String s3 = "类别" + i;
				map.put("学号", li.get(r).getStudent().getId());
				map.put("姓名", li.get(r).getStudent().getName());
				map.put(s1, li.get(r).getActivityName());
				map.put(s2, li.get(r).getScore());
				map.put(s3, li.get(r).getType());
				list.add(map);
			}
		}
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
		try {
			String title = year + "年活动汇总";
			MakeExcel.CreateExcelFile(list, new File(FILEPATH), ll, title);
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MakeExcel.send(FILEPATH, response);
		deleteFile(FILEPATH);

	}

	/**
	 * 
	 * @Title: deleteFile
	 * @Description: 删除单个文件
	 * @param:@param sPath
	 * @param:@return (参数)
	 * @return:boolean(返回类型)
	 *
	 * @param sPath
	 * @return
	 */
	public boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}
}