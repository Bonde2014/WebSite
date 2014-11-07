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

import cn.com.bonde.b2b.website.entity.findEntity.KeHuXinXiFindEntity;
import cn.com.bonde.b2b.website.service.IKeHuXinXiService;
import cn.com.bonde.b2b.website.util.EasyUIJsonUtil;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.Pager;
import cn.com.bonde.b2b.website.util.WriteJsonToPage;

/**
 * @author Administrator
 * 
 */
@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "success", location = "success.jsp") })
public class KeHuXinXiAction extends ProjectBaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource(name = "keHuXinXiService")
	private IKeHuXinXiService keHuXinXiService;

	/**
	 * @return the keHuXinXiService
	 */
	public IKeHuXinXiService getKeHuXinXiService()
	{
		return keHuXinXiService;
	}

	/**
	 * @param keHuXinXiService
	 *            the keHuXinXiService to set
	 */
	public void setKeHuXinXiService(IKeHuXinXiService keHuXinXiService)
	{
		this.keHuXinXiService = keHuXinXiService;
	}

	@Action(value = "khgl.searchKeHuXinXi")
	public String searchKeHuXinXi() throws MyException
	{
		try
		{
			KeHuXinXiFindEntity keHuXinXiFindEntity = this.ConvertDataTableToEntity(KeHuXinXiFindEntity.class);
			Pager pager = keHuXinXiService.getList(keHuXinXiFindEntity);
			String jsonString = EasyUIJsonUtil.getEasyUIJsonStr(pager);
			WriteJsonToPage.WriteJson(jsonString);
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
		return null;
	}

}
