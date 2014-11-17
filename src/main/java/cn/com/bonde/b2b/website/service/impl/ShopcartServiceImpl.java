/**
 * 
 */
package cn.com.bonde.b2b.website.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IShopcartDao;
import cn.com.bonde.b2b.website.service.IShopcartService;
import cn.com.bonde.b2b.website.util.MyException;

/**
 * @author Administrator
 *
 */
@Service(value = "shopcartService")
public class ShopcartServiceImpl implements IShopcartService
{
	@Resource(name="shopcartDao")
	private IShopcartDao shopcartDao;

	/**
	 * @return the shopcartDao
	 */
	public IShopcartDao getShopcartDao()
	{
		return shopcartDao;
	}

	/**
	 * @param shopcartDao the shopcartDao to set
	 */
	public void setShopcartDao(IShopcartDao shopcartDao)
	{
		this.shopcartDao = shopcartDao;
	}

	/**
	 * @创建人：应洪峰
	 * @创建时间：2014年11月16日
	 * @功能说明：
	 * @return
	 * @throws MyException
	 */
	@Override
	public <T> List<T> getEntitiesListByProperty(Class<T> typeClass, String propertyName, Object propertyValue, String... orderBy) throws Exception
	{
		shopcartDao.getEntitiesListByProperty(typeClass,propertyName,propertyValue,orderBy);
		return null;
	}
	

}
