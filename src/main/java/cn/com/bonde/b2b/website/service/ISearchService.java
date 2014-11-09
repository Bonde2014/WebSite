package cn.com.bonde.b2b.website.service;

import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

public interface ISearchService {
    
    public Pager searchByKeyword(SearchFindEntity searchFindEntity) throws Exception;

}
