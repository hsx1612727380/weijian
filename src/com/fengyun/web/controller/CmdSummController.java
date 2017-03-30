package com.fengyun.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fengyun.web.db.playermodel.CmdSummModel;
import com.fengyun.web.db.playermodel.CmdSummPersonModel;
import com.fengyun.web.db.playermodel.CmdSummSupplierModel;
import com.fengyun.web.db.playermodel.EquipmentModel;
import com.fengyun.web.db.playermodel.MaterialModel;
import com.fengyun.web.db.playermodel.ProjectModel;
import com.fengyun.web.db.playermodel.TeamMemberModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.db.vo.TimeVo;
import com.fengyun.web.service.CmdSummPersonService;
import com.fengyun.web.service.CmdSummService;
import com.fengyun.web.service.CmdSummSupplierService;
import com.fengyun.web.service.EquipmentService;
import com.fengyun.web.service.MaterialService;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.ProjectService;
import com.fengyun.web.service.TeamMemberService;
import com.fengyun.web.service.TeamService;
import com.fengyun.web.service.UserService;


@Controller
public class CmdSummController {

	@Autowired
	private CmdSummService cmdsummService;
	
	
	@Autowired
	private PersonService personService;
	
	
	@Autowired
	private CmdSummPersonService cmdsummPersonService;
	
	@Autowired
	private TeamService teamService;
	
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private MaterialService materialService;
	
	
	@Autowired
	private EquipmentService equipmentService;
	
	
	@Autowired
	private CmdSummSupplierService cmdsummSupplierService;
	
	@Autowired
	private ProjectService projectService;

	
	
	@Autowired
	private  HttpServletRequest request;
	
	
	
	
	
	/**
	 * 显示项目的汇总时间
	 * @param id
	 * @return
	 */
	@RequestMapping(value="cmdsumm_time",method=RequestMethod.GET)
	public ModelAndView cmdsummSelect(String id){
		System.out.println(id);
		String pId=id;
		ProjectModel pModel = projectService.getById(id);
		ModelAndView mav = new ModelAndView("/cmdsumm/cmdsumm_time");
		//cmdsummService.addCmdSumm("584512b819f2c4f85842ccc1", "貔貅玩具进出口", "58451b0a19f2c4f85842ccc8", 1, 1, "玩具加工班组", 1000, 800, 10, "吨", 10000, 5000, 50, 5000, 5000, 0, 100, 0, "已经结算清楚", "记录在案", 2015, 1);
		//cmdsummService.addCmdSumm("584512b819f2c4f85842ccc1", "貔貅玩具进出口", "58451b0a19f2c4f85842ccc8", 1, 2, "玩具加工班组", 1000, 800, 10, "公斤", 10000, 5000, 50, 5000, 5000, 0, 100, 0, "结算清楚", "记录", 2015, 1);
		//cmdsummService.addCmdSumm("584512b819f2c4f85842ccc1", "貔貅玩具进出口", "58451b0a19f2c4f85842ccc8", 1, 3, "玩具加工班组", 1000, 800, 10, "克", 10000, 5000, 50, 5000, 5000, 0, 100, 0, "清楚", "在案", 2015, 1);
		//cmdsummService.addCmdSumm(pId, pName, tId, type, teamtype, tName, contractPrice, bgpayment, frequency, unit, total, nowTotal, percentage, thispay, culapay, remain, culPercentage, deposit, settlement, note, year, month);
		List<TimeVo> list = cmdsummService.getCmdTime(pId);
		
		if(pModel != null)
			mav.addObject("pModel",pModel);
		
		mav.addObject("pId",pId);
		mav.addObject("clist", list);
		return mav;
	}
	
	
	/**
	 * 查看（人工，材料，设备）汇总
	 * @param year
	 * @param month
	 * @param pCode
	 * @return
	 */
	@RequestMapping(value = "cmdsumm_list", method = RequestMethod.GET)
	public ModelAndView cmdsummList(int year, int month, String pId) {

		ModelAndView mav = new ModelAndView("/cmdsumm/cmdsumm_list");
		ProjectModel pModel = projectService.getById(pId);
		if(pModel != null)
			mav.addObject("pModel",pModel);
		List<CmdSummModel> list = cmdsummService.getByTime(year, month, pId);
		
		//人工
		CmdSummModel rengong_benban = new CmdSummModel();
		CmdSummModel rengong_laowu = new CmdSummModel();
		CmdSummModel rengong_zhuanye = new CmdSummModel();
		
		CmdSummModel rengongTotal = new CmdSummModel();
		//材料
		CmdSummModel cailiao_benban = new CmdSummModel();
		CmdSummModel cailiao_laowu = new CmdSummModel();
		CmdSummModel cailiao_zhuanye = new CmdSummModel();
		CmdSummModel cailiaoTotal = new CmdSummModel();
		//设备
		CmdSummModel shebei_benban = new CmdSummModel();
		CmdSummModel shebei_laowu = new CmdSummModel();
		CmdSummModel shebei_zhuanye = new CmdSummModel();
		CmdSummModel shebeiTotal = new CmdSummModel();
		// 统计人工
		for (CmdSummModel model : list) {
			//人工
			if (model.getType() == 1) {
				if (model.getTeamtype() == 1) {
					rengong_benban.setContractPrice(rengong_benban
							.getContractPrice() + model.getContractPrice());
					rengong_benban.setBgpayment(rengong_benban.getBgpayment()
							+ model.getBgpayment());
					rengong_benban.setFrequency(rengong_benban.getFrequency()
							+ model.getFrequency());
					rengong_benban.setUnit(model.getUnit());
					rengong_benban.setTotal(rengong_benban.getTotal()
							+ model.getTotal());
					rengong_benban.setNowTotal(rengong_benban.getNowTotal()
							+ model.getNowTotal());
					rengong_benban.setThispay(rengong_benban.getThispay()
							+ model.getThispay());
					rengong_benban.setCulapay(rengong_benban.getCulapay()
							+ model.getCulapay());
					rengong_benban.setRemain(rengong_benban.getRemain()
							+ model.getRemain());
					rengong_benban.setDeposit(rengong_benban.getDeposit()
							+ model.getDeposit());
					rengong_benban.setSettlement(rengong_benban.getSettlement()
							+ model.getSettlement());
					rengong_benban.setNote(rengong_benban.getNote()
							+ model.getNote() + ",");
				} else if (model.getTeamtype() == 2) {
					rengong_laowu.setContractPrice(rengong_laowu
							.getContractPrice() + model.getContractPrice());
					rengong_laowu.setBgpayment(rengong_laowu.getBgpayment()
							+ model.getBgpayment());
					rengong_laowu.setFrequency(rengong_laowu.getFrequency()
							+ model.getFrequency());
					rengong_laowu.setUnit(model.getUnit());
					rengong_laowu.setTotal(rengong_laowu.getTotal()
							+ model.getTotal());
					rengong_laowu.setNowTotal(rengong_laowu.getNowTotal()
							+ model.getNowTotal());

					rengong_laowu.setThispay(rengong_laowu.getThispay()
							+ model.getThispay());
					rengong_laowu.setCulapay(rengong_laowu.getCulapay()
							+ model.getCulapay());
					rengong_laowu.setRemain(rengong_laowu.getRemain()
							+ model.getRemain());
					rengong_laowu.setDeposit(rengong_laowu.getDeposit()
							+ model.getDeposit());
					rengong_laowu.setSettlement(rengong_laowu.getSettlement()
							+ model.getSettlement());
					rengong_laowu.setNote(rengong_laowu.getNote()
							+ model.getNote() + ",");

				} else if (model.getTeamtype() == 3) {
					rengong_zhuanye.setContractPrice(rengong_zhuanye
							.getContractPrice() + model.getContractPrice());
					rengong_zhuanye.setBgpayment(rengong_zhuanye.getBgpayment()
							+ model.getBgpayment());
					rengong_zhuanye.setFrequency(rengong_zhuanye.getFrequency()
							+ model.getFrequency());
					rengong_zhuanye.setUnit(model.getUnit());
					rengong_zhuanye.setTotal(rengong_zhuanye.getTotal()
							+ model.getTotal());
					rengong_zhuanye.setNowTotal(rengong_zhuanye.getNowTotal()
							+ model.getNowTotal());

					rengong_zhuanye.setThispay(rengong_zhuanye.getThispay()
							+ model.getThispay());
					rengong_zhuanye.setCulapay(rengong_zhuanye.getCulapay()
							+ model.getCulapay());
					rengong_zhuanye.setRemain(rengong_zhuanye.getRemain()
							+ model.getRemain());
					rengong_zhuanye.setDeposit(rengong_zhuanye.getDeposit()
							+ model.getDeposit());
					rengong_zhuanye.setSettlement(rengong_zhuanye
							.getSettlement() + model.getSettlement());
					rengong_zhuanye.setNote(rengong_zhuanye.getNote()
							+ model.getNote() + ",");
					rengong_zhuanye.setYear(model.getYear());
					rengong_zhuanye.setMonth(model.getMonth());
					rengong_zhuanye.setpId(model.getpId());
					rengong_zhuanye.setTeamtype(model.getTeamtype());

				}
				// 材料
			} else if (model.getType() == 2) {
				if (model.getTeamtype() == 1) {
					cailiao_benban.setContractPrice(cailiao_benban
							.getContractPrice() + model.getContractPrice());
					cailiao_benban.setBgpayment(cailiao_benban.getBgpayment()
							+ model.getBgpayment());
					cailiao_benban.setFrequency(cailiao_benban.getFrequency()
							+ model.getFrequency());
					cailiao_benban.setUnit(model.getUnit());
					cailiao_benban.setTotal(cailiao_benban.getTotal()
							+ model.getTotal());
					cailiao_benban.setNowTotal(cailiao_benban.getNowTotal()
							+ model.getNowTotal());

					cailiao_benban.setThispay(cailiao_benban.getThispay()
							+ model.getThispay());
					cailiao_benban.setCulapay(cailiao_benban.getCulapay()
							+ model.getCulapay());
					cailiao_benban.setRemain(cailiao_benban.getRemain()
							+ model.getRemain());
					cailiao_benban.setDeposit(cailiao_benban.getDeposit()
							+ model.getDeposit());
					cailiao_benban.setSettlement(cailiao_benban.getSettlement()
							+ model.getSettlement());
					cailiao_benban.setNote(cailiao_benban.getNote()
							+ model.getNote() + ",");
				} else if (model.getTeamtype() == 2) {
					cailiao_laowu.setContractPrice(cailiao_laowu
							.getContractPrice() + model.getContractPrice());
					cailiao_laowu.setBgpayment(cailiao_laowu.getBgpayment()
							+ model.getBgpayment());
					cailiao_laowu.setFrequency(cailiao_laowu.getFrequency()
							+ model.getFrequency());
					cailiao_laowu.setUnit(model.getUnit());
					cailiao_laowu.setTotal(cailiao_laowu.getTotal()
							+ model.getTotal());
					cailiao_laowu.setNowTotal(cailiao_laowu.getNowTotal()
							+ model.getNowTotal());

					cailiao_laowu.setThispay(cailiao_laowu.getThispay()
							+ model.getThispay());
					cailiao_laowu.setCulapay(cailiao_laowu.getCulapay()
							+ model.getCulapay());
					cailiao_laowu.setRemain(cailiao_laowu.getRemain()
							+ model.getRemain());
					cailiao_laowu.setDeposit(cailiao_laowu.getDeposit()
							+ model.getDeposit());
					cailiao_laowu.setSettlement(cailiao_laowu.getSettlement()
							+ model.getSettlement());
					cailiao_laowu.setNote(cailiao_laowu.getNote()
							+ model.getNote() + ",");

				} else if (model.getTeamtype() == 3) {
					cailiao_zhuanye.setContractPrice(cailiao_zhuanye
							.getContractPrice() + model.getContractPrice());
					cailiao_zhuanye.setBgpayment(cailiao_zhuanye.getBgpayment()
							+ model.getBgpayment());
					cailiao_zhuanye.setFrequency(cailiao_zhuanye.getFrequency()
							+ model.getFrequency());
					cailiao_zhuanye.setUnit(model.getUnit());
					cailiao_zhuanye.setTotal(cailiao_zhuanye.getTotal()
							+ model.getTotal());
					cailiao_zhuanye.setNowTotal(cailiao_zhuanye.getNowTotal()
							+ model.getNowTotal());

					cailiao_zhuanye.setThispay(cailiao_zhuanye.getThispay()
							+ model.getThispay());
					cailiao_zhuanye.setCulapay(cailiao_zhuanye.getCulapay()
							+ model.getCulapay());
					cailiao_zhuanye.setRemain(cailiao_zhuanye.getRemain()
							+ model.getRemain());
					cailiao_zhuanye.setDeposit(cailiao_zhuanye.getDeposit()
							+ model.getDeposit());
					cailiao_zhuanye.setSettlement(cailiao_zhuanye
							.getSettlement() + model.getSettlement());
					cailiao_zhuanye.setNote(cailiao_zhuanye.getNote()
							+ model.getNote() + ",");

				}
				// 设备
			} else if (model.getType() == 3) {
				if (model.getTeamtype() == 1) {
					shebei_benban.setContractPrice(shebei_benban
							.getContractPrice() + model.getContractPrice());
					shebei_benban.setBgpayment(shebei_benban.getBgpayment()
							+ model.getBgpayment());
					shebei_benban.setFrequency(shebei_benban.getFrequency()
							+ model.getFrequency());
					shebei_benban.setUnit(model.getUnit());
					shebei_benban.setTotal(shebei_benban.getTotal()
							+ model.getTotal());
					shebei_benban.setNowTotal(shebei_benban.getNowTotal()
							+ model.getNowTotal());

					shebei_benban.setThispay(shebei_benban.getThispay()
							+ model.getThispay());
					shebei_benban.setCulapay(shebei_benban.getCulapay()
							+ model.getCulapay());
					shebei_benban.setRemain(shebei_benban.getRemain()
							+ model.getRemain());
					shebei_benban.setDeposit(shebei_benban.getDeposit()
							+ model.getDeposit());
					shebei_benban.setSettlement(shebei_benban.getSettlement()
							+ model.getSettlement());
					shebei_benban.setNote(shebei_benban.getNote()
							+ model.getNote() + ",");
				} else if (model.getTeamtype() == 2) {
					shebei_laowu.setContractPrice(shebei_laowu
							.getContractPrice() + model.getContractPrice());
					shebei_laowu.setBgpayment(shebei_laowu.getBgpayment()
							+ model.getBgpayment());
					shebei_laowu.setFrequency(shebei_laowu.getFrequency()
							+ model.getFrequency());
					shebei_laowu.setUnit(model.getUnit());
					shebei_laowu.setTotal(shebei_laowu.getTotal()
							+ model.getTotal());
					shebei_laowu.setNowTotal(shebei_laowu.getNowTotal()
							+ model.getNowTotal());

					shebei_laowu.setThispay(shebei_laowu.getThispay()
							+ model.getThispay());
					shebei_laowu.setCulapay(shebei_laowu.getCulapay()
							+ model.getCulapay());
					shebei_laowu.setRemain(shebei_laowu.getRemain()
							+ model.getRemain());
					shebei_laowu.setDeposit(shebei_laowu.getDeposit()
							+ model.getDeposit());
					shebei_laowu.setSettlement(shebei_laowu.getSettlement()
							+ model.getSettlement());
					shebei_laowu.setNote(shebei_laowu.getNote()
							+ model.getNote() + ",");

				} else if (model.getTeamtype() == 3) {
					shebei_zhuanye.setContractPrice(shebei_zhuanye
							.getContractPrice() + model.getContractPrice());
					shebei_zhuanye.setBgpayment(shebei_zhuanye.getBgpayment()
							+ model.getBgpayment());
					shebei_zhuanye.setFrequency(shebei_zhuanye.getFrequency()
							+ model.getFrequency());
					shebei_zhuanye.setUnit(model.getUnit());
					shebei_zhuanye.setTotal(shebei_zhuanye.getTotal()
							+ model.getTotal());
					shebei_zhuanye.setNowTotal(shebei_zhuanye.getNowTotal()
							+ model.getNowTotal());

					shebei_zhuanye.setThispay(shebei_zhuanye.getThispay()
							+ model.getThispay());
					shebei_zhuanye.setCulapay(shebei_zhuanye.getCulapay()
							+ model.getCulapay());
					shebei_zhuanye.setRemain(shebei_zhuanye.getRemain()
							+ model.getRemain());
					shebei_zhuanye.setDeposit(shebei_zhuanye.getDeposit()
							+ model.getDeposit());
					shebei_zhuanye.setSettlement(shebei_zhuanye.getSettlement()
							+ model.getSettlement());
					shebei_zhuanye.setNote(shebei_zhuanye.getNote()
							+ model.getNote() + ",");

				}
			}

		}
		if(rengong_benban.getTotal() != 0)
			rengong_benban.setPercentage(rengong_benban.getNowTotal() * 100 / rengong_benban.getTotal());
		if(rengong_benban.getCulapay() + rengong_benban.getRemain() != 0)
			rengong_benban.setCulPercentage(rengong_benban.getCulapay() * 100 / (rengong_benban.getCulapay() + rengong_benban.getRemain()));
		if(rengong_laowu.getTotal() != 0)
			rengong_laowu.setPercentage(rengong_laowu.getNowTotal() * 100 / rengong_laowu.getTotal());
		if(rengong_laowu.getCulapay() + rengong_laowu.getRemain() != 0)
			rengong_laowu.setCulPercentage(rengong_laowu.getCulapay() * 100 / (rengong_laowu.getCulapay() + rengong_laowu.getRemain()));
		if(rengong_zhuanye.getTotal() != 0)
			rengong_zhuanye.setPercentage(rengong_zhuanye.getNowTotal() * 100 / rengong_zhuanye.getTotal());
		if(rengong_zhuanye.getCulapay() + rengong_zhuanye.getRemain() != 0)
			rengong_zhuanye.setCulPercentage(rengong_zhuanye.getCulapay() * 100 / (rengong_zhuanye.getCulapay() + rengong_zhuanye.getRemain()));
		
		rengongTotal.setContractPrice(rengong_benban
				.getContractPrice() + rengong_laowu.getContractPrice() + rengong_zhuanye.getContractPrice());
		rengongTotal.setBgpayment(rengong_benban.getBgpayment() + rengong_laowu.getBgpayment() + rengong_zhuanye.getBgpayment());
		rengongTotal.setFrequency(rengong_benban.getFrequency() + rengong_laowu.getFrequency() + rengong_zhuanye.getFrequency());
		rengongTotal.setUnit(rengong_benban.getUnit());
		rengongTotal.setTotal(rengong_benban.getTotal() + rengong_laowu.getTotal() + rengong_zhuanye.getTotal());
		rengongTotal.setNowTotal(rengong_benban.getNowTotal() + rengong_laowu.getNowTotal() + rengong_zhuanye.getNowTotal());
		rengongTotal.setThispay(rengong_benban.getThispay() + rengong_laowu.getThispay() + rengong_zhuanye.getThispay());
		rengongTotal.setCulapay(rengong_benban.getCulapay() + rengong_laowu.getCulapay() + rengong_zhuanye.getCulapay());
		rengongTotal.setRemain(rengong_benban.getRemain() + rengong_laowu.getRemain() + rengong_zhuanye.getRemain());
		rengongTotal.setDeposit(rengong_benban.getDeposit() + rengong_laowu.getDeposit() + rengong_zhuanye.getDeposit());
		rengongTotal.setSettlement(rengong_benban.getSettlement() + rengong_laowu.getSettlement() + rengong_zhuanye.getSettlement());
		rengongTotal.setNote(rengong_benban.getNote() + rengong_laowu.getNote() + rengong_zhuanye.getNote());
		if(rengongTotal.getTotal() != 0)
			rengongTotal.setPercentage(rengongTotal.getNowTotal() * 100 / rengongTotal.getTotal());
		if(rengongTotal.getCulapay() + rengongTotal.getRemain() != 0)
			rengongTotal.setCulPercentage(rengongTotal.getCulapay() * 100 / (rengongTotal.getCulapay() + rengongTotal.getRemain()));
		
		//////////////////////////////////////////////////////////////////////////////////
		if(cailiao_benban.getTotal() != 0)
			cailiao_benban.setPercentage(cailiao_benban.getNowTotal() * 100 / cailiao_benban.getTotal());
		if(cailiao_benban.getCulapay() + cailiao_benban.getRemain() != 0)
			cailiao_benban.setCulPercentage(cailiao_benban.getCulapay() * 100 / (cailiao_benban.getCulapay() + cailiao_benban.getRemain()));
		if(cailiao_laowu.getTotal() != 0)
			cailiao_laowu.setPercentage(cailiao_laowu.getNowTotal() * 100 / cailiao_laowu.getTotal());
		if(cailiao_laowu.getCulapay() + cailiao_laowu.getRemain() != 0)
			cailiao_laowu.setCulPercentage(cailiao_laowu.getCulapay() * 100 / (cailiao_laowu.getCulapay() + cailiao_laowu.getRemain()));
		if(cailiao_zhuanye.getTotal() != 0)
			cailiao_zhuanye.setPercentage(cailiao_zhuanye.getNowTotal() * 100 / cailiao_zhuanye.getTotal());
		if(cailiao_zhuanye.getCulapay() + cailiao_zhuanye.getRemain() != 0)
			cailiao_zhuanye.setCulPercentage(cailiao_zhuanye.getCulapay() * 100 / (cailiao_zhuanye.getCulapay() + cailiao_zhuanye.getRemain()));
		
		cailiaoTotal.setContractPrice(cailiao_benban
				.getContractPrice() + cailiao_laowu.getContractPrice() + cailiao_zhuanye.getContractPrice());
		cailiaoTotal.setBgpayment(cailiao_benban.getBgpayment() + cailiao_laowu.getBgpayment() + cailiao_zhuanye.getBgpayment());
		cailiaoTotal.setFrequency(cailiao_benban.getFrequency() + cailiao_laowu.getFrequency() + cailiao_zhuanye.getFrequency());
		cailiaoTotal.setUnit(cailiao_benban.getUnit());
		cailiaoTotal.setTotal(cailiao_benban.getTotal() + cailiao_laowu.getTotal() + cailiao_zhuanye.getTotal());
		cailiaoTotal.setNowTotal(cailiao_benban.getNowTotal() + cailiao_laowu.getNowTotal() + cailiao_zhuanye.getNowTotal());
		cailiaoTotal.setThispay(cailiao_benban.getThispay() + cailiao_laowu.getThispay() + cailiao_zhuanye.getThispay());
		cailiaoTotal.setCulapay(cailiao_benban.getCulapay() + cailiao_laowu.getCulapay() + cailiao_zhuanye.getCulapay());
		cailiaoTotal.setRemain(cailiao_benban.getRemain() + cailiao_laowu.getRemain() + cailiao_zhuanye.getRemain());
		cailiaoTotal.setDeposit(cailiao_benban.getDeposit() + cailiao_laowu.getDeposit() + cailiao_zhuanye.getDeposit());
		cailiaoTotal.setSettlement(cailiao_benban.getSettlement() + cailiao_laowu.getSettlement() + cailiao_zhuanye.getSettlement());
		cailiaoTotal.setNote(cailiao_benban.getNote() + cailiao_laowu.getNote() + cailiao_zhuanye.getNote());
		if(cailiaoTotal.getTotal() != 0)
			cailiaoTotal.setPercentage(cailiaoTotal.getNowTotal() * 100 / cailiaoTotal.getTotal());
		if(cailiaoTotal.getCulapay() + cailiaoTotal.getRemain() != 0)
			cailiaoTotal.setCulPercentage(cailiaoTotal.getCulapay() * 100 / (cailiaoTotal.getCulapay() + cailiaoTotal.getRemain()));
		//////////////////////////////////////////////////////////////////////////
		if(shebei_benban.getTotal() != 0)
			shebei_benban.setPercentage(shebei_benban.getNowTotal() * 100 / shebei_benban.getTotal());
		if(shebei_benban.getCulapay() + shebei_benban.getRemain() != 0)
			shebei_benban.setCulPercentage(shebei_benban.getCulapay() * 100 / (shebei_benban.getCulapay() + shebei_benban.getRemain()));
		if(shebei_laowu.getTotal() != 0)
			shebei_laowu.setPercentage(shebei_laowu.getNowTotal() * 100 / shebei_laowu.getTotal());
		if(shebei_laowu.getCulapay() + shebei_laowu.getRemain() != 0)
			shebei_laowu.setCulPercentage(shebei_laowu.getCulapay() * 100 / (shebei_laowu.getCulapay() + shebei_laowu.getRemain()));
		if(shebei_zhuanye.getTotal() != 0)
			shebei_zhuanye.setPercentage(shebei_zhuanye.getNowTotal() * 100 / shebei_zhuanye.getTotal());
		if(shebei_zhuanye.getCulapay() + shebei_zhuanye.getRemain() != 0)
			shebei_zhuanye.setCulPercentage(shebei_zhuanye.getCulapay() * 100 / (shebei_zhuanye.getCulapay() + shebei_zhuanye.getRemain()));
		shebeiTotal.setContractPrice(shebei_benban
				.getContractPrice() + shebei_laowu.getContractPrice() + shebei_zhuanye.getContractPrice());
		shebeiTotal.setBgpayment(shebei_benban.getBgpayment() + shebei_laowu.getBgpayment() + shebei_zhuanye.getBgpayment());
		shebeiTotal.setFrequency(shebei_benban.getFrequency() + shebei_laowu.getFrequency() + shebei_zhuanye.getFrequency());
		shebeiTotal.setUnit(shebei_benban.getUnit());
		shebeiTotal.setTotal(shebei_benban.getTotal() + shebei_laowu.getTotal() + shebei_zhuanye.getTotal());
		shebeiTotal.setNowTotal(shebei_benban.getNowTotal() + shebei_laowu.getNowTotal() + cailiao_zhuanye.getNowTotal());
		shebeiTotal.setThispay(shebei_benban.getThispay() + shebei_laowu.getThispay() + shebei_zhuanye.getThispay());
		shebeiTotal.setCulapay(shebei_benban.getCulapay() + shebei_laowu.getCulapay() + shebei_zhuanye.getCulapay());
		shebeiTotal.setRemain(shebei_benban.getRemain() + shebei_laowu.getRemain() + shebei_zhuanye.getRemain());
		shebeiTotal.setDeposit(shebei_benban.getDeposit() + shebei_laowu.getDeposit() + shebei_zhuanye.getDeposit());
		shebeiTotal.setSettlement(shebei_benban.getSettlement() + shebei_laowu.getSettlement() + shebei_zhuanye.getSettlement());
		shebeiTotal.setNote(shebei_benban.getNote() + shebei_laowu.getNote() + shebei_zhuanye.getNote());
		if(shebeiTotal.getTotal() != 0)
			shebeiTotal.setPercentage(shebeiTotal.getNowTotal() * 100 / shebeiTotal.getTotal());
		if(shebeiTotal.getCulapay() + shebeiTotal.getRemain() != 0)
			shebeiTotal.setCulPercentage(shebeiTotal.getCulapay() * 100 / (shebeiTotal.getCulapay() + shebeiTotal.getRemain()));
		mav.addObject("rengong_zhuanye",rengong_zhuanye);
		mav.addObject("cailiao_zhuanye",cailiao_zhuanye);
		mav.addObject("shebei_zhuanye",shebei_zhuanye);
		mav.addObject("shebei_laowu",shebei_laowu);
		mav.addObject("rengong_laowu",rengong_laowu);
		mav.addObject("cailiao_laowu", cailiao_laowu);
		mav.addObject("rengong_benban",rengong_benban);
		mav.addObject("shebei_benban",shebei_benban);
		mav.addObject("cailiao_benban",cailiao_benban);
		mav.addObject("rengongTotal", rengongTotal);
		mav.addObject("cailiaoTotal", cailiaoTotal);
		mav.addObject("shebeiTotal", shebeiTotal);
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("pId", pId);
		
		return mav;
	}
	
	/**
	 * 查看人工汇总
	 * @param year
	 * @param month
	 * @param pCode
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "personsummary_list", method = RequestMethod.GET)
	public ModelAndView cmdsummPerson(int year, int month, String pId,
			int type) {

		ModelAndView mav = new ModelAndView("/cmdsumm/personsummary_list");
		ProjectModel pModel = projectService.getById(pId);
		if(pModel != null)
			mav.addObject("pModel",pModel);
		
		List<CmdSummModel> list = cmdsummService.getByType(year, month, pId,
				type);
		List<CmdSummModel> benban = new ArrayList<CmdSummModel>();
		List<CmdSummModel> laowu = new ArrayList<CmdSummModel>();
		List<CmdSummModel> zhuanye = new ArrayList<CmdSummModel>();
		
		CmdSummModel benbanTotal = new CmdSummModel();
		CmdSummModel laowuTotal = new CmdSummModel();
		CmdSummModel zhuanyeTotal = new CmdSummModel();
		
		if(list != null && list.size() > 0){
			for(CmdSummModel model:list){
				if(model.getTeamtype() == 1){
					benban.add(model);
					benbanTotal.setContractPrice(benbanTotal
							.getContractPrice() + model.getContractPrice());
					benbanTotal.setBgpayment(benbanTotal.getBgpayment() + model.getBgpayment());
					benbanTotal.setFrequency(benbanTotal.getFrequency() + model.getFrequency());
					benbanTotal.setUnit(model.getUnit());
					benbanTotal.setTotal(benbanTotal.getTotal() + model.getTotal());
					benbanTotal.setNowTotal(benbanTotal.getNowTotal() + model.getNowTotal());
					benbanTotal.setThispay(benbanTotal.getThispay() + model.getThispay());
					benbanTotal.setCulapay(benbanTotal.getCulapay() + model.getCulapay());
					benbanTotal.setRemain(benbanTotal.getRemain() + model.getRemain());
					benbanTotal.setDeposit(benbanTotal.getDeposit() + model.getDeposit());
					benbanTotal.setSettlement(benbanTotal.getSettlement() + model.getSettlement());
					benbanTotal.setNote(benbanTotal.getNote() + model.getNote());
					if(benbanTotal.getTotal() != 0)
						benbanTotal.setPercentage(benbanTotal.getNowTotal() * 100 / benbanTotal.getTotal());
					if(benbanTotal.getCulapay() + benbanTotal.getRemain() != 0)
						benbanTotal.setCulPercentage(benbanTotal.getCulapay() * 100 / (benbanTotal.getCulapay() + benbanTotal.getRemain()));
				}else if(model.getTeamtype() == 2){
					laowu.add(model);
					laowuTotal.setContractPrice(laowuTotal
							.getContractPrice() + model.getContractPrice());
					laowuTotal.setBgpayment(laowuTotal.getBgpayment() + model.getBgpayment());
					laowuTotal.setFrequency(laowuTotal.getFrequency() + model.getFrequency());
					laowuTotal.setUnit(model.getUnit());
					laowuTotal.setTotal(laowuTotal.getTotal() + model.getTotal());
					laowuTotal.setNowTotal(laowuTotal.getNowTotal() + model.getNowTotal());
					laowuTotal.setThispay(laowuTotal.getThispay() + model.getThispay());
					laowuTotal.setCulapay(laowuTotal.getCulapay() + model.getCulapay());
					laowuTotal.setRemain(laowuTotal.getRemain() + model.getRemain());
					laowuTotal.setDeposit(laowuTotal.getDeposit() + model.getDeposit());
					laowuTotal.setSettlement(laowuTotal.getSettlement() + model.getSettlement());
					laowuTotal.setNote(laowuTotal.getNote() + model.getNote());
					if(laowuTotal.getTotal() != 0)
						laowuTotal.setPercentage(laowuTotal.getNowTotal() * 100 / laowuTotal.getTotal());
					if(laowuTotal.getCulapay() + laowuTotal.getRemain() != 0)
						laowuTotal.setCulPercentage(laowuTotal.getCulapay() * 100 / (laowuTotal.getCulapay() + laowuTotal.getRemain()));
				}else if(model.getTeamtype() == 3){
					zhuanye.add(model);
					zhuanyeTotal.setContractPrice(zhuanyeTotal
							.getContractPrice() + model.getContractPrice());
					zhuanyeTotal.setBgpayment(zhuanyeTotal.getBgpayment() + model.getBgpayment());
					zhuanyeTotal.setFrequency(zhuanyeTotal.getFrequency() + model.getFrequency());
					zhuanyeTotal.setUnit(model.getUnit());
					zhuanyeTotal.setTotal(zhuanyeTotal.getTotal() + model.getTotal());
					zhuanyeTotal.setNowTotal(zhuanyeTotal.getNowTotal() + model.getNowTotal());
					zhuanyeTotal.setThispay(zhuanyeTotal.getThispay() + model.getThispay());
					zhuanyeTotal.setCulapay(zhuanyeTotal.getCulapay() + model.getCulapay());
					zhuanyeTotal.setRemain(zhuanyeTotal.getRemain() + model.getRemain());
					zhuanyeTotal.setDeposit(zhuanyeTotal.getDeposit() + model.getDeposit());
					zhuanyeTotal.setSettlement(zhuanyeTotal.getSettlement() + model.getSettlement());
					zhuanyeTotal.setNote(zhuanyeTotal.getNote() + model.getNote());
					if(zhuanyeTotal.getTotal() != 0)
						zhuanyeTotal.setPercentage(zhuanyeTotal.getNowTotal() * 100 / zhuanyeTotal.getTotal());
					if(zhuanyeTotal.getCulapay() + zhuanyeTotal.getRemain() != 0)
						zhuanyeTotal.setCulPercentage(zhuanyeTotal.getCulapay() * 100 / (zhuanyeTotal.getCulapay() + zhuanyeTotal.getRemain()));
				}
			}
		}
		
		mav.addObject("benban", benban);
		mav.addObject("laowu", laowu);
		mav.addObject("zhuanye", zhuanye);
		mav.addObject("benbanTotal", benbanTotal);
		mav.addObject("laowuTotal", laowuTotal);
		mav.addObject("zhuanyeTotal", zhuanyeTotal);
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("pId", pId);
		return mav;

	}
	
	
	/**
	 * 查看材料，设备商汇总
	 * @param year
	 * @param month
	 * @param pCode
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "suppliersummary_list", method = RequestMethod.GET)
	public ModelAndView cmdsummSupplier(int year, int month, String pId,
			int type) {
		ModelAndView mav = new ModelAndView("/cmdsumm/suppliersummary_list");
		ProjectModel pModel = projectService.getById(pId);
		if(pModel != null)
			mav.addObject("pModel",pModel);
		
		List<CmdSummModel> list = cmdsummService.getByType(year, month, pId,
				type);
		List<CmdSummModel> benban = new ArrayList<CmdSummModel>();
		List<CmdSummModel> laowu = new ArrayList<CmdSummModel>();
		List<CmdSummModel> zhuanye = new ArrayList<CmdSummModel>();
		
		CmdSummModel benbanTotal = new CmdSummModel();
		CmdSummModel laowuTotal = new CmdSummModel();
		CmdSummModel zhuanyeTotal = new CmdSummModel();
		
		if(list != null && list.size() > 0){
			for(CmdSummModel model:list){
				if(model.getTeamtype() == 1){
					benban.add(model);
					benbanTotal.setContractPrice(benbanTotal
							.getContractPrice() + model.getContractPrice());
					benbanTotal.setBgpayment(benbanTotal.getBgpayment() + model.getBgpayment());
					benbanTotal.setFrequency(benbanTotal.getFrequency() + model.getFrequency());
					benbanTotal.setUnit(model.getUnit());
					benbanTotal.setTotal(benbanTotal.getTotal() + model.getTotal());
					benbanTotal.setNowTotal(benbanTotal.getNowTotal() + model.getNowTotal());
					benbanTotal.setThispay(benbanTotal.getThispay() + model.getThispay());
					benbanTotal.setCulapay(benbanTotal.getCulapay() + model.getCulapay());
					benbanTotal.setRemain(benbanTotal.getRemain() + model.getRemain());
					benbanTotal.setDeposit(benbanTotal.getDeposit() + model.getDeposit());
					benbanTotal.setSettlement(benbanTotal.getSettlement() + model.getSettlement());
					benbanTotal.setNote(benbanTotal.getNote() + model.getNote());
					if(benbanTotal.getTotal() != 0)
						benbanTotal.setPercentage(benbanTotal.getNowTotal() * 100 / benbanTotal.getTotal());
					if(benbanTotal.getCulapay() + benbanTotal.getRemain() != 0)
						benbanTotal.setCulPercentage(benbanTotal.getCulapay() * 100 / (benbanTotal.getCulapay() + benbanTotal.getRemain()));
				}else if(model.getTeamtype() == 2){
					laowu.add(model);
					laowuTotal.setContractPrice(laowuTotal
							.getContractPrice() + model.getContractPrice());
					laowuTotal.setBgpayment(laowuTotal.getBgpayment() + model.getBgpayment());
					laowuTotal.setFrequency(laowuTotal.getFrequency() + model.getFrequency());
					laowuTotal.setUnit(model.getUnit());
					laowuTotal.setTotal(laowuTotal.getTotal() + model.getTotal());
					laowuTotal.setNowTotal(laowuTotal.getNowTotal() + model.getNowTotal());
					laowuTotal.setThispay(laowuTotal.getThispay() + model.getThispay());
					laowuTotal.setCulapay(laowuTotal.getCulapay() + model.getCulapay());
					laowuTotal.setRemain(laowuTotal.getRemain() + model.getRemain());
					laowuTotal.setDeposit(laowuTotal.getDeposit() + model.getDeposit());
					laowuTotal.setSettlement(laowuTotal.getSettlement() + model.getSettlement());
					laowuTotal.setNote(laowuTotal.getNote() + model.getNote());
					if(laowuTotal.getTotal() != 0)
						laowuTotal.setPercentage(laowuTotal.getNowTotal() * 100 / laowuTotal.getTotal());
					if(laowuTotal.getCulapay() + laowuTotal.getRemain() != 0)
						laowuTotal.setCulPercentage(laowuTotal.getCulapay() * 100 / (laowuTotal.getCulapay() + laowuTotal.getRemain()));
				}else if(model.getTeamtype() == 3){
					zhuanye.add(model);
					zhuanyeTotal.setContractPrice(zhuanyeTotal
							.getContractPrice() + model.getContractPrice());
					zhuanyeTotal.setBgpayment(zhuanyeTotal.getBgpayment() + model.getBgpayment());
					zhuanyeTotal.setFrequency(zhuanyeTotal.getFrequency() + model.getFrequency());
					zhuanyeTotal.setUnit(model.getUnit());
					zhuanyeTotal.setTotal(zhuanyeTotal.getTotal() + model.getTotal());
					zhuanyeTotal.setNowTotal(zhuanyeTotal.getNowTotal() + model.getNowTotal());
					zhuanyeTotal.setThispay(zhuanyeTotal.getThispay() + model.getThispay());
					zhuanyeTotal.setCulapay(zhuanyeTotal.getCulapay() + model.getCulapay());
					zhuanyeTotal.setRemain(zhuanyeTotal.getRemain() + model.getRemain());
					zhuanyeTotal.setDeposit(zhuanyeTotal.getDeposit() + model.getDeposit());
					zhuanyeTotal.setSettlement(zhuanyeTotal.getSettlement() + model.getSettlement());
					zhuanyeTotal.setNote(zhuanyeTotal.getNote() + model.getNote());
					if(zhuanyeTotal.getTotal() != 0)
						zhuanyeTotal.setPercentage(zhuanyeTotal.getNowTotal() * 100 / zhuanyeTotal.getTotal());
					if(zhuanyeTotal.getCulapay() + zhuanyeTotal.getRemain() != 0)
						zhuanyeTotal.setCulPercentage(zhuanyeTotal.getCulapay() * 100 / (zhuanyeTotal.getCulapay() + zhuanyeTotal.getRemain()));
				}
			}
		}
		
		mav.addObject("benban", benban);
		mav.addObject("laowu", laowu);
		mav.addObject("zhuanye", zhuanye);
		mav.addObject("benbanTotal", benbanTotal);
		mav.addObject("laowuTotal", laowuTotal);
		mav.addObject("zhuanyeTotal", zhuanyeTotal);
		mav.addObject("year", year);
		mav.addObject("month", month);
		mav.addObject("pId", pId);
		if(type == 2){
			mav.addObject("type", "材料商");
		}else if(type == 3){
			mav.addObject("type", "设备商");
		}
		return mav;

	}
	/**
	 * 新增人工费汇总
	 */
	@RequestMapping(value="personsummary_add",method=RequestMethod.GET)
	public String addCmdSummPerson(String pId ,String pName){
		
		System.out.println("pId--------------："+pId);
		System.out.println("pName--------------："+pName);
		request.setAttribute("pId", pId);
		request.setAttribute("pName", pName);
		return "/cmdsumm/personsummary_add";
	}
	
	
	@RequestMapping(value="personsummary_add2",method=RequestMethod.POST)
	public ModelAndView addCmdSummPerson2(String pId ,String pName){
		System.out.println("++++++++++++++++++++:"+pId);
		System.out.println("++++++++++++++++++++:"+pName);
		long tNum ;
		if(StringUtils.isBlank(request.getParameter("tNum"))){
			tNum = 0;
		} else {
			tNum = Long.parseLong(request.getParameter("tNum"));
		}
		TeamModel teamModel = teamService.getTeamByCode(tNum);
		String tId;
		if(teamModel != null){
			tId =teamModel.getId();
		} else {
			ModelAndView mav = new ModelAndView("/cmdsumm/add_cmdsummperson");
			return mav;
		}
		int teamtype =Integer.parseInt(request.getParameter("teamtype"));
		String tName = request.getParameter("tName");
		int contractPrice;
		if("".equals(request.getParameter("contractPrice"))){
			contractPrice = 0;
		} else {
			contractPrice = Integer.parseInt(request.getParameter("contractPrice"));
		}
		int bgpayment;
		if("".equals(request.getParameter("bgpayment"))){
			bgpayment = 0;
		} else {
			bgpayment = Integer.parseInt(request.getParameter("bgpayment"));
		}
		int frequency;
		if("".equals(request.getParameter("frequency"))){
			frequency = 0;
		} else {
			frequency = Integer.parseInt(request.getParameter("frequency"));
		}
		int total;
		if("".equals(request.getParameter("total"))){
			total = 0;
		} else {
			total = Integer.parseInt(request.getParameter("total"));
		}
		int nowTotal;
		if("".equals(request.getParameter("nowTotal"))){
			nowTotal = 0;
		} else {
			nowTotal = Integer.parseInt(request.getParameter("nowTotal"));
		}
		int percentage;
		if("".equals(request.getParameter("percentage"))){
			percentage = 0;
		} else {
			percentage = Integer.parseInt(request.getParameter("percentage"));
		}
		int thispay;
		if("".equals(request.getParameter("thispay"))){
			thispay = 0;
		} else {
			thispay = Integer.parseInt(request.getParameter("thispay"));
		}
		int culapay;
		if("".equals(request.getParameter("culapay"))){
			culapay = 0;
		} else {
			culapay = Integer.parseInt(request.getParameter("culapay"));
		}
		int thisSalary;
		if("".equals(request.getParameter("thisSalary"))){
			thisSalary = 0;
		} else {
			thisSalary = Integer.parseInt(request.getParameter("thisSalary"));
		}
		int noSalary;
		if("".equals(request.getParameter("noSalary"))){
			noSalary = 0;
		} else {
			noSalary = Integer.parseInt(request.getParameter("noSalary"));
		}
		int remain;
		if("".equals(request.getParameter("remain"))){
			remain = 0;
		} else {
			remain = Integer.parseInt(request.getParameter("remain"));
		}
		int deposit;
		if("".equals(request.getParameter("deposit"))){
			deposit = 0;
		} else {
			deposit = Integer.parseInt(request.getParameter("deposit"));
		}
		int year;
		if("".equals(request.getParameter("year"))){
			year = 0;
		} else {
			year = Integer.parseInt(request.getParameter("year"));
		}
		int month;
		if("".equals(request.getParameter("month"))){
			month = 0;
		} else {
			month = Integer.parseInt(request.getParameter("month"));
		}
		int culPercentage;
		if("".equals(request.getParameter("culPercentage"))){
			culPercentage = 0;
		} else {
			culPercentage = Integer.parseInt(request.getParameter("culPercentage"));
		}
		String unit = request.getParameter("unit");
		String settlement = request.getParameter("settlement");
		String note = request.getParameter("note");
		boolean bln = cmdsummService.addPersonCmdSumm(pId,pName,tId,1,teamtype,tName,contractPrice,bgpayment,frequency,unit,total,nowTotal,percentage,thispay,culapay,thisSalary,noSalary,settlement,note,year,month,remain,deposit,culPercentage);
		List<TimeVo> list = cmdsummService.getCmdTime(pId);
		ProjectModel pModel = projectService.getById(pId);
		ModelAndView mav = new ModelAndView("/cmdsumm/cmdsumm_time");
		if(pModel != null)
			mav.addObject("pModel",pModel);
		
		mav.addObject("pId",pId);
		mav.addObject("clist", list);
		return mav;
		
		
		
	}
	
	
	/**
	 * 新增供应商汇总
	 */
	@RequestMapping(value="suppliersummary_add",method=RequestMethod.GET)
	public String addCmdSummSupplier(String pId ,String pName){
		
		request.setAttribute("pId", pId);
		request.setAttribute("pName", pName);
		return "/cmdsumm/suppliersummary_add";
	}
	
	
	
	
	@RequestMapping(value="suppliersummary_add2",method=RequestMethod.POST)
	public ModelAndView addCmdSummSupplier2(String pId ,String pName){
		
		
		String tNum = request.getParameter("tNum");
		int teamtype =Integer.parseInt(request.getParameter("teamtype"));
		String tName = request.getParameter("tName");
		String unit = request.getParameter("unit");
		String settlement = request.getParameter("settlement");
		String note = request.getParameter("note");
		int type = Integer.parseInt(request.getParameter("type"));
		String tId = null;
		if(type==2){
			MaterialModel materialmodel = materialService.getByCode(tNum);
			if(materialmodel!=null){
				tId = materialmodel.getId();
			}
		}else if(type==3){
			EquipmentModel equipmentmodel = equipmentService.getByCode(tNum);
			if(equipmentmodel!=null){
				tId = equipmentmodel.getId();
			}
		}
		String principal = request.getParameter("principal");
		String account = request.getParameter("account");
		String invoice = request.getParameter("invoice");
		int budget;
		if("".equals(request.getParameter("budget"))){
			budget = 0;
		} else {
			budget = Integer.parseInt(request.getParameter("budget"));
		}
		int contractPrice;
		if("".equals(request.getParameter("contractPrice"))){
			contractPrice = 0;
		} else {
			contractPrice = Integer.parseInt(request.getParameter("contractPrice"));
		}
		int receipt;
		if("".equals(request.getParameter("receipt"))){
			receipt = 0;
		} else {
			receipt = Integer.parseInt(request.getParameter("receipt"));
		}
		int cumulative;
		if("".equals(request.getParameter("cumulative"))){
			cumulative = 0;
		} else {
			cumulative = Integer.parseInt(request.getParameter("cumulative"));
		}
		int bgpayment;
		if("".equals(request.getParameter("bgpayment"))){
			bgpayment = 0;
		} else {
			bgpayment = Integer.parseInt(request.getParameter("bgpayment"));
		}
		int frequency;
		if("".equals(request.getParameter("frequency"))){
			frequency = 0;
		} else {
			frequency = Integer.parseInt(request.getParameter("frequency"));
		}
		int total;
		if("".equals(request.getParameter("total"))){
			total = 0;
		} else {
			total = Integer.parseInt(request.getParameter("total"));
		}
		int nowTotal;
		if("".equals(request.getParameter("nowTotal"))){
			nowTotal = 0;
		} else {
			nowTotal = Integer.parseInt(request.getParameter("nowTotal"));
		}
		int percentage;
		if("".equals(request.getParameter("percentage"))){
			percentage = 0;
		} else {
			percentage = Integer.parseInt(request.getParameter("percentage"));
		}
		int thispay;
		if("".equals(request.getParameter("thispay"))){
			thispay = 0;
		} else {
			thispay = Integer.parseInt(request.getParameter("thispay"));
		}
		int culapay;
		if("".equals(request.getParameter("culapay"))){
			culapay = 0;
		} else {
			culapay = Integer.parseInt(request.getParameter("culapay"));
		}
		int remain;
		if("".equals(request.getParameter("remain"))){
			remain = 0;
		} else {
			remain = Integer.parseInt(request.getParameter("remain"));
		}
		int deposit;
		if("".equals(request.getParameter("deposit"))){
			deposit = 0;
		} else {
			deposit = Integer.parseInt(request.getParameter("deposit"));
		}
		int year;
		if("".equals(request.getParameter("year"))){
			year = 0;
		} else {
			year = Integer.parseInt(request.getParameter("year"));
		}
		int month;
		if("".equals(request.getParameter("month"))){
			month = 0;
		} else {
			month = Integer.parseInt(request.getParameter("month"));
		}
		int culPercentage;
		if("".equals(request.getParameter("culPercentage"))){
			culPercentage = 0;
		} else {
			culPercentage = Integer.parseInt(request.getParameter("culPercentage"));
		}
		int num;
		if("".equals(request.getParameter("num"))){
			num = 0;
		} else {
			num = Integer.parseInt(request.getParameter("num"));
		}
		int price;
		if("".equals(request.getParameter("price"))){
			price = 0;
		} else {
			price = Integer.parseInt(request.getParameter("price"));
		}
		int subtotal;
		if("".equals(request.getParameter("subtotal"))){
			subtotal = 0;
		} else {
			subtotal = Integer.parseInt(request.getParameter("subtotal"));
		}
		int otherpay;
		if("".equals(request.getParameter("otherpay"))){
			otherpay = 0;
		} else {
			otherpay = Integer.parseInt(request.getParameter("otherpay"));
		}
		int restpay;
		if("".equals(request.getParameter("restpay"))){
			restpay = 0;
		} else {
			restpay = Integer.parseInt(request.getParameter("restpay"));
		}
		
		boolean bln = cmdsummService.addSupplierCmdSumm(pId,pName,tId,type,teamtype,tName,principal,account,unit,frequency,budget,num,price,subtotal,bgpayment,receipt,cumulative,thispay,culapay,otherpay,restpay,settlement,note,year,month,contractPrice,total,nowTotal,percentage,remain,culPercentage,deposit,invoice);
		List<TimeVo> list = cmdsummService.getCmdTime(pId);
		ProjectModel pModel = projectService.getById(pId);
		ModelAndView mav = new ModelAndView("/cmdsumm/cmdsumm_time");
		if(pModel != null)
			mav.addObject("pModel",pModel);
		mav.addObject("pId",pId);
		mav.addObject("clist", list);
		return mav;
			
	}
	
	
	/**
	 * 查看供应商明细表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="supplierdetail_list",method=RequestMethod.GET)
	public ModelAndView cmdSummSupplier(String id, int teamtype){
		System.out.println(id);
		String cmdId=id;
		ModelAndView mav = new ModelAndView("/cmdsumm/supplierdetail_list");
		List<CmdSummSupplierModel> list = cmdsummSupplierService.getByCmd(cmdId);
		CmdSummModel cmdSummModel = cmdsummService.getById(cmdId);
		if(cmdSummModel != null){
			mav.addObject("cModel",cmdSummModel);
			ProjectModel pModel = projectService.getById(cmdSummModel.getpId());
			if(pModel != null)
				mav.addObject("pModel",pModel);
		}
		mav.addObject("teamtype", teamtype);
		mav.addObject("cslist", list);
		
		return mav;
	}
	
	
	/**
	 * 查看人工明细表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="persondetail_list",method=RequestMethod.GET)
	public ModelAndView cmdSummPerson(String id,int teamtype){
		System.out.println(id);
		String cmdId=id;
		ModelAndView mav = new ModelAndView("/cmdsumm/persondetail_list");
		List<CmdSummPersonModel> list=cmdsummPersonService.getByCmd(cmdId);
		CmdSummModel cmdSummModel = cmdsummService.getById(cmdId);
		if(cmdSummModel != null){
			mav.addObject("cModel",cmdSummModel);
			ProjectModel pModel = projectService.getById(cmdSummModel.getpId());
			if(pModel != null)
				mav.addObject("pModel",pModel);
		}
		
		mav.addObject("cplist", list);
		mav.addObject("teamtype", teamtype);
		return mav;
	}
	
	
	/**
	 * 新增人工明细
	 */
	@RequestMapping(value="persondetail_add",method=RequestMethod.GET)
	public String addpersonCmdSumm(String id, int teamtype,String tId){
		String cmdId  = id;
		System.out.print("-------+++++++++++++++++++---------"+tId);
		request.setAttribute("teamtype", teamtype);
		request.setAttribute("cmdId", cmdId);
		request.setAttribute("tId", tId);
		return "/cmdsumm/persondetail_add";
	}
	
	
	
	
	@RequestMapping(value="persondetail_add2",method=RequestMethod.POST)
	public ModelAndView addpersonCmdSumm2(String cmdId, int teamtype,String tId){
		System.out.println("++++++++++++++++++++:"+cmdId);
		System.out.println("++++++++++++++++++++:"+teamtype);
		System.out.println("-----------------------------:"+tId);
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String account = request.getParameter("account");
		String voucher = request.getParameter("voucher");
		String inTime = request.getParameter("inTime");
		String outTime = request.getParameter("outTime");
		String safe = request.getParameter("safe");
		String attendance = request.getParameter("attendance");
		String access = request.getParameter("access");
		String identity = request.getParameter("identity");
		String workContent = request.getParameter("workContent");
		int count;
		if("".equals(request.getParameter("count"))){
			count = 0;
		} else {
			count = Integer.parseInt(request.getParameter("count"));
		}
		int salary;
		if("".equals(request.getParameter("salary"))){
			salary = 0;
		} else {
			salary = Integer.parseInt(request.getParameter("salary"));
		}
		int deduct;
		if("".equals(request.getParameter("deduct"))){
			deduct = 0;
		} else {
			deduct = Integer.parseInt(request.getParameter("deduct"));
		}
		int realSalary;
		if("".equals(request.getParameter("realSalary"))){
			realSalary = 0;
		} else {
			realSalary = Integer.parseInt(request.getParameter("realSalary"));
		}
		int noSalary;
		if("".equals(request.getParameter("noSalary"))){
			noSalary = 0;
		} else {
			noSalary = Integer.parseInt(request.getParameter("noSalary"));
		}
		String flag = request.getParameter("flag");
		String note = request.getParameter("note");
		String payTime = request.getParameter("payTime");
		String drawee = request.getParameter("drawee");
		int paytype = Integer.parseInt(request.getParameter("paytype"));
		//查询该用户是否在用户表里，如果不在则加进用户表
		UserModel usermodel = userService.getByUserId(userId);
		if(usermodel == null){
			UserModel userModel = new UserModel();
			userModel.setUserName(name);
			userModel.setUserId(userId);
			userModel.setUserPassword("123456");
			userService.addUser(userModel);
			personService.initialPerson(userId);
		}
		//查询该用户是否在该班组里，如果不在则把他加进班组
		TeamMemberModel tmmodel = teamMemberService.getByUserIdAndtId(userId, tId);
		if(tmmodel==null){
			TeamMemberModel teamMemberModel = new TeamMemberModel();
			teamMemberModel.settId(tId);
			teamMemberModel.setUserId(userId);
			teamMemberModel.setStatus(3);
			teamMemberService.addTeamMember(teamMemberModel);
		}
		CmdSummModel cmdSummModel = cmdsummService.getById(cmdId);
		TeamModel teamModel =teamService.getTeamById(tId);
		String tName;
		if(teamModel != null){
			tName = teamModel.getName();
		}
		if(cmdSummModel != null){
			boolean bln = cmdsummPersonService.addCmdSummPerson(cmdId,cmdSummModel.getpId(),teamtype,name,userId,account,voucher,inTime,
				outTime,safe,attendance,access,identity,workContent,count,salary,
				deduct,realSalary,noSalary,flag, note,tId,payTime,drawee,paytype,cmdSummModel.getpName(),cmdSummModel.getYear(),cmdSummModel.getMonth());
		}
		List<CmdSummPersonModel> list = cmdsummPersonService.getByCmd(cmdId);
		ModelAndView mav = new ModelAndView("/cmdsumm/persondetail_list");
		if(cmdSummModel != null){
			mav.addObject("cModel",cmdSummModel);
			ProjectModel pModel = projectService.getById(cmdSummModel.getpId());
			if(pModel != null)
				mav.addObject("pModel",pModel);
		}
		mav.addObject("tName", teamModel.getName());
		mav.addObject("teamtype", teamtype);
		mav.addObject("cplist", list);
		return mav;


	
	
	
	}
	
	
	/**
	 * 新增供应商明细
	 */
	@RequestMapping(value="supplierdetail_add",method=RequestMethod.GET)
	public String addsupplierCmdSumm(String id, int teamtype){
		String cmdId  = id;
		request.setAttribute("teamtype", teamtype);
		request.setAttribute("cmdId", cmdId);
		return "/cmdsumm/supplierdetail_add";
	}
	
	
	
	
	@RequestMapping(value="supplierdetail_add2",method=RequestMethod.POST)
	public ModelAndView addsupplierCmdSumm2(String cmdId, int teamtype ){
		
		String tName = request.getParameter("tName");
		String principal = request.getParameter("principal");
		String cName = request.getParameter("cName");
		String account = request.getParameter("account");
		String unit = request.getParameter("unit");
		int frequency;
		if("".equals(request.getParameter("frequency"))){
			frequency = 0;
		} else {
			frequency = Integer.parseInt(request.getParameter("frequency"));
		}
		int num;
		if("".equals(request.getParameter("num"))){
			num = 0;
		} else {
			num = Integer.parseInt(request.getParameter("num"));
		}
		int price;
		if("".equals(request.getParameter("price"))){
			price = 0;
		} else {
			price = Integer.parseInt(request.getParameter("price"));
		}
		int subtotal;
		if("".equals(request.getParameter("subtotal"))){
			subtotal = 0;
		} else {
			subtotal = Integer.parseInt(request.getParameter("subtotal"));
		}
		int thispay;
		if("".equals(request.getParameter("thispay"))){
			thispay = 0;
		} else {
			thispay = Integer.parseInt(request.getParameter("thispay"));
		}
		int culapay;
		if("".equals(request.getParameter("culapay"))){
			culapay = 0;
		} else {
			culapay = Integer.parseInt(request.getParameter("culapay"));
		}
		int otherpay;
		if("".equals(request.getParameter("otherpay"))){
			otherpay = 0;
		} else {
			otherpay = Integer.parseInt(request.getParameter("otherpay"));
		}
		int restpay;
		if("".equals(request.getParameter("restpay"))){
			restpay = 0;
		} else {
			restpay = Integer.parseInt(request.getParameter("restpay"));
		}
		int bgpayment;
		if("".equals(request.getParameter("bgpayment"))){
			bgpayment = 0;
		} else {
			bgpayment = Integer.parseInt(request.getParameter("bgpayment"));
		}
		int budget;
		if("".equals(request.getParameter("budget"))){
			budget = 0;
		} else {
			budget = Integer.parseInt(request.getParameter("budget"));
		}
		int receipt;
		if("".equals(request.getParameter("receipt"))){
			receipt = 0;
		} else {
			receipt = Integer.parseInt(request.getParameter("receipt"));
		}
		int cumulative;
		if("".equals(request.getParameter("cumulative"))){
			cumulative = 0;
		} else {
			cumulative = Integer.parseInt(request.getParameter("cumulative"));
		}
		String information = request.getParameter("information");
		String invoice = request.getParameter("invoice");
		String settlement = request.getParameter("settlement");
		String using = request.getParameter("using");
		String quality = request.getParameter("quality");
		String note = request.getParameter("note");
		CmdSummModel cmdSummModel = cmdsummService.getById(cmdId);
		if(cmdSummModel != null){
			boolean bln = cmdsummSupplierService.addCmdSummSupplier(cmdId,cmdSummModel.getpId(),cmdSummModel.getpName(),cmdSummModel.getType(),teamtype,cmdSummModel.gettId(),tName,principal,cName,account,unit,frequency,num,price,subtotal,thispay,culapay,otherpay,restpay,bgpayment,budget,receipt,cumulative,information,invoice, settlement, using,quality,note,cmdSummModel.getYear(),cmdSummModel.getMonth());
		}
		List<CmdSummSupplierModel> list = cmdsummSupplierService.getByCmd(cmdId);
		ModelAndView mav = new ModelAndView("/cmdsumm/supplierdetail_list");
		if(cmdSummModel != null){
			mav.addObject("cModel",cmdSummModel);
			ProjectModel pModel = projectService.getById(cmdSummModel.getpId());
			if(pModel != null)
				mav.addObject("pModel",pModel);
		}
		mav.addObject("cslist", list);
		mav.addObject("teamtype", teamtype);
		return mav;


	
	
	
	}

}
