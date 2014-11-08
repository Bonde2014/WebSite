/**
 * 
 */
package cn.com.bonde.b2b.website.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.ILoginDao;
import cn.com.bonde.b2b.website.entity.QxDlxx;
import cn.com.bonde.b2b.website.service.ILoginService;
import cn.com.bonde.b2b.website.util.Constants;
import cn.com.bonde.b2b.website.util.MD5;
import cn.com.bonde.b2b.website.util.MyException;

/**
 * @author Administrator
 *
 */
@Service(value = "loginService")
public class LoginSevriceImpl implements ILoginService
{
	@Resource(name="loginDao")
	private ILoginDao loginDao;
	

	/**
	 * @return the loginDao
	 */
	public ILoginDao getLoginDao()
	{
		return loginDao;
	}


	/**
	 * @param loginDao the loginDao to set
	 */
	public void setLoginDao(ILoginDao loginDao)
	{
		this.loginDao = loginDao;
	}


	/**
	 * @创建人：应洪峰
	 * @创建时间：2014年11月8日
	 * @功能说明：
	 * @return
	 * @throws MyException
	 */
	@Override
	public String doLogin(QxDlxx qxDlxx,HttpSession session) throws Exception
	{
		Map<String, Object> propertyMap = new HashMap<String, Object>();
		propertyMap.put("dlm", qxDlxx.getDlm());
		propertyMap.put("dlkl", MD5.getMd5(qxDlxx.getDlkl()));
		List<QxDlxx> list = loginDao.getEntitiesListByProperties(QxDlxx.class, propertyMap);
		if(list==null||list.size()!=1){
			return "账号或密码错误";
		}else{
			//否则保存帐号信息到session中
			session.setAttribute(Constants.SESSION_LOGIN, list.get(0));
			return "true";
		}
		
	}

}
