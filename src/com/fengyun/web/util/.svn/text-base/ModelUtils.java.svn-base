package com.fengyun.web.util;

import java.util.Date;

import com.mongodb.BasicDBObject;

public class ModelUtils {

	public static String nullToString(String str){
		if(str == null)
			return "";
		return str;
	}
	
	/**
	 * 分数转星星
	 * @param score
	 * @return
	 */
	public static int score2star(int score){
//		0星：0分到29分；
//		1星：30分到44分；
//		2星：45分到59分；
//		3星：60分到74分；
//		4星：75分到89分；
//		5星：90分到100分；
		if(score <= 29){
			return 0;
		}else if(score >= 30 && score <= 44){
			return 1;
		}else if(score >= 45 && score <= 59){
			return 2;
		}else if(score >= 60 && score <= 74){
			return 3;
		}else if(score >= 75 && score <= 89){
			return 4;
		}else if(score >= 90){
			return 5;
		}else{
			return 0;
		}
	}
	
	/**
	 * 构造查询时间段条件
	 * 如果输入有误，默认查询最近一年的数据
	 * @param startDate 20160801
	 * @param endDate 20160831
	 * @param queryObj
	 */
	public static void queryDate(String startDateStr,String endDateStr,BasicDBObject queryObj){
		
		startDateStr = startDateStr + "000000";
		endDateStr = endDateStr + "235959";
		Date startDate = DateStringUtils.parseYMDS(startDateStr);
		Date endDate = DateStringUtils.parseYMDS(endDateStr);
		queryObj.put("startDate", new BasicDBObject("$gte",startDate));
		queryObj.put("endDate", new BasicDBObject("$lte",endDate));
		
	}
	
	public static void queryDate(String startDateStr,String endDateStr,BasicDBObject queryObj,String columName){
		startDateStr = startDateStr + "000000";
		endDateStr = endDateStr + "235959";
		Date startDate = DateStringUtils.parseYMDS(startDateStr);
		Date endDate = DateStringUtils.parseYMDS(endDateStr);
		BasicDBObject bo = new BasicDBObject("$gte",startDate);
		bo.append("$lte",endDate);
		//bo最终格式例： { "$gte" : { "$date" : "2016-08-15T16:00:00.000Z"} , "$lte" : { "$date" : "2016-10-16T15:59:59.000Z"}}
		queryObj.put(columName, bo);
	}
}
