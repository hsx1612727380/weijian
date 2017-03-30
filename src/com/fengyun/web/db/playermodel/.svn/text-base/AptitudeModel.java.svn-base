package com.fengyun.web.db.playermodel;



import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.EAdtype;
import com.fengyun.web.hardcode.EAdlevel;
import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;


/**
 * 公司资质与资信
 */
public class AptitudeModel implements BaseIdModel {
	
	private String id;
	private String code;     //公司编号
	//private String cName;       //公司名称
	private String certificate;     //证书编号
	private int adtype;       //资质资信类别
	private String adtypeName;    //资质资信类别名称
	private int adlevel;       //资质资信等级
	private String adlevelName;    //资质等级名称
	private String approval;      //审批机关
	private String approvalTime;     //资质最新批准日期
	private String validity;        //资质有效期
	
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("code", this.code);
		obj.put("certificate", this.certificate);
		obj.put("adtype", this.adtype);
		obj.put("adlevel", this.adlevel);
		obj.put("approval", this.approval);
		obj.put("approvalTime", this.approvalTime);
		obj.put("validity", this.validity);
		
		return obj;
	}
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.code = result.getString("code");
		this.certificate = result.getString("certificate");
		this.adtype = result.getInt("adtype", 0);
		this.adtypeName = EAdtype.getadtypeName(this.adtype);
		this.adlevel = result.getInt("adlevel", 0);
		this.adlevelName = EAdlevel.getadlevelName(this.adlevel);
		this.approval = result.getString("approval");
		this.approvalTime = result.getString("approvalTime");
		this.validity = result.getString("validity");
		
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

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	

	public int getAdtype() {
		return adtype;
	}

	public void setAdtype(int adtype) {
		this.adtype = adtype;
	}

	public String getAdtypeName() {
		return adtypeName;
	}

	public void setAdtypeName(String adtypeName) {
		this.adtypeName = adtypeName;
	}

	public int getAdlevel() {
		return adlevel;
	}

	public void setAdlevel(int adlevel) {
		this.adlevel = adlevel;
	}

	public String getAdlevelName() {
		return adlevelName;
	}

	public void setAdlevelName(String adlevelName) {
		this.adlevelName = adlevelName;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	

	

}
