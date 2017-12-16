package com.bookshop.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.admin.dao.AdminDaoImpl;
import com.bookshop.entity.Admin;


@Service
@Transactional(readOnly=true)
public class AdminServiceImpl {
	@Resource
	private AdminDaoImpl adminDaoImpl;
	
	//管理员登录
	public Admin login(String name,String password) {
		return this.adminDaoImpl.login(name, password);
	}
	//查询所有管理员
	public List<Admin> findAll(){
		return this.adminDaoImpl.findAll();
	}
}
