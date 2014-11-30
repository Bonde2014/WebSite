/**
 * 
 */
package cn.com.bonde.b2b.website.service;

import java.util.List;
import java.util.Map;

import cn.com.bonde.b2b.website.entity.DmPsfs;
import cn.com.bonde.b2b.website.entity.QxKhxx;

/**
 * @author Administrator
 * 
 */
public interface IShopcartService
{
	public <T> List<T> getEntitiesListByProperty(Class<T> typeClass, String propertyName, Object propertyValue, String... orderBy) throws Exception;

	public <T> List<T> getEntityListByHQL(final String hql, Map<String, Object>... paramMap) throws Exception;

	public List<Map<String, Object>> getEntityList(String khDm, String... ids) throws Exception;

	public boolean addToShopCart(Long spdm, Integer spsl, QxKhxx khxx) throws Exception;

	public List<DmPsfs> getPsfsList() throws Exception;

	public boolean deleteShopCart(QxKhxx khxx, String spdms) throws Exception;

	public boolean updateShopCart(Long spdm, Integer spsl, QxKhxx khxx) throws Exception;
}
