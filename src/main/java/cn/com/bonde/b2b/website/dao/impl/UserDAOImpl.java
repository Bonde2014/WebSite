package cn.com.bonde.b2b.website.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.com.bonde.b2b.website.dao.IUserDAO;
import cn.com.bonde.b2b.website.vo.User;

public class UserDAOImpl extends HibernateTemplate implements IUserDAO {

    @Override
    public User findUserByNameAndPass(String username, String password) {
        List userList = find("from User ur where ur.username=? and ur.password=?", new String[] { username,
                password });
        if (userList != null && userList.size() >= 1) {
            return (User) userList.get(0);
        } else
            return null;
    }

    @Override
    public void saveUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        save(user);
        
    }

}
