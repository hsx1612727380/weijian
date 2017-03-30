package com.fengyun.web.db.playermodel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;

import mmo.common.data.db.BaseIdModel;
/**
 * 设备商出入库记录
 * @author 13794
 *
 */
public class EquipmentTradModel implements BaseIdModel {
	
	 
	private String id;
	private String eId;    //设备商id
	private String eName;    //设备商名称
	private String pId;    //项目id
	private String pName;    //项目名称
	private String toolName;  //设备名称
	private String principal; // 委托，经办人 
	private String year;     //年
	private String month;   //月
	private String day;     //日
	private String rentdate;   //出租日期
	private int thisrent;     //本次租赁
	private int allrent;     //累计租赁3
	private int thispay; // 本次付款
	private int culapay; // 累计付款
	private int otherpay; // 其他款
	private int restpay; // 余款
	private String invoice;     //发票情况
	private String drawee;    //付款人
	private String payment;   //付款方式
	private String serial;    //流水号
	private String note; // 备注
	
	
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(10);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("eId", this.eId);
		obj.put("eName", this.eName);
		obj.put("toolName", this.toolName);
		obj.put("pId", this.pId);
		obj.put("pName", this.pName);
		obj.put("principal", this.principal);
		obj.put("year", this.year);
		obj.put("month", this.month);
		obj.put("day", this.day);
		obj.put("rentdate", this.rentdate);
		obj.put("thisrent", this.thisrent);
		obj.put("allrent", this.allrent);
		obj.put("thispay", this.thispay);
		obj.put("culapay", this.culapay);
		obj.put("otherpay", this.otherpay);
		obj.put("restpay", this.restpay);
		obj.put("invoice", this.invoice);
		obj.put("note", this.note);
		obj.put("drawee", this.drawee);
		obj.put("payment", this.payment);
		obj.put("serial", this.serial);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.eId = result.getString("eId");
		this.eName = result.getString("eName");
		this.toolName = result.getString("toolName");
		this.pId = result.getString("pId");
		this.pName = result.getString("pName");
		this.principal = result.getString("principal");
		this.rentdate = result.getString("rentdate");
		this.thisrent = result.getInt("thisrent", 0);
		this.allrent = result.getInt("allrent", 0);
		this.invoice = result.getString("invoice");
		this.note = result.getString("note");
		this.drawee = result.getString("drawee");
		this.payment = result.getString("payment");
		this.serial = result.getString("serial");
		this.year = result.getString("year");
		this.month = result.getString("month");
		this.day = result.getString("day");
		this.thispay = result.getInt("thispay", 0);
		this.culapay = result.getInt("culapay", 0);
		this.otherpay = result.getInt("otherpay", 0);
		this.restpay = result.getInt("restpay", 0);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
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

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRentdate() {
		return rentdate;
	}

	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}

	public int getThisrent() {
		return thisrent;
	}

	public void setThisrent(int thisrent) {
		this.thisrent = thisrent;
	}

	public int getAllrent() {
		return allrent;
	}

	public void setAllrent(int allrent) {
		this.allrent = allrent;
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

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDrawee() {
		return drawee;
	}

	public void setDrawee(String drawee) {
		this.drawee = drawee;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	
	
	
	
	
	
	
	

	

}
