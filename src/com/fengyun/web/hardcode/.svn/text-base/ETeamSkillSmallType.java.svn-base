package com.fengyun.web.hardcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 班组类型
 * 
 * @author mayu
 * 
 */
public enum ETeamSkillSmallType {

	GuanLi_XMJL(201, ETeamSkillBigType.GuanLi.id, "项目经理"), GuanLi_SGY(202,
			ETeamSkillBigType.GuanLi.id, "施工员"), GuanLi_AQY(203,
			ETeamSkillBigType.GuanLi.id, "安全员"), GuanLi_ZLY(204,
			ETeamSkillBigType.GuanLi.id, "资料员"), GuanLi_CLY(205,
			ETeamSkillBigType.GuanLi.id, "测量员"), GuanLi_ZJY(206,
			ETeamSkillBigType.GuanLi.id, "造价员"), GuanLi_ZHLY(207,
			ETeamSkillBigType.GuanLi.id, "质量员"), GuanLi_CALY(208,
			ETeamSkillBigType.GuanLi.id, "材料员"), GuanLi_JXY(209,
			ETeamSkillBigType.GuanLi.id, "机械员"), GuanLi_JILI(210,
			ETeamSkillBigType.GuanLi.id, "监理"), GuanLi_GCS(211,
			ETeamSkillBigType.GuanLi.id, "工程师"), GuanLi_TBY(212,
			ETeamSkillBigType.GuanLi.id, "投标员"), GuanLi_ZXJL(213,
			ETeamSkillBigType.GuanLi.id, "执行经理"), GuanLi_SCJL(214,
			ETeamSkillBigType.GuanLi.id, "生产经理"), GuanLi_JSY(215,
			ETeamSkillBigType.GuanLi.id, "BIMB技术员"), GuanLi_SWJL(216,
			ETeamSkillBigType.GuanLi.id, "商务经理"), TuJian_WGB(101,
			ETeamSkillBigType.TuJian.id, "瓦工班"), TuJian_MGB(102,
			ETeamSkillBigType.TuJian.id, "木工班"), TuJian_GJB(103,
			ETeamSkillBigType.TuJian.id, "钢筋班"), TuJian_HNTB(104,
			ETeamSkillBigType.TuJian.id, "混凝土班"), TuJian_YQB(105,
			ETeamSkillBigType.TuJian.id, "油漆班"), TuJian_FSB(106,
			ETeamSkillBigType.TuJian.id, "防水班"), TuJian_ZSZXB(107,
			ETeamSkillBigType.TuJian.id, "装饰装修班"), TuJian_JXSBB(108,
			ETeamSkillBigType.TuJian.id, "机械设备班"), TuJian_JZB(109,
			ETeamSkillBigType.TuJian.id, "架子班"), TuJian_WJZL(110,
			ETeamSkillBigType.TuJian.id, "外架租赁"), TuJian_LMB(111,
			ETeamSkillBigType.TuJian.id, "铝模班"), TuJian_PGB(112,
			ETeamSkillBigType.TuJian.id, "普工班"), TuJian_LHJB(113,
			ETeamSkillBigType.TuJian.id, "铝合金班"), TuJian_SFBPB(114,
			ETeamSkillBigType.TuJian.id, "石方爆破班"), TuJian_GJZZSB(115,
			ETeamSkillBigType.TuJian.id, "古建筑装饰班"), TuJian_YLLHB(116,
			ETeamSkillBigType.TuJian.id, "园林绿化班"), TuJian_DJJCB(117,
			ETeamSkillBigType.TuJian.id, "地基基础班"), AnZhuang_DQSBB(301,
			ETeamSkillBigType.AnZhuang.id, "电气设备班"), AnZhuang_GPSB(302,
			ETeamSkillBigType.AnZhuang.id, "给排水班"), AnZhuang_XFKTB(303,
			ETeamSkillBigType.AnZhuang.id, "消防安装班"), AnZhuang_TFKTB(304,
			ETeamSkillBigType.AnZhuang.id, "通风空调班"), AnZhuang_RDAZB(305,
			ETeamSkillBigType.AnZhuang.id, "弱电安装班"), AnZhuang_RQAZB(306,
			ETeamSkillBigType.AnZhuang.id, "燃气安装班"), AnZhuang_DTAZB(307,
			ETeamSkillBigType.AnZhuang.id, "电梯安装班"), AnZhuang_GJGAZB(308,
			ETeamSkillBigType.AnZhuang.id, "钢结构安装班"), AnZhuang_MQAZB(309,
			ETeamSkillBigType.AnZhuang.id, "幕墙安装班"), QiTa_TDSJ(401,
			ETeamSkillBigType.QiTa.id, "塔吊司机"), QiTa_TDZH(402,
			ETeamSkillBigType.QiTa.id, "塔吊指挥"), QiTa_DCSJ(403,
			ETeamSkillBigType.QiTa.id, "吊车司机"), QiTa_SSG(404,
			ETeamSkillBigType.QiTa.id, "司索工"), QiTa_DHG(405,
			ETeamSkillBigType.QiTa.id, "电焊工"), QiTa_BA(406,
			ETeamSkillBigType.QiTa.id, "保安"), QiTa_HQ(407,
			ETeamSkillBigType.QiTa.id, "后勤"), QiTa_LWD(408,
			ETeamSkillBigType.QiTa.id, "劳务队"), ;

	public int id;
	public int bigType;
	public String desc;

	private ETeamSkillSmallType(final int id, final int bigType,
			final String desc) {
		this.id = id;
		this.bigType = bigType;
		this.desc = desc;
	}

	public static String getSkillSmallTypeName(int id) {
		for (ETeamSkillSmallType e : ETeamSkillSmallType.values()) {
			if (e.id == id)
				return e.desc;
		}
		return null;
	}

	public static List<ETeamSkillSmallType> getSkillSmallTypeId(int bigType) {
		List<ETeamSkillSmallType> list = new ArrayList<ETeamSkillSmallType>();
		for (ETeamSkillSmallType e : ETeamSkillSmallType.values()) {
			if (e.bigType == bigType)
				list.add(e);
		}
		return list;
	}

}
