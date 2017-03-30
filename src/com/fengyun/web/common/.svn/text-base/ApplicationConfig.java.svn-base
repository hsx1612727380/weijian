package com.fengyun.web.common;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import mmo.common.ApplicationLocalImpl;
import mmo.common.IApplicationLocal;
import mmo.common.data.db.BaseFileDataModel;
import mmo.common.data.db.BaseIdModel;
import mmo.core.command.Terminal;

import com.fengyun.web.db.dao.ModelTools;
import com.mongodb.BasicDBObject;

public class ApplicationConfig {

	/**
	 * 
	 */
	public static void init(){
		ApplicationLocalImpl applicationLocalImpl = ApplicationLocalImpl.getInstance();  
	    applicationLocalImpl.setCallBack(new IApplicationLocal() {  
	        @Override
			public boolean useCache() {
				return false;
			}

			@Override
			public boolean isDebug() {
				return Config.getInstance().isDebug();
			}

			@Override
			public int[] getPorts() {
				return Config.getInstance().getPorts();
			}

			@Override
			public int getIdle() {
				return 0;
			}

			@Override
			public boolean isAutoSendPolicy() {
				return false;
			}

			@Override
			public int getBufferSize() {
				return 0;
			}

			@Override
			public boolean isTcpNodelay() {
				return false;
			}

			@Override
			public String getCommandPackage() {
				return null;
			}

			@Override
			public String getMyServerId() {
				return Config.getInstance().getMyServerId();
			}

			@Override
			public boolean isCompress() {
				return false;
			}

			@Override
			public boolean isIgnoreHead() {
				return false;
			}

			@Override
			public List<String> getRmiips() {
				return Config.getInstance().getRmiips();
			}

			@Override
			public boolean isPressureDebug() {
				return Config.getInstance().isPressureDebug();
			}

			@Override
			public String getRootPath() {
				return Config.getInstance().getRootPath();
			}

			@Override
			public void logPackage(Terminal t, int uuid, String cmd,
					int cmdIndex, Object[] args) {
				
			}

			@Override
			public <T extends BaseIdModel> T mongoToModel(String tableName,
					BasicDBObject result) {
				return ModelTools.mongoToModel(tableName, result);
			}

			@Override
			public <T extends BaseFileDataModel> T fileToModel(
					String tableName, Map<String, String> result) {
				return ModelTools.fileToModel(tableName, result);
			}

			@Override
			public int getTerminalSize() {
				return Config.getInstance().getWorldPlayerSize();
			}

			@Override
			public String getPlatformUrl() {
				return null;
			}

			@Override
			public Properties getProp2(String path) {
				return Config.getInstance().getProp(path);
			}  
	    });  
	}
}
