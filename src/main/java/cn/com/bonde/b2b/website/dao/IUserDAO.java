package cn.com.bonde.b2b.website.dao;

import java.util.List;

import cn.com.bonde.b2b.website.entity.Userinfo;

public interface IUserDAO {

    
    /**
     * 
    * @Title: saveUser 
    * @Description:
    * @param user void
     */
    public void saveUser(Userinfo user)throws Exception;
    public List<Userinfo> query() throws Exception;

}
