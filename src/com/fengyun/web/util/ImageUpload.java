package com.fengyun.web.util;

import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fengyun.web.common.Config;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

public class ImageUpload {

	@SuppressWarnings("static-access")
	public void imageUpload(File file, String fileName, String filePath,
			ServletConfig config, HttpServletRequest request,
			HttpServletResponse response) {
		SmartUpload mySmartUpload = new SmartUpload();
		try {
			mySmartUpload.initialize(config, request, response);
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		System.out.println(file.getSize() / 1000 + "kb");
		String fileExt = file.getFileExt();
		String str = "jpg,JPG,jpeg,JPEG,bmp,BMP,png,PNG";
		String[] arr = str.split(",");
		boolean flag = Arrays.asList(arr).contains(fileExt);
		if (!flag) {
			String erroStr = "请上传jpg、jpeg、png、bmp图片格式图片";
			PublicMethod.stringToWeb(erroStr, response);
		}
		int fileSize = file.getSize() / 1024;
		if (fileSize > 3000) {
			String erroStr = "请上传存储容量小于3M的图片";
			PublicMethod.stringToWeb(erroStr, response);
		}
		java.io.File filemk = new java.io.File(filePath);
		System.out.println("filePath:" + filePath);
		if (!filemk.exists()) {
			filemk.mkdirs();
		}
		try {
			String reg = "\\";
			if(Config.getInstance().getMyServerId().equals("linux")){
				reg = "/";
			}
			file.saveAs(filePath + reg + fileName, file.SAVEAS_PHYSICAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
