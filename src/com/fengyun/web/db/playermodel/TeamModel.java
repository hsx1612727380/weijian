package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.Area;
import com.fengyun.web.hardcode.ETeamSkillBigType;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.fengyun.web.util.ModelUtils;
import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/**
 * 班组
 * 
 */
public class TeamModel implements BaseIdModel {

	private String id;
	private String name;// 班组名称
	private long code;// 班组编号
	private String leaderName;// 班组长名称
	private String leaderMobile;// 负责人电话---对应user表的userId
	private int skillBigType;// 技能大类型
	private String skillBigTypeName;// 技能大类型名称
	private int skillSmallType;// 技能小类型
	private String skillSmallTypeName;// 技能小类型名称
	private String requireStatement;// 招聘要求、招聘声明


	private int status;// 0-找工作 1-已工作

	private String province;// 省份
	private String city;// 城市
	private String county;// 城市
	private String provinceChn;// 省份中文名
	private String cityChn;// 城市中文名
	private String countyChn;// 区或县
	private String street;// 地址街道
	private Date createTime;//

	private int score = 60;// 诚信度分数
	private int reliableStar = 3;// 诚信星级
	private int noreliableStar = 0;// 非诚信星级

	private String streetStr;// 街道
	private long num = 1;// 班组人数
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(19);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("name", this.name);
		obj.put("code", this.code);
		obj.put("leaderName", this.leaderName);
		obj.put("leaderMobile", this.leaderMobile);
		obj.put("skillBigType", this.skillBigType);
		obj.put("skillSmallType", this.skillSmallType);
		obj.put("status", this.status);
		obj.put("province", this.province);
		obj.put("city", this.city);
		obj.put("street", this.street);
		obj.put("createTime", this.createTime);
		obj.put("score", this.score);
		obj.put("requireStatement", this.requireStatement);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.name = result.getString("name");
		if (result.getString("code") != null)
			this.code = Long.valueOf(result.getString("code"));
		// this.code = result.get("code") == null ? 0 : result.getLong("code");
		this.leaderName = result.getString("leaderName");
		this.leaderMobile = result.getString("leaderMobile");
		this.skillBigType = result.getInt("skillBigType", 0);
		this.skillBigTypeName = ETeamSkillBigType
				.getSkillBigTypeName(this.skillBigType);
		this.skillSmallType = result.getInt("skillSmallType", 0);
		this.skillSmallTypeName = ETeamSkillSmallType
				.getSkillSmallTypeName(this.skillSmallType);
		this.status = result.getInt("status", 0);
		this.province = result.getString("province");
		this.city = result.getString("city");
		this.street = result.getString("street");
		this.requireStatement = result.getString("requireStatement");
		this.createTime = (Date) result.get("createTime");

		this.provinceChn = Area.getNameByCode(this.province);
		this.cityChn = Area.getNameByCode(this.city);
		this.countyChn = Area.getNameByCode(this.county);

		this.score = result.getInt("score", 0);
		this.reliableStar = ModelUtils.score2star(score);
		this.streetStr = Area.getNameByCode(this.street);
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getRequireStatement() {
		return requireStatement;
	}

	public void setRequireStatement(String requireStatement) {
		this.requireStatement = requireStatement;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
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

	public String getCountyChn() {
		return countyChn;
	}

	public void setCountyChn(String countyChn) {
		this.countyChn = countyChn;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getReliableStar() {
		return reliableStar;
	}

	public void setReliableStar(int reliableStar) {
		this.reliableStar = reliableStar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLeaderMobile() {
		return leaderMobile;
	}

	public void setLeaderMobile(String leaderMobile) {
		this.leaderMobile = leaderMobile;
	}

	public int getSkillBigType() {
		return skillBigType;
	}

	public void setSkillBigType(int skillBigType) {
		this.skillBigType = skillBigType;
	}

	public String getSkillBigTypeName() {
		return skillBigTypeName;
	}

	public void setSkillBigTypeName(String skillBigTypeName) {
		this.skillBigTypeName = skillBigTypeName;
	}

	public int getSkillSmallType() {
		return skillSmallType;
	}

	public void setSkillSmallType(int skillSmallType) {
		this.skillSmallType = skillSmallType;
	}

	public String getSkillSmallTypeName() {
		return skillSmallTypeName;
	}

	public void setSkillSmallTypeName(String skillSmallTypeName) {
		this.skillSmallTypeName = skillSmallTypeName;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getNoreliableStar() {
		return 5 - this.reliableStar;
	}

	public void setNoreliableStar(int noreliableStar) {
		this.noreliableStar = noreliableStar;
	}

	public String getStreetStr() {
		return streetStr;
	}

	public void setStreetStr(String streetStr) {
		this.streetStr = streetStr;
	}
	
}
