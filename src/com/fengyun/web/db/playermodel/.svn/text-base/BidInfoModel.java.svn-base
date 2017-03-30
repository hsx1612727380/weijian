package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;
import mmo.common.utils.DateStringUtils;

/**
 * 招标信息
 * @author 13794
 *
 */
public class BidInfoModel implements BaseIdModel {
	
	private String id;
	private String title;    //招标信息标题
	private String URL;    //招标信息地址链接
	private int bidtype;    //招标信息类型   1-招投标  ，2-行业动态
	private String year; 
	private String month;
	private String day;
	private Date createTime = new Date();// 创建时间
	private String createTimeStr;

	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("title", this.title);
		obj.put("URL", this.URL);
		obj.put("bidtype", this.bidtype);
		obj.put("year", this.year);
		obj.put("month", this.month);
		obj.put("day", this.day);
		obj.put("createTime", this.createTime);
		return obj;
	}
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.title = result.getString("title");
		this.URL = result.getString("URL");
		this.bidtype = result.getInt("bidtype", 0);
		this.year = result.getString("year");
		this.month = result.getString("month");
		this.day = result.getString("day");
		this.createTime = (Date)result.get("createTime");
				
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public int getBidtype() {
		return bidtype;
	}

	public void setBidtype(int bidtype) {
		this.bidtype = bidtype;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
	public String getCreateTimeStr() {
		return DateStringUtils.format(this.createTime);
	}
	
	

}
