package cn.com.bonde.b2b.website.dao;

import java.util.List;
import java.util.Map;

import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

public interface ISearchDao extends IBaseDBDao {
    
    public Pager searchByKeyword(SearchFindEntity searchFindEntity) throws Exception;
    
    
    public List<Map<String, Object>> queryTodayPrice(Long topCatalog) throws Exception;
}
