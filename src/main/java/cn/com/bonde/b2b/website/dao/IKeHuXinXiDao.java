/**
 * 
 */
package cn.com.bonde.b2b.website.dao;

import cn.com.bonde.b2b.website.entity.findEntity.KeHuXinXiFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

/**
 * @author Administrator
 *
 */
public interface IKeHuXinXiDao
{
	public Pager getList(KeHuXinXiFindEntity findEntity)throws Exception;
}
