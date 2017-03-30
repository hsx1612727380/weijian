package com.fengyun.web.db.playermodel;

import java.util.Date;

import javax.xml.crypto.Data;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;


/**
 * 汇总供应商明细表
 * @author 13794
 *
 */
public class CmdSummSupplierModel implements BaseIdModel {
	
	
	private String id;
	private String cmdId;// 汇总ID
	private String pId;// 项目ID
	private String pName;// 项目名称
	private String tId;// 租赁方/材料/设备商ID
	private int type;// 1-租赁方 2-材料商 3-设备商
	private int teamtype;    //班组类型： 1-本班组，2-专业分包班组，3-劳务分包班组
	private String tName;// 租赁方或者材料设备商名称
	// /////////////////////////////////////////
	private String principal; // 委托，经办人
	private String cName;   //名称，规格，和型号
	private String account; // 支付宝账户或凭证
	private String unit; // 单位
	private int frequency;// 次数
	private int num; // 数量
	private int price; // 单价
	private int subtotal; // 小计
	private int thispay; // 本次付款
	private int culapay; // 累计付款
	private int otherpay; // 其他款
	private int restpay; // 余款
	private String information;   //资料情况
	private String invoice;     //发票情况
	private String settlement; // 结算情况
	private String using;      //用途
	private String quality;     //质量
	private String note; // 备注
	private int year;     //年
	private int month;      //月
	// ////////施工机械设备
	private int deposit;// 押金
	private Data startTime;   //入场时间
	private Data exitTime;   //退场时间
	private int personpay;   //人工工资支付情况
	private String thislease;    //本期租赁情况
	private String allease;     //累计租赁情况
	private int status;     //出租方是否签名 ：  1-是，  2-否
	// 材料商
	private int bgpayment; // 预付款
	private int budget; // 预算量
	private int receipt; // 本次入库/租赁量
	private int cumulative; // 累计入库/租赁量
	private Date createTime = new Date();
	
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(23);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("cmdId", this.cmdId);
		obj.put("pId", this.pId);
		obj.put("pName", this.pName);
		obj.put("tId", this.tId);
		obj.put("type", this.type);
		obj.put("teamtype", this.teamtype);
		obj.put("tName", this.tName);
		obj.put("principal", this.principal);
		obj.put("account", this.account);
		obj.put("unit", this.unit);
		obj.put("frequency", this.frequency);
		obj.put("num", this.num);
		obj.put("price", this.price);
		obj.put("subtotal", this.subtotal);
		obj.put("thispay", this.thispay);
		obj.put("culapay", this.culapay);
		obj.put("otherpay", this.otherpay);
		obj.put("restpay", this.restpay);
		obj.put("information", this.information);
		obj.put("invoice", this.invoice);
		obj.put("settlement", this.settlement);
		obj.put("using", this.using);
		obj.put("quality", this.quality);
		obj.put("deposit", this.deposit);
		obj.put("startTime", this.startTime);
		obj.put("exitTime", this.exitTime);
		obj.put("personpay", this.personpay);
		obj.put("thislease", this.thislease);
		obj.put("allease", this.allease);
		obj.put("status", this.status);
		obj.put("bgpayment", this.bgpayment);
		obj.put("budget", this.budget);
		obj.put("receipt", this.receipt);
		obj.put("cumulative", this.cumulative);
		obj.put("createTime", this.createTime);
		obj.put("year", this.year);
		obj.put("month", this.month);
		obj.put("cName", this.cName);
		obj.put("note", this.note);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.cmdId = result.getString("cmdId");
		this.pId = result.getString("pId");
		this.pName = result.getString("pName");
		this.tId = result.getString("tId");
		this.type = result.getInt("type");
		this.teamtype = result.getInt("teamtype");
		this.tName = result.getString("tName");
		this.principal = result.getString("principal");
		this.account = result.getString("account");
		this.unit = result.getString("unit");
		this.frequency = result.getInt("frequency");
		this.num = result.getInt("num");
		this.year = result.getInt("year");
		this.month = result.getInt("month");
		this.price = result.getInt("price", 0);
		this.subtotal = result.getInt("subtotal", 0);
		this.thispay = result.getInt("thispay", 0);
		this.culapay = result.getInt("culapay", 0);
		this.otherpay = result.getInt("otherpay", 0);
		this.restpay = result.getInt("restpay", 0);
		this.information = result.getString("information");
		this.invoice = result.getString("invoice");
		this.settlement = result.getString("settlement");
		this.using = result.getString("using");
		this.quality = result.getString("quality");
		this.note = result.getString("note");
		this.deposit = result.getInt("deposit");
		this.startTime = (Data) result.get("startTime");
		this.exitTime = (Data) result.get("exitTime");
		this.personpay = result.getInt("personpay");
		this.thislease = result.getString("thislease");
		this.allease = result.getString("allease");
		this.status = result.getInt("status");
		this.bgpayment = result.getInt("bgpayment");
		this.budget = result.getInt("budget",0);
		this.receipt = result.getInt("receipt",0);
		this.cumulative = result.getInt("cumulative",0);
		this.cName = result.getString("cName");
		this.createTime = (Date) result.get("createTime");
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getTeamtype() {
		return teamtype;
	}

	public void setTeamtype(int teamtype) {
		this.teamtype = teamtype;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCmdId() {
		return cmdId;
	}

	public void setCmdId(String cmdId) {
		this.cmdId = cmdId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	public int getThispay() {
		return thispay;
	}

	public void setThispay(int thispay) {
		this.thispay = thispay;
	}

	public int getCulapay() {
		return culapay;
	}

	public void setCulapay(int culapay) {
		this.culapay = culapay;
	}

	public int getOtherpay() {
		return otherpay;
	}

	public void setOtherpay(int otherpay) {
		this.otherpay = otherpay;
	}

	public int getRestpay() {
		return restpay;
	}

	public void setRestpay(int restpay) {
		this.restpay = restpay;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getSettlement() {
		return settlement;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	public String getUsing() {
		return using;
	}

	public void setUsing(String using) {
		this.using = using;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public Data getStartTime() {
		return startTime;
	}

	public void setStartTime(Data startTime) {
		this.startTime = startTime;
	}

	public Data getExitTime() {
		return exitTime;
	}

	public void setExitTime(Data exitTime) {
		this.exitTime = exitTime;
	}

	public int getPersonpay() {
		return personpay;
	}

	public void setPersonpay(int personpay) {
		this.personpay = personpay;
	}

	public String getThislease() {
		return thislease;
	}

	public void setThislease(String thislease) {
		this.thislease = thislease;
	}

	public String getAllease() {
		return allease;
	}

	public void setAllease(String allease) {
		this.allease = allease;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBgpayment() {
		return bgpayment;
	}

	public void setBgpayment(int bgpayment) {
		this.bgpayment = bgpayment;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getReceipt() {
		return receipt;
	}

	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}

	public int getCumulative() {
		return cumulative;
	}

	public void setCumulative(int cumulative) {
		this.cumulative = cumulative;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

}
