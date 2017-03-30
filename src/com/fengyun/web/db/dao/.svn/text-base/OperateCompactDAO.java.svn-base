package com.fengyun.web.db.dao;

import java.util.List;

import org.bson.types.ObjectId;

import mmo.common.data.db.MongoDBManager;

import com.fengyun.web.db.playermodel.OperateCompactModel;
import com.mongodb.BasicDBObject;

/**
 * 项目操作员--合同管理
 * @author zhengss
 *	2017-01-20
 */
public class OperateCompactDAO {

	/** 对应表名 **/
	private static final String tableName = Tables.ProjectCompact;
	
	/**
	 * 通过Model添加一个合同
	 * @param operateCompact
	 * @return
	 */
	public static boolean add(OperateCompactModel operateCompact){
		return MongoDBManager.insert(tableName, operateCompact);
	}

	/**
	 * 通过pId查询项目所有的合同
	 * @param id
	 * @return 
	 */
	public static List<OperateCompactModel> getByPId(String id) {
		BasicDBObject queryObj = new BasicDBObject(2);
		queryObj.put("pId", id);
		List<OperateCompactModel> list = MongoDBManager.find(tableName, queryObj);
		return list;
	}

	/**
	 * 通过Id查询出一记录
	 * @param id
	 * @return
	 */
	public static OperateCompactModel getById(String id) {
		BasicDBObject queryObj = new BasicDBObject();
		queryObj.put("_id", new ObjectId(id));
		OperateCompactModel model = MongoDBManager.findOne(tableName, queryObj);
		return model;
	}

	/**
	 * 更新
	 * @param compactModel
	 */
	public static void update(OperateCompactModel compactModel) {
		MongoDBManager.update(tableName, compactModel);
	}
}
