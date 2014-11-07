/**
 * 
 */
package cn.com.bonde.b2b.website.service;

import cn.com.bonde.b2b.website.entity.findEntity.KeHuXinXiFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

/**
 * @author Administrator
 *
 */
public interface IKeHuXinXiService
{
	public Pager getList(KeHuXinXiFindEntity findEntity)throws Exception;
}
