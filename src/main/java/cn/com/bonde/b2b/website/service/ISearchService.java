package cn.com.bonde.b2b.website.service;

import java.util.List;
import java.util.Map;

import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

public interface ISearchService {
    
    public Pager searchByKeyword(SearchFindEntity searchFindEntity) throws Exception;
    
    public List<Map<String, Object>> queryTodayPrice(Long topCatalog) throws Exception;

}
