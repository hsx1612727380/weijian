package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.Area;
import com.fengyun.web.util.ModelUtils;
import com.mongodb.BasicDBObject;

/**
 * 设备商信息
 * 
 * @author mayu
 * 
 */
public class EquipmentModel implements BaseIdModel {

	private String id;
	private String name;//供应商名称
	private String code;// 机构代码
	private String licence; ;// 统一社会信用代码
	private String regcapital;// 注册资金
	private String userId;//
	private String leaderName;//法人代表名字
	private String province;// 省份
	private String city;// 城市
	private String county;//区或县
	private String provinceChn;// 省份中文名
	private String cityChn;// 城市
	private String countyChn;// 区或县
	
	private String street;// 地址街道
	private Date createTime;//
	private int status;//0-未审核   1-已经审核
	private String shopName;// 设备名称
	private int score = 60;// 诚信度分数
	private int reliableStar = 3;// 诚信星级
	private int noreliableStar = 0;// 非诚信星级
	
	private String establishDate;  // 成立日期

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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
		obj.put("county", this.county);
		obj.put("street", this.street);
		obj.put("createTime", this.createTime);
		obj.put("status", this.status);
		obj.put("shopName", this.shopName);
		obj.put("score", this.score);
		obj.put("licence", this.licence);
		obj.put("regcapital", this.regcapital);
		obj.put("establishDate", this.establishDate);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.name = result.getString("name");
		this.code = result.getString("code");
		this.licence = result.getString("licence");
		this.regcapital = result.getString("regcapital");
		this.userId = result.getString("userId");
		this.leaderName = result.getString("leaderName");
		this.province = result.getString("province");
		this.city = result.getString("city");
		this.county = result.getString("county");
		this.street = result.getString("street");
		this.provinceChn = Area.getNameByCode(this.province);
		this.cityChn = Area.getNameByCode(this.city);
		this.countyChn = Area.getNameByCode(this.county);
		
		this.createTime = (Date) result.get("createTime");
		this.status = result.getInt("status");
		this.shopName = result.getString("shopName");
		this.score = result.getInt("score", 0);
		this.reliableStar = ModelUtils.score2star(score);
		this.establishDate = result.getString("establishDate");
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
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

	public int getNoreliableStar() {
		return 5 - this.reliableStar;
	}

	public void setNoreliableStar(int noreliableStar) {
		this.noreliableStar = noreliableStar;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getRegcapital() {
		return regcapital;
	}

	public void setRegcapital(String regcapital) {
		this.regcapital = regcapital;
	}

	public String getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(String establishDate) {
		this.establishDate = establishDate;
	}
	
	
	
}
