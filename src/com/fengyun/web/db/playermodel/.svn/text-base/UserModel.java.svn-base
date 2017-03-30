package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;
import mmo.common.utils.DateStringUtils;

import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.Area;
import com.fengyun.web.hardcode.ETeamSkillBigType;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.fengyun.web.util.ModelUtils;
import com.mongodb.BasicDBObject;

/**
 * 用户表
 * 
 * @author user
 * 
 */
public class UserModel implements BaseIdModel {

	private String id;
	private String userId;// 手机号(作为登录帐号)
	private String userName; // 真实姓名
	private String userType = "0"; // 用户类别 0：用户  1：材料商  2：设备商  3:公司负责人 4:项目负责人 
	private String userProvince;// 省份
	private String userCity;// 城市
	private String userStreet;// 街道
	private String userProvinceStr;// 省份
	private String userCityStr;// 城市
	private String userStreetStr;// 街道
	private String userPassword = "123456";// 密码
	private String userSex;// 性别 1-男 2-女
	private int age;// 年龄
	private String userStatus;// 用工状态 1：正在找工作 ；2：在岗；3：在岗寻求更好的工作
	private String userIdentity;// 身份证号
	public Date createTime = new Date();// 注册时间
	private int score = 60;// 诚信度分数
	private int reliableStar = 3;// 诚信星级
	private int noreliableStar = 0;// 非诚信星级
	private int skillBigType;// 技能大类型
	private String skillBigTypeName;// 技能大类型名称
	private int skillSmallType;// 技能小类型
	private String skillSmallTypeName;// 技能小类型名称
	private Date lastLogin = new Date(); //最后一次登录时间
	private int loginTimes = 0;  //登录次数
	private String createTimeStr;
	private String IdentityImageName;//身份证照片名称
	private String credential; //持证情况

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(20);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("userName", this.userName);
		obj.put("userType", this.userType);
		obj.put("userProvince", this.userProvince);
		obj.put("userCity", this.userCity);
		obj.put("userId", this.userId);
		obj.put("userStreet", this.userStreet);
		obj.put("userPassword", this.userPassword);
		obj.put("userSex", this.userSex);
		obj.put("userStatus", this.userStatus);
		obj.put("userIdentity", this.userIdentity);
		obj.put("createTime", this.createTime);
		obj.put("score", this.score);
		obj.put("skillBigType", this.skillBigType);
		obj.put("skillSmallType", this.skillSmallType);
		obj.put("age", this.age);
		obj.put("lastLogin", this.lastLogin);
		obj.put("loginTimes", this.loginTimes);
		obj.put("IdentityImageName", this.IdentityImageName);
		obj.put("credential", this.credential);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.userName = result.getString("userName");
		// 预防之前有玩家名字出现特殊字符进行修正
		if (userName != null)
			userName = userName.replaceAll("\r", "").replaceAll("\n", "")
					.replaceAll("\t", "");
		this.userType = result.getString("userType");
		this.userProvince = result.getString("userProvince");
		this.userCity = result.getString("userCity");
		this.userStreet = result.getString("userStreet");
		this.userPassword = result.getString("userPassword");
		this.userId = result.getString("userId");
		this.userSex = result.getString("userSex");
		this.userStatus = result.getString("userStatus");
		this.userIdentity = result.getString("userIdentity");
		this.IdentityImageName = result.getString("IdentityImageName");
		this.createTime = (Date) result.get("createTime");
		this.score = result.getInt("score", 0);
		this.reliableStar = ModelUtils.score2star(score);
		this.skillBigType = result.getInt("skillBigType", 0);
		this.skillBigTypeName = ETeamSkillBigType
				.getSkillBigTypeName(this.skillBigType);
		this.skillSmallType = result.getInt("skillSmallType", 0);
		this.skillSmallTypeName = ETeamSkillSmallType
				.getSkillSmallTypeName(this.skillSmallType);
		this.age = result.getInt("age", 0);

		this.userProvinceStr = Area.getNameByCode(this.userProvince);
		this.userCityStr = Area.getNameByCode(this.userCity);
		this.userStreetStr = Area.getNameByCode(this.userStreet);
		this.lastLogin = (Date) result.get("lastLogin");
		this.loginTimes = result.getInt("loginTimes",0);
		this.credential = result.getString("credential");
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdentityImageName()
	{
		return IdentityImageName;
	}

	public void setIdentityImageName(String identityImageName)
	{
		IdentityImageName = identityImageName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getReliableStar() {
		return ModelUtils.score2star(score);
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserProvince() {
		return userProvince;
	}

	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserStreet() {
		return userStreet;
	}

	public void setUserStreet(String userStreet) {
		this.userStreet = userStreet;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	public int getNoreliableStar() {
		return 5 - this.reliableStar;
	}

	public void setNoreliableStar(int noreliableStar) {
		this.noreliableStar = noreliableStar;
	}

	public String getUserProvinceStr() {
		return userProvinceStr;
	}

	public void setUserProvinceStr(String userProvinceStr) {
		this.userProvinceStr = userProvinceStr;
	}

	public String getUserCityStr() {
		return userCityStr;
	}

	public void setUserCityStr(String userCityStr) {
		this.userCityStr = userCityStr;
	}

	public String getUserStreetStr() {
		return userStreetStr;
	}

	public void setUserStreetStr(String userStreetStr) {
		this.userStreetStr = userStreetStr;
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

	public String getCreateTimeStr() {
		return DateStringUtils.format(this.createTime);
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
	
}
