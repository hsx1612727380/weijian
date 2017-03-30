package com.fengyun.web.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringUtils {
//	public static final String DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";
//	public static final String DATE_FORMATE_YMD = "yyyy-MM-dd";
//	public static final String DATE_FORMATE_YMDSS = "yyyyMMddHHmmssSSS";
//	public static final String DATE_FORMATE_YMDS = "yyyyMMddHHmmss";
//	public static final String DATE_FORMATE_HM = "HH:mm";
	//
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DateFormat df_ymd = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat df_md = new SimpleDateFormat("MM-dd");
	private static final DateFormat df_ymdss = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static final DateFormat df_ymds = new SimpleDateFormat("yyyyMMddHHmmss");
	private static final DateFormat df_hm = new SimpleDateFormat("HH:mm");
	private static final DateFormat df_hms = new SimpleDateFormat("HH:mm:ss");
	

	public static String format(Date date) {
		return df.format(date);
	}

	public static String formatYMD(Date date) {
		return df_ymd.format(date);
	}
	
	public static String formatMD(Date date) {
		return df_md.format(date);
	}

	public static String formatYMDSS(Date date) {
		return df_ymdss.format(date);
	}
	
	public static String formatYMDS(Date date) {
		return df_ymds.format(date);
	}

	public static String formatHM(Date date) {
		return df_hm.format(date);
	}
	
	public static String formatHMS(Date date) {
		return df_hms.format(date);
	}

	public static Date parseYMD(String str) {
		try {
			return df_ymd.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return null;
	}

	public static Date parseYMDS(String str) {
		try {
			return df_ymds.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return null;
	}

	public static Date parse(String str) {
		try {
			return df.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
		}
		return null;
	}

}
