package cn.com.bonde.b2b.website.dao;

import java.util.List;
import java.util.Map;

import cn.com.bonde.b2b.website.entity.XsDdqk;
import cn.com.bonde.b2b.website.entity.XsDdqkSpmx;

public interface IOrderDao extends IBaseDBDao {

    public List<XsDdqk> queryOrder(Long userId, String orderStatus) throws Exception;

    public List<Map<String, Object>> queryOrderDetail(List<Long> orderNumList) throws Exception;

}
