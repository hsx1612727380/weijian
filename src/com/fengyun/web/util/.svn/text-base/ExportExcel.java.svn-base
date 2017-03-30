package com.fengyun.web.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * String[] Title 导出excel的表头 String fileName 导出excel的文件名 List<T> listContent
 * 要导出的excel数据内容集合 int skip 要跳过前面skip个字段不导出 String[] dateFieldNames
 * 需要转换时间格式的字段的名字数组
 * 
 * @author zheng 调用：示例（要处理异常） String[] dateFiled =
 *         {"storageTime"};//需要转化时间格式的字段名 按照model的toModel方法中的字段顺序将字段名列出： String[] tTitle =
 *         {"班组名称"
 *         ,"班组类型(0劳务1材料2设备)","合同价","预付款","次数","本次付","已付","累计付","未付","总任务量"
 *         ,"本次工程量","累计工程量","进度百分比","结算","存档时间","备注"};
 * 
 *         ExportExcel.exportExcel(response, tTitle, "班组任务进度表",
 *         tList,3,dateFiled);
 */
public abstract class ExportExcel {
	/**
	 * @param response
	 * @param Title  String[] Title 导出excel的表头
	 * @param fileName   String fileName 导出excel的文件名
	 * @param listContent    List<T> listContent 是要导出的excel数据内容集合
	 * @param skip		int skip 要跳过当前表的前面skip个字段不导出（例如去除id字段）
	 * @param dateFieldNames	String[] dateFieldNames 需要转换时间格式的字段的名字数组 
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public static <T> void exportExcel(HttpServletResponse response,
			String[] Title, String fileName, List<T> listContent, int skip,
			String[] dateFieldNames) throws IOException, RowsExceededException,
			WriteException {
		OutputStream output = response.getOutputStream();// 获取一个输出流
		response.reset();// 使用前清空response
		// 设定输出文件头
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String(fileName.getBytes("utf-8"), "ISO8859-1") + ".xls");
		response.setContentType("application/msexcel");// 定义输出类型
		// 创建可写入的Excel工作薄，且内容将写入到输出流，并通过输出流输出给客户端浏览
		// 该代码表示将xxx.xls的Excel文件通过应答实体（response）输出给请求的客户端浏览器，下载到客户端本地（保存或直接打开）
		WritableWorkbook wk = Workbook.createWorkbook(output);

		// 若要直接输出到磁盘文件可采用下列代码替换加下划线这部分代码
		/*
		 * File file=new File("D://temp.xls");
		 * WritableWorkbook wwb = Workbook.createWorkbook(file);
		 */

		// 创建可写入的Excel工作表
		WritableSheet sheet = wk.createSheet(fileName, 0);
		// 创建WritableFont 字体对象，参数依次表示黑体、字号12、粗体、非斜体、不带下划线、亮蓝色
		// 和其他几种字体
		WritableFont titleFont = new WritableFont(
				WritableFont.createFont("黑体"), 12, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.LIGHT_BLUE);
		WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
		// WritableFont BoldFont = new WritableFont(WritableFont.ARIAL,
		// 10,WritableFont.BOLD);

		WritableCellFormat cloumnTitleFormat = new WritableCellFormat();
		cloumnTitleFormat.setFont(new WritableFont(WritableFont
				.createFont("宋体"), 10, WritableFont.BOLD, false));
		cloumnTitleFormat.setAlignment(Alignment.CENTRE);
		// 创建WritableCellFormat对象，将该对象应用于单元格从而设置单元格的样式
		WritableCellFormat titleFormat = new WritableCellFormat();

		// 设置字体格式
		titleFormat.setFont(titleFont);
		titleFormat.setAlignment(Alignment.CENTRE);// 设置文本水平居中对齐
		titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置文本垂直居中对齐
		titleFormat.setBackground(Colour.GRAY_25);// 设置背景颜色
		titleFormat.setWrap(false);// 设置不自动换行

		// 用于正文居左
		WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
		wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
		wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
		wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
		wcf_left.setWrap(false); // 文字是否换行

		// 标题 行 把单元格（column, row）到单元格（column1, row1）进行合并。
		// mergeCells(column, row, column1, row1);
		sheet.mergeCells(0, 0, Title.length - 1, 0);// 单元格合并方法，Title.length-1为要合并的行数
		// 添加Label对象，参数依次表示在第一列，第一行，内容，使用的格式
		Label lab_00 = new Label(0, 0, fileName, titleFormat);
		// 将定义好的表 标题
		// Label对象添加到工作表上，这样工作表的第一列第一行的内容为‘fileName’并应用了titleFormat定义的样式
		sheet.addCell(lab_00);

		// 设置excel工作表 表头 并 写入到excel工作表
		for (int i = 0; i < Title.length; i++) {
			sheet.addCell(new Label(i, 1, Title[i], cloumnTitleFormat));
		}

		// 将内容写入到excel工作表
		/** ***************以下是EXCEL正文数据********************* */
		Field[] fields = null;
		int i = 2; // 从第二行开始写表格
		for (Object obj : listContent) { // 遍历集合
			fields = obj.getClass().getDeclaredFields(); // 反射获取集合中对象字段
			int j = 0; // 控制 行
			// for(Field variable : fields){ //遍历字段填充当前行的每一列
			for (int x = skip; x < fields.length; x++) { // 遍历字段填充当前行的每一列
				// 跳过skip个字段不输出skip
				Field variable = fields[x];
				variable.setAccessible(true); //
				Object va = null;
				try {
					va = variable.get(obj);
					// 获取字段的名字，如果是传入的时间字段，格式化时间在输出
					String name = variable.getName();
					for (int y = 0; y < dateFieldNames.length; y++) {
						if (name.equals(dateFieldNames[y])) {
							va = DateStringUtils.format((Date) variable
									.get(obj));
						}
					}

					if (va == null) {
						va = "";
					}

					sheet.addCell(new Label(j, i, va.toString(), wcf_left));
					j++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			i++;
		}
		// 将定义的工作表输出到之前指定的介质中（这里是客户端浏览器）
		wk.write();
		// 操作完成时，关闭对象，释放占用的内存空间
		wk.close();
	}

	/**
	 * Title 导出excel的表头 fileName 导出excel的文件名 List<T> listContent 要导出的excel数据来源
	 * needIndex 需要写入excel文件的字段的次序 tableName 要导出的表单名称
	 * 
	 * @author krai 调用：示例（要处理异常） String[] Title =
	 *         {"id","项目id","0个人/1班组","班组编号","班组名称","姓名","联系方式","性质","奖惩措施"};
	 *         List<RewardsAndPunishModel> leaderList =
	 *         rewardsAndPunishService.getRAPListByUserId(session,1);
	 *         ExportExcel.exportExcel(response,Title,"奖惩记录表",leaderList);
	 */
	public static <T> void recoredExportExcel(HttpServletResponse response,
			String tableName, String[] Title, String fileName, int needIndex[],
			List<T> listContent, String[] dateFieldName) throws IOException,
			RowsExceededException, WriteException {
		OutputStream output = response.getOutputStream();// 获取一个输出流
		response.reset();// 使用前清空response
		// 设定输出文件头
		response.setHeader("Content-disposition", "attachment; filename="
				+ new String(fileName.getBytes("utf-8"), "ISO8859-1") + ".xls");
		response.setContentType("application/msexcel");// 定义输出类型
		// 创建可写入的Excel工作薄，且内容将写入到输出流，并通过输出流输出给客户端浏览
		// 该代码表示将xxx.xls的Excel文件通过应答实体（response）输出给请求的客户端浏览器，下载到客户端本地（保存或直接打开）
		WritableWorkbook wk = Workbook.createWorkbook(output);

		// 若要直接输出到磁盘文件可采用下列代码替换加下划线这部分代码
		/*
		 * File file=new File("D://temp.xls"); WritableWorkbook wwb =
		 * Workbook.createWorkbook(file);
		 */

		// 创建可写入的Excel工作表
		WritableSheet sheet = wk.createSheet(fileName, 0);
		// 创建WritableFont 字体对象，参数依次表示黑体、字号12、粗体、非斜体、不带下划线、亮蓝色
		// 和其他几种字体
		WritableFont titleFont = new WritableFont(
				WritableFont.createFont("黑体"), 12, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, Colour.LIGHT_BLUE);
		WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 10);
		// WritableFont BoldFont = new WritableFont(WritableFont.ARIAL,
		// 10,WritableFont.BOLD);

		WritableCellFormat cloumnTitleFormat = new WritableCellFormat();
		cloumnTitleFormat.setFont(new WritableFont(WritableFont
				.createFont("宋体"), 10, WritableFont.BOLD, false));
		cloumnTitleFormat.setAlignment(Alignment.CENTRE);
		// 创建WritableCellFormat对象，将该对象应用于单元格从而设置单元格的样式
		WritableCellFormat titleFormat = new WritableCellFormat();

		// 设置字体格式
		titleFormat.setFont(titleFont);
		titleFormat.setAlignment(Alignment.CENTRE);// 设置文本水平居中对齐
		titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);// 设置文本垂直居中对齐
		titleFormat.setBackground(Colour.GRAY_25);// 设置背景颜色
		titleFormat.setWrap(false);// 设置不自动换行

		// 用于正文居左
		WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);
		wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条
		wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐
		wcf_left.setAlignment(Alignment.LEFT); // 文字水平对齐
		wcf_left.setWrap(false); // 文字是否换行

		// 标题 行 把单元格（column, row）到单元格（column1, row1）进行合并。
		// mergeCells(column, row, column1, row1);
		sheet.mergeCells(0, 0, Title.length - 1, 0);// 单元格合并方法，Title.length-1为要合并的行数
		// 添加Label对象，参数依次表示在第一列，第一行，内容，使用的格式
		Label lab_00 = new Label(0, 0, fileName, titleFormat);
		// 将定义好的表 标题
		// Label对象添加到工作表上，这样工作表的第一列第一行的内容为‘fileName’并应用了titleFormat定义的样式
		sheet.addCell(lab_00);

		// 设置excel工作表 表头 并 写入到excel工作表
		for (int i = 0; i < Title.length; i++) {
			sheet.addCell(new Label(i, 1, Title[i], cloumnTitleFormat));
		}

		// 将内容写入到excel工作表
		/** ***************以下是EXCEL正文数据********************* */
		Field[] fields = null;
		int i = 2; // 从第二行开始写表格
		int xuhao = 1;// 排列序号
		for (Object obj : listContent) { // 遍历集合
			fields = obj.getClass().getDeclaredFields(); // 反射获取集合中对象字段
			System.out.println();
			int j = 0; // 控制 行
			// for(Field variable : fields){ //遍历字段填充当前行的每一列
			for (int x:needIndex) { // 遍历字段填充当前行的每一列
				// 跳过skip个字段不输出skip
				Field variable = fields[0];
				if (x == 100) {
				} else {
					variable = fields[x];
				}
				variable.setAccessible(true); //
				Object va = null;
				try {
					va = variable.get(obj);
					// 获取字段的名字，如果是传入的时间字段，格式化时间在输出
					String name = variable.getName();
					for (int y = 0; y < dateFieldName.length; y++) {
						if (name.equals(dateFieldName[y])) {
							va = DateStringUtils.format((Date) variable
									.get(obj));
						}
					}
					if (va == null) {
						va = "";
					}
					// 在excel第一列加入序号
					if (x == 100) {
						sheet.addCell(new Label(j, i, String.valueOf(xuhao),
								wcf_left));
						xuhao = xuhao + 1;
						System.out.println("-----------------------------");
						System.out.println("xuhao:" + xuhao);
					}
					// 如果是导出的是工资表，将付款方式 支付方式：1-支付宝 ， 2-微信， 3-银行卡，4-现金 更改为对应的中文
					// 逻辑:1)
					else if ("payrollRecrd".equals(tableName) && x == 12) {
						String payTypeName = "tableName";
						switch (va.toString()) {
						case "1":
							payTypeName = "支付宝";
							break;
						case "2":
							payTypeName = "微信";
							break;
						case "3":
							payTypeName = "银行卡";
							break;
						case "4":
							payTypeName = "现金";
							break;
						}
						sheet.addCell(new Label(j, i, payTypeName, wcf_left));
					}
					// 如果是导出的是出入记录
					else if ("accRecord".equals(tableName) && x == 7) {
						String typeName = "";
						switch (va.toString()) {
						case "0":
							typeName = "进场";
							break;
						case "1":
							typeName = "退场";
							break;
						}
						sheet.addCell(new Label(j, i, typeName, wcf_left));
					}
					else if ("accRecord".equals(tableName) && x == 6){
						String confirm = "";
						switch (va.toString()) {
						case "1":
							confirm = "已确认";
							break;
						case "0":
							confirm = "未确认";
							break;
						}
						sheet.addCell(new Label(j, i, confirm, wcf_left));
					}
					// 如果是导出的是班组考勤记录表
					else if ("teamAttendenceRecordToExcel".equals(tableName)&& x>1) {
						String attenceBoolean = "";
						switch (va.toString()) {
						case "0":
							attenceBoolean = "✘";
							break;
						case "1":
							attenceBoolean = "✔";
							break;
						}
						sheet.addCell(new Label(j, i, attenceBoolean, wcf_left));
					}
					// 如果是导出的是【个人中心-班组考勤记录】表--zss
					else if (("AttendanceInfo".equals(tableName)&& x == 7)) {
						String confirm = "";
						switch (va.toString()) {
						case "1":
							confirm = "已确认";
							break;
						case "0":
							confirm = "未确认";
							break;
						}
						sheet.addCell(new Label(j, i, confirm, wcf_left));
					}
					// 如果是导出的是成员考勤记录表
					else if ("teamMemberAttendenceRecordToExcel".equals(tableName)&& x==6) {
						String attenceBoolean = va.toString().substring(0,10);
						sheet.addCell(new Label(j, i, attenceBoolean, wcf_left));
					} 
					else {
						sheet.addCell(new Label(j, i, va.toString(), wcf_left));
						System.out.println("次序："+x+"值"+ va.toString()); 	 	
					}
					j++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			i++;
		}
		// 将定义的工作表输出到之前指定的介质中（这里是客户端浏览器）
		wk.write();
		// 操作完成时，关闭对象，释放占用的内存空间
		wk.close();
	}

}
