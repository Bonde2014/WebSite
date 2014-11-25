package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IOrderDao;
import cn.com.bonde.b2b.website.entity.XsDdqk;
import cn.com.bonde.b2b.website.entity.XsDdqkSpmx;
import cn.com.bonde.b2b.website.util.DataSwitch;

@Repository("orderDAO")
public class OrderDAOImpl  extends BaseDBDaoImpl implements IOrderDao {

    @Override
    public List<XsDdqk> queryOrder(Long userId, String orderStatus) throws Exception {
        Map<String, Object> parasMaps = new HashMap<String, Object>();
        parasMaps.put("qdsDm", userId);
        if(!StringUtils.isBlank(orderStatus)){
            parasMaps.put("ddzt", orderStatus);
        }
        return this.getEntitiesListByProperties(XsDdqk.class, parasMaps, "ddscsj");
    }

    @Override
    public List<Map<String, Object>> queryOrderDetail(List<Long> orderNumList) throws Exception {
    	  String ddxhStr="-1";
    	   for(Long orderNum: orderNumList){
    		   ddxhStr+=(","+orderNum);
    	   }
           StringBuffer sbSql = new StringBuffer();
           sbSql.append("SELECT ");
           sbSql.append("  T.DDXH, ");
           sbSql.append("  D.SP_DM, ");
           sbSql.append("  D.SP_JG, ");
           sbSql.append("  D.SP_ZJ, ");
           sbSql.append("  D.SP_SL, ");
           sbSql.append("  S.SPMC ");
           sbSql.append("FROM ");
           sbSql.append("  XS_DDQK T ");
           sbSql.append("LEFT JOIN XS_DDQK_SPMX D ");
           sbSql.append("  ON T.DDXH=D.DDXH ");
           sbSql.append("LEFT JOIN SP_SPXX S ");
           sbSql.append("  ON D.SP_DM=S.SP_DM ");
           sbSql.append("WHERE ");
           sbSql.append("  T.DDXH ");
           sbSql.append("IN ");
           sbSql.append("  ("+ddxhStr+") ");
           sbSql.append("ORDER BY ");
           sbSql.append("  T.DDXH, ");
           sbSql.append("  D.SP_DM ");
           Map<String, Object> parasMaps = new HashMap<String, Object>();
           return this.getMapListBySql(sbSql.toString(), parasMaps);
    }

}
