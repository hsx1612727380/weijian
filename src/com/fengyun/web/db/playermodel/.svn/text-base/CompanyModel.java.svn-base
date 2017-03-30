package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.Area;
import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;


public class CompanyModel implements BaseIdModel {

	private String id;
	private String code;// 公司代码
	private String name;// 公司名称
	private String password = "123456";// 公司名称
	private String leaderName;// 联系人
	private String userId;// 联系人手机号
	private String province;// 省份
	private String city;// 城市
	private String provinceChn;// 省份中文名
	private String cityChn;// 城市
	private String street;// 地址街道
	private Date createTime = new Date();//
	private int status; // 申请审核状态：0 ：未申请审核、1：审核中、2、审核通过
	private String organization;// 统一社会信用代码，为18位
	private String type;// 公司类型 :建筑公司、劳务公司,设计公司,监理公司,其他
	private Date lastLogin = new Date(); // 最后一次登录时间
	private int loginTimes = 0; // 登录次数
	//
	private String regType;// 注册类型
	private String regMoney;// 注册资金
	private String tel; //联系方式，可以是[座机]或[手机号]或者[座机/手机号]
	

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(10);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("name", this.name);
		obj.put("code", this.code);
		obj.put("userId", this.userId);
		obj.put("leaderName", this.leaderName);
		obj.put("province", this.province);
		obj.put("city", this.city);
		obj.put("street", this.street);
		obj.put("createTime", this.createTime);
		obj.put("password", this.password);
		obj.put("status", this.status);
		obj.put("organization", this.organization);
		obj.put("type", this.type);
		obj.put("lastLogin", this.lastLogin);
		obj.put("loginTimes", this.loginTimes);
		obj.put("regType", this.regType);
		obj.put("regMoney", this.regMoney);
		obj.put("tel", this.tel);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.name = result.getString("name");
		this.code = result.getString("code");
		this.userId = result.getString("userId");
		this.leaderName = result.getString("leaderName");
		this.password = result.getString("password");
		this.province = result.getString("province");
		this.city = result.getString("city");
		this.provinceChn = Area.getNameByCode(this.province);
		this.cityChn = Area.getNameByCode(this.city);
		this.street = result.getString("street");
		this.createTime = (Date) result.get("createTime");
		this.status = result.getInt("status");
		this.organization = result.getString("organization");
		this.type = result.getString("type");
		this.lastLogin = (Date) result.get("lastLogin");
		this.loginTimes = result.getInt("loginTimes", 0);
		this.regType = result.getString("regType");
		this.regMoney = result.getString("regMoney");
		this.tel = result.getString("tel");
	}

	public String getCreateTimeMD() {
		if(this.createTime != null)
			return DateStringUtils.formatMD(this.createTime);
		return "";
	}
	
	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	public String getRegMoney() {
		return regMoney;
	}

	public void setRegMoney(String regMoney) {
		this.regMoney = regMoney;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvinceChn() {
		return provinceChn;
	}

	public void setProvinceChn(String provinceChn) {
		this.provinceChn = provinceChn;
	}

	public String getCityChn() {
		return cityChn;
	}

	public void setCityChn(String cityChn) {
		this.cityChn = cityChn;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(int loginTimes) {
		this.loginTimes = loginTimes;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	
}
