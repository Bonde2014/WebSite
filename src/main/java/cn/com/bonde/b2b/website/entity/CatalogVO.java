package cn.com.bonde.b2b.website.entity;

import java.util.List;

public class CatalogVO {
    
    private Long id;
    
    private String name;
    
    private List<CatalogVO> childList;

    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    
    /**
     * @return the childList
     */
    public List<CatalogVO> getChildList() {
        return childList;
    }


    
    /**
     * @param childList the childList to set
     */
    public void setChildList(List<CatalogVO> childList) {
        this.childList = childList;
    }

    
   
}
