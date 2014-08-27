package cn.com.bonde.b2b.website.service;

import java.util.List;

import cn.com.bonde.b2b.website.entity.User;

public interface IUserService {

	public void save(User user);
	public List<User> query()throws Exception;
}
