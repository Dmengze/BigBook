package com.bookshop.user.dao;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.bookshop.entity.Users;
import com.bookshop.util.Page;

@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	        //该方法用于查询user账号,用于判断用户名和密码是否正确，用户登录时使用
			public Users login(String userName,String password) {
				Query q=this.sessionFactory.getCurrentSession().createQuery("from Users where user_name=? and user_password=?");
				q.setParameter(0,  userName);
				q.setParameter(1, password);
				return (Users) q.uniqueResult();
			}
			//该方法用于判断用户名是否存在
			public Users judge(String userName){
				Query q=this.sessionFactory.getCurrentSession().createQuery("from Users where user_name=?");
				q.setParameter(0,  userName);
				return (Users) q.uniqueResult();
				
			}
			//该方法用于插入user用户，用于用户注册
			public void add(String name, String password,String email,String telephone,String address) {
				Users us =  new Users();
			    us.setUser_name(name);
			    us.setUser_password(password);
			    us.setUser_address(address);
			    us.setUser_email(email);
			    us.setUser_telephone(telephone);
			    us.setUser_address(address);
			    sessionFactory.getCurrentSession().save(us);
			}
			
			//该方法用于查询所有的user用户,admin调用此方法
			@SuppressWarnings("unchecked")
			public List<Users> selectAll(){
				Query ps= sessionFactory.getCurrentSession().createQuery("from Users");			 	 
				return ps.list();
			}
			//该方法用于删除user用户，admin调用此方法
			public void delet(int id) {
				Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Users where id = ?");
				q.setInteger(0, id).executeUpdate();
			
			}
			//该方法用于更新user账户,用户自己更改信息时
			public void update(int id, String name, String password,String email,String telephone,String address) {
				
				Query ps=this.sessionFactory.getCurrentSession().createQuery("update Users set user_name=? ,user_password=?,user_email=?,user_telephone=?,user_address=? where user_id=?");	 
					 ps.setString(0, name);
					 ps.setString(1,password);
					 ps.setString(2,email);
					 ps.setString(3,telephone);
					 ps.setString(4, address);
					 ps.setInteger(5, id);
					 ps.executeUpdate();
			
			}
			//该方法用于通过id查询user信息的方法，
			@SuppressWarnings("unchecked")
			public List<Users> selectById(int id) {
				// TODO Auto-generated method stub
				Query q=this.sessionFactory.getCurrentSession().createQuery("from Users where user_id=?");
				return q.setParameter(0, id).list();
			}
			
			//查询所有用户的数量，admin调用此方法
			public Long selectCount(){
				Query q=this.sessionFactory.getCurrentSession().createQuery("select count(*) as num from Users");
				return ((Long)q.uniqueResult());
			}
			//该方法用于按页查询，admin后台使用此方法
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public List<Users> selectByPage(Page page){
				Query q=this.sessionFactory.getCurrentSession().createQuery("from Users ");
				q.setFirstResult((page.getDpage().intValue()-1) *page.getPagecount().intValue());
				 q.setMaxResults(page.getPagecount().intValue());
				 return q.list();
			}
		
		
}
