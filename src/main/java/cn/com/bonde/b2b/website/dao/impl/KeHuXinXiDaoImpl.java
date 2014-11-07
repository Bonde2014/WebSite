/**
 * 
 */
package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IKeHuXinXiDao;
import cn.com.bonde.b2b.website.entity.findEntity.KeHuXinXiFindEntity;
import cn.com.bonde.b2b.website.util.MyException;
import cn.com.bonde.b2b.website.util.Pager;

/**
 * @author Administrator
 * 
 */
@Repository("keHuXinXiDao")
public class KeHuXinXiDaoImpl extends BaseDBDaoImpl implements IKeHuXinXiDao
{

	/**
	 * @throws Exception 
	 * @创建人：应洪峰
	 * @创建时间：2014年11月2日
	 * @功能说明：
	 * @return
	 * @throws MyException
	 */
	@Override
	public Pager getList(KeHuXinXiFindEntity findEntity) throws Exception
	{
		Map<String, Object> parasMaps = new HashMap<String, Object>();
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("SELECT ");
		sbSql.append("  KH_DM AS KHDM, ");
		sbSql.append("  DLM, ");
		sbSql.append("  KHLB, ");
		sbSql.append("  KH_MC, ");
		sbSql.append("  date_format(LRSJ,'%Y-%m-%d %h:%i:%s') AS LRSJ, ");
		sbSql.append("  FZR_XM AS FZRXM ");
		sbSql.append("FROM ");
		sbSql.append("  QX_KHXX ");
		sbSql.append("  WHERE 1=1 ");
		sbSql.append("  AND FZR_XM LIKE :FZRXM ");
		sbSql.append("  OR  DLM LIKE :DLM ");
		parasMaps.put("FZRXM", findEntity.getFzrxm()+"%");
		parasMaps.put("DLM", findEntity.getDlm()+"%");
		return this.getListBySQLQuery(sbSql.toString(), parasMaps, findEntity);
	}

}
