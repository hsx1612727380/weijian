package com.fengyun.web.db.playermodel;

import java.util.Date;

import mmo.common.data.db.BaseIdModel;

import org.bson.types.ObjectId;

import com.fengyun.web.hardcode.EScore;
import com.mongodb.BasicDBObject;

/**
 * 评价
 * 包括项目对个人评价，项目对班组评价
 * @author mayu
 * 
 */
public class CommentsModel implements BaseIdModel {

	private String id;
	private String startTime;// 201509
	private String endTime;// 201509
	private String projectName;
	private String teamName;
	private String name; //项目管理——员工/班组 进退场 (12月13日)
	private int score1 = 0;//技能评价  \材料质量评价
	private int scoreStr1;
	private int score2 = 0;//勤劳评价  \材料价格评价
	private int scoreStr2;
	private int score3 = 0;//态度评价 \ 材料售后评价
	private int scoreStr3;
	private String desc;
	private Date createTime = new Date();

	private int type;// 1-个人 2-班组 3-材料商 4-设备商
	private String cId;// tId or userId （班组长cId==tId）,（个人用户cId==userId）
	private String pId; // 项目的ID
	
	@Override
	public BasicDBObject getBasicDBObject() {
		BasicDBObject obj = new BasicDBObject(23);
		if (id != null)
		obj.put("_id", new ObjectId(this.id));
		obj.put("startTime", this.startTime);
		obj.put("endTime", this.endTime);
		obj.put("projectName", this.projectName);
		obj.put("teamName", this.teamName);
		obj.put("name", this.name);
		obj.put("score1", this.score1);
		obj.put("score2", this.score2);
		obj.put("score3", this.score3);
		obj.put("desc", this.desc);
		obj.put("createTime", this.createTime);
		obj.put("type", this.type);
		obj.put("cId", this.cId);
		obj.put("pId", this.pId);
		return obj;
	}

	@Override
	public void toModel(BasicDBObject result) {
		this.id = result.getString("_id");
		this.startTime = result.getString("startTime");
		this.endTime = result.getString("endTime");
		this.projectName = result.getString("projectName");
		this.teamName = result.getString("teamName");
		this.name = result.getString("name");
		this.score1 = result.getInt("score1");
		this.score2 = result.getInt("score2");
		this.score3 = result.getInt("score3");
		this.desc = result.getString("desc");
		this.createTime = (Date) result.get("createTime");
		this.type = result.getInt("type");
		this.cId = result.getString("cId");
		this.pId = result.getString("pId");
		this.scoreStr1 = EScore.getNameByScore(score1);
		this.scoreStr2 = EScore.getNameByScore(score2);
		this.scoreStr3 = EScore.getNameByScore(score3);
	}

	public int getScoreStr1() {
		return scoreStr1;
	}

	public void setScoreStr1(int scoreStr1) {
		this.scoreStr1 = scoreStr1;
	}

	public int getScoreStr2() {
		return scoreStr2;
	}

	public void setScoreStr2(int scoreStr2) {
		this.scoreStr2 = scoreStr2;
	}

	public int getScoreStr3() {
		return scoreStr3;
	}

	public void setScoreStr3(int scoreStr3) {
		this.scoreStr3 = scoreStr3;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public int getScore3() {
		return score3;
	}

	public void setScore3(int score3) {
		this.score3 = score3;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}
	
	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

}
