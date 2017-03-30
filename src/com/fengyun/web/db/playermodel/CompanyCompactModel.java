package com.fengyun.web.db.playermodel;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

/**
 * 公司合同
 * @author hsx
 *
 */
public class CompanyCompactModel implements BaseIdModel {

	private String id;
	private String code; // 公司的code
	private String projectName; // 工程名称
	private String buildUnit; // 建设单位
	private String achieveWorkDate; // 竣工日期
	private double compactPrice; // 合同金额
	private int isTender; // 是否有中标书：0-无，1-有
	private int isCompact; // 是否有合同书：0-无，1-有
	private int isAchieveReport; // 是否有骏工报告：0-无，1-有
	private String startWorkDate; // 开工日期
	private String leaderName; // 项目经理
	private String attachment;	// 附件
	private String executiveInfo; // 执行情况
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(13);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("code", this.code);
		obj.put("projectName", this.projectName);
		obj.put("buildUnit", this.buildUnit);
		obj.put("achieveWorkDate", this.achieveWorkDate);
		obj.put("compactPrice", this.compactPrice);
		obj.put("isTender", this.isTender);
		obj.put("isCompact", this.isCompact);
		obj.put("isAchieveReport", this.isAchieveReport);
		obj.put("startWorkDate", this.startWorkDate);
		obj.put("leaderName", this.leaderName);
		obj.put("attachment", this.attachment);
		obj.put("executiveInfo", this.executiveInfo);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.code = result.getString("code");
		this.projectName = result.getString("projectName");
		this.buildUnit = result.getString("buildUnit");
		this.achieveWorkDate = result.getString("achieveWorkDate");
		this.compactPrice = result.getDouble("compactPrice");
		this.isTender = result.getInt("isTender");
		this.isCompact = result.getInt("isCompact");
		this.isAchieveReport = result.getInt("isAchieveReport");
		this.startWorkDate = result.getString("startWorkDate");
		this.leaderName = result.getString("leaderName");
		this.attachment = result.getString("attachment");
		this.executiveInfo = result.getString("executiveInfo");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBuildUnit() {
		return buildUnit;
	}

	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}

	public String getAchieveWorkDate() {
		return achieveWorkDate;
	}

	public void setAchieveWorkDate(String achieveWorkDate) {
		this.achieveWorkDate = achieveWorkDate;
	}

	public double getCompactPrice() {
		return compactPrice;
	}

	public void setCompactPrice(double compactPrice) {
		this.compactPrice = compactPrice;
	}

	public int getIsTender() {
		return isTender;
	}

	public void setIsTender(int isTender) {
		this.isTender = isTender;
	}

	public int getIsCompact() {
		return isCompact;
	}

	public void setIsCompact(int isCompact) {
		this.isCompact = isCompact;
	}

	public int getIsAchieveReport() {
		return isAchieveReport;
	}

	public void setIsAchieveReport(int isAchieveReport) {
		this.isAchieveReport = isAchieveReport;
	}

	public String getStartWorkDate() {
		return startWorkDate;
	}

	public void setStartWorkDate(String startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getExecutiveInfo() {
		return executiveInfo;
	}

	public void setExecutiveInfo(String executiveInfo) {
		this.executiveInfo = executiveInfo;
	}
	
}
