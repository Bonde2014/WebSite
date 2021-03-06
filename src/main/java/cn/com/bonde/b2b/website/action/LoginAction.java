package cn.com.bonde.b2b.website.action;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.QxDlxx;
import cn.com.bonde.b2b.website.service.ILoginService;
import cn.com.bonde.b2b.website.util.Constants;
import cn.com.bonde.b2b.website.util.MD5;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.WriteJsonToPage;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "success", location = "/pages/login.jsp"),
           @Result(name = "changePassword", location = "/pages/changePassword.jsp")})
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
	
	@Action(value="changePasswordInit")
	public String changePasswordInit(){
	    return "changePassword";
	}
	
	@Action(value="changePassword")
    public void changePassword() throws Exception{
	   QxDlxx dlxx = (QxDlxx)this.getSession().getAttribute(Constants.SESSION_LOGIN);
       String dlklOld = getParameter("dlkl_old");
       String dlklNew = getParameter("dlkl_new");
       boolean flag = false;
       if(!StringUtils.isBlank(dlklOld)
               &&MD5.getMd5(dlklOld).equals(dlxx.getDlkl())){
           dlxx.setDlkl(MD5.getMd5(dlklNew));
           flag = loginService.update(dlxx);
       }
       WriteJsonToPage.WriteJson(flag);
    }

	@Action(value="doLogout")
    public String doLogout() throws Exception{
        getSession().invalidate();
        return SUCCESS;
    }
	
}
