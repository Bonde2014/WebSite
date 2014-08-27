package cn.com.bonde.b2b.website.dao;

import java.util.List;

import cn.com.bonde.b2b.website.entity.User;

public interface IUserDAO {

    /**
     * 
     * @Title: findUserByNameAndPass
     * @Description:
     * @param username
     * @param password
     * @return User
     */
    public User findUserByNameAndPass(String username, String password);
    
    /**
     * 
    * @Title: saveUser 
    * @Description:
    * @param user void
     */
    public void saveUser(User user);
    public List<User> query() throws Exception;

}
