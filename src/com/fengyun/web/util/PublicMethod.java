package com.fengyun.web.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

/**
 * 公共方法
 */
public class PublicMethod {

	private static Log log = LogFactory.getLog(PublicMethod.class);

	/**
	 * 抛出一个异常
	 */
	public static void throwException(String message) {
		try {
			throw new Exception(message);
		} catch (Exception e) {
			log.error(message, e);
		}
	}

	/**
	 * 抛出一个错误
	 * 
	 * @param e
	 * @param message
	 */
	public static void throwError(Exception e, String message) {
		log.error(message, e);
	}

	/**
	 * 创建cdkey文件
	 * 
	 * @param fileName
	 *            文件名
	 * @param size
	 *            长度
	 * @param sps
	 *            分隔符位置
	 * @param num
	 *            成长多少个key
	 * @param print
	 *            是否打聊出key
	 */
	public static void createCDKeyFile(String fileName, String pre, int num, int keylen) {
		String content = createCDKey(fileName, pre, num, keylen);
		if (StringUtils.isNotBlank(content)) {
			try {
				FileUtils.saveString(fileName, content);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 创建CDKey
	 * 
	 * @param pre
	 *            前缀
	 * @param length
	 *            cdkey字符长度
	 * @param num
	 *            创建多少个
	 */
	private static String createCDKey(String fileName, String pre, int num, int keylen) {
		List<String> cdkeylist = FileUtils.loaderFile(fileName, true);
		if (cdkeylist == null)
			cdkeylist = new ArrayList<String>();

		String content = "";

		for (int i = cdkeylist.size(); i < num;) {
			String cdkey = pre + getRandomString(keylen);
			if (!cdkeylist.contains(cdkey)) {
				cdkeylist.add(cdkey);
				i++;
				content += cdkey + "\r\n";
			}
		}

		return content;
	}

	/**
	 * 
	 * @param length
	 *            cdkey长度
	 */
	private static String getRandomString(int keylen) { // length表示生成字符串的长度
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < keylen; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/** rkai 将对象转换成json字符串并返回给前台
	 *  @param object 所要转换的对象
	 * @param response
	 */
	public static void objectToJson(Object object,HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html;charset=UTF-8");
			Gson gson = new Gson();
			String jsonarray = gson.toJson(object);
			String json = jsonarray.toString();
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/** rkai 将字符串传回前台
	 *  * @param str 后台所要传回的字符串
	 * @param response
	 */
	public static void stringToWeb(String str,HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
