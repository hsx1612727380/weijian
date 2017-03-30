package com.fengyun.web.db.playermodel;

import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.Area;
import com.fengyun.web.hardcode.ETeamSkillBigType;
import com.fengyun.web.hardcode.ETeamSkillSmallType;
import com.fengyun.web.util.DateStringUtils;
import com.mongodb.BasicDBObject;

/**
 * 需求信息 包括 发布 求职和招聘
 * 
 * @author mayu
 */
public class RequirementsModel implements BaseIdModel {

	private String id;
	private String title;
	private String rId;// 对应个人userId，班组id，项目ID
	private String name;// 对应个人，班组，项目名字
	private String leaderName;// 对应个人，班组，项目负责人
	private int type;// 1-求职 2-招聘
	private int userType;// 1-个人 2-班组 3-项目（标记动作发起者）
	private String shopName;// 材料或者设备名称
	private int teamType;// 1-施工班组 2-材料班组 3-设备班组
	private int skillBigType;// 技能大类型
	private String skillBigTypeName;// 技能大类型名称
	private int skillSmallType;// 技能小类型
	private String skillSmallTypeName;// 技能小类型名称
	
	private int status = 1;// 状态 0 表示关闭  1表示公开招聘信息
	private String province;// 省份   （求职招聘地址）
	private String city;// 城市  （求职招聘地址）
	private String street;// 地址街道  （求职招聘地址）
	private Date createTime = new Date();// 创建时间
	
	private String provinceStr;// 省份
	private String cityStr;// 城市
	private String streetStr;// 街道
	private int num = 5;// 招聘人数
	private String desc;// 备注
	
	private UserModel userModel;
	private TeamModel teamModel;
	private MaterialModel materialModel;
	private EquipmentModel equipmentModel;
	private ProjectModel pModel;
	private CompanyModel cModel;
	
	private Properties pro;//

	@Override	
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(15);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("title", this.title);
		obj.put("type", this.type);
		obj.put("userType", this.userType);
		obj.put("status", this.status);
		obj.put("skillBigType", this.skillBigType);
		obj.put("skillSmallType", this.skillSmallType);
		obj.put("status", this.status);
		obj.put("province", this.province);
		obj.put("city", this.city);
		obj.put("street", this.street);
		obj.put("createTime", this.createTime);
		obj.put("rId", this.rId);
		obj.put("name", this.name);
		obj.put("leaderName", this.leaderName);
		obj.put("num", this.num);
		obj.put("teamType", this.teamType);
		obj.put("shopName", this.shopName);
		obj.put("desc", this.desc);
		obj.put("pro", this.pro);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.title = result.getString("title");
		this.type = result.getInt("type");
		this.userType = result.getInt("userType");
		this.status = result.getInt("status");
		this.skillBigType = result.getInt("skillBigType", 0);
		this.skillBigTypeName = ETeamSkillBigType
				.getSkillBigTypeName(this.skillBigType);
		this.skillSmallType = result.getInt("skillSmallType", 0);
		this.skillSmallTypeName = ETeamSkillSmallType
				.getSkillSmallTypeName(this.skillSmallType);
		this.province = result.getString("province");
		this.city = result.getString("city");
		this.street = result.getString("street");
		this.createTime = (Date) result.get("createTime");
		this.rId = result.getString("rId");
		this.name = result.getString("name");
		this.leaderName = result.getString("leaderName");
		this.provinceStr = Area.getNameByCode(this.province);
		this.cityStr = Area.getNameByCode(this.city);
		this.streetStr = Area.getNameByCode(this.street);
		this.num = result.getInt("num", 5);
		this.teamType = result.getInt("teamType", 1);
		this.shopName = result.getString("shopName");
		this.desc = result.getString("desc");
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

	public String getPro(String id) {
		return pro == null ? null : pro.getProperty(id);
	}

	public void setpro(String id, String value) {
		if (pro == null) {
			pro = new Properties();
		}
		pro.setProperty(id, value);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ProjectModel getpModel() {
		return pModel;
	}

	public void setpModel(ProjectModel pModel) {
		this.pModel = pModel;
	}

	public CompanyModel getcModel() {
		return cModel;
	}

	public void setcModel(CompanyModel cModel) {
		this.cModel = cModel;
	}

	public TeamModel getTeamModel() {
		return teamModel;
	}

	public void setTeamModel(TeamModel teamModel) {
		this.teamModel = teamModel;
	}

	public MaterialModel getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(MaterialModel materialModel) {
		this.materialModel = materialModel;
	}

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getTeamType() {
		return teamType;
	}

	public void setTeamType(int teamType) {
		this.teamType = teamType;
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
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

	public String getProvinceStr() {
		return provinceStr;
	}

	public void setProvinceStr(String provinceStr) {
		this.provinceStr = provinceStr;
	}

	public String getCityStr() {
		return cityStr;
	}

	public void setCityStr(String cityStr) {
		this.cityStr = cityStr;
	}

	public String getStreetStr() {
		return streetStr;
	}

	public void setStreetStr(String streetStr) {
		this.streetStr = streetStr;
	}

	public String getCreateTimeStr() {
		return DateStringUtils.format(this.createTime);
	}

	public String getCreateTimeMD() {
		return DateStringUtils.formatMD(this.createTime);
	}
}
