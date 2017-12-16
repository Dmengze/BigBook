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
        //�÷������ڲ�ѯ��ǰ�û��Ĺ��ﳵ�е�����ͼ��
		@SuppressWarnings("unchecked")
		public List<Cart_detial> selectByUser(int us_id){
			Query q=this.sessionFactory.getCurrentSession().createQuery("from Cart_detial where us_id=?");
			return q.setParameter(0, us_id).list();	
		}
		 //�޸ĵ�ǰ�û���ĳ��ͼ������
		public void update( int count ,int cart_detial_id) {
			Query q=this.sessionFactory.getCurrentSession().createQuery("update Cart_detial set count=? where cart_detial_id=?");
				 q.setInteger(0,count);
				 q.setInteger(1, cart_detial_id);
				 q.executeUpdate();
		}
		//���ӵ�ǰͼ������(+1)
		public void addNum(int cart_detial_id){
			Query q=this.sessionFactory.getCurrentSession().createQuery("update Cart_detial c set c.count=c.count + 1 where cart_detial_id=?");
            q.setInteger(0, cart_detial_id);
			q.executeUpdate();
		}
		
		//��ȥ��ǰͼ����������1��
		public void downNum(int cart_detial_id){
			Query q=this.sessionFactory.getCurrentSession().createQuery("update Cart_detial c set c.count=c.count-1 where cart_detial_id=?");
            q.setInteger(0, cart_detial_id);
			q.executeUpdate();
		}
		
		//ɾ�����ﳵ�е�ĳһ���鼮
		public void delete(int cart_detial_id) {
			// TODO Auto-generated method stub
				 Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Cart_detial where cart_detial_id= ?");
				 q.setInteger(0, cart_detial_id).executeUpdate();
		}
		

		//��յ�ǰ�û��Ĺ��ﳵ
		public void deletecart(int us_id) {
			// TODO Auto-generated method stub
				 Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Cart_detial where us_id = ?");
				 q.setInteger(0, us_id).executeUpdate();
		}
		
        //��ͼ����뵽��ǰ�û��Ĺ��ﳵ
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
