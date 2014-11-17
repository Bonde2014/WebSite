/**
 * 
 */
package cn.com.bonde.b2b.website.entity.findEntity;

/**
 * @author Administrator
 *
 */
public class SearchFindEntity extends BaseFindEntity
{
     private String keyword;
     
     private Long catalog;

    
    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    
    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    
    /**
     * @return the catalog
     */
    public Long getCatalog() {
        return catalog;
    }


    
    /**
     * @param catalog the catalog to set
     */
    public void setCatalog(Long catalog) {
        this.catalog = catalog;
    }
    
}
