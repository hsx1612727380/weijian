package com.fengyun.web.db.playermodel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

public class KeyPersonModel implements BaseIdModel {
	
	
	private String id;
	private String pCode;    //项目代号
	private String name;    //姓名
	private String cName;    //公司名称
	private String phone;    //电话
	private String role;      //项目中担任角色  
	//担任角色列举：
	//1.项目经理
	//2.工程协管员
	//3.首席建筑师
	//4.暖通工程师
	//5.机械工程师
	//6.电气工程师
	//7.质量评估或质量控制文档管理员
	//8.质量评估或质量控制经理
	//9.商务经理
	//10.施工经理
	//11.流程协调员
	//12.施工员
	//13.预算员
	//14.安全员
	//15.质检员
	//16.材料员
	
	
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(5);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("pCode", this.pCode);
		obj.put("name", this.name);
		obj.put("cName", this.cName);
		obj.put("phone", this.phone);
		obj.put("role", this.role);
		
		return obj;
	}
	
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.pCode = result.getString("pCode");
		this.name = result.getString("name");
		this.cName = result.getString("cName");
		this.phone = result.getString("phone");
		this.role = result.getString("role");
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	
	
	
	
	
}
