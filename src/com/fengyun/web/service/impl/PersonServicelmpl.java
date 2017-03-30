package com.fengyun.web.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengyun.web.db.dao.PersonDAO;
import com.fengyun.web.db.dao.Tables;
import com.fengyun.web.db.dao.UserDAO;
import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.fengyun.web.service.PersonService;
import com.fengyun.web.service.UserService;
import com.mongodb.BasicDBObject;

@Service
public class PersonServicelmpl implements PersonService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<PersonModel> getPersonList(BasicDBObject queryObj,int pageNow,int pageSize) {
		if(pageNow <= 0)
			pageNow = 1;
		if(pageSize <= 0)
			pageSize = Tables.PAGENUM;
		int skip = (pageNow - 1) * pageSize;
		return PersonDAO.getAll(queryObj,pageSize, skip);
	}

	@Override
	public long countAllPerson(BasicDBObject queryObj) {
		return PersonDAO.countAll(queryObj);
	}
	
	
	@Override
	public boolean addPerson(int type,String teamCode,String teamName,String name, String gender, String national, String education, String birth, String age, String height,
			String weight, String identity, String health, String marriage, String skillBigType, String skillSmallType ,String province,String city, String jobstatus, String integrity,
			String bankcard, String address, String guidelines, String safety, String contract, String worktime, String unit, String experience, String userId,String entryTime,String exitTime) {
		PersonModel model = new PersonModel();
		model.setType(type);
		model.setTeamCode(teamCode);
		model.setTeamName(teamName);
		model.setName(name);
		model.setAddress(address);
		model.setAge(age);
		model.setBankcard(bankcard);
		model.setBirth(birth);
		model.setContract(contract);
		model.setCreateTime(new Date());
		model.setEducation(education);
		model.setExperience(experience);
		model.setGender(gender);
		model.setHealth(health);
		model.setHeight(height);
		model.setIdentity(identity);
		model.setProvince(province);
		model.setCity(city);
		model.setJobstatus(jobstatus);
		model.setNational(national);
		model.setMarriage(marriage);
		model.setSafety(safety);
		model.setSkillBigType(skillBigType);
		model.setSkillSmallType(skillSmallType);
		model.setUnit(unit);
		model.setWeight(weight);
		model.setWorktime(worktime);
		model.setGuidelines(guidelines);
		model.setIntegrity(integrity);
		model.setUserId(userId);
		model.setEntryTime(entryTime);
		model.setExitTime(exitTime);
		try{
			PersonDAO.insert(model);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public void delPerson(String id) {
		PersonDAO.delete(id);
	}

	@Override
	public PersonModel getById(String id) {
		return PersonDAO.getById(id);
	}

	@Override
	public void updatePerson(PersonModel model) {
		PersonDAO.update(model);
	}

	/**
	 * 通过userId查询用户的诚信档案
	 * @param userId
	 */
	@Override
	public PersonModel getByUserId(String userId) {
		// TODO Auto-generated method stub
		return PersonDAO.getPersonModelByUserId(userId);
	}

	/**
	 * 通过班组的teamCode和用户的类型type = 1,查询班组的诚信基本信息 -zss
	 * @param teamCode
	 * @param type
	 * @return
	 */
	@Override
	public PersonModel getByTeamCodeAndType(String teamCode, int type) {
		// TODO Auto-generated method stub
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("teamCode", teamCode);
		queryObj.put("type", type);
		PersonModel groupIntegerity = PersonDAO.getGroupIntegerity(queryObj);
		return groupIntegerity;
	}

	/**
	 * 通过班组信息添加班组诚信档案的基本信息 -zss
	 */
	@Override
	public void insert(TeamModel team) {
		// TODO Auto-generated method stub
		PersonModel model = new PersonModel();
		//添加班组的基本信息和班组长的基本信息
		//1、添加班组基本信息
		model.setProvince(team.getProvince());
		model.setCity(team.getCity());
		model.setSkillBigType(String.valueOf(team.getSkillBigType()));
		model.setSkillSmallType(String.valueOf(team.getSkillSmallType()));
		model.setTeamName(team.getName());
		model.setTeamCode(String.valueOf(team.getCode()));
		model.setUserId(team.getId());//班组的是tId/对个人的是userId
		model.setCreateTime(team.getCreateTime());
		//2、查询出并添加班组长基本信息到班组诚信档案中
		UserModel userModel = userService.getByUserId(team.getLeaderMobile());
		model.setAge(String.valueOf(userModel.getAge()));
		model.setIntegrity(String.valueOf(userModel.getScore()));
		model.setType(1);
		model.setName(userModel.getUserName());
		PersonDAO.insert(model);
		return ;
	}

	/**
	 * 注册时添加用户诚信档案的电话号码：userId字段。-zss
	 * @param userId 
	 */
	@Override
	public void initialPerson(String userId) {
		// TODO Auto-generated method stub
		PersonModel personModel = new PersonModel();
		UserModel userModel = userService.getByUserId(userId);
		userModel.setUserStatus("1");//初始化用工状态 为1：找工作,2:在职
		String userIdentity = userModel.getUserIdentity();
		if(StringUtils.isNotBlank(userIdentity)){
			personModel.setIntegrity("60");
			personModel.setIdentity(userIdentity);
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(calendar.YEAR); 
			System.out.println(year);
			int birthYear = Integer.valueOf(userIdentity.substring(6, 10)); 
			int age = year - birthYear;
			personModel.setAge(String.valueOf(age));
			String birthday = userIdentity.substring(6, 10)+"年"+userIdentity.substring(10,12)+"月"+userIdentity.substring(12,14)+"日";
			personModel.setBirth(birthday);
			int bit17 = Integer.parseInt(userIdentity.substring(14,17));
			if(bit17>=0&&bit17%2==1){
				personModel.setGender("1"); //1--男 2--女
			}else{
				personModel.setGender("2");
			}
		}
		String name = userModel.getUserName();
		if(StringUtils.isNotBlank(name)){
			personModel.setName(name);
		}
		int skillBigType = userModel.getSkillBigType();
		personModel.setSkillBigType(String.valueOf(skillBigType));
		int skillSmallType = userModel.getSkillSmallType();
		personModel.setSkillSmallType(String.valueOf(skillSmallType));
		personModel.setCreateTime(new Date());
		personModel.setUserId(userId);
		
		PersonDAO.insert(personModel);
		UserDAO.update(userModel);
	}

	@Override
	public void initialUser(String userName, String userId, String identity, String userType) {
		// TODO Auto-generated method stub
		int type = Integer.parseInt(userType);
		//初始化诚信档案的用户类型type，userName,身份证Identity，和jobStatus: "1"，诚信度: "60",用户id或班组id
		this.addPerson(type, null, null, userName, null, null, null, null, null,null, null, identity, null, null, null, null, null, null, "1", "60", null, null, null, null, null, null, null, null, userId,null,null);
	}
	
	@Override
	public void addPersonAndUser(PersonModel personmodel) {
		PersonDAO.addPerson(personmodel);
	}
}
