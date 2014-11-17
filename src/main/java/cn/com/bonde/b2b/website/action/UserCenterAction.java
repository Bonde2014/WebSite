package cn.com.bonde.b2b.website.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.service.IOrderService;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "userCenter", location = "/pages/userCenter.jsp"),
    @Result(name = "userOrder", location = "/pages/userOrder.jsp")})
public class UserCenterAction extends ProjectBaseAction
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4044106435263199102L;
    
    @Resource
    private IOrderService orderService;
    
    
    @Action(value="userCenter")
    public String init(){
        return "userCenter";
    }
    
    @Action(value="userOrder")
    public String userOrder() throws Exception{
        orderService.queryOrder(1L, null);
        return "userOrder";
    }
    
    


	
}
