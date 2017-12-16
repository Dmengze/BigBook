package com.bookshop.order.dao;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.bookshop.entity.Orders;
import com.bookshop.util.Page;

@Repository
public class OrderDaoImpl {
	       @Resource
	       private SessionFactory sessionFactory;
	       
	       //该方法用于查询当前用户的所有订单
			@SuppressWarnings("unchecked")
			public List<Orders> selectByUser(int user_id){
				Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders where user_id=?");
				return q.setParameter(0, user_id).list();	
			}
			
			//取消某一订单
			public void delete(int order_id) {
				// TODO Auto-generated method stub
					 Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Orders where order_id= ?");
					 q.setInteger(0,order_id).executeUpdate();
			}
			
	        //提交订单
			public void add(int count,String book_img,String book_name,Double book_price,int user_id) {
				Orders od= new Orders();
				 od.setBook_img(book_img);
				 od.setBook_name(book_name);
				 od.setBook_price(book_price);
				 od.setCount(count);
				 od.setUser_id(user_id);
				 sessionFactory.getCurrentSession().save(od);				
			}
			//查询订单数量
			public Long selectCount(){
				Query q=this.sessionFactory.getCurrentSession().createQuery("select count(*) as num from Orders");
				return ((Long)q.uniqueResult());
			}
			//查看所有订单,用于后台查看所有订单（分页）
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public List<Orders> selectByPage(Page page){
				Query q=this.sessionFactory.getCurrentSession().createQuery("from Orders ");
				q.setFirstResult((page.getDpage().intValue()-1) *page.getPagecount().intValue());
				 q.setMaxResults(page.getPagecount().intValue());
				 return q.list();
			}
			
			
	}