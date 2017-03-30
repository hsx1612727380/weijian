package com.fengyun.web.hardcode;

public enum EUserStatus {

	Free(1,"空闲"),
	NeedJob(2,"找工作"),
	
	;
	
	public int status;
	String desc;
	
	private EUserStatus(final int status,final String desc){
		this.status = status;
		this.desc = desc;
	}
	
	
}
