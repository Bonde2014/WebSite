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
public  interface ILoginService
{
	public String doLogin(QxDlxx qxDlxx,HttpSession session)throws Exception;
}
