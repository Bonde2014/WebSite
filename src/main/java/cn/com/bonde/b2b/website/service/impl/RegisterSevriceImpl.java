/**
 * 
 */
package cn.com.bonde.b2b.website.service.impl;



import java.util.List;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.ISupplySelfDao;
import cn.com.bonde.b2b.website.entity.CgGhsSpmx;
import cn.com.bonde.b2b.website.entity.QxDlxx;
import cn.com.bonde.b2b.website.entity.QxKhxx;
import cn.com.bonde.b2b.website.entity.findEntity.SupplyListFindEntity;
import cn.com.bonde.b2b.website.entity.findEntity.SupplySelfFindEntity;
import cn.com.bonde.b2b.website.service.IRegisterService;
import cn.com.bonde.b2b.website.service.ISupplySelfService;
import cn.com.bonde.b2b.website.util.Pager;

/**
 * @author Administrator
 *
 */
@Service(value = "registerService")
public class RegisterSevriceImpl implements IRegisterService
{
	@Resource(name="supplySelfDao")
	private ISupplySelfDao supplySelfDao;  //随便找一个DAO的子类即可
	

	public ISupplySelfDao getSupplySelfDao() {
		return supplySelfDao;
	}

	public void setSupplySelfDao(ISupplySelfDao supplySelfDao) {
		this.supplySelfDao = supplySelfDao;
	}

	
	@Override
	public boolean addRegistInfo(QxDlxx dlxx, QxKhxx khxx)throws Exception{
        //先保存账户信息
		if (!supplySelfDao.addEntity(dlxx)){
			  return false;
		}
        //再保存客户信息
		if (!supplySelfDao.addEntity(khxx)){
			  return false;
		}
		return true;
	}
	


}
