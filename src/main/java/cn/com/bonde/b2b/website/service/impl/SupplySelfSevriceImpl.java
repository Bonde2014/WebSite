/**
 * 
 */
package cn.com.bonde.b2b.website.service.impl;



import java.util.List;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.ISupplySelfDao;
import cn.com.bonde.b2b.website.entity.CgGhsSpmx;
import cn.com.bonde.b2b.website.entity.findEntity.SupplyListFindEntity;
import cn.com.bonde.b2b.website.entity.findEntity.SupplySelfFindEntity;
import cn.com.bonde.b2b.website.service.ISupplySelfService;
import cn.com.bonde.b2b.website.util.Pager;

/**
 * @author Administrator
 *
 */
@Service(value = "supplySelfService")
public class SupplySelfSevriceImpl implements ISupplySelfService
{
	@Resource(name="supplySelfDao")
	private ISupplySelfDao supplySelfDao;
	

	public ISupplySelfDao getSupplySelfDao() {
		return supplySelfDao;
	}

	public void setSupplySelfDao(ISupplySelfDao supplySelfDao) {
		this.supplySelfDao = supplySelfDao;
	}

	@Override
	public Pager querySupplyProducts(SupplySelfFindEntity supplyFindEntity)throws Exception{
		return supplySelfDao.querySupplyProducts(supplyFindEntity);
	}
	
	@Override
	public boolean addProduct2Supply(List<Long> spdms, Long ghsDm)throws Exception{
		for(Long spDm : spdms){
		  CgGhsSpmx ghsEntity=new CgGhsSpmx();   //不知道ghxh会不会自动生成？会
		  ghsEntity.setGhsDm(ghsDm);
		  ghsEntity.setSpDm(spDm);
		  ghsEntity.setGhbz("0");//ghbz供货标识默认是0-未上架
		  if (!supplySelfDao.addEntity(ghsEntity)){
			  return false;
		  }
		}
		return true;
	}
	
	@Override
	public Pager querySupplyList(SupplyListFindEntity supplyFindEntity)throws Exception{
		return supplySelfDao.querySupplyList(supplyFindEntity);
		
		//直接用下面这个方法还不行，因为涉及到要与sp_spxx表要进行联表查询，以获取商品名称、品牌、型号等内容
		//return supplySelfDao.getEntitiesListByProperties(CgGhsSpmx.class, propertyMap);
	}
	
	@Override
	public boolean downSupplyProduct(Long ghxh)throws Exception{
		CgGhsSpmx ghsEntity=new CgGhsSpmx();
		ghsEntity.setGhxh(ghxh);
		ghsEntity.setGhbz("0");  //0-未上架/下架 ，1-已上架
		return supplySelfDao.updateEntiyFieldBySql(ghsEntity);
	}
	
	@Override
	public boolean editSupplyInfo(Long ghxh, Long ghjg, Integer ghsl )throws Exception{
		CgGhsSpmx ghsEntity=new CgGhsSpmx();
		ghsEntity.setGhxh(ghxh);
		ghsEntity.setGhbz("1");  //0-未上架/下架 ，1-已上架
		ghsEntity.setSpJg(ghjg); //供货价格
		ghsEntity.setSpSl(ghsl);  //可供货数量
		return supplySelfDao.updateEntiyFieldBySql(ghsEntity);
	}

}
