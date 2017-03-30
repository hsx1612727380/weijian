package com.fengyun.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mmo.common.utils.KeyWordsUtils.TariffMapComparator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fengyun.web.common.Config;

public class UserIdLimitUtils {

	private static final Log log = LogFactory.getLog(UserIdLimitUtils.class);

	public static final String KEYWORDS_FILE = "/userid.txt";

	private static List<String> userIds;

	private static boolean isAuthIdLimit = Config.getInstance().isAuthIdLimit();

	public static void init() {
		userIds = new ArrayList<String>();

		String filePath = Config.getInstance().getRootPath() + KEYWORDS_FILE;

		BufferedReader in = null;
		// 载入关键字列表
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)),
					Charset.forName("UTF-8")));

			String useId;
			while ((useId = in.readLine()) != null) {
				if (!useId.trim().equals("") && !useId.startsWith("#")) {
					if (!userIds.contains(useId))
						userIds.add(useId);
				}
			}
			Collections.sort(userIds, new TariffMapComparator());
		} catch (final Exception ex) {
			log.error("文件不存在：" + filePath, ex);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (final IOException ex) {
				log.error("关闭文件错误", ex);
			}
		}
	}

	public static boolean beLimited(String userId) {
		if (isAuthIdLimit) {
			if (userIds == null || userId.length() == 0) {
				return false;
			}

			return !userIds.contains(userId);
		}

		return false;
	}

	public static void addUserId(String userId) {
		if (userIds == null) {
			userIds = new ArrayList<String>();
		}

		if (userIds.contains(userId)) {
			return;
		}

		userIds.add(userId);

		String filePath = Config.getInstance().getRootPath() + KEYWORDS_FILE;
		try {
			String content = FileUtils.readFile(filePath, null);
			content += "\n" + userId;
			FileUtils.saveString(filePath, content);
		} catch (Exception e) {
			log.error("文件处理错误", e);
		}
	}

	public static void setUserLimit(boolean isAuthIdLimit) {
		Config.getInstance().setAuthIdLimit(isAuthIdLimit);
		UserIdLimitUtils.isAuthIdLimit = isAuthIdLimit;
	}
}
