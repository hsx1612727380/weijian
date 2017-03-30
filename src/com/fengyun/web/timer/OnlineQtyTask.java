package com.fengyun.web.timer;

import org.aspectj.weaver.World;

import com.fengyun.web.service.LogManager;


public class OnlineQtyTask extends BaseTimerTask {

	@Override
	public void runTask() throws Exception {
		// 在线人数
//		Integer qty = World.getPlayerQty();
//		LogManager.onlineQtyLog(qty);	
//		log.info("统计在线人数" + qty);
	}
}
