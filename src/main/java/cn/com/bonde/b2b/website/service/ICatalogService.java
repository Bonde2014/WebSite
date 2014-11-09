/**
 * 
 */
package cn.com.bonde.b2b.website.service;

import javax.servlet.http.HttpSession;

import cn.com.bonde.b2b.website.entity.QxDlxx;

/**
 * @author Administrator
 *
 */
public  interface ICatalogService
{
	public String queryCatalog(String spfl_dm)throws Exception;
}
