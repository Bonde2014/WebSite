package cn.com.bonde.b2b.website.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.Userinfo;
import cn.com.bonde.b2b.website.service.IUserService;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value="/")
@Results({@Result(name = "success", location = "success.jsp")})
public class LoginAction extends ProjectBaseAction {
	
	

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5748465179322729840L;

    @Resource(name="userService")
    private IUserService userService;
    private List<Userinfo> list=null;
    /**
	 * @param userService the userService to set
	 */
	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	/**
	 * @return the list
	 */
	public List<Userinfo> getList()
	{
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Userinfo> list)
	{
		this.list = list;
	}

	@Action(value = "login")
    public String login() throws Exception {
		Userinfo user = new Userinfo(getParameter("username"), getParameter("password"));
        userService.save(user);
        list=userService.query();
        return SUCCESS;
    }


}
