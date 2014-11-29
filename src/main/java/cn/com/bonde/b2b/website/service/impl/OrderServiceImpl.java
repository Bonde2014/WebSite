package cn.com.bonde.b2b.website.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IOrderDao;
import cn.com.bonde.b2b.website.entity.QxKhxx;
import cn.com.bonde.b2b.website.entity.XsDdqk;
import cn.com.bonde.b2b.website.entity.XsDdqkShxx;
import cn.com.bonde.b2b.website.entity.XsDdqkSpmx;
import cn.com.bonde.b2b.website.entity.XsDdqkSpmxId;
import cn.com.bonde.b2b.website.entity.XsGwc;
import cn.com.bonde.b2b.website.entity.XsGwcId;
import cn.com.bonde.b2b.website.entity.enumeration.ddztEnum;
import cn.com.bonde.b2b.website.service.IOrderService;
import cn.com.bonde.b2b.website.util.DataSwitch;
import cn.com.bonde.b2b.website.util.MyException;

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService
{

	@Resource
	private IOrderDao orderDao;

	@Override
	public List<XsDdqk> queryOrder(Long userId, String orderStatus) throws Exception
	{
		return orderDao.queryOrder(userId, orderStatus);
	}

	 public List<Map<String, Object>> queryOrderList(Long userId, String orderStatus) throws Exception 
	 {
		 return orderDao.queryOrderList(userId, orderStatus);
	 }
	
	@Override
	public List<Map<String, Object>> queryOrderDetail(List<String> orderNumList) throws Exception
	{
		return orderDao.queryOrderDetail(orderNumList);
	}
	
	

	/**
	 * @创建人：应洪峰
	 * @创建时间：2014年11月29日
	 * @功能说明：
	 * @return
	 * @throws MyException
	 */
	@Override
	public boolean saveOrder(String psfsdm, List<Map<String, Object>> list, QxKhxx khxx) throws Exception
	{
		try
		{
			Double zje = 0.00;
			for (Map<String, Object> map : list)
			{
				zje += DataSwitch.convertObjectToDouble(map.get("ZJ" + khxx.getQdsJb()));
			}
			XsDdqk xsDdqk = new XsDdqk();
			xsDdqk.setQdsDm(khxx.getKhDm());
			xsDdqk.setDdzt(ddztEnum.DAI_QUE_REN);
			xsDdqk.setDdzjeGj(zje);
			xsDdqk.setDdzje(zje);
			xsDdqk.setDdscsj(new Date());
			orderDao.addEntity(xsDdqk);
			XsDdqkSpmxId id = new XsDdqkSpmxId();
			id.setDdid(xsDdqk.getDdid());
			XsDdqkSpmx xsDdqkSpmx = new XsDdqkSpmx();
			for (Map<String, Object> map : list)
			{
				id.setXxh(DataSwitch.convertObjectToInteger(map.get("SP_DM")));
				xsDdqkSpmx.setId(id);
				xsDdqkSpmx.setSpDm(DataSwitch.convertObjectToLong(map.get("SP_DM")));
				xsDdqkSpmx.setSpJg(DataSwitch.convertObjectToDouble(map.get("JG" + khxx.getQdsJb())));
				xsDdqkSpmx.setSpJgCj(DataSwitch.convertObjectToDouble(map.get("JG" + khxx.getQdsJb())));
				xsDdqkSpmx.setSpSl(DataSwitch.convertObjectToInteger(map.get("SP_SL")));
				xsDdqkSpmx.setSpZj(DataSwitch.convertObjectToDouble(map.get("ZJ" + khxx.getQdsJb())));
				orderDao.addEntity(xsDdqkSpmx);
				XsGwcId XsGwcId = new XsGwcId(khxx.getKhDm(),DataSwitch.convertObjectToLong(map.get("SP_DM")));
				orderDao.deleteByPrimaryId(XsGwc.class, XsGwcId);
				XsGwcId=null;
			}
			XsDdqkShxx XsDdqkShxx = new XsDdqkShxx();
			XsDdqkShxx.setDdid(xsDdqk.getDdid());
			XsDdqkShxx.setFhfsDm(psfsdm);
			XsDdqkShxx.setShrDh(khxx.getLxdh());
			XsDdqkShxx.setShrDz(khxx.getLxdz());
			XsDdqkShxx.setShrXm(khxx.getFzrXm());
			orderDao.addEntity(XsDdqkShxx);
			return true;
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	  public List<Map<String, Object>> queryDdztList(Long userId) throws Exception{
		  return orderDao.queryDdztList(userId);
	  }

	  public boolean updateUserInfo(QxKhxx khxx) throws Exception{
		  return orderDao.updateEntiy(khxx);
	  }
}
