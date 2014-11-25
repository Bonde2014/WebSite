/**
 * 
 */
package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.ICatalogDao;
import cn.com.bonde.b2b.website.dao.ILoginDao;
import cn.com.bonde.b2b.website.dao.ISupplySelfDao;
import cn.com.bonde.b2b.website.entity.findEntity.SupplyListFindEntity;
import cn.com.bonde.b2b.website.entity.findEntity.SupplySelfFindEntity;
import cn.com.bonde.b2b.website.util.Pager;

/**
 * @author Administrator
 *
 */
@Repository("supplySelfDao")
public class SupplySelfDaoImpl extends BaseDBDaoImpl implements ISupplySelfDao
{

	static String SEARCH_PRODUCT_SQL ="SELECT a.sp_dm,a.spmc,a.scjg, (select t.spfl_mc from dm_spfl t where t.spfl_dm=a.spfl_dm) spfl_mc,(select t.sppp_mc from dm_spfl2 t where t.sppp_dm=a.sppp_dm) sppp_mc, a.spxh FROM sp_spxx a where a.spfl_dm=:SPFLDM and a.sppp_dm=:SPPPDM and a.sp_dm not in (select sp_dm from cg_ghs_spmx b where b.ghs_dm=:GHSDM )";
	static String SEARCH_SUPPLY_SQL ="SELECT a.sp_dm,a.spmc,a.scjg, (select t.spfl_mc from dm_spfl t where t.spfl_dm=a.spfl_dm) spfl_mc,(select t.sppp_mc from dm_spfl2 t where t.sppp_dm=a.sppp_dm) sppp_mc, a.spxh, a.jldw, b.ghxh, b.sp_jg, b.sp_sl, b.ghbz, b.bjsj FROM cg_ghs_spmx b, sp_spxx a where b.ghs_dm=:GHSDM and a.sp_dm=b.sp_dm";

	@Override
	public Pager querySupplyProducts(SupplySelfFindEntity supplyFindEntity)throws Exception{
		Map<String, Object> parasMaps = new HashMap<String, Object>();
		parasMaps.put("SPFLDM", supplyFindEntity.getSpflDm());
		parasMaps.put("SPPPDM", supplyFindEntity.getSpppDm());
		parasMaps.put("GHSDM", supplyFindEntity.getGhsDm());
		return this.getListBySQLQuery(SEARCH_PRODUCT_SQL, parasMaps, supplyFindEntity);
	}
	
	public Pager querySupplyList(SupplyListFindEntity supplyFindEntity)throws Exception{
		Map<String, Object> parasMaps = new HashMap<String, Object>();
		parasMaps.put("GHSDM", supplyFindEntity.getGhsDm());
		return this.getListBySQLQuery(SEARCH_SUPPLY_SQL, parasMaps, supplyFindEntity);
	}
	
}
