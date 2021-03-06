/**
 * 
 */
package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IShopcartDao;
import cn.com.bonde.b2b.website.entity.DmPsfs;
import cn.com.bonde.b2b.website.entity.QxKhxx;
import cn.com.bonde.b2b.website.util.MyException;

/**
 * @author Administrator
 * 
 */
@Repository("shopcartDao")
public class ShopcartDaoImpl extends BaseDBDaoImpl implements IShopcartDao
{

	/**
	 * @创建人：应洪峰
	 * @创建时间：2014年11月17日
	 * @功能说明：
	 * @return
	 * @throws MyException
	 */
	@Override
	public List<Map<String, Object>> getEntityList(String khDm, String... ids) throws Exception
	{
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT ");
		sbSql.append("  T.KH_DM, ");
		sbSql.append("  S.SPMC, ");
		sbSql.append("  T.SP_DM, ");
		sbSql.append("  T.SP_SL, ");
		sbSql.append("  T.TJSJ, ");
		sbSql.append("  D.JG1*T.SP_SL AS ZJ1, ");
		sbSql.append("  D.JG2*T.SP_SL AS ZJ2, ");
		sbSql.append("  D.JG3*T.SP_SL AS ZJ3, ");
		sbSql.append("  D.JG0*T.SP_SL AS ZJ0, ");
		sbSql.append("  D.JG1, ");
		sbSql.append("  D.JG2, ");
		sbSql.append("  D.JG3, ");
		sbSql.append("  D.JG0, ");
		sbSql.append("   ");
		sbSql.append("CASE WHEN ");
		sbSql.append("  K.QDS_JB=1 ");
		sbSql.append("THEN ");
		sbSql.append("  D.JG1*T.SP_SL ");
		sbSql.append("WHEN ");
		sbSql.append("  K.QDS_JB=2 ");
		sbSql.append("THEN ");
		sbSql.append("  D.JG2*T.SP_SL ");
		sbSql.append("ELSE ");
		sbSql.append("  D.JG3*T.SP_SL ");
		sbSql.append("END ");
		sbSql.append("  AS ZJ, ");
		sbSql.append("   ");
		sbSql.append("CASE WHEN ");
		sbSql.append("  K.QDS_JB=1 ");
		sbSql.append("THEN ");
		sbSql.append("  D.JG1 ");
		sbSql.append("WHEN ");
		sbSql.append("  K.QDS_JB=2 ");
		sbSql.append("THEN ");
		sbSql.append("  D.JG2 ");
		sbSql.append("ELSE ");
		sbSql.append("  D.JG3 ");
		sbSql.append("END ");
		sbSql.append("  AS JG, ");
		sbSql.append("  D.KSSL, ");
		sbSql.append("  D.BJSJ, ");
		sbSql.append("  D.BJRY_DM, ");
		sbSql.append("  D.SJBZ, ");
		sbSql.append("  D.BJBZ ");
		sbSql.append("FROM ");
		sbSql.append("  XS_GWC T ");
		sbSql.append("LEFT JOIN QX_KHXX K ");
		sbSql.append("  ON T.KH_DM=K.KH_DM ");
		sbSql.append("LEFT JOIN XS_FJBJ D ");
		sbSql.append("  ON T.SP_DM=D.SP_DM ");
		sbSql.append("LEFT JOIN SP_SPXX S ");
		sbSql.append("  ON T.SP_DM=S.SP_DM ");
		sbSql.append("WHERE ");
		sbSql.append("  T.KH_DM=:KHDM ");
		if (ids.length != 0)
		{
			sbSql.append(" AND T.SP_DM IN (" + ids[0].toString().trim() + ") ");
		}
		sbSql.append("ORDER BY ");
		sbSql.append("  T.SP_DM ASC ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("KHDM", khDm);
		return this.getMapListBySql(sbSql.toString(), paramMap);
	}

	@SuppressWarnings("unchecked")
	public List<DmPsfs> getPsfsList() throws Exception
	{
		return getEntityListByHQL("from DmPsfs where sfyx=1 order by pxwz");
	}

	public boolean deleteShopCart(QxKhxx khxx, String spdms) throws Exception
	{
		Map<String, Object> paramMaps = new HashMap<String, Object>();
		paramMaps.put("KHDM", khxx.getKhDm());
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("DELETE FROM ");
		sbSql.append("  XS_GWC ");
		sbSql.append("WHERE ");
		sbSql.append("  KH_DM=:KHDM ");
		sbSql.append("  AND SP_DM ");
		sbSql.append("IN ");
		sbSql.append("  (" + spdms + ") ");
		return this.deleteBySql(sbSql.toString(), paramMaps);
	}
}
