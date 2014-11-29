package cn.com.bonde.b2b.website.service;

import java.util.List;
import java.util.Map;

import cn.com.bonde.b2b.website.entity.QxKhxx;
import cn.com.bonde.b2b.website.entity.XsDdqk;

public interface IOrderService
{

	public List<XsDdqk> queryOrder(Long userId, String orderStatus) throws Exception;

	public List<Map<String, Object>> queryOrderDetail(List<String> orderNumList) throws Exception;

	public boolean saveOrder(String psfsdm, List<Map<String, Object>> list, QxKhxx khxx) throws Exception;

	public List<Map<String, Object>> queryOrderList(Long userId, String orderStatus) throws Exception;

	public List<Map<String, Object>> queryDdztList(Long userId) throws Exception;

	public boolean updateUserInfo(QxKhxx khxx) throws Exception;
}
