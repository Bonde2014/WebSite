package cn.com.bonde.b2b.website.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IOrderDao;
import cn.com.bonde.b2b.website.entity.XsDdqk;
import cn.com.bonde.b2b.website.entity.XsDdqkShxx;
import cn.com.bonde.b2b.website.service.IOrderService;

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {
    
    @Resource
    private IOrderDao orderDao;

    @Override
    public List<XsDdqk> queryOrder(Long userId, String orderStatus) throws Exception {
        return orderDao.queryOrder(userId, orderStatus);
    }

    @Override
    public List<XsDdqkShxx> queryOrderDetail(List<Long> orderNumList) throws Exception {
        return orderDao.queryOrderDetail(orderNumList);
    }

}