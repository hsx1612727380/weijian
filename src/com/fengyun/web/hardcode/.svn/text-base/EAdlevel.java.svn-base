package com.fengyun.web.hardcode;

import java.util.ArrayList;
import java.util.List;

public enum EAdlevel {
	ZhaoBiaoDaiLi_JiaJi(101, EAdtype.ZhaoBiaoDaiLi.id, "甲级"),
	ZhaoBiaoDaiLi_YiJi(102, EAdtype.ZhaoBiaoDaiLi.id, "乙级"),
	ZhaoBiaoDaiLi_ZanDingJi(103, EAdtype.ZhaoBiaoDaiLi.id, "暂定级"),
	ZaoJiaZiXun_JiaJi(201, EAdtype.ZaoJiaZiXun.id, "甲级"),
	ZaoJiaZiXun_YiJi(202, EAdtype.ZaoJiaZiXun.id, "乙级"),
	MuGongZuoYe_YiJi(301, EAdtype.MuGongZuoYe.id, "一级"),
	MuGongZuoYe_ErJi(302, EAdtype.MuGongZuoYe.id, "二级"),
	ShiGongZongChengBao_TeJi(401, EAdtype.ShiGongZongChengBao.id, "特级"),
	ShiGongZongChengBao_YiJi(402, EAdtype.ShiGongZongChengBao.id, "一级"),
	ShiGongZongChengBao_ErJi(403, EAdtype.ShiGongZongChengBao.id, "二级"),
	ShiGongZongChengBao_SanJi(404, EAdtype.ShiGongZongChengBao.id, "三级"),
	ZhuanYeChengBao_YiJi(501, EAdtype.ZhuanYeChengBao.id, "一级"),
	ZhuanYeChengBao_ErJi(502, EAdtype.ZhuanYeChengBao.id, "二级"),
	ZhuanYeChengBao_SanJi(503, EAdtype.ZhuanYeChengBao.id, "三级"),
	LaoWuFenBao_SanJi(601, EAdtype.LaoWuFenBao.id, "不分等级"),
	GongChengKanChaZongHeLei_JiaJi(701, EAdtype.GongChengKanChaZongHeLei.id, "甲级"),
	GongChengKanChaZhuanYeLei_JiaJi(801, EAdtype.GongChengKanChaZhuanYeLei.id, "甲级"),
	GongChengKanChaZhuanYeLei_YiJi(802, EAdtype.GongChengKanChaZhuanYeLei.id, "乙级"),
	GongChengKanChaLaoWuLei_YiJi(902, EAdtype.GongChengKanChaLaoWuLei.id, "不分级别"),
	ShenTu_YiLei(1001, EAdtype.ShenTu.id, "一类"),
	ShenTu_ErLei(1002, EAdtype.ShenTu.id, "二类"),
	JianCe_YiJi(1101, EAdtype.JianCe.id, "一级"),
	JianCe_ErJi(1102, EAdtype.JianCe.id, "二级"),
	
	;
	
	
	
	
	
	public int id;
	public int type;
	public String desc;

	private EAdlevel(final int id, final int type,
			final String desc) {
		this.id = id;
		this.type = type;
		this.desc = desc;
	}

	public static String getadlevelName(int id) {
		for (EAdlevel e : EAdlevel.values()) {
			if (e.id == id)
				return e.desc;
		}
		return null;
	}

	public static List<EAdlevel> getEAdlevelId(int type) {
		List<EAdlevel> list = new ArrayList<EAdlevel>();
		for (EAdlevel e : EAdlevel.values()) {
			if (e.type == type)
				list.add(e);
		}
		return list;
	}

}
