/**
 * 
 */
package cn.com.bonde.b2b.website.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IShopcartDao;
import cn.com.bonde.b2b.website.entity.SpSpxx;
import cn.com.bonde.b2b.website.entity.XsGwc;
import cn.com.bonde.b2b.website.entity.XsGwcId;
import cn.com.bonde.b2b.website.service.IShopcartService;
import cn.com.bonde.b2b.website.util.DataSwitch;
import cn.com.bonde.b2b.website.util.MyException;

/**
 * @author Administrator
 * 
 */
@Service(value = "shopcartService")
public class ShopcartServiceImpl implements IShopcartService
{
	@Resource(name = "shopcartDao")
	private IShopcartDao shopcartDao;

	/**
	 * @return the shopcartDao
	 */
	public IShopcartDao getShopcartDao()
	{
		return shopcartDao;
	}

	/**
	 * @param shopcartDao
	 *            the shopcartDao to set
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
		shopcartDao.getEntitiesListByProperty(typeClass, propertyName, propertyValue, orderBy);
		return null;
	}

	/**
	 * @创建人：应洪峰
	 * @创建时间：2014年11月17日
	 * @功能说明：
	 * @return
	 * @throws MyException
	 */
	@Override
	public <T> List<T> getEntityListByHQL(String hql, Map<String, Object>... paramMap) throws Exception
	{
		shopcartDao.getEntityListByHQL(hql, paramMap);
		return null;
	}

	/**
	 * @创建人：应洪峰
	 * @创建时间：2014年11月17日
	 * @功能说明：
	 * @return
	 * @throws MyException
	 */
	@Override
	public List<Map<String, Object>> getEntityList(String khDm) throws Exception
	{
		return shopcartDao.getEntityList(khDm);
	}

	public boolean addToShopCart(Long spdm, Long khdm) throws Exception
	{
		boolean flag=false;
		SpSpxx spxx = shopcartDao.getEntityByPrimaryId(SpSpxx.class, spdm);
		XsGwcId id = new XsGwcId();
		id.setSpDm(spdm);
		id.setKhDm(khdm);
		XsGwc xsGwc = shopcartDao.getEntityByPrimaryId(XsGwc.class, id);
		if (xsGwc != null)
		{
			xsGwc.setSpSl(xsGwc.getSpSl() + 1);
			xsGwc.setSpZj(xsGwc.getSpZj() + xsGwc.getSpJg());
			flag=shopcartDao.updateEntiy(xsGwc);
		}
		else
		{
			xsGwc = new XsGwc();
			xsGwc.setId(id);
			xsGwc.setSpJg(spxx.getScjg());
			xsGwc.setSpJgCj(spxx.getScjg());
			xsGwc.setSpSl(1);
			xsGwc.setSpZj(spxx.getScjg());
			xsGwc.setTjsj(new Timestamp(DataSwitch.GetPresentTime().getTime()));
			flag=shopcartDao.addEntity(xsGwc);
		}
		return flag;
	}

}
