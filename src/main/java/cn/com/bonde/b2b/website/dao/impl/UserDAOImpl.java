package cn.com.bonde.b2b.website.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.com.bonde.b2b.website.dao.IUserDAO;
import cn.com.bonde.b2b.website.entity.User;

@Repository("userDao")
public class UserDAOImpl extends HibernateTemplate implements IUserDAO {
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public User findUserByNameAndPass(String username, String password) {
    	//测试commit
        List userList = find("from User ur where ur.username=? and ur.password=?", new String[] { username,
                password });
        if (userList != null && userList.size() >= 1) {
            return (User) userList.get(0);
        } else
            return null;
    }
    
    public List<User> query() throws Exception
	{
		return (List<User>) find("from User");
	}

    @Override
    public void saveUser(User user) {
        this.save(user);
    }

}
