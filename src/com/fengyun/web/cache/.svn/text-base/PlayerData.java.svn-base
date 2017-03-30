package com.fengyun.web.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fengyun.web.db.playermodel.UserModel;


/**
 * 用户内存数据
 * 
 */
public class PlayerData {

	/** 用户User数据 */
	private static Map<String, UserModel> userMap = new ConcurrentHashMap<String, UserModel>();
	/**
	 * 清理某个玩家的所有内存数据
	 * 
	 * @param playerId
	 */
	public static void clean(String playerId) {
		try {
			userMap.remove(playerId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String, UserModel> getUserMap() {
		return userMap;
	}
	
	
	
	
	

}