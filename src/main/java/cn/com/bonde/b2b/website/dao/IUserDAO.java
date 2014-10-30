package cn.com.bonde.b2b.website.dao;

import java.util.List;

import cn.com.bonde.b2b.website.entity.Userinfo;

public interface IUserDAO extends IBaseDBDao {

    
    /**
     * 
    * @Title: saveUser 
    * @Description:
    * @param user void
     */
    public List<Userinfo> query() throws Exception;

}
