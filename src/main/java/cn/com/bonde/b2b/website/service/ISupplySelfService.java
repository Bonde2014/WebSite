/**
 * 
 */
package cn.com.bonde.b2b.website.service;

import java.util.List;

import cn.com.bonde.b2b.website.entity.CgGhsSpmx;
import cn.com.bonde.b2b.website.entity.findEntity.SupplyListFindEntity;
import cn.com.bonde.b2b.website.entity.findEntity.SupplySelfFindEntity;
import cn.com.bonde.b2b.website.util.Pager;


/**
 * @author Administrator
 * <p>功能描述: 供货商自行管理货架的相关服务</p>
 */
public  interface ISupplySelfService
{
	//根据商品分类、商品品牌，查询某供货商可供货的商品列表
	public Pager querySupplyProducts(SupplySelfFindEntity supplyFindEntity)throws Exception;
	
	//将某个商品添加到某供货商的货架
	public boolean addProduct2Supply(List<Long> spdms, Long ghsDm)throws Exception;
	
	//查询某供货商货架上可售的供货列表
	public Pager querySupplyList(SupplyListFindEntity supplyFindEntity)throws Exception;
	
	//下架某个供货商货架上的某件商品
	public boolean downSupplyProduct(Long ghxh)throws Exception;
	
	//为某个供货商货架上某件商品，添加供货报价信息
	public boolean editSupplyInfo(Long ghxh, Long ghjg, Integer ghsl )throws Exception;
	
}
