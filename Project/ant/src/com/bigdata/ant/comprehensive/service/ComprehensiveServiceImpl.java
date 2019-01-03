package com.bigdata.ant.comprehensive.service;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigdata.ant.comprehensive.dao.ComprehensiveDaoImpl;
import com.bigdata.ant.comprehensive.dao.ComprehensiveMoralDaoImpl;
import com.bigdata.ant.comprehensive.dao.ComprehensiveStudyDaoImpl;
import com.bigdata.ant.entity.ActivitySum;
import com.bigdata.ant.entity.Comprehensive;
import com.bigdata.ant.entity.Monitor;
import com.bigdata.ant.entity.Student;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * @ClassName:ComprehensiveServiceImpl
 * @Description:TODO（用一句话描述这个类的作用）算综测，生成综测成绩单
 * @Author wangmengzhen
 * @Date:2018年12月26日
 *
 */
@Service
@Transactional(readOnly = false)
public class ComprehensiveServiceImpl {

	@Resource
	private ComprehensiveMoralDaoImpl comprehensiveMoralDaoImpl;
	@Resource
	private ComprehensiveStudyDaoImpl comprehensiveStudyDaoImpl;
	@Resource
	private ComprehensiveDaoImpl comprehensiveDaoImpl;

	/**
	 * 
	 * @Title: getStudentByClass
	 * @Description: TODO(这里用一句话描述这个方法的作用) 通过班委获得该班级的学生集合
	 * @param:@param monitor
	 * @param:@return (参数)
	 * @return:Set<Student>(返回类型)
	 *
	 * @param monitor
	 * @return
	 */
	public Set<Student> getStudentByClass(Monitor monitor) {
		return monitor.getClassInfo().getStudents();
	}

	/**
	 * 
	 * @Title: getMoralAwardScoreByStudent
	 * @Description: TODO(这里用一句话描述这个方法的作用) 通过学生获得品德奖励分
	 * @param:@param student
	 * @param:@return (参数)
	 * @return:float(返回类型)
	 *
	 * @param student
	 * @return
	 */
	public float getMoralAwardScoreByStudent(Student student) {
		List<ActivitySum> list = student.getSumActivities();
		float sumMoralScore = 0;
		for (ActivitySum activitySum : list) {
			if (activitySum.getType().equals("品行表现")) {
				sumMoralScore += activitySum.getScore();
			}
		}
		sumMoralScore += comprehensiveMoralDaoImpl.getMoralScore(student.getId());
		return sumMoralScore;
	}

	/**
	 * 
	 * @Title: getStudyScoreByStudent
	 * @Description: TODO(这里用一句话描述这个方法的作用) 通过学生查找学业成绩
	 * @param:@param student
	 * @param:@return (参数)
	 * @return:float(返回类型)
	 *
	 * @param student
	 * @return
	 */
	public float getStudyScoreByStudent(Student student) {
		float sumStudyScore = 0;
		sumStudyScore += comprehensiveStudyDaoImpl.getStudyScore(student.getId());
//		System.out.println("studyScore"+sumStudyScore);
		return sumStudyScore;
	}

	/**
	 * 
	 * @Title: getAbilityAwardScoreByStudent
	 * @Description: TODO(这里用一句话描述这个方法的作用) 通过学生获得能力表现分数
	 * @param:@param student
	 * @param:@return (参数)
	 * @return:float(返回类型)
	 *
	 * @param student
	 * @return
	 */
	public float getAbilityAwardScoreByStudent(Student student) {
		List<ActivitySum> list = student.getSumActivities();
		float sumAbilityScore = 0;
		for (ActivitySum activitySum : list) {
			if (activitySum.getType().equals("能力表现")) {
				sumAbilityScore += activitySum.getScore();
			}
		}
		return sumAbilityScore;
	}

	/**
	 * 
	 * @Title: getComprehensiveScore
	 * @Description: TODO(这里用一句话描述这个方法的作用) 计算综测成绩
	 * @param:@param maxMoral
	 * @param:@param maxStudy
	 * @param:@param maxAbility
	 * @param:@param student
	 * @param:@return (参数)
	 * @return:float(返回类型)
	 *
	 * @param maxMoral
	 * @param maxStudy
	 * @param maxAbility
	 * @param student
	 * @return
	 */
	public float getComprehensiveScore(float maxMoral, float maxStudy, float maxAbility, Student student) {
		float moral = getMoralAwardScoreByStudent(student);
		float study = getStudyScoreByStudent(student);
		float ability = getAbilityAwardScoreByStudent(student);
		float comprehensiveScore = moral / maxMoral * 30 + study / maxStudy * 50 + ability / maxAbility * 20;
		return comprehensiveScore;
	}

	/**
	 * 
	 * @Title: insertScore
	 * @Description: TODO(这里用一句话描述这个方法的作用) 插入到数据库中
	 * @param:@param monitor (参数)
	 * @return:void(返回类型)
	 *
	 * @param monitor
	 */
	public void insertScore(Monitor monitor) {
		float maxMoral = 0;
		float maxStudy = 0;
		float maxAbility = 0;
		Set<Student> studentSet = monitor.getClassInfo().getStudents();// 获得该班级学生集合
		for (Student student : studentSet) {
			float moral = getMoralAwardScoreByStudent(student);
			if (maxMoral < moral) {
				maxMoral = moral;
			}

			float study = getStudyScoreByStudent(student);
			if (maxStudy < study) {
				maxStudy = study;
			}

			float ability = getAbilityAwardScoreByStudent(student);
			if (maxAbility < ability) {
				maxAbility = ability;
			}
		}
		for (Student student : studentSet) {
			float comprehensiveScore = getComprehensiveScore(maxMoral, maxStudy, maxAbility, student);// 得到该学生的综测分数
			Comprehensive comprehensive = comprehensiveDaoImpl.getComprehensive(student.getId());
			if (comprehensive != null) {// 若已有该成绩则更新
				comprehensive.setScore(comprehensiveScore);
			} else {// 若无该成绩，则插入数据
				Comprehensive comprehensive1 = new Comprehensive();
				comprehensive1.setId(student.getId());
				comprehensive1.setScore(comprehensiveScore);
				comprehensive1.setName(student.getName());
				comprehensiveDaoImpl.saveComprehensive(comprehensive1);
			}
		}

	}

	/**
	 * 
	* @Title: getList  
	* @Description: TODO(这里用一句话描述这个方法的作用) 通过班委获得数据库中综测表集合
	* @param:@param monitor
	* @param:@return (参数)
	* @return:List<Comprehensive>(返回类型)
	*
	 * @param monitor
	 * @return
	 */
	public List<Comprehensive> getList(Monitor monitor) {
		Set<Student> studentSet = monitor.getClassInfo().getStudents();
		List<Comprehensive> list = new ArrayList();
		for (Student student : studentSet) {
			Comprehensive comprehensive = comprehensiveDaoImpl.getComprehensive(student.getId());
			list.add(comprehensive);
		}
		return list;
	}

	/**
	 * 
	* @Title: downloadExcel  
	* @Description: TODO(这里用一句话描述这个方法的作用) 调用该方法，将内容写入到Excel中，并下载
	* @param:@param response
	* @param:@param monitor
	* @param:@throws Exception (参数)
	* @return:void(返回类型)
	*
	 * @param response
	 * @param monitor
	 * @throws Exception
	 */
	public void downloadExcel(HttpServletResponse response, Monitor monitor) throws Exception {
		OutputStream os = response.getOutputStream();// 取得输出流
		response.reset();// 清空输出流
		response.setHeader("Content-disposition", "attachment; filename=comprehensive.xls");// 设定输出文件头
		response.setContentType("application/msexcel");// 定义输出类型
		WritableWorkbook wbook = Workbook.createWorkbook(os); // 建立excel文件
		String tmptitle = "综测表"; // 标题
		WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet名称

		// 设置excel标题
		WritableFont wfont = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		WritableCellFormat wcfFC = new WritableCellFormat(wfont);
		wcfFC.setBackground(Colour.AQUA);
		wfont = new jxl.write.WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		wcfFC = new WritableCellFormat(wfont);
		// 开始生成主体内容
		wsheet.addCell(new Label(0, 0, "学号"));
		wsheet.addCell(new Label(1, 0, "姓名"));
		wsheet.addCell(new Label(2, 0, "综测分数"));
		List<Comprehensive> list = getList(monitor);
		int count = 0;
		for (Comprehensive comprehensive : list) {
			wsheet.addCell(new Label(0, count + 1, list.get(count).getId()));
			wsheet.addCell(new Label(1, count + 1, list.get(count).getName()));
			wsheet.addCell(new jxl.write.Number(2, count + 1, (float) list.get(count).getScore()));
			count++;
		}

		// 主体内容生成结束
		wbook.write(); // 写入文件
		wbook.close();
		os.close(); // 关闭流
	}
}
