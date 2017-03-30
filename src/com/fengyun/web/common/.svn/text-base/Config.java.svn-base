package com.fengyun.web.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import mmo.common.utils.DateStringUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Config {
	private final static String CONFIG_PATH = "config.properties"; // 常规配置文件，一般是本机配置

	private static Log log = LogFactory.getLog(Config.class);

	private String host;// 本服务器IP
	private int[] ports = new int[] { 8081 }; // 端口,默认8081
	private List<String> rmiips = new ArrayList<String>();// 允许远程调用的ip列表
	private boolean debug = false; // 调试模式，默认不调试
	private String userdatapath = "";// 冷数据目录
	private String packagepath = "";
	private boolean iflogpackage = false;// 是否抓取信息包，默认不抓取
	private String myServerId = ""; // 本机的ServerId
	private String mySeqId = ""; // 本机的区号
	private int zoneCount = 1; // 分线数量
	private boolean pressureDebug = false;
	private String rootPath;
	private int worldPlayerSize; // 单服人数限制
	private boolean authIdLimit = false; // 限号登录
	private Date openTime;// 正式开服时间
	private String fromSite;// 合作方
	private boolean buySwitch = false;// 购买开关
	private boolean giftSwitch = false;// 礼包开关
	private boolean sdkSwitch = false;// 移动开关
	private String adminAccountName; // 超级管理员账号
	private String adminPassword; // 超级管理员密码
	private String adminName; // 超级管理员姓名
	private String adminMobile; // 超级管理员电话
	private String adminPopedom; // 超级管理员权限

	private String VISITADDRESS = "http://localhost:8080/image";
	private String BASEPATH = "D:\\image";
	private String PERSONITENDITYBASEPATH;
	private String MATERIALPROJECTPATH;
	private String EQUIPMENTPROJECTPATH;
	private String SARYPATH;
	private String COMPANYCOMPACTPATH;
	private String TMESECURITYCLARIFICAITON;
	private String TMEQUALITYCLARIFICAITON;
	private String OPERATECOMPACT;
	private String TEAMPROJECT;

	private static final Config instance = new Config();

	private Config() {
		rootPath = Config.class.getClassLoader().getResource("").getPath();
	}

	public void init(String rootPath) {
		if (StringUtils.isNotBlank(rootPath)) {
			this.rootPath = rootPath;
		}
		initServerConfig();
	}

	/**
	 * 获取一个本进程内的单例Config对象
	 * 
	 * @return
	 */
	public static Config getInstance() {
		return instance;
	}

	private void initServerConfig() {
		Properties props = getProp(CONFIG_PATH);

		this.host = props.getProperty("default.host");
		String strPorts = props.getProperty("default.ports");
		String[] arrPorts = StringUtils.split(strPorts, ",");
		ports = new int[arrPorts.length];
		for (int i = 0; i < arrPorts.length; i++) {
			ports[i] = Integer.valueOf(arrPorts[i]);
		}

		String[] iplist = props.getProperty("rmi.ips").split(",");
		for (String ip : iplist) {
			if (!rmiips.contains(ip))
				rmiips.add(ip);
		}

		this.myServerId = props.getProperty("server.id");
		this.mySeqId = props.getProperty("server.seqId");
		try {
			this.zoneCount = Integer.parseInt(props.getProperty("zone.count"));
		} catch (Exception e) {
			zoneCount = 1;
		}

		String strOpenTime = props.getProperty("openTime");
		if (StringUtils.isNotEmpty(strOpenTime)) {
			this.openTime = DateStringUtils.parseYMD(strOpenTime);
		} else {
			log.error("没有设置开服时间，如正式开服需手动修改config.properties文件!!!");
		}
		adminAccountName = props.getProperty("adminaccountname");
		adminPassword = props.getProperty("adminpassword");
		adminName = props.getProperty("adminname");
		adminMobile = props.getProperty("adminmobile");
		adminPopedom = props.getProperty("adminpopedom");

		VISITADDRESS = props.getProperty("VISITADDRESS");
		BASEPATH = props.getProperty("BASEPATH");
		PERSONITENDITYBASEPATH=props.getProperty("PERSONITENDITYBASEPATH");
		MATERIALPROJECTPATH=props.getProperty("MATERIALPROJECTPATH");
		EQUIPMENTPROJECTPATH=props.getProperty("EQUIPMENTPROJECTPATH");
		SARYPATH=props.getProperty("SARYPATH");
		COMPANYCOMPACTPATH=props.getProperty("COMPANYCOMPACTPATH");
		TMESECURITYCLARIFICAITON=props.getProperty("TMESECURITYCLARIFICAITON");
		TMEQUALITYCLARIFICAITON=props.getProperty("TMEQUALITYCLARIFICAITON");
		OPERATECOMPACT=props.getProperty("OPERATECOMPACT");
		TEAMPROJECT = props.getProperty("TEAMPROJECT");
		props.clear();
	}

	public boolean isIflogpackage() {
		return iflogpackage;
	}

	public void setIflogpackage(boolean iflog) {
		this.iflogpackage = iflog;
	}

	public String getPackagepath() {
		return packagepath;
	}

	public String getMyServerId() {
		return myServerId;
	}

	public int[] getPorts() {
		return ports;
	}

	public boolean isPressureDebug() {
		return pressureDebug;
	}

	public String getHost() {
		return host;
	}

	public List<String> getRmiips() {
		return rmiips;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public Properties getProp(String path) {
		Properties props = new Properties();
		FileInputStream fin = null;
		String configPath = rootPath + path;
		try {
			fin = new FileInputStream(new File(configPath));
			props.load(fin);
		} catch (Exception e) {
			log.error("配置文件读取出错：" + configPath, e);
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					log.error("配置文件读取出错：" + configPath, e);
				}
			}
		}

		return props;
	}

	public String getUserdatapath() {
		return userdatapath;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public int getZoneCount() {
		return zoneCount;
	}

	public void addZoneCount(int zoneCount) {
		this.zoneCount += zoneCount;
	}

	public int getWorldPlayerSize() {
		return worldPlayerSize;
	}

	public void setWorldPlayerSize(int worldPlayerSize) {
		this.worldPlayerSize = worldPlayerSize;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public String getFromSite() {
		return fromSite;
	}

	public boolean isAuthIdLimit() {
		return authIdLimit;
	}

	public void setAuthIdLimit(boolean authIdLimit) {
		this.authIdLimit = authIdLimit;
	}

	public String getMySeqId() {
		return mySeqId;
	}

	public boolean isBuySwitch() {
		return buySwitch;
	}

	public boolean isGiftSwitch() {
		return giftSwitch;
	}

	public boolean isSdkSwitch() {
		return sdkSwitch;
	}

	public String getAdminAccountName() {
		return adminAccountName;
	}

	public void setAdminAccountName(String adminAccountName) {
		this.adminAccountName = adminAccountName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminPopedom() {
		return adminPopedom;
	}

	public void setAdminPopedom(String adminPopedom) {
		this.adminPopedom = adminPopedom;
	}

	public String getVISITADDRESS() {
		return VISITADDRESS;
	}

	public String getBASEPATH() {
		return BASEPATH;
	}

	public String getPERSONITENDITYBASEPATH() {
		return PERSONITENDITYBASEPATH;
	}

	public String getMATERIALPROJECTPATH() {
		return MATERIALPROJECTPATH;
	}

	public String getEQUIPMENTPROJECTPATH() {
		return EQUIPMENTPROJECTPATH;
	}

	public String getSARYPATH() {
		return SARYPATH;
	}

	public String getCOMPANYCOMPACTPATH() {
		return COMPANYCOMPACTPATH;
	}

	public String getTMESECURITYCLARIFICAITON() {
		return TMESECURITYCLARIFICAITON;
	}

	public String getTMEQUALITYCLARIFICAITON() {
		return TMEQUALITYCLARIFICAITON;
	}

	public String getOPERATECOMPACT() {
		return OPERATECOMPACT;
	}

	public String getTEAMPROJECT() {
		return TEAMPROJECT;
	}

	
}
