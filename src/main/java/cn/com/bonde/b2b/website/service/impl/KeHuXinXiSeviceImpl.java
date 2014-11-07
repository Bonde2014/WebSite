/**
 * 
 */
package cn.com.bonde.b2b.website.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IKeHuXinXiDao;
import cn.com.bonde.b2b.website.entity.findEntity.KeHuXinXiFindEntity;
import cn.com.bonde.b2b.website.service.IKeHuXinXiService;
import cn.com.bonde.b2b.website.util.Pager;

/**
 * @author Administrator
 *
 */
@Service(value = "keHuXinXiService")
public class KeHuXinXiSeviceImpl implements IKeHuXinXiService
{
	@Resource(name="keHuXinXiDao")
	private IKeHuXinXiDao keHuXinXiDao;

	/**
	 * @return the keHuXinXiDao
	 */
	public IKeHuXinXiDao getKeHuXinXiDao()
	{
		return keHuXinXiDao;
	}

	/**
	 * @param keHuXinXiDao the keHuXinXiDao to set
	 */
	public void setKeHuXinXiDao(IKeHuXinXiDao keHuXinXiDao)
	{
		this.keHuXinXiDao = keHuXinXiDao;
	}
	
	public Pager getList(KeHuXinXiFindEntity findEntity)throws Exception{
		return keHuXinXiDao.getList(findEntity);
	}

}
