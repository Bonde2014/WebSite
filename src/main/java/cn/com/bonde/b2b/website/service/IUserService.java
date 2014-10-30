package cn.com.bonde.b2b.website.service;

import java.util.List;

import cn.com.bonde.b2b.website.entity.Userinfo;

public interface IUserService {

	public void save(Userinfo user)throws Exception;
	public List<Userinfo> query()throws Exception;
}
