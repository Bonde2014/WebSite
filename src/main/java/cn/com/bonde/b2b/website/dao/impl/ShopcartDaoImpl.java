/**
 * 
 */
package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IShopcartDao;
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> getEntityList(String khDm) throws Exception
	{
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT ");
		sbSql.append("  KH_DM, ");
		sbSql.append("  SP_DM, ");
		sbSql.append("  SP_JG, ");
		sbSql.append("  SP_JG_CJ, ");
		sbSql.append("  SP_SL, ");
		sbSql.append("  SP_ZJ, ");
		sbSql.append("  TJSJ ");
		sbSql.append("FROM ");
		sbSql.append("  XS_GWC ");
		sbSql.append("WHERE ");
		sbSql.append("  KH_DM=:KHDM ");
		sbSql.append("ORDER BY ");
		sbSql.append("  TJSJ ASC ");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("KHDM", khDm);
		return this.getMapListBySql(sbSql.toString(), paramMap);
	}

}
