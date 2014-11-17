/**
 * 
 */
package cn.com.bonde.b2b.website.service;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface IShopcartService
{
	public <T> List<T> getEntitiesListByProperty(Class<T> typeClass, String propertyName, Object propertyValue, String... orderBy) throws Exception;
}
