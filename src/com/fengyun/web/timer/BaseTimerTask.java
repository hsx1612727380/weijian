package com.fengyun.web.timer;

import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public abstract class BaseTimerTask extends TimerTask implements Job{

	protected static final Log log = LogFactory.getLog("timerTask");
	
	@Override
	public synchronized void run() {
		long start = System.currentTimeMillis();
		try{
			runTask();
		}
		catch(Exception ex){
			log.error(ex, ex);
		} finally {
		}
		log.info("定时任务" + this.getClass().getSimpleName() + ",用时："
				+ (System.currentTimeMillis() - start));
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		run();
	}

	public abstract void runTask() throws Exception;
	
}
