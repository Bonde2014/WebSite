package cn.com.bonde.b2b.website.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.XsDdqk;
import cn.com.bonde.b2b.website.service.IOrderService;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "userCenter", location = "/pages/userCenter.jsp"),
    @Result(name = "userOrder", location = "/pages/userOrder.jsp")})
public class UserCenterAction extends ProjectBaseAction
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4044106435263199102L;
    
    @Resource
    private IOrderService orderService;
    private List<XsDdqk> xsddqkList=null;
    private List<Map<String, Object>> mapList=null;
    
    
    /**
	 * @return the xsddqkList
	 */
	public List<XsDdqk> getXsddqkList()
	{
		return xsddqkList;
	}

	/**
	 * @param xsddqkList the xsddqkList to set
	 */
	public void setXsddqkList(List<XsDdqk> xsddqkList)
	{
		this.xsddqkList = xsddqkList;
	}

	
	
	
	/**
	 * @return the mapList
	 */
	public List<Map<String, Object>> getMapList()
	{
		return mapList;
	}

	/**
	 * @param mapList the mapList to set
	 */
	public void setMapList(List<Map<String, Object>> mapList)
	{
		this.mapList = mapList;
	}

	@Action(value="userCenter")
    public String init(){
        return "userCenter";
    }
    
    @Action(value="userOrder")
    public String userOrder() throws Exception{
    	xsddqkList= orderService.queryOrder(this.getKhxx().getKhDm(), null);
    	List<Long> list = new  ArrayList<Long>();
    	for(XsDdqk xsddqk:xsddqkList){
    		list.add(xsddqk.getDdxh());
    	}
    	mapList=orderService.queryOrderDetail(list);
        return "userOrder";
    }
    
    


	
}
