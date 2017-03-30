package com.fengyun.web.db.vo;

import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;

/**
 * 供应商花名册
 * 
 * @author hsx
 * 
 */
public class MaterialEquipmentRosterVo {

	private int type; // materialModel为2，equipmentModel为3
	private MaterialModel materialModel;
	private EquipmentModel equipmentModel;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
