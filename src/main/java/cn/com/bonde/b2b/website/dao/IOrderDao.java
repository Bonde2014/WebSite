package cn.com.bonde.b2b.website.dao;

import java.util.List;

import cn.com.bonde.b2b.website.entity.XsDdqk;
import cn.com.bonde.b2b.website.entity.XsDdqkShxx;

public interface IOrderDao extends IBaseDBDao {

    public List<XsDdqk> queryOrder(Long userId, String orderStatus) throws Exception;

    public List<XsDdqkShxx> queryOrderDetail(List<Long> orderNumList) throws Exception;

}
