package com.fengyun.web.db.playermodel;

import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.Area;
import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;

public class ProjectModel implements BaseIdModel {

	private String id;
	private String name;// 项目名称
	private String code;// 公司代码
	private String companyType;// 公司类型，对应 companymodel：type
	private String pCode;// 项目代号
	private String userId;// 负责人手机号
	private String identity;// 负责人身份证
	private String leaderName;// 负责人名称
	private String province;// 省份编号
	private String city;// 城市编号

	private String provinceChn;// 省份中文名
	private String cityChn;// 城市

	private String street;// 地址街道
	private Date createTime = new Date();//
	private int check;// 是否审核 0-未审核；1-已审核
	private int status = 0;// 0——未开始，1——进行中，2——已完成
	private int price;// 合同价
	private int prepaid;// 预付款
	private int progress;// 进度百分比

	private String longitude;// 经度
	private String latitude;// 纬度

	private String allWork; // 总工作量
	private String thsWork; // 本次工程量
	private String accWork; // 累计工作量
	private int times; // 次数
	private String unit; // 单位(工程)
	private String buildUnit; // 建设单位
	private String note; //  	
	//
	private String provinceCode;// 省级项目编号
	private String type;		// 项目分类
	private String projectTitanic; // 立项文号
	private String projectlevel; // 立项级别
	private String projectorgan; // 立项批复机关
	private String replytime; // 立项批复时间
	private String investment; // 总投资（万元）
	private String totalarea;// 总面积/长度（平方米/米）
	private String scale; // 建设规模
	private String nature; // 建设性质
	private String purpose; // 工程用途
	private String worktime; // 计划开工日期
	
	

	private CompanyModel companyModel;

	private Properties pro; // 项目环节

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(10);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("name", this.name);
		obj.put("code", this.code);
		obj.put("pCode", this.pCode);
		obj.put("userId", this.userId);
		obj.put("leaderName", this.leaderName);
		obj.put("province", this.province);
		obj.put("city", this.city);
		obj.put("street", this.street);
		obj.put("createTime", this.createTime);
		obj.put("status", this.status);
		obj.put("check", this.check);
		obj.put("price", this.price);
		obj.put("prepaid", this.prepaid);
		obj.put("progress", this.progress);
		obj.put("longitude", this.longitude);
		obj.put("latitude", this.latitude);
		obj.put("allWork", this.allWork);
		obj.put("thsWork", this.thsWork);
		obj.put("accWork", this.accWork);
		obj.put("times", this.times);
		obj.put("unit", this.unit);
		obj.put("buildUnit", this.buildUnit);
		obj.put("provinceCode", this.provinceCode);
		obj.put("type", this.type);
		obj.put("nature", this.nature);
		obj.put("purpose", this.purpose);
		obj.put("projectTitanic", this.projectTitanic);
		obj.put("projectlevel", this.projectlevel);
		obj.put("projectorgan", this.projectorgan);
		obj.put("replytime", this.replytime);
		obj.put("investment", this.investment);
		obj.put("totalarea", this.totalarea);
		obj.put("scale", this.scale);
		obj.put("worktime", this.worktime);
		obj.put("note", this.note);
		obj.put("pro", this.pro);
		obj.put("identity", this.identity);
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.name = result.getString("name");
		this.code = result.getString("code");
		this.pCode = result.getString("pCode");
		this.userId = result.getString("userId");
		this.leaderName = result.getString("leaderName");
		this.province = result.getString("province");
		this.city = result.getString("city");

		this.provinceChn = Area.getNameByCode(this.province);
		this.cityChn = Area.getNameByCode(this.city);

		this.street = result.getString("street");
		this.createTime = (Date) result.get("createTime");
		this.status = result.getInt("status");
		this.check = result.getInt("check", 0);
		this.price = result.getInt("price", 0);
		this.prepaid = result.getInt("prepaid", 0);
		this.progress = result.getInt("progress", 0);
		this.longitude = result.getString("longitude");
		if (longitude == null || "".equals(longitude))
			longitude = "113.346715";
		this.latitude = result.getString("latitude");
		if (latitude == null || "".equals(latitude))
			latitude = "23.140517";
		this.allWork = result.getString("allWork");
		this.thsWork = result.getString("thsWork");
		this.accWork = result.getString("accWork");
		this.times = result.getInt("times", 0);
		this.unit = result.getString("unit");
		this.buildUnit = result.getString("buildUnit");
		this.provinceCode = result.getString("provinceCode");
		this.type = result.getString("type");
		this.nature = result.getString("nature");
		this.purpose = result.getString("purpose");
		this.projectTitanic = result.getString("projectTitanic");
		this.projectlevel = result.getString("projectlevel");
		this.projectorgan = result.getString("projectorgan");
		this.replytime = result.getString("replytime");
		this.investment = result.getString("investment");
		this.totalarea = result.getString("totalarea");
		this.identity = result.getString("identity");
		this.scale = result.getString("scale");
		this.worktime = result.getString("worktime");
		this.note = result.getString("note");
		Properties pro = new Properties();
		if (result.get("pro") != null)
			pro.putAll((HashMap<Object, Object>) result.get("pro"));
		this.setPro(pro);
	}

	public Properties getPro() {
		return pro;
	}

	public void setPro(Properties pro) {
		if (pro == null)
			this.pro = new Properties();
		else
			this.pro = pro;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPro(String id) {
		return pro == null ? null : pro.getProperty(id);
	}

	public void setpro(String id, String value) {
		if (pro == null) {
			pro = new Properties();
		}
		pro.setProperty(id, value);
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
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

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrepaid() {
		return prepaid;
	}

	public void setPrepaid(int prepaid) {
		this.prepaid = prepaid;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getAllWork() {
		return allWork;
	}

	public void setAllWork(String allWork) {
		this.allWork = allWork;
	}

	public String getAccWork() {
		return accWork;
	}

	public void setAccWork(String accWork) {
		this.accWork = accWork;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProjectTitanic() {
		return projectTitanic;
	}

	public void setProjectTitanic(String projectTitanic) {
		this.projectTitanic = projectTitanic;
	}

	public String getProjectorgan() {
		return projectorgan;
	}

	public void setProjectorgan(String projectorgan) {
		this.projectorgan = projectorgan;
	}

	public String getReplytime() {
		return replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

	public String getInvestment() {
		return investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
	}

	public String getTotalarea() {
		return totalarea;
	}

	public void setTotalarea(String totalarea) {
		this.totalarea = totalarea;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public String getCreateTimeStr() {
		return DateStringUtils.format(this.createTime);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProjectlevel() {
		return projectlevel;
	}

	public void setProjectlevel(String projectlevel) {
		this.projectlevel = projectlevel;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getThsWork() {
		return thsWork;
	}

	public void setThsWork(String thsWork) {
		this.thsWork = thsWork;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBuildUnit() {
		return buildUnit;
	}

	public void setBuildUnit(String buildUnit) {
		this.buildUnit = buildUnit;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCreateTimeMD() {
		if (this.createTime != null)
			return DateStringUtils.formatMD(this.createTime);
		return "";
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public CompanyModel getCompanyModel() {
		return companyModel;
	}

	public void setCompanyModel(CompanyModel companyModel) {
		this.companyModel = companyModel;
	}

}
