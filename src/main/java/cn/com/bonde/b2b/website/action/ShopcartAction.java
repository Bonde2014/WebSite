/**
 * 
 */
package cn.com.bonde.b2b.website.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.XsGwc;
import cn.com.bonde.b2b.website.entity.XsGwcId;
import cn.com.bonde.b2b.website.service.IShopcartService;
import cn.com.bonde.b2b.website.util.MyException;

/**
 * @author Administrator
 * 
 */
@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "success", location = "shopcart.jsp") })
public class ShopcartAction extends ProjectBaseAction
{
	private static final long serialVersionUID = 1L;
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

	@Action(value = "goShopcart")
	public String goShopcart() throws MyException
	{
		try
		{
			XsGwcId id= new XsGwcId(); 
			id.setKhDm(this.getKhxx().getKhDm());
			shopcartService.getEntitiesListByProperty(XsGwc.class,"id", id, "tjsj");
           this.setReuestAttr("shopcartList", shopcartService.getEntitiesListByProperty(XsGwc.class,"id", id, "tjsj"));
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
		return SUCCESS;
	}

}
