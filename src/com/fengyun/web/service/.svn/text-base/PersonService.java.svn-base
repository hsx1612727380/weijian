package com.fengyun.web.service;

import java.util.List;

import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.TeamModel;
import com.mongodb.BasicDBObject;

public interface PersonService {

	long countAllPerson(BasicDBObject queryObj);

	List<PersonModel> getPersonList(BasicDBObject queryObj, int pageNow,
			int pageSize);

	boolean addPerson(int type,String teamCode,String teamName,String name, String gender, String national,
			String education, String birth, String age, String height,
			String weight, String identity, String health, String marriage,
			String skillBigType, String skillSmallType, String province,String city,
			String jobstatus, String integrity, String bankcard,
			String address, String guidelines, String safety, String contract,
			String worktime, String unit, String experience, String userId,String entryTime,String exitTime);

	void updatePerson(PersonModel model);

	void delPerson(String id);

	
	public PersonModel getById(String id);

	/**
	 * 通过userId查询用户的诚信档案 -zss
	 * @param userId
	 */
	PersonModel getByUserId(String userId);

	/**
	 * 通过班组的teamCode和用户的类型type = 1,查询班组的诚信基本信息 
	 * @param teamCode
	 * @param type
	 * @return
	 */
	PersonModel getByTeamCodeAndType(String teamCode, int type);

	/**
	 * 通过班组信息添加班组诚信档案的基本信息
	 * @param team
	 */
	void insert(TeamModel team);

	/**
	 * 注册时添加用户诚信档案的电话号码：userId字段。
	 * @param userId
	 */
	void initialPerson(String userId);

	/**
	 * 项目负责人注册,初始化用户信息
	 * @param userId
	 * @param identity
	 * @param userType
	 * @param userName 
	 */
	void initialUser(String userName,String userId, String identity, String userType);

	void addPersonAndUser(PersonModel personmodel);

	

}
