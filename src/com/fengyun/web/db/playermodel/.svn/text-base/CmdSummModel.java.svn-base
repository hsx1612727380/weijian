package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

/**
 * 汇总表
 * 
 * @author mayu
 * 
 */
public class CmdSummModel implements BaseIdModel {

	private String id;
	private String pId;// 项目ID
	private String pName;// 项目名称
	private String tId;// 班组/材料/设备商Id
	private String tNum;   //班组/材料/设备商编号
	private int type;// 1-班组 2-材料商 3-设备商
	private int teamtype;    //班组类型： 1-本班组 2-劳务分包班组 3-专业分包班组
	private String tName;// 班组或者材料设备商名称
	// /////////////////////////////////////////
	private int contractPrice; // 合同价
	private int bgpayment;// 预付款
	private int frequency;// 次数
	private String unit; // 单位
	private int total; // 总工程量
	private int nowTotal; // 本次工程量
	private int percentage; // 本次工程量占总量百分比例
	private int thispay; // 本次付款
	private int culapay; // 累计付款
	private int remain; // 余额
	private int culPercentage; // 累计付款百分比
	private int deposit;// 押金
	private String settlement; // 结算情况
	private String note; // 备注
	private int year;     //年
	private int month;      //月
	

	// ////////人工
	private int thisSalary; // 已付工资
	private int noSalary; // 未付工资
	// ////////材料设备商
	private String principal; // 委托，经办人
	private String account; // 支付宝账户或凭证
	private int budget; // 预算量
	private int num; // 数量
	private int price; // 单价
	private int subtotal; // 小计
	private int receipt; // 本次入库/租赁量
	private int cumulative; // 累计入库/租赁量
	private int otherpay; // 其他款
	private int restpay; // 余款
	private String invoice;  //发票情况

	private Date createTime = new Date();

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(23);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("pId", this.pId);
		obj.put("pName", this.pName);
		obj.put("tId", this.tId);
		obj.put("tNum", this.tNum);
		obj.put("type", this.type);
		obj.put("tName", this.tName);
		obj.put("teamtype", this.teamtype);
		obj.put("contractPrice", this.contractPrice);
		obj.put("bgpayment", this.bgpayment);
		obj.put("frequency", this.frequency);
		obj.put("unit", this.unit);
		obj.put("total", this.total);
		obj.put("nowTotal", this.nowTotal);
		obj.put("percentage", this.percentage);
		obj.put("thispay", this.thispay);
		obj.put("culapay", this.culapay);
		obj.put("remain", this.remain);
		obj.put("culPercentage", this.culPercentage);
		obj.put("deposit", this.deposit);
		obj.put("settlement", this.settlement);
		obj.put("note", this.note);
		obj.put("thisSalary", this.thisSalary);
		obj.put("noSalary", this.noSalary);
		obj.put("principal", this.principal);
		obj.put("account", this.account);
		obj.put("budget", this.budget);
		obj.put("num", this.num);
		obj.put("price", this.price);
		obj.put("subtotal", this.subtotal);
		obj.put("receipt", this.receipt);
		obj.put("cumulative", this.cumulative);
		obj.put("otherpay", this.otherpay);
		obj.put("restpay", this.restpay);
		obj.put("createTime", this.createTime);
		obj.put("year", this.year);
		obj.put("month", this.month);
		obj.put("invoice", this.invoice);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.pId = result.getString("pId");
		this.pName = result.getString("pName");
		this.tId = result.getString("tId");
		this.tNum = result.getString("tNum");
		this.type = result.getInt("type", 1);
		this.tName = result.getString("tName");
		this.teamtype = result.getInt("teamtype");

		this.contractPrice = result.getInt("contractPrice", 0);
		this.bgpayment = result.getInt("bgpayment", 0);
		this.frequency = result.getInt("frequency", 0);
		this.unit = result.getString("unit");
		this.total = result.getInt("total", 0);
		this.year = result.getInt("year");
		this.month = result.getInt("month");

		this.nowTotal = result.getInt("nowTotal", 0);
		this.percentage = result.getInt("percentage", 0);
		this.thispay = result.getInt("thispay", 0);
		this.culapay = result.getInt("culapay", 0);
		this.remain = result.getInt("remain", 0);
		this.culPercentage = result.getInt("culPercentage", 0);
		this.deposit = result.getInt("deposit", 0);
		this.settlement = result.getString("settlement");
		this.note = result.getString("note");

		this.thisSalary = result.getInt("thisSalary", 0);
		this.noSalary = result.getInt("noSalary", 0);
		this.principal = result.getString("principal");
		this.account = result.getString("account");
		this.budget = result.getInt("budget", 0);
		this.num = result.getInt("num", 0);
		this.price = result.getInt("price", 0);

		this.subtotal = result.getInt("subtotal", 0);
		this.receipt = result.getInt("receipt", 0);
		this.cumulative = result.getInt("cumulative", 0);
		this.otherpay = result.getInt("otherpay", 0);
		this.restpay = result.getInt("restpay", 0);
		this.createTime = (Date) result.get("createTime");
		this.invoice = result.getString("invoice");

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

	public int getContractPrice() {
		return contractPrice;
	}

	public void setContractPrice(int contractPrice) {
		this.contractPrice = contractPrice;
	}

	public int getBgpayment() {
		return bgpayment;
	}

	public void setBgpayment(int bgpayment) {
		this.bgpayment = bgpayment;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNowTotal() {
		return nowTotal;
	}

	public void setNowTotal(int nowTotal) {
		this.nowTotal = nowTotal;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
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

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public int getCulPercentage() {
		return culPercentage;
	}

	public void setCulPercentage(int culPercentage) {
		this.culPercentage = culPercentage;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public String getSettlement() {
		return settlement;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getThisSalary() {
		return thisSalary;
	}

	public void setThisSalary(int thisSalary) {
		this.thisSalary = thisSalary;
	}

	public int getNoSalary() {
		return noSalary;
	}

	public void setNoSalary(int noSalary) {
		this.noSalary = noSalary;
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

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String gettNum() {
		return tNum;
	}

	public void settNum(String tNum) {
		this.tNum = tNum;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

}
