package cn.com.bonde.b2b.website.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IUserDAO;
import cn.com.bonde.b2b.website.entity.Userinfo;

@Repository("userDao")
public class UserDAOImpl extends BaseDBDaoImpl implements IUserDAO {
    
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        super.setSessionFactory(sessionFactory);
//    }

    @SuppressWarnings("unchecked")
	public List<Userinfo> query() throws Exception
	{
		return this.getEntityListByHQL("from Userinfo");
	}

    public void saveUser(Userinfo user) throws Exception {
        this.addEntity(user);
    }

}
