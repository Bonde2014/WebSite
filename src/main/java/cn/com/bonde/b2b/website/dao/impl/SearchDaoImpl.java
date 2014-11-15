package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.ISearchDao;
import cn.com.bonde.b2b.website.entity.findEntity.SearchFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

@Repository("searchDao")
public class SearchDaoImpl extends BaseDBDaoImpl implements ISearchDao {

    @Override
    public Pager searchByKeyword(SearchFindEntity searchFindEntity) throws Exception {
        Map<String, Object> parasMaps = new HashMap<String, Object>();
        StringBuilder hqlBuilder = new StringBuilder("FROM SpSpxx a, SpSpxq b where a.spDm=b.spDm");
        if (!StringUtils.isBlank(searchFindEntity.getKeyword())) {
            hqlBuilder.append(" and a.spmc like:keyword");
            parasMaps.put("keyword", "%" + searchFindEntity.getKeyword() + "%");
        }

        StringBuilder countSqlBuilder = new StringBuilder(
                                                          "select count(1) FROM sp_spxx a, sp_spxq b where a.sp_dm=b.sp_dm");
        if (!StringUtils.isBlank(searchFindEntity.getKeyword())) {
            countSqlBuilder.append(" and a.spmc like:keyword");
        }
        return this.getListByHQL(hqlBuilder.toString(), parasMaps, searchFindEntity, countSqlBuilder.toString());
    }

    @Override
    public List<Map<String, Object>> queryTodayPrice(Long topCatalog) throws Exception {
        final String sql = "SELECT a.sp_dm spDm,a.jg1,a.jg2,a.jg3,a.kssl,a.bjsj,b.spmc,b.scjg,(select t.spfl_mc from dm_spfl t where t.spfl_dm=b.spfl_dm) spflMc,(select t.sppp_mc from dm_spfl2 t where t.sppp_dm = b.sppp_dm) spppMc FROM xs_fjbj a,sp_spxx b where a.sp_dm=b.sp_dm and a.bjbz='1' and a.sjbz='1' and b.spfl_dm like :topCatalog";
        Map<String, Object> parasMaps = new HashMap<String, Object>();
        parasMaps.put("topCatalog", topCatalog+"%");
        return this.getMapListBySql(sql, parasMaps);
    }

}
