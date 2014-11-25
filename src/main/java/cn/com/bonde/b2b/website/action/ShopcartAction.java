/**
 * 
 */
package cn.com.bonde.b2b.website.action;

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

import cn.com.bonde.b2b.website.service.IShopcartService;
import cn.com.bonde.b2b.website.util.DataSwitch;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.WriteJsonToPage;

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
	private List<Map<String, Object>> shopcartList = null;
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
	 * @return the shopcartList
	 */
	public List<Map<String, Object>> getShopcartList()
	{
		return shopcartList;
	}

	/**
	 * @param shopcartList
	 *            the shopcartList to set
	 */
	public void setShopcartList(List<Map<String, Object>> shopcartList)
	{
		this.shopcartList = shopcartList;
	}

	@Action(value = "goShopcart")
	public String goShopcart() throws MyException
	{
		try
		{
			shopcartList = shopcartService.getEntityList(DataSwitch.convertObjectToString(this.getKhxx().getKhDm()));
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
		return SUCCESS;
	}

	@Action(value = "addToShopCart")
	public void addToShopCart() throws MyException
	{
		try
		{
			String spdm = this.getParameter("spdm");
			String spsl = this.getParameter("spsl");
			boolean msg = shopcartService.addToShopCart(DataSwitch.convertObjectToLong(spdm), DataSwitch.convertObjectToInteger(spsl), this.getKhxx());
			WriteJsonToPage.WriteJson(msg);
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
	}

}
