package com.fengyun.web.db.playermodel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/**
 * 项目花名册
 * 
 * @author wq
 * 
 */
public class ProjectRosterModel implements BaseIdModel {

	private String id;
	private String pId; // 项目id
	private String name; // 姓名
	private int sex; // 1.男 2.女
	private String phone; // 联系方式：电话
	private String position; // 职位
	private String identity; // 身份证
	private String address; // 地址
	/*private String province; // 省份
	private String city; // 城市
	private String street; // 街道
	 */
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(11);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("pId", this.pId);
		obj.put("name", this.name);
		obj.put("sex", this.sex);
		obj.put("phone", this.phone);
		obj.put("position", this.position);
		obj.put("identity", this.identity);
		obj.put("address", this.address);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.pId = result.getString("pId");
		this.name = result.getString("name");
		this.sex = result.getInt("sex", 0);
		this.phone = result.getString("phone");
		this.position = result.getString("position");
		this.identity = result.getString("identity");
		this.address = result.getString("address");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
