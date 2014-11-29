package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IOrderDao;
import cn.com.bonde.b2b.website.entity.XsDdqk;

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
    
    public List<Map<String, Object>> queryOrderList(Long userId, String orderStatus) throws Exception {
         StringBuffer sbSql = new StringBuffer();
         sbSql.append("SELECT ");
         sbSql.append("  T.DDID, ");
         sbSql.append("  T.DDXH, ");
         sbSql.append("  T.QDS_DM, ");
         sbSql.append("  T.DDZJE, ");
         sbSql.append("  T.DDZJE_GJ, ");
         sbSql.append("  T.DDZT, ");
         sbSql.append("  T.XSRY_DM,");
         sbSql.append("  T.DDSCSJ, ");
         sbSql.append("  T.DDQRSJ, ");
         sbSql.append("  T.DDFHSJ , ");
         sbSql.append("  T.DDZFSJ, ");
         sbSql.append("  D.NAME, ");
         sbSql.append("  (SELECT COUNT(S.DDID) ");
         sbSql.append("FROM ");
         sbSql.append("  XS_DDQK_SPMX S ");
         sbSql.append("WHERE ");
         sbSql.append("  S.DDID=T.DDID) AS SPSL ");
         sbSql.append("FROM ");
         sbSql.append("  XS_DDQK T ");
         sbSql.append("LEFT JOIN T_ENUM D ");
         sbSql.append("  ON T.DDZT=D.VALUE ");
         sbSql.append("  AND UPPER(D.TYPE)=UPPER('DDZT') ");
         sbSql.append("  WHERE 1=1");
         sbSql.append("  AND T.QDS_DM=:QDSDM ");
         if(!StringUtils.isBlank(orderStatus)){
         sbSql.append("  AND T.DDZT=:DDZT ");
         }
         sbSql.append("  ORDER BY  T.DDSCSJ DESC");
         Map<String, Object> parasMaps = new HashMap<String, Object>();
         parasMaps.put("QDSDM", userId);
         if(!StringUtils.isBlank(orderStatus)){
             parasMaps.put("DDZT", orderStatus);
         }
         return this.getMapListBySql(sbSql.toString(), parasMaps);
  }


    @Override
    public List<Map<String, Object>> queryOrderDetail(List<String> orderNumList) throws Exception {
    	  String ddidStr="-1";
    	   for(String orderNum: orderNumList){
    		   ddidStr+=(","+orderNum);
    	   }
           StringBuffer sbSql = new StringBuffer();
           sbSql.append("SELECT ");
           sbSql.append("  T.DDID, ");
           sbSql.append("  T.DDXH, ");
           sbSql.append("  D.SP_DM, ");
           sbSql.append("  D.SP_JG_CJ, ");
           sbSql.append("  D.SP_ZJ, ");
           sbSql.append("  D.SP_SL, ");
           sbSql.append("  S.SPMC ");
           sbSql.append("FROM ");
           sbSql.append("  XS_DDQK T ");
           sbSql.append("LEFT JOIN XS_DDQK_SPMX D ");
           sbSql.append("  ON T.DDID=D.DDID ");
           sbSql.append("LEFT JOIN SP_SPXX S ");
           sbSql.append("  ON D.SP_DM=S.SP_DM ");
           sbSql.append("WHERE ");
           sbSql.append("  T.DDID ");
           sbSql.append("IN ");
           sbSql.append("  ("+ddidStr+") ");
           sbSql.append("ORDER BY ");
           sbSql.append("  T.DDXH, ");
           sbSql.append("  D.SP_DM ");
           Map<String, Object> parasMaps = new HashMap<String, Object>();
           return this.getMapListBySql(sbSql.toString(), parasMaps);
    }
    
    
    public List<Map<String, Object>> queryDdztList(Long userId) throws Exception {
    	StringBuffer sbSql = new StringBuffer();
    	sbSql.append("SELECT ");
    	sbSql.append("  D.NAME, ");
    	sbSql.append("  D.VALUE, ");
    	sbSql.append("  COUNT(T.DDID) AS DDSL ");
    	sbSql.append("FROM ");
    	sbSql.append("  T_ENUM D ");
    	sbSql.append("LEFT JOIN XS_DDQK T ");
    	sbSql.append("  ON T.DDZT=D.VALUE ");
    	sbSql.append("  AND T.QDS_DM=:QDSDM ");
    	sbSql.append("WHERE ");
    	sbSql.append("  UPPER(D.TYPE)=UPPER('DDZT') ");
    	sbSql.append("  AND D.VALUE ");
    	sbSql.append("IN ");
    	sbSql.append("  ('01', ");
    	sbSql.append("  '03', ");
    	sbSql.append("  '05') ");
    	sbSql.append("GROUP BY ");
    	sbSql.append("  D.NAME, ");
    	sbSql.append("  D.VALUE ");
    	sbSql.append("ORDER BY ");
    	sbSql.append("  D.PXWZ ");
        Map<String, Object> parasMaps = new HashMap<String, Object>();
        parasMaps.put("QDSDM", userId);
        return this.getMapListBySql(sbSql.toString(), parasMaps);
 }


}
