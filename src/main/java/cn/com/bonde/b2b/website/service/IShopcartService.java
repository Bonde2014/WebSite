/**
 * 
 */
package cn.com.bonde.b2b.website.service;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */
public interface IShopcartService
{
	public <T> List<T> getEntitiesListByProperty(Class<T> typeClass, String propertyName, Object propertyValue, String... orderBy) throws Exception;
	public <T> List<T> getEntityListByHQL(final String hql, Map<String, Object>... paramMap) throws Exception;
	public List<Map<String,Object>> getEntityList(String khDm)throws Exception;
}
