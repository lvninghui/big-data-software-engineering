package com.bigdata.ant.upload.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bigdata.ant.entity.BasicScore;
import com.bigdata.ant.entity.MoralScore;
import com.bigdata.ant.upload.dao.UploadDaoImpl;
import com.bigdata.ant.upload.dao.UploadMoralDaoImpl;
import com.bigdata.ant.utils.ReadExcel;

/**
 * 
 * @ClassName:UploadServiceImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author wangmengzhen
 * @Date:2018年12月24日
 *
 */
@Service
@Transactional(readOnly = false)
public class UploadServiceImpl {

	@Resource
	private UploadDaoImpl uploadDaoImpl;
	@Resource
	private UploadMoralDaoImpl uploadMoralDaoImpl;

	/**
	 * 
	 * @Title: addBasicScore
	 * @Description: TODO(这里用一句话描述这个方法的作用) 无数据，插入数据；有数据，更新数据
	 * @param:@param basicScore (参数)
	 * @return:void(返回类型)
	 *
	 * @param basicScore
	 */
	public void addBasicScore(BasicScore basicScore) {
		BasicScore basicScore1;
		try {
			basicScore1 = uploadDaoImpl.get(basicScore.getId());
			if (basicScore1 != null) {
				basicScore1.setStudyScore(basicScore.getStudyScore());
			} else {
				uploadDaoImpl.addBasicScore(basicScore);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @Title: addMoralScore
	 * @Description: TODO(这里用一句话描述这个方法的作用) 无数据，插入数据；有数据，更新数据
	 * @param:@param moralScore (参数)
	 * @return:void(返回类型)
	 *
	 * @param moralScore
	 */
	public void addMoralScore(MoralScore moralScore) {
		MoralScore moralScore1;
		try {
			moralScore1 = uploadMoralDaoImpl.get(moralScore.getId());
			if (moralScore1 != null) {
				moralScore1.setMoralScore(moralScore.getMoralScore());
			} else {
				uploadMoralDaoImpl.addMoralScore(moralScore);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	* @Title: batchImport  
	* @Description: TODO(这里用一句话描述这个方法的作用) 批量导入学业成绩
	* @param:@param name
	* @param:@param file
	* @param:@return (参数)
	* @return:boolean(返回类型)
	*
	 * @param name
	 * @param file
	 * @return
	 */
	public boolean batchImport(String name, MultipartFile file) {
		boolean b = false;
		// 创建处理EXCEL
		ReadExcel readExcel = new ReadExcel();
		// 解析excel，获取客户信息集合。
		List<BasicScore> basicScoreList = readExcel.getExcelInfo(name, file);

		if (basicScoreList != null) {
			b = true;
		}

		// 迭代添加信息
		for (BasicScore basicScore : basicScoreList) {
			addBasicScore(basicScore);
		}
		return b;
	}

	/**
	 * 
	* @Title: moralImport  
	* @Description: TODO(这里用一句话描述这个方法的作用) 批量导入品德成绩
	* @param:@param name
	* @param:@param file
	* @param:@return (参数)
	* @return:boolean(返回类型)
	*
	 * @param name
	 * @param file
	 * @return
	 */
	public boolean moralImport(String name, MultipartFile file) {
		boolean b = false;
		// 创建处理EXCEL
		ReadExcel readExcel = new ReadExcel();
		// 解析excel，获取客户信息集合。
		List<MoralScore> moralScoreList = readExcel.getExcelMoral(name, file);

		if (moralScoreList != null) {
			b = true;
		}

		// 迭代添加信息
		for (MoralScore moralScore : moralScoreList) {
			addMoralScore(moralScore);
		}
		return b;
	}
}
