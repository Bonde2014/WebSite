/**
 * 
 */
package cn.com.bonde.b2b.website.dao;

import java.util.List;
import java.util.Map;

import cn.com.bonde.b2b.website.entity.DmPsfs;
import cn.com.bonde.b2b.website.entity.QxKhxx;

/**
 * @author Administrator
 * 
 */
public interface IShopcartDao extends IBaseDBDao
{
	public List<Map<String, Object>> getEntityList(String khDm, String... ids) throws Exception;

	public List<DmPsfs> getPsfsList() throws Exception;

	public boolean deleteShopCart(QxKhxx khxx, String spdms) throws Exception;
}
