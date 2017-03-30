package com.fengyun.web.db.playermodel;

/**
 * @author zhengss
 * 项目操作员--合同管理
 * 2017-01-20
 */
import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

public class OperateCompactModel  implements BaseIdModel {
	private String id;
	private String pId;			//工程id
	private String company;		//建设单位
	private String projectName;	//工程名称
	private String compactName;	//合同名称
	private String compactType;	//合同类别   1-材料合同 2-用工合同 3-设备租赁合同 4-设备采购合同
	private String compactBrief;//合同概要
	private String compactNum;	//合同编号
	private String supplier;	//供应商名称
	private double amount;		//总金额
	private String attachment;	//附件
	private Date signDate;		//签订日期
	private String excute;			//执行情况
	private String remark;			//备注
	private String invoice;			//发票
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(12);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("pId", this.pId);
		obj.put("company", this.company);
		obj.put("projectName", this.projectName);
		obj.put("compactName", this.compactName);
		obj.put("compactType", this.compactType);
		obj.put("compactBrief", this.compactBrief);
		obj.put("compactNum", this.compactNum);
		obj.put("supplier", this.supplier);
		obj.put("amount", this.amount);
		obj.put("attachment", this.attachment);
		obj.put("signDate", this.signDate);
		obj.put("excute", this.excute);
		obj.put("remark", this.remark);
		obj.put("invoice", this.invoice);
		return obj;
	}


	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.pId = result.getString("pId");
		this.company = result.getString("company");
		this.projectName = result.getString("projectName");
		this.compactName = result.getString("compactName");
		this.compactType = result.getString("compactType");
		this.compactBrief = result.getString("compactBrief");
		this.compactNum = result.getString("compactNum");
		this.supplier = result.getString("supplier");
		this.amount = result.getDouble("amount");
		this.attachment = result.getString("attachment");
		this.signDate = (Date) result.get("signDate");
		this.excute = result.getString("excute");
		this.remark = result.getString("remark");
		this.invoice = result.getString("invoice");
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public void setId(String id) {
		this.id = id;
	}


	public String getpId() {
		return pId;
	}


	public void setpId(String pId) {
		this.pId = pId;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getCompactName() {
		return compactName;
	}


	public void setCompactName(String compactName) {
		this.compactName = compactName;
	}


	public String getCompactType() {
		return compactType;
	}


	public void setCompactType(String compactType) {
		this.compactType = compactType;
	}


	public String getCompactBrief() {
		return compactBrief;
	}


	public void setCompactBrief(String compactBrief) {
		this.compactBrief = compactBrief;
	}


	public String getCompactNum() {
		return compactNum;
	}


	public void setCompactNum(String compactNum) {
		this.compactNum = compactNum;
	}


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getAttachment() {
		return attachment;
	}


	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}


	public Date getSignDate() {
		return signDate;
	}


	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}


	public String getExcute() {
		return excute;
	}


	public void setExcute(String excute) {
		this.excute = excute;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getInvoice() {
		return invoice;
	}


	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	
	
}
