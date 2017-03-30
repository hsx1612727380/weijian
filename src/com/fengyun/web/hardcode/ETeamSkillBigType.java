package com.fengyun.web.hardcode;


/**
 * 班组技能
 * @author mayu
 *
 */
public enum ETeamSkillBigType {

	TuJian(1,"土建"),
	GuanLi(2,"管理"),
	AnZhuang(3,"安装"),
	QiTa(4,"其他"),
	;
	
	public int id;
	public String desc;
	
	private ETeamSkillBigType(final int id,final String desc){
		this.id = id;
		this.desc = desc;
	}
	
	public static String getSkillBigTypeName(int dd){
		for(ETeamSkillBigType e : ETeamSkillBigType.values()){
			if(e.id == dd)
				return e.desc;
		}
		return null;
	}
}
