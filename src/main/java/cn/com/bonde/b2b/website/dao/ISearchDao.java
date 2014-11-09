package cn.com.bonde.b2b.website.dao;

import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

public interface ISearchDao extends IBaseDBDao {
    
    public Pager searchByKeyword(SearchFindEntity searchFindEntity) throws Exception;
    
}
