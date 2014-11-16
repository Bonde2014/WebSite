package cn.com.bonde.b2b.website.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IOrderDao;
import cn.com.bonde.b2b.website.entity.XsDdqk;
import cn.com.bonde.b2b.website.entity.XsDdqkShxx;

@Repository("orderDAO")
public class OrderDAOImpl  extends BaseDBDaoImpl implements IOrderDao {

    @Override
    public List<XsDdqk> queryOrder(Long userId, String orderStatus) throws Exception {
        Map<String, Object> parasMaps = new HashMap<String, Object>();
        parasMaps.put("qdsDm", userId);
        if(!StringUtils.isBlank(orderStatus)){
            parasMaps.put("ddzt", orderStatus);
        }
        return this.getEntitiesListByProperties(XsDdqk.class, parasMaps, "ddscsj");
    }

    @Override
    public List<XsDdqkShxx> queryOrderDetail(List<Long> orderNumList) throws Exception {
        return null;
    }

}
