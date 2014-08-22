package cn.com.bonde.b2b.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IUserDAO;
import cn.com.bonde.b2b.website.entity.User;
import cn.com.bonde.b2b.website.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDao;

    public void setUserDao(IUserDAO userDao) {
        this.userDao = userDao;
    }

    public List<User> query() throws Exception {
        return null;
    }

    public void save(User user) throws Exception {
    }

}
