package com.bookshop.cart.dao;


import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bookshop.entity.Cart_detial;
@Repository
public class CartDaoImpl {
	 @Resource
     private SessionFactory sessionFactory;
        //该方法用于查询当前用户的购物车中的所有图书
		@SuppressWarnings("unchecked")
		public List<Cart_detial> selectByUser(int us_id){
			Query q=this.sessionFactory.getCurrentSession().createQuery("from Cart_detial where us_id=?");
			return q.setParameter(0, us_id).list();	
		}
		 //修改当前用户的某种图书数量
		public void update( int count ,int cart_detial_id) {
			Query q=this.sessionFactory.getCurrentSession().createQuery("update Cart_detial set count=? where cart_detial_id=?");
				 q.setInteger(0,count);
				 q.setInteger(1, cart_detial_id);
				 q.executeUpdate();
		}
		//增加当前图书数量(+1)
		public void addNum(int cart_detial_id){
			Query q=this.sessionFactory.getCurrentSession().createQuery("update Cart_detial c set c.count=c.count + 1 where cart_detial_id=?");
            q.setInteger(0, cart_detial_id);
			q.executeUpdate();
		}
		
		//减去当前图书数量（—1）
		public void downNum(int cart_detial_id){
			Query q=this.sessionFactory.getCurrentSession().createQuery("update Cart_detial c set c.count=c.count-1 where cart_detial_id=?");
            q.setInteger(0, cart_detial_id);
			q.executeUpdate();
		}
		
		//删除购物车中的某一种书籍
		public void delete(int cart_detial_id) {
			// TODO Auto-generated method stub
				 Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Cart_detial where cart_detial_id= ?");
				 q.setInteger(0, cart_detial_id).executeUpdate();
		}
		

		//清空当前用户的购物车
		public void deletecart(int us_id) {
			// TODO Auto-generated method stub
				 Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Cart_detial where us_id = ?");
				 q.setInteger(0, us_id).executeUpdate();
		}
		
        //将图书加入到当前用户的购物车
		public void add(int count,String book_img,String book_name,Double book_price,int us_id) {
			 Cart_detial cd= new Cart_detial();
			 cd.setBook_img(book_img);
			 cd.setBook_name(book_name);
			 cd.setBook_price(book_price);
			 cd.setCount(count);
			 cd.setUs_id(us_id);
			 sessionFactory.getCurrentSession().save(cd);
			
		}
}
