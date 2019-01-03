//package com.bigdata.ant.utils;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.bigdata.ant.entity.ActivitySum;
//
//import jxl.Sheet;
//import jxl.Workbook;
//
//public class StuService {
//	/**
//	 * 查询指定目录中电子表格中所有的数据
//	 * 
//	 * @param file 文件完整路径
//	 * @return
//	 */
//	public static List<ActivitySum> getAllByExcel(String file) {
//		List<ActivitySum> list = new ArrayList<ActivitySum>();
//		try {
//			Workbook rwb = Workbook.getWorkbook(new File(file));
//			Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
//			int clos = rs.getColumns();// 得到所有的列
//			int rows = rs.getRows();// 得到所有的行
//			System.out.println("clos:" + clos + " rows:" + rows);
//			for (int i = 2; i < rows + 1; i++) {
//				for (int j = 0; j < clos; j++) {
//					// 第一个是列数，第二个是行数
//					String id = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列 所以这里得j++
//					
//					String activity = rs.getCell(j++, i).getContents();
//					String score = rs.getCell(j++, i).getContents();
//					System.out.println(" name:" + id + " sex:" + activity + " num:" + score);
//					list.add(new ActivitySum(id,activity, Integer.parseInt(score)));
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//
//	}
//
////	/**
////	 * 通过Id判断是否存在
////	 * 
////	 * @param id
////	 * @return
////	 */
////	public static boolean isExist(int id) {
////		try {
////			DBhepler db = new DBhepler();
////			ResultSet rs = db.Search("select * from stu where id=?", new String[] { id + "" });
////			if (rs.next()) {
////				return true;
////			}
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return false;
////	}
//
//}
