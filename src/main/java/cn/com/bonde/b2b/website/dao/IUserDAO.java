package cn.com.bonde.b2b.website.dao;

import cn.com.bonde.b2b.website.vo.User;

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
    * @param username
    * @param password void
     */
    public void saveUser(String username, String password);

}
