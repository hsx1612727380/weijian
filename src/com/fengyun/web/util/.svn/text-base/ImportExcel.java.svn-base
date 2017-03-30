package com.fengyun.web.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

public class ImportExcel {

	public static String createDateExcel(String filePath, ServletConfig config, HttpServletRequest request, HttpServletResponse response) {
		SmartUpload smartUpload = new SmartUpload();
		try {
			smartUpload.initialize(config, request, response);
			smartUpload.upload();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Files files = smartUpload.getFiles();
		File file = files.getFile(0);
		String fileExt = file.getFileExt();
		String[] arr = {"xls"};
	    boolean flag2 = Arrays.asList(arr).contains(fileExt);
		if (!flag2) {
			String erroStr = "请上传xls的EXCEL文件";
	    	PublicMethod.stringToWeb(erroStr, response);
		}
		java.io.File filemk = new java.io.File(filePath);  
        if (!filemk.exists() && !filemk.isDirectory()) {  
        	filemk.mkdirs();
        }  
		Date dateCurrentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("YYMMddHHmmss");
		String currentTime = formatter.format(dateCurrentTime); 
		String fileName = currentTime + "." + fileExt;
		try {
			file.saveAs(filePath + "\\" + fileName, file.SAVEAS_AUTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
}
