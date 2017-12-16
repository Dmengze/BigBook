package com.bookshop.order.service;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.entity.Orders;
import com.bookshop.order.dao.OrderDaoImpl;
//import com.bookshop.util.Page;
import com.bookshop.util.Page;

@Service
@Transactional
public class OrderServiceImpl {
	@Resource
	private OrderDaoImpl orderDaoImpl;
	
	//�÷������ڲ�ѯ��ǰ�û������ж���
	public List<Orders> selectByUser(int id){
		return this.orderDaoImpl.selectByUser(id);
	}
	 //ȡ������
	public void delete(int order_id) {
		this.orderDaoImpl.delete(order_id);
	}
	
	//���ɶ���
	public void add(int count,String book_img,String book_name,Double book_price,int user_id) {
		this.orderDaoImpl.add(count, book_img, book_name, book_price, user_id);
	}
	//��ѯ������������
	public Long selectCount(){
		return this.orderDaoImpl.selectCount();
	}
	//�÷������ڲ�ѯ���еĶ���(��ҳ��ѯ)
		@SuppressWarnings("rawtypes")
		public List<Orders> selectByPage(Page page){
			return this.orderDaoImpl.selectByPage(page);
		}
	
	
	

}
