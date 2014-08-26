package cn.com.bonde.b2b.website.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.User;
import cn.com.bonde.b2b.website.service.IUserService;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Results({@Result(name = "success", location = "login.jsp")})
public class LoginAction extends ProjectBaseAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5748465179322729840L;

    @Autowired
    private IUserService userService;

    @Action(value = "login")
    public String login() {
        
        
        User user = new User(getParameter("username"), getParameter("password"));
        userService.save(user);
        return SUCCESS;
    }


}
