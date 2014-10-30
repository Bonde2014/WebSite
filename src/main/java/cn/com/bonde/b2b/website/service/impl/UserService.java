package cn.com.bonde.b2b.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.bonde.b2b.website.dao.IUserDAO;
import cn.com.bonde.b2b.website.entity.Userinfo;
import cn.com.bonde.b2b.website.service.IUserService;

@Service(value = "userService")
public class UserService implements IUserService
{

	@Autowired
	private IUserDAO userDao;

	public void setUserinfoDao(IUserDAO userDao)
	{
		this.userDao = userDao;
	}

	public List<Userinfo> query() throws Exception
	{
		return userDao.query();
	}

	public void save(Userinfo Userinfo) throws Exception
	{
		userDao.addEntity(Userinfo);
	}

}
