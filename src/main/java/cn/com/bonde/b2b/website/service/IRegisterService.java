/**
 * 
 */
package cn.com.bonde.b2b.website.service;


import cn.com.bonde.b2b.website.entity.QxDlxx;
import cn.com.bonde.b2b.website.entity.QxKhxx;



/**
 * @author Administrator
 * <p>功能描述: 客户自行登记注册服务</p>
 */
public  interface IRegisterService
{
	
	//保存账户信息和客户信息
	public boolean addRegistInfo(QxDlxx dlxx, QxKhxx khxx)throws Exception;
		
}
