package com.bookshop.admin.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.bookshop.entity.Admin;

@Repository
public class AdminDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	//管理员登录
	public Admin login(String name,String password) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Admin a where a.admin_name=? and a.admin_password=?");
		q.setParameter(0,  name);
		q.setParameter(1, password);
		return (Admin) q.uniqueResult();
	}	
		
	//查询所有管理员
	@SuppressWarnings("unchecked")
	public List<Admin> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Admin");
		return q.list();
	}
	

}
