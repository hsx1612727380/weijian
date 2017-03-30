package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;
import mmo.common.utils.DateStringUtils;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

/**
 * 项目工程下班组及供应商管理
 * 申请、邀请加入
 * @author mayu
 * 
 */

public class ProjectDepartmentModel implements BaseIdModel {

	private String id;
	private String vId;// 邀请的ID,对应班组、材料商、设备商自动生成的id（主键） 
	private String pId;// 项目ID
	private int status;// 状态--(0没有关系)-(1申请中)，(2邀请中) (3-已加入) (4-已结束或离开)
	private int type;// 班组类型：1-班组 2-材料 3-设备
	private Date createTime = new Date();
	private String createTimeStr;
	
	private String name; //班组名称(只限于班组，需要把vid关联的表把中的name获取到再set到这来，[因为班组有三个表])
	private int category; // 班组类别： 1本班组，2劳务班组，3专业班组
	private int contractPrice; // 合同价
	private int advanceCharge; // 预付款
	private int times; // 次数
	private int allWork; // 总工程量
	private int thsWork; // 本次工程量
	private int accWork; // 累计工程量
	private int progress; // 累计完成比例
	private int thsPay; // 本次付款
	private int accPay; // 累计付款
	private int alreadyPay; // 已付工资
	private int notYetPay; // 未付工资
	private int settlement; // 结算情况（结算（settlement）%）
	private String remark; // 备注
	private String imageName; // 附件图片名称
	
	private String label; // 标签
	private String securityClarificaiton; // 安全交底
	private String securityDate; // 安全交底上传时间
	private String qualityClarificaiton; // 质量交底
	private String qualityDate; // 质量交底上传时间

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(20);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("vId", this.vId);
		obj.put("pId", this.pId);
		obj.put("status", this.status);
		obj.put("type", this.type);
		obj.put("createTime", this.createTime);
		obj.put("name", this.name);
		obj.put("category", this.category);
		obj.put("contractPrice", this.contractPrice);
		obj.put("advanceCharge", this.advanceCharge);
		obj.put("times", this.times);
		obj.put("allWork", this.allWork);
		obj.put("thsWork", this.thsWork);
		obj.put("accWork", this.accWork);
		obj.put("progress", this.progress);
		obj.put("thsPay", this.thsPay);
		obj.put("accPay", this.accPay);
		obj.put("alreadyPay", this.alreadyPay);
		obj.put("notYetPay", this.notYetPay);
		obj.put("settlement", this.settlement);
		obj.put("remark", this.remark);
		obj.put("imageName", this.imageName);
		obj.put("label", this.label);
		obj.put("securityClarificaiton", this.securityClarificaiton);
		obj.put("securityDate", this.securityDate);
		obj.put("qualityClarificaiton", this.qualityClarificaiton);
		obj.put("qualityDate", this.qualityDate);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.vId = result.getString("vId");
		this.imageName = result.getString("imageName");
		this.pId = result.getString("pId");
		this.status = result.getInt("status",0);
		this.type = result.getInt("type",0);
		this.createTime = (Date) result.get("createTime");
		this.name = result.getString("name");
		this.category = result.getInt("category",0);
		this.contractPrice = result.getInt("contractPrice",0);
		this.advanceCharge = result.getInt("advanceCharge",0);
		this.times = result.getInt("times",0);
		this.allWork = result.getInt("allWork",0);
		this.thsWork = result.getInt("thsWork",0);
		this.accWork = result.getInt("accWork",0);
		this.progress = result.getInt("progress",0);
		this.thsPay = result.getInt("thsPay",0);
		this.accPay = result.getInt("accPay",0);
		this.alreadyPay = result.getInt("alreadyPay",0);
		this.notYetPay = result.getInt("notYetPay",0);
		this.settlement = result.getInt("settlement",0);
		this.remark = result.getString("remark");
		this.label = result.getString("label");
		this.securityClarificaiton = result.getString("securityClarificaiton");
		this.securityDate = result.getString("securityDate");
		this.qualityClarificaiton = result.getString("qualityClarificaiton");
		this.qualityDate = result.getString("qualityDate");
	}

	public String getCreateTimeStr() {
		return DateStringUtils.format(this.createTime);
	}
	
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
	public String getvId() {
		return vId;
	}

	public String getImageName()
	{
		return imageName;
	}

	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}

	public void setvId(String vId) {
		this.vId = vId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVId() {
		return vId;
	}

	public void setVId(String vId) {
		this.vId = vId;
	}

	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}

	public int getAdvanceCharge() {
		return advanceCharge;
	}

	public void setAdvanceCharge(int advanceCharge) {
		this.advanceCharge = advanceCharge;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getAllWork() {
		return allWork;
	}

	public void setAllWork(int allWork) {
		this.allWork = allWork;
	}

	public int getThsWork() {
		return thsWork;
	}

	public void setThsWork(int thsWork) {
		this.thsWork = thsWork;
	}

	public int getAccWork() {
		return accWork;
	}

	public void setAccWork(int accWork) {
		this.accWork = accWork;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getThsPay() {
		return thsPay;
	}

	public void setThsPay(int thsPay) {
		this.thsPay = thsPay;
	}

	public int getAccPay() {
		return accPay;
	}

	public void setAccPay(int accPay) {
		this.accPay = accPay;
	}

	public int getAlreadyPay() {
		return alreadyPay;
	}

	public void setAlreadyPay(int alreadyPay) {
		this.alreadyPay = alreadyPay;
	}

	public int getNotYetPay() {
		return notYetPay;
	}

	public void setNotYetPay(int notYetPay) {
		this.notYetPay = notYetPay;
	}

	public int getSettlement() {
		return settlement;
	}

	public void setSettlement(int settlement) {
		this.settlement = settlement;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getSecurityClarificaiton() {
		return securityClarificaiton;
	}

	public void setSecurityClarificaiton(String securityClarificaiton) {
		this.securityClarificaiton = securityClarificaiton;
	}

	public String getQualityClarificaiton() {
		return qualityClarificaiton;
	}

	public void setQualityClarificaiton(String qualityClarificaiton) {
		this.qualityClarificaiton = qualityClarificaiton;
	}

	public String getSecurityDate() {
		return securityDate;
	}

	public void setSecurityDate(String securityDate) {
		this.securityDate = securityDate;
	}

	public String getQualityDate() {
		return qualityDate;
	}

	public void setQualityDate(String qualityDate) {
		this.qualityDate = qualityDate;
	}
	
}
