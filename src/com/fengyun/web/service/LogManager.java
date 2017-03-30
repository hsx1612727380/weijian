package com.fengyun.web.service;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

import mmo.common.utils.DateStringUtils;
import mmo.common.utils.StringUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 日志类
 * 
 */
public class LogManager {

	private final static Log loginLog = LogFactory.getLog("player.login");
	

	private final static int REG = 1; // 新注册
	private final static int NO_REG = 0; // 不是新注册
	private final static int LOGIN_SUCCESS = 1; // 登陆成功
	private final static int LOGIN_FAIL = 0; // 登陆失败

	

	/**
	 * 登录日志
	 */
	public static void loginLog(Date loginTime, String gameId, String playerId, String playerName, String loginIp,
			boolean isReg, boolean state, String source, String version) {
		StringBuilder sb = new StringBuilder();
		sb.append(gameId).append(StringUtil.SPLIT);
		sb.append(playerId).append(StringUtil.SPLIT);
		sb.append(playerName).append(StringUtil.SPLIT);
		sb.append(loginIp).append(StringUtil.SPLIT);
		sb.append(isReg ? REG : NO_REG).append(StringUtil.SPLIT);
		sb.append(state ? LOGIN_SUCCESS : LOGIN_FAIL).append(StringUtil.SPLIT);
		sb.append(source).append(StringUtil.SPLIT);
		sb.append(DateStringUtils.format(loginTime)).append(StringUtil.SPLIT);
		sb.append(version);
		loginLog.info(sb.toString());
	}

	public static void writeCommonLog(String str, String filePath) {
		PrintWriter log_file;
		try {
			int lastindex = filePath.lastIndexOf("/");
			String path = filePath;
			if (lastindex >= 0)
				path = filePath.substring(0, lastindex);
			if (mkDir(path)) {
				log_file = new PrintWriter(new FileWriter(filePath, true), true);
				log_file.println(DateStringUtils.formatYMDSS(new Date()) + "|" + str);
				log_file.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建一个目录
	 */
	private static boolean mkDir(String DirectoryName) {
		boolean bRet = false;
		java.io.File file = new java.io.File(DirectoryName);
		if (file.exists()) {
			bRet = true;
		} else {
			bRet = file.mkdirs();
		}
		return bRet;
	}
}
