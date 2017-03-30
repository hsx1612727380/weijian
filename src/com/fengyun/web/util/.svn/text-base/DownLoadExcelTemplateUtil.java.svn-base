package com.fengyun.web.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * 提供导入EXCEL的模板
 * 
 * @author hsx
 * 
 */
public class DownLoadExcelTemplateUtil {
	
	@SuppressWarnings("unchecked")
	public static void getExcelTemplate(String filePath, HttpServletRequest request, HttpServletResponse response) {
		java.io.File file = new java.io.File(filePath);
		SAXBuilder builder = new SAXBuilder();
		try {
			// 解析xml文件
			Document parse = builder.build(file);
			// 创建Excel
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建Sheet
			HSSFSheet sheet = workbook.createSheet();
			// 获取xml文件根节点
			Element root = parse.getRootElement();
			// 获取模板名称
			String templateName = root.getAttribute("name").getValue();
			int rownum = 0;
			int column = 0;
			// 设置列宽
			Element colgroup = root.getChild("colgroup");
			setColumnWidth(sheet, colgroup);
			// 设置标题
			Element title = root.getChild("title");
			List<Element> trs = title.getChildren("tr");
			for (int i = 0; i < trs.size(); i++) {
				Element tr = trs.get(i);
				List<Element> tds = tr.getChildren("td");
				HSSFRow row = sheet.createRow(rownum);
				HSSFCellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				for (column = 0; column < tds.size(); column++) {
					Element td = tds.get(column);
					HSSFCell cell = row.createCell(column);
					Attribute rowSpan = td.getAttribute("rowspan");
					Attribute colSpan = td.getAttribute("colspan");
					Attribute value = td.getAttribute("value");
					if (value != null) {
						String val = value.getValue();
						cell.setCellValue(val);
						int rspan = rowSpan.getIntValue() - 1;
						int cspan = colSpan.getIntValue() - 1;
						// 设置字体
						HSSFFont font = workbook.createFont();
						font.setFontName("仿宋_GB2312");
						font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
						font.setFontHeightInPoints((short) 12);
						cellStyle.setFont(font);
						cell.setCellStyle(cellStyle);
						// 合并单元格
						sheet.addMergedRegion(new CellRangeAddress(rspan,
								rspan, 0, cspan));
					}
				}
				rownum++;
			}
			// 设置表头信息
			Element thead = root.getChild("thead");
			trs = thead.getChildren("tr");
			for (int i = 0; i < trs.size(); i++) {
				Element tr = trs.get(i);
				HSSFRow row = sheet.createRow(rownum);
				List<Element> ths = tr.getChildren("th");
				for (column = 0; column < ths.size(); column++) {
					Element th = ths.get(column);
					Attribute valueAttr = th.getAttribute("value");
					HSSFCell cell = row.createCell(column);
					if (valueAttr != null) {
						String value = valueAttr.getValue();
						cell.setCellValue(value);
					}
				}
				rownum++;
			}
			// 设置数据区域样式
			Element tbody = root.getChild("tbody");
			Element tr = tbody.getChild("tr");
			int repeat = tr.getAttribute("repeat").getIntValue();
			List<Element> tds = tr.getChildren("td");
			for (int i = 0; i < repeat; i++) {
				HSSFRow row = sheet.createRow(rownum);
				for (column = 0; column < tds.size(); column++) {
					Element td = tds.get(column);
					HSSFCell cell = row.createCell(column);
					setType(workbook, cell, td);
				}
				rownum++;
			}
			// 生产的EXCEL保存到本地
			String importPath = request.getSession().getServletContext()
					.getRealPath("\\resource\\execl\\import\\template\\");
			java.io.File importMK = new java.io.File(importPath);
			if (!importMK.exists() && !importMK.isDirectory()) {
				importMK.mkdirs();
			}
			String importPath1 = importPath + "\\" + templateName + ".xls";
			java.io.File importFile = new java.io.File(importPath1);
			if (!importFile.exists() && !importFile.isFile()) {
				importFile.createNewFile();
				FileOutputStream stream = FileUtils.openOutputStream(importFile);
				workbook.write(stream);
				stream.close();
			}
			String fullFileName = importPath1;
			// 读取文件
			InputStream in = new FileInputStream(fullFileName);
			OutputStream out = response.getOutputStream();
			// 使用前清空response
			response.reset();
			// 设定输出文件头
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(templateName.getBytes("utf-8"), "ISO8859-1")
					+ ".xls");
			// 定义输出类型
			response.setContentType("application/msexcel");
			// 写文件
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置单元格的样式
	 * @param workbook
	 * @param cell
	 * @param td
	 */
	private static void setType(HSSFWorkbook workbook, HSSFCell cell, Element td) {
		Attribute typeAttr = td.getAttribute("type");
		String type = typeAttr.getValue();
		HSSFDataFormat format = workbook.createDataFormat();
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		if ("NUMERIC".equalsIgnoreCase(type)) {
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			Attribute formatAttr = td.getAttribute("format");
			String formatValue = formatAttr.getValue();
			formatValue = StringUtils.isNotBlank(formatValue) ? formatValue : "#, ##0.00";
			cellStyle.setDataFormat(format.getFormat(formatValue));
		} else if ("STRING".equalsIgnoreCase(type)) {
			cell.setCellValue("");
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cellStyle.setDataFormat(format.getFormat("@"));
		} else if ("DATE".equalsIgnoreCase(type)) {
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			Attribute formatAttr = td.getAttribute("format");
			String formatValue = formatAttr.getValue();
			cellStyle.setDataFormat(format.getFormat(formatValue));
		} else if ("ENUM".equalsIgnoreCase(type)) {
			CellRangeAddressList regions = new CellRangeAddressList(cell.getRowIndex(), 
					cell.getRowIndex(), cell.getColumnIndex(), cell.getColumnIndex());
			Attribute enumAttr = td.getAttribute("format");
			String enumValue = enumAttr.getValue();
			// 加载下拉列表内容
			DVConstraint constraint = DVConstraint.createExplicitListConstraint(enumValue.split(","));
			// 数据有效性对象
			HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
			workbook.getSheetAt(0).addValidationData(dataValidation);
		}
		cell.setCellStyle(cellStyle);
	}

	/**
	 * 设置列宽
	 * @param sheet
	 * @param colgroup
	 */
	@SuppressWarnings("unchecked")
	private static void setColumnWidth(HSSFSheet sheet, Element colgroup) {
		List<Element> cols = colgroup.getChildren("col");
		for (int i = 0; i < cols.size(); i++) {
			Element col = cols.get(i);
			Attribute width = col.getAttribute("width");
			String unit = width.getValue().replaceAll("[0-9,\\.]", "");
			String value = width.getValue().replaceAll(unit, "");
			int v = 0;
			if (StringUtils.isBlank(unit) || "px".endsWith(unit)) {
				v = Math.round(Float.parseFloat(value) * 37F);
			} else if ("em".endsWith(unit)) {
				v = Math.round(Float.parseFloat(value) * 267.5F);
			}
			sheet.setColumnWidth(i, v); // 第i列的宽度为v
		}
	}
	
}
