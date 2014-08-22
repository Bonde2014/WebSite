package cn.com.bonde.b2b.website.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.dao.IUserDAO;
import cn.com.bonde.b2b.website.entity.User;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value="/login")
@Results({@Result(name = "success", location = "pages/login.jsp")})
public class LoginAction extends ProjectBaseAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5748465179322729840L;

    @Resource(name = "userDAOImpl")
    private IUserDAO userDAO;

    @Action(value = "login")
    public String login() {
        //User user = userDAO.findUserByNameAndPass(getParameter("username"), getParameter("password"));
        userDAO.saveUser(getParameter("username"), getParameter("password"));
        return SUCCESS;
    }


}
