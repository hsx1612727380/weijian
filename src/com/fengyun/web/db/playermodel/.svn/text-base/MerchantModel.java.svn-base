package com.fengyun.web.db.playermodel;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;

/**
 * 
 * 材料（设备）商诚信档案
 * 
 * @author wangqi
 * 
 */

public class MerchantModel implements BaseIdModel {

	private String id;
	private int type;// 1-材料 2-设备
	private String code;// 机构代码
	private String supplier; // 供应商名称
	private String itemname; // 物品名称
	private String licence; // 统一社会信用代码
	private String build; // 成立日期
	private String supply; // 供货地区
	private String registercapital; // 注册资金
	private String registeraddress; // 注册地址
	private String paid; // 实缴   
	private String paytype; // 结算方式 (月\年)
	private String cope; // 期初应付
	private String name; // 联系人姓名——(注册时的输入的姓名)
	private String address; // 联系人地址
	private String email; // 邮箱
	private String identification; // 身份证 ——(注册时的身份证)
	private String phone; // 电话
	private String qq; // QQ
	private String mobile; // 手机   ——(注册时的电话号码,初始化诚信档案时是使用userId作为mobile初始化的)
	private String wetchat; // 微信（联系）
	private String note; // 备注
	private String payment; // 支付账号  微信（支付）
	private String paytreasure; // 支付宝
	private String bankaccount; // 银行账号
	private Date createTime;
	//(2016.11.22新添加字段)
	private int status; // 0：停供中，1：供货中——(初始化是设置为 1)
	private String depositBank;//开户行
	private int open; //1：公开 0：不公开 ——(初始化是设置为 1)
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(23);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("supplier", this.supplier);
		obj.put("licence", this.licence);
		obj.put("build", this.build);
		obj.put("registercapital", this.registercapital);
		obj.put("registeraddress", this.registeraddress);
		obj.put("name", this.name);
		obj.put("address", this.address);
		obj.put("email", this.email);
		obj.put("identification", this.identification);
		obj.put("phone", this.phone);
		obj.put("qq", this.qq);
		obj.put("wetchat", this.wetchat);
		obj.put("note", this.note);
		obj.put("createTime", this.createTime);
		obj.put("paytreasure", this.paytreasure);
		obj.put("supply", this.supply);
		obj.put("status", this.status);
		obj.put("payment", this.payment);
		obj.put("bankaccount", this.bankaccount);
		obj.put("itemname", this.itemname);
		obj.put("paid", this.paid);
		obj.put("paytype", this.paytype);
		obj.put("cope", this.cope);
		obj.put("mobile", this.mobile);
		obj.put("type", this.type);
		obj.put("code", this.code);
		obj.put("depositBank", this.depositBank);
		obj.put("open", this.open);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.supplier = result.getString("supplier");
		this.address = result.getString("address");
		this.build = result.getString("build");
		this.createTime = (Date) result.get("createTime");
		this.email = result.getString("email");
		this.identification = result.getString("identification");
		this.licence = result.getString("licence");
		this.name = result.getString("name");
		this.note = result.getString("note");
		this.phone = result.getString("phone");
		this.qq = result.getString("qq");
		this.registeraddress = result.getString("registeraddress");
		this.registercapital = result.getString("registercapital");
		this.wetchat = result.getString("wetchat");
		this.paytreasure = result.getString("paytreasure");
		this.supply = result.getString("supply");
		this.status = result.getInt("status",1);
		this.payment = result.getString("payment");
		this.bankaccount = result.getString("bankaccount");
		this.itemname = result.getString("itemname");
		this.paid = result.getString("paid");
		this.paytype = result.getString("paytype");
		this.cope = result.getString("cope");
		this.mobile = result.getString("mobile");
		this.type = result.getInt("type", 0);
		this.code = result.getString("code");
		this.depositBank = result.getString("depositBank");
		this.open = result.getInt("open",1);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getlicence() {
		return licence;
	}

	public void setlicence(String licence) {
		this.licence = licence;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getSupply() {
		return supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRegistercapital() {
		return registercapital;
	}

	public void setRegistercapital(String registercapital) {
		this.registercapital = registercapital;
	}

	public String getRegisteraddress() {
		return registeraddress;
	}

	public void setRegisteraddress(String registeraddress) {
		this.registeraddress = registeraddress;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getCope() {
		return cope;
	}

	public void setCope(String cope) {
		this.cope = cope;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWetchat() {
		return wetchat;
	}

	public void setWetchat(String wetchat) {
		this.wetchat = wetchat;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPaytreasure() {
		return paytreasure;
	}

	public void setPaytreasure(String paytreasure) {
		this.paytreasure = paytreasure;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDepositBank() {
		return depositBank;
	}

	public void setDepositBank(String depositBank) {
		this.depositBank = depositBank;
	}

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

}
