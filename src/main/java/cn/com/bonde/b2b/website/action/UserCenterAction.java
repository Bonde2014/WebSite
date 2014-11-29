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

import cn.com.bonde.b2b.website.entity.QxKhxx;
import cn.com.bonde.b2b.website.service.IOrderService;
import cn.com.bonde.b2b.website.service.IShopcartService;
import cn.com.bonde.b2b.website.util.Constants;
import cn.com.bonde.b2b.website.util.DataSwitch;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.WriteJsonToPage;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "userCenter", location = "/pages/userCenter.jsp"),
          @Result(name = "userOrder", location = "/pages/userOrder.jsp") })
public class UserCenterAction extends ProjectBaseAction {

    /**
     * serialVersionUID
     */
    private static final long         serialVersionUID = -4044106435263199102L;

    @Resource
    private IOrderService             orderService;
    private List<Map<String,Object>>    xsddqkList       = null;
    private List<Map<String, Object>> mapList          = null;
    private List<Map<String, Object>>  ddztList          = null;
    
    @Resource(name = "shopcartService")
	private IShopcartService shopcartService;

	/**
	 * @return the shopcartService
	 */
	public IShopcartService getShopcartService()
	{
		return shopcartService;
	}

	/**
	 * @param shopcartService
	 *            the shopcartService to set
	 */
	public void setShopcartService(IShopcartService shopcartService)
	{
		this.shopcartService = shopcartService;
	}

    /**
	 * @return the xsddqkList
	 */
	public List<Map<String, Object>> getXsddqkList()
	{
		return xsddqkList;
	}

	/**
	 * @param xsddqkList the xsddqkList to set
	 */
	public void setXsddqkList(List<Map<String, Object>> xsddqkList)
	{
		this.xsddqkList = xsddqkList;
	}

	/**
     * @return the mapList
     */
    public List<Map<String, Object>> getMapList() {
        return mapList;
    }

    /**
     * @param mapList the mapList to set
     */
    public void setMapList(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }

    
    /**
	 * @return the ddztList
	 */
	public List<Map<String, Object>> getDdztList()
	{
		return ddztList;
	}

	/**
	 * @param ddztList the ddztList to set
	 */
	public void setDdztList(List<Map<String, Object>> ddztList)
	{
		this.ddztList = ddztList;
	}

	@Action(value = "userCenter")
    public String init() {
        return "userCenter";
    }

    @Action(value = "userOrder")
    public String userOrder() throws Exception {
    	String orderStatus=this.getParameter("ddzt");
    	ddztList=orderService.queryDdztList(this.getKhxx().getKhDm());
        xsddqkList = orderService.queryOrderList(this.getKhxx().getKhDm(), orderStatus);
        List<String> list = new ArrayList<String>();
        for (Map<String,Object> xsddqk : xsddqkList) {
            list.add(DataSwitch.convertObjectToString(xsddqk.get("DDID")));
        }
        mapList = orderService.queryOrderDetail(list);
        this.setReuestAttr("ddzt", orderStatus);
        return "userOrder";
    }
    
    @Action(value = "doUserInfo")
	public void doUserInfo() throws MyException{
		try
		{
			QxKhxx  khxx= this.getKhxx();
			khxx.setFzrXm(this.getParameter("fzrXm"));
			khxx.setLxdh(this.getParameter("lxdh"));
			khxx.setLxdz(this.getParameter("lxdz"));
			boolean result=orderService.updateUserInfo(khxx);
			if(result){
				this.getSession().setAttribute(Constants.SESSION_LOGIN, khxx);
			}
			  WriteJsonToPage.WriteJson(result);
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
	}
    
    
    @Action(value = "saveOrder")
	public void saveOrder() throws MyException{
		try
		{
			String psfsdm = this.getParameter("psfsdm");
			String[] spdms= this.getRequest().getParameterValues("spdm");
			List<Map<String,Object>> list = shopcartService.getEntityList(DataSwitch.convertObjectToString(this.getKhxx().getKhDm()),DataSwitch.getStr(spdms));
			boolean result=orderService.saveOrder(psfsdm, list, this.getKhxx());
			  WriteJsonToPage.WriteJson(result);
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
	}

}
