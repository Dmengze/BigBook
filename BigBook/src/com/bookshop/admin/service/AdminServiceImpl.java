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
	
	//����Ա��¼
	public Admin login(String name,String password) {
		return this.adminDaoImpl.login(name, password);
	}
	//��ѯ���й���Ա
	public List<Admin> findAll(){
		return this.adminDaoImpl.findAll();
	}
}
