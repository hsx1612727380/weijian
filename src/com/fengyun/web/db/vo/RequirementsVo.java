package com.fengyun.web.db.vo;

import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.TeamModel;

public class RequirementsVo {

	private int starNum; // 诚信度
	private TeamModel teamModel;
	private MaterialModel materialModel;
	private EquipmentModel equipmentModel;

	public int getStarNum() {
		return starNum;
	}

	public void setStarNum(int starNum) {
		this.starNum = starNum;
	}
	
	public TeamModel getTeamModel() {
		return teamModel;
	}

	public void setTeamModel(TeamModel teamModel) {
		this.teamModel = teamModel;
	}

	public MaterialModel getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(MaterialModel materialModel) {
		this.materialModel = materialModel;
	}

	public EquipmentModel getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

}
