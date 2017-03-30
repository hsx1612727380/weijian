package com.fengyun.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fengyun.web.common.Config;

/**
 * 禁止包含的词组工具类（静态方法类）
 * @author Charlie
 *
 */
public class ForbidWordsUtils {
	private static final Log log = LogFactory.getLog(ForbidWordsUtils.class);

	private static final List<String> keywords = new ArrayList<String>();

	public static final String KEYWORDS_FILE = "forbidwords.txt";
	
	public static void init() {
		BufferedReader in = null;
		// 载入关键字列表
		try {
			String filePath = Config.getInstance().getRootPath() + KEYWORDS_FILE;
			in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)),
					Charset.forName("UTF-8")));

			String keyword;
			while ((keyword = in.readLine()) != null) {
				if (!keyword.trim().equals("") && !keyword.startsWith("#")) {
					if (!keywords.contains(keyword))
						keywords.add(keyword);
					if (!keywords.contains(keyword.toLowerCase()))
						keywords.add(keyword.toLowerCase());
					if (!keywords.contains(keyword.toUpperCase()))
						keywords.add(keyword.toUpperCase());
				}
			}
			Collections.sort(keywords, new TariffMapComparator());
		} catch (final Exception ex) {
			log.error("classpath:/forbidwords.txt not exists", ex);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (final IOException ex) {
				log.error(ex, ex);
			}
		}
	}

	/**
	 * 获得关键字列表
	 * 
	 * @return
	 */
	public static List<String> getKeywords() {
		return keywords;
	}

	/**
	 * 检查是否包含不允许的关键字
	 * 
	 * @param content
	 * @return 包含的禁语，没有的话返回null
	 */
	public static boolean containsKeyword(final String content) {
		String lowContent = content.toLowerCase();
		for (String keyword : keywords) {
			if (lowContent.contains(keyword.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private static String repeatString(String str, int num) {
		StringBuffer sb = new StringBuffer(0);
		for (int i = 0; i < num; i++) {
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * 检查是否包含不允许的关键字
	 * 
	 * @param content
	 * @throws KeyWordsException
	 */
	public static String replaceKeyword(final String content) {
		String result = content;
		for (final String keyword : keywords) {
			if (result.contains(keyword))
				result = result.replace(keyword, repeatString("*", keyword.length()));
		}
		if (!result.equals(content)) {
			log.error("user say:" + content + "  被系统屏蔽为:" + result);
		}
		return result;
	}

	/**
	 * 重新初始化
	 */
	public static void reset() {
		keywords.clear();
		init();
	}

	public static void main(String[] args) {
		// URL url =
		// KeyWordsUtils.class.getResource(KeyWordsUtils.KEYWORDS_FILE);
		// File file = new File(url.getFile());
		// System.out.println(file);
		init();
		String aa = "卖qq阿大使的歪";
		System.out.println(keywords.size() + ",,," + keywords.contains(aa));
		aa = replaceKeyword(aa);
		System.out.println("result=");
		System.out.println(aa);
		/*
		 * System.out.println(checkKeyword("")); for (String s : keywords) {
		 * System.out.println(s); } System.out.print(checkKeyword(""));
		 */
	}

	public static class TariffMapComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o2.length() - o1.length();
		}
	}
	
}
