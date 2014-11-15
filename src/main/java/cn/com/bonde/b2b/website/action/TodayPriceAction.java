package cn.com.bonde.b2b.website.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.DmSpfl;
import cn.com.bonde.b2b.website.service.BaseCodeService;
import cn.com.bonde.b2b.website.service.ISearchService;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "success", location = "/pages/todayPrice.jsp") })
public class TodayPriceAction extends ProjectBaseAction {
    
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3496500170192948959L;
    
    private List<DmSpfl> oneLevelCategoryList;
    
    private List<List<Map<String,Object>>> todayPriceList;
    
    @Resource
    private ISearchService searchService;
    
    @Resource
    private BaseCodeService baseCodeService;
    
    
    @Action(value="todayPrice")
    public String init() throws Exception {
        List<DmSpfl> spflList = baseCodeService.getSpflList();
        //上级代码为空表示第一级类目
        oneLevelCategoryList = new ArrayList<DmSpfl>();
        todayPriceList = new ArrayList<List<Map<String,Object>>>();
        for(DmSpfl spfl:spflList){
            if(spfl.getSjSpflDm()==null){
                oneLevelCategoryList.add(spfl);
                todayPriceList.add(searchService.queryTodayPrice(spfl.getSpflDm()));
            }
        }
        return SUCCESS;
    }
    

    
    /**
     * @return the oneLevelCategoryList
     */
    public List<DmSpfl> getOneLevelCategoryList() {
        return oneLevelCategoryList;
    }


    
    /**
     * @param oneLevelCategoryList the oneLevelCategoryList to set
     */
    public void setOneLevelCategoryList(List<DmSpfl> oneLevelCategoryList) {
        this.oneLevelCategoryList = oneLevelCategoryList;
    }



    
    /**
     * @return the todayPriceList
     */
    public List<List<Map<String, Object>>> getTodayPriceList() {
        return todayPriceList;
    }



    
    /**
     * @param todayPriceList the todayPriceList to set
     */
    public void setTodayPriceList(List<List<Map<String, Object>>> todayPriceList) {
        this.todayPriceList = todayPriceList;
    }

}
