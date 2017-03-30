package com.fengyun.web.cache.page;


public class PageHandler {
	
	/**
	 * 
	 * @param pageSize 每页显示的数量
	 * @param pageNow 当前要访问的页数
	 * @param dataCount	总的记录数
	 * @return
	 */
	public static Page getPage(int pageSize,int pageNow,long dataCount){
		Page page = new Page();
		page.setDataCount(dataCount);
		if(pageSize > 0)
			page.setPageSize(pageSize);
		
		
		if(pageNow > 0)
			page.setPageNow(pageNow);
		else
			pageNow = 1;
		//获得总页数
		int pageCount = (int)((dataCount - 1) / page.getPageSize()) + 1;
		page.setPageCount(pageCount);
		
		page.setLastPage(pageCount);
		//设置上一页下一页
		if(pageNow > 1)
			page.setPrePage(pageNow - 1);
		if(pageNow < pageCount)
			page.setNextPage(pageNow + 1);
		
		return page;
	}

	
	
}
