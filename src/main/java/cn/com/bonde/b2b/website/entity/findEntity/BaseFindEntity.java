package cn.com.bonde.b2b.website.entity.findEntity;

import cn.com.bonde.b2b.website.util.Constants;

public class BaseFindEntity {
	private int page; //当前第几页
	private int rows; //每页记录数
	
	public BaseFindEntity (){
	    rows = Constants.PAGE_SIZE;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
}
