package com.fengyun.web.timer;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 使用opensymphony.com的Quartz项目实现定时任务，配置文件为quartz.properties，任务列表登记在jobs.xml
  *
 */
public class TimerServer {
	/**
	 * 启动Quartz定时系统
	 * @throws Exception
	 */
	public void run() throws Exception {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        sched.start();
    }
	
	public static void main(String[] args) throws Exception{
		TimerServer server = new TimerServer();
		server.run();
	}
}
