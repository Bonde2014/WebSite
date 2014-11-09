package cn.com.bonde.b2b.website.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.QxDlxx;
import cn.com.bonde.b2b.website.service.ICatalogService;
import cn.com.bonde.b2b.website.service.ILoginService;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.WriteJsonToPage;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "success", location = "/pages/index.jsp") })
public class ProductCatalogAction extends ProjectBaseAction
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5748465179322729840L;

	@Resource(name = "catalogService")
	private ICatalogService catalogService;
	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	private String spflDm;  //页面传递的大类代码

	public String getSpflDm() {
		return spflDm;
	}

	public void setSpflDm(String spflDm) {
		this.spflDm = spflDm;
	}


	@Action(value = "getCatalog")
	public void getCatalogList() throws Exception
	{
		try
		{
			String msg = catalogService.queryCatalog(spflDm);
			WriteJsonToPage.WriteJson(msg);
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
	}


}
