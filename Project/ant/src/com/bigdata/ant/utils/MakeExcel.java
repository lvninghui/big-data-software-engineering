package com.bigdata.ant.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class MakeExcel {

	public MakeExcel() {
	}

	// 入参是一个list,一条数据存一个map对象，map对象中存列和值得对应关系，destFile当然就是要存的文件信息。
	// headList很重要，它是列的展示，当然和数据的列要对应不然找不到对应的地方存储。
	public static void CreateExcelFile(List<Map<String, Object>> list, File destFile, List<String> headList,
			String message) throws WriteException, IOException {
		int sizeAll = list.size();
		// 设置每页最大条数 65534 ，求出整数页 wholeNumber
		int wholeNumber = sizeAll / 65534;
		// 求出最后一页的条数
		int yu = sizeAll % 65534;
		int sheetSize = 1;
		int flagList = 1;
		if (sizeAll <= 65534) {
			sheetSize = 1;
		} else {
			if (yu > 0) {
				sheetSize = wholeNumber + 1;
			} else {
				sheetSize = wholeNumber;
			}
		}

		WritableWorkbook book = null;
		book = Workbook.createWorkbook(destFile);
		if (list.size() == 0) {
			book.write();
		} else {
			for (int j = 0; j < sheetSize; j++) {
				int index;
				WritableSheet sheet = book.createSheet(destFile.getName().replace(".xls", "") + j, j);
				/**
				 * ARIAL : 字体样式 【WritableFont.createFont("宋体") : 宋体字体的设置】 19 : 字体大小
				 * WritableFont.BOLD, false 是判断是否为斜体,选择true时为斜体 ,默认为 false
				 */
				WritableFont BoldFont = new WritableFont(WritableFont.TIMES, 15);
				WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);
				wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
				wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
				wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐
				wcf_center.setWrap(false); // 文字是否换行
				// wcf_center.setBackground(Colour.LIGHT_GREEN);// 单元格背景颜色
				for (int i = 0; i < headList.size() + 1; i++) {
					sheet.setColumnView(i, 25);// 设置第i列的宽度
				}
				// 合并首行
				sheet.mergeCells(0, 0, headList.size() - 1, 0);
				sheet.addCell(new Label(0, 0, message, wcf_center));

				index = 0;
				for (String name : headList) {
					if (name != null) {
						sheet.addCell(new Label(index, 1, name, wcf_center));
						index++;
					}

				}
				int i = 0;
				int t = 2;
				while (flagList <= list.size()) {
					index = 0;
					if (i < 65534) {
						for (String name : headList) {
							if (list.get(flagList - 1).get(name) != null) {
								sheet.addCell(new Label(index, t, list.get(flagList - 1).get(name) + "", wcf_center));
								index++;
							}
						}
						i++;
						t++;
						flagList++;
					} else {
						break;
					}
				}
			}
		}
		book.write();
		if (book != null)
			book.close();
	}

	/**
	 * 文件下载
	 *
	 * @param filepath 文件路径
	 * @param response
	 */
	public static void send(String filepath, HttpServletResponse response) {
		try {
			File file = new File(filepath);// path是文件地址
			String filename = file.getName();// 获取日志文件名称
			InputStream fis = new BufferedInputStream(new FileInputStream(filepath));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			response.reset();
			// 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			os.write(buffer);// 输出文件
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
