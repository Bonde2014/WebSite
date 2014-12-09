/**
 * 
 */
package cn.com.bonde.b2b.website.service;


/**
 * @author Administrator
 *
 */
public  interface ICatalogService
{
	public String queryCatalog(Long spflDm)throws Exception;
	
	public String queryAllCatalog()throws Exception;
}
