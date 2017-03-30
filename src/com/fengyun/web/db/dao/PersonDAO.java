package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.BaseIdModel;
import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.PersonModel;
import com.fengyun.web.db.playermodel.UserModel;
import com.mongodb.BasicDBObject;

public class PersonDAO {
	

		/** 公共sql **/
		private static final String tableName = Tables.Person;
		
		/**
		 * 查询某负责的所有项目
		 * @param userId
		 * @return
		 */
		public static List<PersonModel> getByUserId(String userId) {
			BasicDBObject queryObj = new BasicDBObject(2);
			queryObj.put("userId", userId);
			
			List<PersonModel> models = MongoDBManager.find(tableName, queryObj);//
			return models;
		}
		
		/**
		 * 查询某项目
		 * @param id
		 * @return
		 */
		public static PersonModel getById(String id) {
			BasicDBObject queryObj = new BasicDBObject(2);
			queryObj.put("_id", new ObjectId(id));
			return MongoDBManager.findOne(tableName, queryObj);
		}
		
		/**
		 * 插入新记录
		 * 
		 * @param model
		 */
		public synchronized static void insert(PersonModel model) {
			MongoDBManager.insert(tableName, model);
		}
		
		/**
		 * 获得所有项目
		 * @param id
		 * @return
		 */
		public static List<PersonModel> getAll(BasicDBObject queryObj,int row,int skip) {
			List<PersonModel> models = MongoDBManager.find(tableName,queryObj,row,skip);//
			return models;
		}
		
		public static long countAll(BasicDBObject queryObj){
			return MongoDBManager.getCount(tableName,queryObj);
		}
		
		/**
		 * 删除
		 * @param id
		 */
		public static void delete(String id){
			MongoDBManager.delete(tableName, id, null);
		}
		
		/**
		 * 更新保存model
		 *  
		 * @param model
		 */
		public static boolean update(PersonModel model) {
			return MongoDBManager.update(tableName, model);
		}
		
		/**
		 * 更新部分字段
		 * @param id
		 * @param playerId
		 * @param fieldObj
		 * @return
		 */
		public static void update(String id, BasicDBObject fieldObj) {
			MongoDBManager.updateFields(tableName, id, fieldObj,null);
		}

		/**
		 * 通过userId查询用户的诚信档案
		 * @param userId
		 */
		public static PersonModel getPersonModelByUserId(String userId) {
			// TODO Auto-generated method stub
			BasicDBObject queryObj = new BasicDBObject(2);
			queryObj.put("userId", userId);
			PersonModel model = MongoDBManager.findOne(tableName, queryObj);
			return model;
		}

		/*
		 * 查询班组的诚信档案基本信息
		 */
		public static PersonModel getGroupIntegerity(BasicDBObject queryObj) {
			// TODO Auto-generated method stub
			PersonModel model = MongoDBManager.findOne(tableName, queryObj);
			return model;
		}

		
		
		public static void addPerson(PersonModel personmodel) {
			// TODO Auto-generated method stub
			MongoDBManager.insert(tableName, personmodel);
		}


}
