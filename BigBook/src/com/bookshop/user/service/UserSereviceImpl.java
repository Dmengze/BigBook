package com.bookshop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.entity.Users;
import com.bookshop.user.dao.UserDaoImpl;
import com.bookshop.util.Page;

@Service
@Transactional
//(readOnly=true)
public class UserSereviceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	//该方法用于查询user账号,用于判断用户名和密码是否正确，用户登录时使用
	public Users login(String userName,String password) {
		return this.userDaoImpl.login(userName, password);
	}
	//该方法用于判断用户名是否存在
	public Users judge(String userName){
		return this.userDaoImpl.judge(userName);
	}
	
	//该方法用于插入user用户，用于用户注册
	public void add(String name, String password,String email,String telephone,String address) {
		this.userDaoImpl.add(name, password, email, telephone, address);
	}
	//该方法用于查询所有的user用户,admin调用此方法
	public List<Users> selectAll(){
	 return this.userDaoImpl.selectAll();
	}
	//该方法用于删除user用户，admin调用此方法
	public void delet(int id) {
		this.userDaoImpl.delet(id);
	}
	//该方法用于更新user账户，admin调用此方法
	public void update(int id, String name, String password,String email,String telephone,String address) {
		this.userDaoImpl.update(id, name, password, email, telephone, address);
	}
	//该方法用于通过id查询user信息的方法，admin调用此方法
	public List<Users> selectById(int id) {
		return this.userDaoImpl.selectById(id);
	}
	//查询所有用户的数量，admin调用此方法
	public Long selectCount(){
		return this.userDaoImpl.selectCount();
	}
	//该方法用于按页查询，admin后台使用此方法
	@SuppressWarnings("rawtypes")
	public List<Users> selectByPage(Page page){
		return this.userDaoImpl.selectByPage(page);
	}
	

}
