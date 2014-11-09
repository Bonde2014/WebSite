package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.ISearchDao;
import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

@Repository("searchDao")
public class SearchDaoImpl extends BaseDBDaoImpl implements ISearchDao {

    @Override
    public Pager searchByKeyword(SearchFindEntity searchFindEntity) throws Exception{
        Map<String, Object> parasMaps = new HashMap<String, Object>();
        StringBuilder hqlBuilder = new StringBuilder("FROM SpSpxx a, SpSpxq b where a.spDm=b.spDm");
        if(!StringUtils.isBlank(searchFindEntity.getKeyword())){
            hqlBuilder.append(" and a.spmc like:keyword");
            parasMaps.put("keyword", "%"+searchFindEntity.getKeyword()+"%");
        }
        
        StringBuilder countSqlBuilder = new StringBuilder("select count(1) FROM sp_spxx a, sp_spxq b where a.sp_dm=b.sp_dm");
        if(!StringUtils.isBlank(searchFindEntity.getKeyword())){
            countSqlBuilder.append(" and a.spmc like:keyword");
        }
        return this.getListByHQL(hqlBuilder.toString(), parasMaps, searchFindEntity,countSqlBuilder.toString());
    }


}
