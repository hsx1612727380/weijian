package com.fengyun.web.db.vo;

public class TotalVo {
	
	private String code;
	private String name;
	private int totalSalary; //总的应付工资
	private int totalRealSalary;    //总的已付工资
	private int totalNoSalary;     //总的未付工资
	private int totalTax;        //总的税款
	
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
	public int getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}
	public int getTotalRealSalary() {
		return totalRealSalary;
	}
	public void setTotalRealSalary(int totalRealSalary) {
		this.totalRealSalary = totalRealSalary;
	}
	public int getTotalNoSalary() {
		return totalNoSalary;
	}
	public void setTotalNoSalary(int totalNoSalary) {
		this.totalNoSalary = totalNoSalary;
	}
	public int getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(int totalTax) {
		this.totalTax = totalTax;
	}
	
	
	
	
	
	
	

}
