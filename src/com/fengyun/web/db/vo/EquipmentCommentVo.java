package com.fengyun.web.db.vo;

import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;

public class EquipmentCommentVo {

	private EquipmentModel equipmentModel;
	private CommentsModel commentsModel;
	private ProjectDepartmentModel projectDepartmentModel;
	private int starNum;

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public CommentsModel getCommentsModel() {
		return commentsModel;
	}

	public void setCommentsModel(CommentsModel commentsModel) {
		this.commentsModel = commentsModel;
	}

	public ProjectDepartmentModel getProjectDepartmentModel() {
		return projectDepartmentModel;
	}

	public void setProjectDepartmentModel(
			ProjectDepartmentModel projectDepartmentModel) {
		this.projectDepartmentModel = projectDepartmentModel;
	}

	public int getStarNum() {
		return starNum;
	}

	public void setStarNum(int starNum) {
		this.starNum = starNum;
	}

}
