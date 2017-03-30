package com.fengyun.web.page;

import javax.servlet.http.HttpServlet;

import mmo.common.data.db.RedisManager;
import mmo.common.utils.KeyWordsUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fengyun.web.cache.SysData;
import com.fengyun.web.common.ApplicationConfig;
import com.fengyun.web.common.Config;
import com.fengyun.web.hardcode.Area;

public class ServletInit extends HttpServlet {
	private static Log log = LogFactory.getLog(ServletInit.class);
	
	public static boolean hasRun = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 374084557551254887L;

	@Override
	public void init(){
		if(hasRun)
			return;
//		Runtime.getRuntime().addShutdownHook(new Thread() {
//			public void run() {
//				// 执行退出工作1公告;2断开玩家登录;3T玩家离线
//				World.cleanOnlinePlayers();
//				System.out.println("--------------ServletInit exit----------------");
//			}
//		});
		long start = System.currentTimeMillis();
		try {
			log.info("---开始初始化配置类---");
			Config.getInstance().init(null); // 调用一下，初始化配置类
			log.info("---完成初始化配置类---");
			
			log.info("---开始初始化参数回调---");
			ApplicationConfig.init(); //初始化参数，实现回调
			log.info("---完成初始化参数回调---");
			
			log.info("---开始关键字初始化--");
			KeyWordsUtils.init();
			log.info("---完成关键字初始化--");
			
			log.info("---开始缓存系统初始化---");
			RedisManager.init();
			log.info("---完成缓存系统初始化---");
			
			Area.init();

//			log.info("---开始发布和订阅功能初始化---");
//			NoticeFacade.newInstance();
//			log.info("---完成发布和订阅功能初始化---");			
			
			//每隔1个小时刷新首页
			final Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					for (;;) {
						try {
							SysData.getIndexPage().reload();
						} catch (Exception e) {
							log.error("心跳出错:World", e);
						}

						try {
							Thread.sleep(60*60*1000);
						} catch (InterruptedException e) {
							log.error("心跳线程出错:World", e);
						}

					}
				}
			}, "SysData.getIndexPage().reload()");
			t.start();
			
		} catch (Exception e) {
			log.error(e,e);
		}
		hasRun = true;
		log.info("服务端初始化完毕!耗时:" + (System.currentTimeMillis() - start) + "毫秒");
	}
	
}
