package cn.com.bonde.b2b.website.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IUserDAO;
import cn.com.bonde.b2b.website.entity.Userinfo;

@Repository("userDao")
public class UserDAOImpl extends BaseDBDaoImpl implements IUserDAO {
    

    @SuppressWarnings("unchecked")
	public List<Userinfo> query() throws Exception
	{
		return this.getEntityListByHQL("from Userinfo");
	}
}
