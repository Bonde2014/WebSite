/**
 * 
 */
package cn.com.bonde.b2b.website.dao;

import java.util.List;
import java.util.Map;

import cn.com.bonde.b2b.website.entity.XsGwc;


/**
 * @author Administrator
 *
 */
public interface IShopcartDao extends IBaseDBDao
{
	public List<Map<String,Object>>  getEntityList(String khDm)throws Exception;
}
