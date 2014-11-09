package cn.com.bonde.b2b.website.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "success", location = "/pages/productList.jsp") })
public class SearchAction extends ProjectBaseAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4288078529248188610L;
    
    @Action(value="doSearch")
    public String doSearch(){
        return SUCCESS;
    }

}
