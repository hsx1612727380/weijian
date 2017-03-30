package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.Area;
import com.fengyun.web.hardcode.ETeamSkillBigType;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.mongodb.BasicDBObject;

/**
 * 个人/班组诚信档案
 * 
 * @author 13794
 * 
 */

public class PersonModel implements BaseIdModel {

	private String id;
	private String userId; // 用户id或班组ID
	private int type = 0; // 0-个人 1-班组
	private String name; // 姓名
	private String gender; // 性别  1-男 2-女
	private String national; // 民族
	private String education; // 文化程度
	private String birth; // 出生日期
	private String age; // 年龄
	private String height; // 身高
	private String weight; // 体重
	private String identity; // 身份证
	private String health; // 身体状况
	private String marriage; // 婚姻
	private String skillBigType; // 技能大类型
	private String skillSmallType; // 技能小类型
	private String province;// 省份
	private String city;// 城市
	private String jobstatus; // 求职/用工状态 1：正在找工作 ；2：在岗；3：在岗，寻求更好的工作
	private String integrity; // 诚信度
	private String bankcard; // 银行卡
	private String address; // 家庭住址
	private String guidelines; // 进场须知
	private String entryTime; // 进场时间
	private String exitTime; // 退场时间
	private String safety; // 安全教育
	private String contract; // 劳动计件计时合同
	private String worktime; // 时间
	private String unit; // 单位
	private String experience; // 经历
	private Date createTime; 
	// 班组
	private String teamName;// 班组名称
	private String teamCode;// 班组code
	//
	private String provinceChn;// 省份中文名
	private String cityChn;// 城市
	private String skillBigTypeName;// 技能大类型名称
	private String skillSmallTypeName;// 技能小类型名称	

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(23);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("name", this.name);
		obj.put("gender", this.gender);
		obj.put("national", this.national);
		obj.put("education", this.education);
		obj.put("birth", this.birth);
		obj.put("age", this.age);
		obj.put("height", this.height);
		obj.put("weight", this.weight);
		obj.put("identity", this.identity);
		obj.put("health", this.health);
		obj.put("marriage", this.marriage);
		obj.put("skillBigType", this.skillBigType);
		obj.put("skillSmallType", this.skillSmallType);
		obj.put("jobstatus", this.jobstatus);
		obj.put("integrity", this.integrity);
		obj.put("bankcard", this.bankcard);
		obj.put("address", this.address);
		obj.put("guidelines", this.guidelines);
		obj.put("safety", this.safety);
		obj.put("contract", this.contract);
		obj.put("worktime", this.worktime);
		obj.put("unit", this.unit);
		obj.put("experience", this.experience);
		obj.put("createTime", this.createTime);
		obj.put("userId", this.userId);
		obj.put("type", this.type);
		obj.put("teamName", this.teamName);
		obj.put("teamCode", this.teamCode);
		obj.put("province", this.province);
		obj.put("entryTime", this.entryTime);
		obj.put("exitTime", this.exitTime);
		obj.put("city", this.city);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.name = result.getString("name");
		this.gender = result.getString("gender");
		this.national = result.getString("national");
		this.education = result.getString("education");
		this.createTime = (Date) result.get("createTime");
		this.birth = result.getString("birth");
		this.age = result.getString("age");
		this.height = result.getString("height");
		this.weight = result.getString("weight");
		this.identity = result.getString("identity");
		this.health = result.getString("health");
		this.marriage = result.getString("marriage");
		this.skillBigType = result.getString("skillBigType");
		this.skillSmallType = result.getString("skillSmallType");
		this.province = result.getString("province");
		this.city = result.getString("city");
		this.jobstatus = result.getString("jobstatus");
		this.integrity = result.getString("integrity");
		this.bankcard = result.getString("bankcard");
		this.address = result.getString("address");
		this.guidelines = result.getString("guidelines");
		this.safety = result.getString("safety");
		this.contract = result.getString("contract");
		this.worktime = result.getString("worktime");
		this.unit = result.getString("unit");
		this.experience = result.getString("experience");
		this.userId = result.getString("userId");
		this.entryTime = result.getString("entryTime");
		this.exitTime = result.getString("exitTime");

		this.type = result.getInt("type", 0);
		this.teamName = result.getString("teamName");
		this.teamCode = result.getString("teamCode");
		this.provinceChn = Area.getNameByCode(this.province);
		this.cityChn = Area.getNameByCode(this.city);
		try {
			this.skillBigTypeName = ETeamSkillBigType
					.getSkillBigTypeName(Integer.valueOf(this.skillBigType));
			this.skillSmallTypeName = ETeamSkillSmallType
					.getSkillSmallTypeName(Integer.valueOf(this.skillSmallType));
		} catch (Exception e) {
			
		}
	}

	public String getSkillBigTypeName() {
		return skillBigTypeName;
	}

	public void setSkillBigTypeName(String skillBigTypeName) {
		this.skillBigTypeName = skillBigTypeName;
	}

	public String getSkillSmallTypeName() {
		return skillSmallTypeName;
	}

	public void setSkillSmallTypeName(String skillSmallTypeName) {
		this.skillSmallTypeName = skillSmallTypeName;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getSkillBigType() {
		return skillBigType;
	}

	public void setSkillBigType(String skillBigType) {
		this.skillBigType = skillBigType;
	}

	public String getSkillSmallType() {
		return skillSmallType;
	}

	public void setSkillSmallType(String skillSmallType) {
		this.skillSmallType = skillSmallType;
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

	public String getJobstatus() {
		return jobstatus;
	}

	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}

	public String getIntegrity() {
		return integrity;
	}

	public void setIntegrity(String integrity) {
		this.integrity = integrity;
	}

	public String getBankcard() {
		return bankcard;
	}

	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGuidelines() {
		return guidelines;
	}

	public void setGuidelines(String guidelines) {
		this.guidelines = guidelines;
	}

	public String getSafety() {
		return safety;
	}

	public void setSafety(String safety) {
		this.safety = safety;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	
}
