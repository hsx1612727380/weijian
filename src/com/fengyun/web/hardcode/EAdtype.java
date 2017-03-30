package com.fengyun.web.hardcode;

public enum EAdtype {
	ZhaoBiaoDaiLi(1,"招标代理"),
	ZaoJiaZiXun(2,"造价咨询"),
	MuGongZuoYe(3,"木工作业"),
	ShiGongZongChengBao(4,"施工总承包"),
	ZhuanYeChengBao(5,"专业承包"),
	LaoWuFenBao(6,"劳务分包"),
	GongChengKanChaZongHeLei(7,"工程勘察综合类"),
	GongChengKanChaZhuanYeLei(8,"工程勘察专业类"),
	GongChengKanChaLaoWuLei(9,"工程勘察劳务类"),
	ShenTu(10,"审图"),
	JianCe(11,"检测"),
	;
	
	public int id;
	public String desc;
	
	private EAdtype(final int id,final String desc){
		this.id = id;
		this.desc = desc;
	}
	
	public static String getadtypeName(int dd){
		for(EAdtype e : EAdtype.values()){
			if(e.id == dd)
				return e.desc;
		}
		return null;
	}

}
