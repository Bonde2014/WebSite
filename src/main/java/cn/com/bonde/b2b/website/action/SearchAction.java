package cn.com.bonde.b2b.website.action;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.DmSpfl;
import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.service.BaseCodeService;
import cn.com.bonde.b2b.website.service.ISearchService;
import cn.com.bonde.b2b.website.util.Pager;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "index", location = "/pages/index.jsp"), @Result(name = "productSearch", location = "/pages/productSearch.jsp"),
		@Result(name = "productList", location = "/pages/productList.jsp"), @Result(name = "productDetail", location = "/pages/productDetail.jsp") })
public class SearchAction extends ProjectBaseAction
{

	private SearchFindEntity searchFindEntity;

	private Pager pager;

	private Map<String, Object> productMap;

	private List<DmSpfl> spflList;

	@Resource
	private ISearchService searchService;

	@Resource(name = "baseCodeService")
	private BaseCodeService baseCodeService;

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4288078529248188610L;

	@Action(value = "init")
	public String init() throws Exception
	{
		return "index"; //指向真正的首页（带广告图片），而不是又跳转到产品列表页面   //searchCatalog();
	}	

	@Action(value = "doSearch")
	public String doSearch() throws Exception
	{
		if (searchFindEntity == null)
		{
			searchFindEntity = new SearchFindEntity();
		}
		searchFindEntity.setRows(50);
		pager = searchService.searchByKeyword(searchFindEntity);
		return "productSearch";
	}

	@Action(value = "searchCatalog")
	public String searchCatalog() throws Exception
	{
		if (searchFindEntity == null)
		{
			searchFindEntity = new SearchFindEntity();
		}
		searchFindEntity.setRows(30);
		pager = searchService.searchByKeyword(searchFindEntity);
		return "productList";
	}

	@Action(value = "searchProduct")
	public String searchProduct() throws Exception
	{
		Long productId = Long.valueOf(getParameter("productId"));
		productMap = searchService.queryProduct(productId);
		if (productMap != null)
		{
			spflList = baseCodeService.getSpflList(((BigInteger) productMap.get("spfl_dm")).longValue());
			Collections.reverse(spflList);
		}
		return "productDetail";
	}

	@Action(value = "loadImage")
	public void loadImage() throws Exception
	{
		String url = getParameter("imageUrl");
		HttpServletResponse imgResponse = getResponse();
		FileInputStream in = new FileInputStream(new File(url));
		ServletOutputStream out = imgResponse.getOutputStream();
		byte[] bytes = new byte[2048];
		int bytesReaded = -1;
		while ((bytesReaded = in.read(bytes)) != -1)
		{
			out.write(bytes, 0, bytesReaded);
		}
		out.flush();
		in.close();
		out.close();
	}

	/**
	 * @return the searchFindEntity
	 */
	public SearchFindEntity getSearchFindEntity()
	{
		return searchFindEntity;
	}

	/**
	 * @param searchFindEntity
	 *            the searchFindEntity to set
	 */
	public void setSearchFindEntity(SearchFindEntity searchFindEntity)
	{
		this.searchFindEntity = searchFindEntity;
	}

	/**
	 * @return the pager
	 */
	public Pager getPager()
	{
		return pager;
	}

	/**
	 * @param pager
	 *            the pager to set
	 */
	public void setPager(Pager pager)
	{
		this.pager = pager;
	}

	/**
	 * @return the productMap
	 */
	public Map<String, Object> getProductMap()
	{
		return productMap;
	}

	/**
	 * @param productMap
	 *            the productMap to set
	 */
	public void setProductMap(Map<String, Object> productMap)
	{
		this.productMap = productMap;
	}

	/**
	 * @return the spflList
	 */
	public List<DmSpfl> getSpflList()
	{
		return spflList;
	}

	/**
	 * @param spflList
	 *            the spflList to set
	 */
	public void setSpflList(List<DmSpfl> spflList)
	{
		this.spflList = spflList;
	}

}
