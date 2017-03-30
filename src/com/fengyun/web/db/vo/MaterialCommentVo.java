package com.fengyun.web.db.vo;

import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;

public class MaterialCommentVo {

	private MaterialModel materialModel;
	private CommentsModel commentsModel;
	private ProjectDepartmentModel projectDepartmentModel;
	private int starNum;

	public MaterialModel getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(MaterialModel materialModel) {
		this.materialModel = materialModel;
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
