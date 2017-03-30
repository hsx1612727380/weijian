package com.fengyun.web.db.playermodel;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;


/**
 * 材料商出入库记录
 * @author 13794
 *
 */
public class MaterialTradModel implements BaseIdModel {
	
	private String id;
	private String mId;   //材料商id
	private String mName;   //材料商名称
	private String itemName;  //材料名称
	private String pId;    //项目id
	private String pName;    //项目名称
	private String principal; // 委托，经办人
	private String year;     //年
	private String month;   //月
	private String day;     //日
	private String outTime;   //出库时间
	private String  outNum;     //出库量
	private String allease;     //累计出库
	private int thispay; // 本次付款
	private int culapay; // 累计付款
	private int otherpay; // 其他款
	private int restpay; // 余款 
	private String invoice; //发票情况
	private String note; // 备注
	private String drawee;    //付款人
	private String payment;   //付款方式
	private String serial;    //流水号

	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(10);
		if (id != null)
			obj.put("_id", new ObjectId(this.id));
		obj.put("mId", this.mId);
		obj.put("mName", this.mName);
		obj.put("itemName", this.itemName);
		obj.put("pId", this.pId);
		obj.put("pName", this.pName);
		obj.put("principal", this.principal);
		obj.put("year", this.year);
		obj.put("month", this.month);
		obj.put("day", this.day);
		obj.put("outTime", this.outTime);
		obj.put("outNum", this.outNum);
		obj.put("allease", this.allease);
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
		this.mId = result.getString("mId");
		this.mName = result.getString("mName");
		this.itemName = result.getString("itemName");
		this.pId = result.getString("pId");
		this.pName = result.getString("pName");
		this.principal = result.getString("principal");
		this.outTime = result.getString("outTime");
		this.outNum = result.getString("outNum");
		this.allease = result.getString("allease");
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

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getOutNum() {
		return outNum;
	}

	public void setOutNum(String outNum) {
		this.outNum = outNum;
	}

	public String getAllease() {
		return allease;
	}

	public void setAllease(String allease) {
		this.allease = allease;
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
