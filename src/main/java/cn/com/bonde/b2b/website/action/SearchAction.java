package cn.com.bonde.b2b.website.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.service.ISearchService;
import cn.com.bonde.b2b.website.util.Pager;

@Controller
@Scope("prototype")
@ParentPackage(value = "base")
@Namespace(value = "/")
@Results({ @Result(name = "productSearch", location = "/pages/productSearch.jsp"), 
    @Result(name = "productList", location = "/pages/productList.jsp"),
    @Result(name = "productDetail", location = "/pages/productDetail.jsp")})
public class SearchAction extends ProjectBaseAction {
    
    private SearchFindEntity searchFindEntity;
    
    private Pager pager;
    
    @Resource
    private ISearchService searchService;

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4288078529248188610L;
    
    @Action(value="doSearch")
    public String doSearch(){
        searchFindEntity.setRows(50);
        try {
            pager = searchService.searchByKeyword(searchFindEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "productSearch";
    }
    
    @Action(value="searchCatalog")
    public String searchCatalog(){
        return "productList";
    }
    
    @Action(value="searchProduct")
    public String searchProdcut(){
        return "productDetail";
    }

    
    /**
     * @return the searchFindEntity
     */
    public SearchFindEntity getSearchFindEntity() {
        return searchFindEntity;
    }

    
    /**
     * @param searchFindEntity the searchFindEntity to set
     */
    public void setSearchFindEntity(SearchFindEntity searchFindEntity) {
        this.searchFindEntity = searchFindEntity;
    }


    
    /**
     * @return the pager
     */
    public Pager getPager() {
        return pager;
    }


    
    /**
     * @param pager the pager to set
     */
    public void setPager(Pager pager) {
        this.pager = pager;
    }

    
}
