package com.fengyun.web.db.dao;

import java.util.Map;

import mmo.common.data.db.BaseFileDataModel;
import mmo.common.data.db.BaseIdModel;

import com.fengyun.web.db.playermodel.AccrecordModel;
import com.fengyun.web.db.playermodel.AdminModel;
import com.fengyun.web.db.playermodel.AptitudeModel;
import com.fengyun.web.db.playermodel.AttendanceInfoModel;
import com.fengyun.web.db.playermodel.BehaviorModel;
import com.fengyun.web.db.playermodel.BidInfoModel;
import com.fengyun.web.db.playermodel.CmdSummModel;
import com.fengyun.web.db.playermodel.CmdSummPersonModel;
import com.fengyun.web.db.playermodel.CmdSummSupplierModel;
import com.fengyun.web.db.playermodel.CommentsModel;
import com.fengyun.web.db.playermodel.CompanyCompactModel;
import com.fengyun.web.db.playermodel.CompanyModel;
import com.fengyun.web.db.playermodel.EngineerModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.EquipmentTradModel;
import com.fengyun.web.db.playermodel.JoinBuildModel;
import com.fengyun.web.db.playermodel.KeyPersonModel;
import com.fengyun.web.db.playermodel.MessageModel;
import com.fengyun.web.db.playermodel.NoticeLogModel;
import com.fengyun.web.db.playermodel.NoticeModel;
import com.fengyun.web.db.playermodel.PayrollRecordModel;
import com.fengyun.web.db.playermodel.LawInsuModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.MaterialTradModel;
import com.fengyun.web.db.playermodel.MerchantModel;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.OperateCompactModel;
import com.fengyun.web.db.playermodel.ProjectDepartmentModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.ProjectProgressModel;
import com.fengyun.web.db.playermodel.ProjectRosterModel;
import com.fengyun.web.db.playermodel.RequirementsModel;
import com.fengyun.web.db.playermodel.RewardsAndPunishModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.TeamScheduleModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.mongodb.BasicDBObject;

public class ModelTools {

	@SuppressWarnings("unchecked")
	public static <T extends BaseIdModel> T mongoToModel(String tableName,
			BasicDBObject result) {
		BaseIdModel model = null;
		if (Tables.User.equals(tableName)) {
			model = new UserModel();
		} else if (Tables.AttendanceInfo.equals(tableName)) {
			model = new AttendanceInfoModel();
		} else if (Tables.CmdSumm.equals(tableName)) {
			model = new CmdSummModel();
		} else if (Tables.Equipment.equals(tableName)) {
			model = new EquipmentModel();
		} else if (Tables.Material.equals(tableName)) {
			model = new MaterialModel();
		} else if (Tables.Merchant.equals(tableName)) {
			model = new MerchantModel();
		} else if (Tables.Team.equals(tableName)) {
			model = new TeamModel();
		} else if (Tables.TeamMember.equals(tableName)) {
			model = new TeamMemberModel();
		} else if (Tables.Project.equals(tableName)) {
			model = new ProjectModel();
		} else if (Tables.ProjectDepartment.equals(tableName)) {
			model = new ProjectDepartmentModel();
		} else if (Tables.Admin.equals(tableName)) {
			model = new AdminModel();
		} else if (Tables.Company.equals(tableName)) {
			model = new CompanyModel();
		} else if (Tables.Person.equals(tableName)) {
			model = new PersonModel();
		} else if (Tables.Comments.equals(tableName)) {
			model = new CommentsModel();
		}else if (Tables.Requirements.equals(tableName)) {
			model = new RequirementsModel();
		}else if (Tables.CmdSummPerson.equals(tableName)) {
			model = new CmdSummPersonModel();
		}else if (Tables.CmdSummSupplier.equals(tableName)) {
			model = new CmdSummSupplierModel();
		}else if (Tables.MaterialTrad.equals(tableName)) {
			model = new MaterialTradModel();
		}else if (Tables.EquipmentTrad.equals(tableName)) {
			model = new EquipmentTradModel();
		}else if (Tables.BidInfo.equals(tableName)) {
			model = new BidInfoModel();
		}else if (Tables.Aptitude.equals(tableName)) {
			model = new AptitudeModel();
		}else if (Tables.LawInsu.equals(tableName)) {
			model = new LawInsuModel();
		}else if (Tables.Engineer.equals(tableName)) {
			model = new EngineerModel();
		}else if (Tables.JoinBuild.equals(tableName)) {
			model = new JoinBuildModel();
		}else if (Tables.KeyPerson.equals(tableName)) {
			model = new KeyPersonModel();
		}else if (Tables.Accrecord.equals(tableName)) {
			model = new AccrecordModel();
		}else if (Tables.PayrollRecord.equals(tableName)) {
			model = new PayrollRecordModel();
		}else if (Tables.Behavior.equals(tableName)) {
			model = new BehaviorModel();
		}else if (Tables.RewardsAndPunish.equals(tableName)) {
			model = new RewardsAndPunishModel();
		}else if (Tables.TeamSchedule.equals(tableName)) {
			model = new TeamScheduleModel();
		}else if (Tables.ProjectProgress.equals(tableName)) {
			model = new ProjectProgressModel();
		}else if (Tables.ProjectRoster.equals(tableName)) {
			model = new ProjectRosterModel();
		}else if (Tables.ProjectCompact.equals(tableName)) {
			model = new OperateCompactModel();
		} else if (Tables.CompanyCompact.equals(tableName)) {
			model = new CompanyCompactModel();
		} else if (Tables.Message.equals(tableName)) {
			model = new MessageModel();
		} else if (Tables.Notice.equals(tableName)) {
			model = new NoticeModel();
		} else if (Tables.NoticeLog.equals(tableName)) {
			model = new NoticeLogModel();
		}

		//
		if (model != null) {
			if (result.size() >= 1)
				model.toModel(result);
			return (T) model;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T fileToModel(String tableName, Map<String, String> result) {

		BaseFileDataModel model = null;

		// if (Tables.Goods.equals(tableName)) {
		// model = new GoodsModel();
		// }

		if (model != null) {
			model.toModel(result);
			return (T) model;
		}

		return null;
	}
}
