package cn.com.bonde.b2b.website.util;


import java.io.Serializable;
import java.util.List;

public class Pager implements Serializable {
    
	public  Pager() {

	}
	
	private static final long serialVersionUID = 1L;
	
	private Integer pageNo;
	private Integer pageSize;
	private Integer pageTotal;
	private Integer total;
	@SuppressWarnings("rawtypes")
	private List rows;
	public Integer getPageNo() {
		return pageNo;
	}
	
	//从第几条开始
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

    
    /**
     * @return the pageTotal
     */
    public Integer getPageTotal() {
        return pageTotal;
    }

    
    /**
     * @param pageTotal the pageTotal to set
     */
    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }
}
