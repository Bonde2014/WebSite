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
import cn.com.bonde.b2b.website.service.ILoginService;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.WriteJsonToPage;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "success", location = "/pages/login.jsp") })
public class LoginAction extends ProjectBaseAction
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5748465179322729840L;

	@Resource(name = "loginService")
	private ILoginService loginService;
	private QxDlxx qxDlxx;

	/**
	 * @return the loginService
	 */
	public ILoginService getLoginService()
	{
		return loginService;
	}

	/**
	 * @param loginService
	 *            the loginService to set
	 */
	public void setLoginService(ILoginService loginService)
	{
		this.loginService = loginService;
	}

	/**
	 * @return the qxDlxx
	 */
	public QxDlxx getQxDlxx()
	{
		return qxDlxx;
	}

	/**
	 * @param qxDlxx
	 *            the qxDlxx to set
	 */
	public void setQxDlxx(QxDlxx qxDlxx)
	{
		this.qxDlxx = qxDlxx;
	}

	@Action(value = "doLogin")
	public void doLogin() throws Exception
	{
		try
		{
			String msg = loginService.doLogin(qxDlxx, this.getSession());
			WriteJsonToPage.WriteJson(msg);
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
	}

	public String update() throws Exception
	{
		try
		{
			loginService.update(qxDlxx);
			return "";
		}
		catch (Exception e)
		{
			throw new MyException(e, this.getClass(), "");
		}
	}
	
	@Action(value="doLogout")
    public String doLogout() throws Exception{
        getSession().invalidate();
        return SUCCESS;
    }
}
