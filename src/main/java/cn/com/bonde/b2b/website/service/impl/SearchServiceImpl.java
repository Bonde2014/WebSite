package cn.com.bonde.b2b.website.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.ISearchDao;
import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.service.ISearchService;
import cn.com.bonde.b2b.website.util.Pager;

@Service(value="searchService")
public class SearchServiceImpl implements ISearchService {
    
    @Resource
    private ISearchDao searchDao;

    @Override
    public Pager searchByKeyword(SearchFindEntity searchFindEntity) throws Exception{
        return searchDao.searchByKeyword(searchFindEntity);
    }

    
    /**
     * @return the searchDao
     */
    public ISearchDao getSearchDao() {
        return searchDao;
    }

    
    /**
     * @param searchDao the searchDao to set
     */
    public void setSearchDao(ISearchDao searchDao) {
        this.searchDao = searchDao;
    }

}
