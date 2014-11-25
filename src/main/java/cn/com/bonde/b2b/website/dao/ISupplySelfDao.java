/**
 * 
 */
package cn.com.bonde.b2b.website.dao;

import cn.com.bonde.b2b.website.entity.findEntity.SupplyListFindEntity;
import cn.com.bonde.b2b.website.entity.findEntity.SupplySelfFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

/**
 * @author Administrator
 *
 */
public interface ISupplySelfDao extends IBaseDBDao
{
	//根据商品分类、商品品牌，查询某供货商可供货的商品列表
	public Pager querySupplyProducts(SupplySelfFindEntity supplyFindEntity)throws Exception;
	
	//根据供货商代码查询货架列表
	public Pager querySupplyList(SupplyListFindEntity supplyFindEntity)throws Exception;
}
