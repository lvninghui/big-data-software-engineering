package com.bigdata.ant.update.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bigdata.ant.entity.ActivitySum;
import com.bigdata.ant.entity.Student;
import com.bigdata.ant.login.dao.StudentDaoImpl;
import com.bigdata.ant.update.dao.UpdateDaoImpl;

import jxl.Sheet;
import jxl.Workbook;

/**
 * 
 * @ClassName:UpdateServiceImpl
 * @Description:修改报名表
 * @Author xujunmei
 * @Date:2018年12月24日
 *
 */
@Service
@Transactional(readOnly = false)
public class UpdateServiceImpl {
	@Resource
	private StudentDaoImpl studentDaoImpl;
	@Resource
	private UpdateDaoImpl updateDaoImpl;

	/**
	 * 
	 * @Title: listId
	 * @Description: 查出id对应的学生
	 * @param:@return (参数)
	 * @return:Student(返回类型)
	 *
	 * @return
	 */
	public Student getStuById(String id) {
		return this.studentDaoImpl.getStuById(id);
	}

	/**
	 * 
	 * @Title: getAllByExcel
	 * @Description: 读出excel中的数据并将其插入到list中
	 * @param:@param file
	 * @param:@return (参数)
	 * @return:List<ActivitySum>(返回类型)
	 *
	 * @param file
	 * @return
	 */
	public List<ActivitySum> getAllByExcel(File file) {
		List<ActivitySum> list = new ArrayList<ActivitySum>();
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		if (month < 9) {
			y--;
		}
		String year = String.valueOf(y);
		try {
			Workbook rwb = Workbook.getWorkbook(file);
			Sheet rs = rwb.getSheet(0);
			int clos = rs.getColumns();
			int rows = rs.getRows();
			System.out.println("clos:" + clos + " rows:" + rows);
			for (int i = 2; i < rows; i++) {
				int j = 0;
				ActivitySum a = new ActivitySum();
				a.setYear(year);
				String id = rs.getCell(j, i).getContents();
				System.out.println(id);
				j = j + 2;
				Student s = this.getStuById(id);
				String activity = rs.getCell(j++, i).getContents();
				System.out.println(activity);
				String score = rs.getCell(j++, i).getContents();
				System.out.println(score);
				String type = rs.getCell(j++, i).getContents();
				System.out.println(type);
				a.setStudent(s);
				a.setActivityName(activity);
				a.setScore(Float.parseFloat(score));
				a.setType(type);
				list.add(a);
				int m = j++;
				while (rs.getCell(m, i).getContents() != null && rs.getCell(m, i).getContents() != "") {
					System.out.println(m);
					ActivitySum a1 = new ActivitySum();
					a1.setYear(year);
					a1.setStudent(s);
					String acticvitys = rs.getCell(m++, i).getContents();
					System.out.println(acticvitys);
					String scores = rs.getCell(m++, i).getContents();
					System.out.println(scores);
					String types = rs.getCell(m++, i).getContents();
					System.out.println(types);
					a1.setActivityName(acticvitys);
					a1.setScore(Float.parseFloat(scores));
					a1.setType(types);
					list.add(a1);
					m = m + 3;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @Title: setAS
	 * @Description: 插入
	 * @param:@param s
	 * @param:@param name
	 * @param:@param score
	 * @param:@param type (参数)
	 * @return:void(返回类型)
	 *
	 * @param s
	 * @param name
	 * @param score
	 * @param type
	 */
	public void setAS(Student s, String name, Float score, String type) {
		this.updateDaoImpl.setAS(s, name, score, type);
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param:@throws Exception (参数)
	 * @return:void(返回类型)
	 *
	 * @throws Exception
	 */
	public void delete() throws Exception {
		this.updateDaoImpl.delete();
	}
}
