package cn.com.bonde.b2b.website.service;

import java.util.List;

import cn.com.bonde.b2b.website.entity.XsDdqk;
import cn.com.bonde.b2b.website.entity.XsDdqkShxx;


public interface IOrderService {
    
    
    public List<XsDdqk> queryOrder(Long userId,String orderStatus) throws Exception;
    
    public List<XsDdqkShxx> queryOrderDetail(List<Long> orderNumList) throws Exception;
    

}
