package com.bookshop.cart.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.cart.dao.CartDaoImpl;
import com.bookshop.entity.Cart_detial;

@Service
@Transactional
public class CartServiceImpl {
	@Resource
	private CartDaoImpl  cartdaoImpl;
	//�÷������ڲ�ѯ��ǰ�û��Ĺ��ﳵ
	public List<Cart_detial> selectByUser(int us_id){
		return this.cartdaoImpl.selectByUser(us_id);
	}
	//�޸ĵ�ǰ�û����ﳵ�е�ĳ���������
	public void update( int count ,int cart_detial_id) {
		this.cartdaoImpl.update(count, cart_detial_id);
	}
	//���ӵ�ǰͼ������(+1)
	public void addNum(int cart_detial_id){
		this.cartdaoImpl.addNum(cart_detial_id);
	}
	//��ȥ��ǰͼ����������1��
	public void downNum(int cart_detial_id){
		this.cartdaoImpl.downNum(cart_detial_id);			
	}
	//ɾ�����ﳵ�е�ĳһ���鼮
	public void delete(int cart_detial_id) {
		this.cartdaoImpl.delete(cart_detial_id);
	}
	//��յ�ǰ���ﳵ
	public void deletecart(int us_id) {
		this.cartdaoImpl.deletecart(us_id);
	}
	//��ͼ����뵽��ǰ�û��Ĺ��ﳵ
	public void add(int count,String book_img,String book_name,Double book_price,int us_id) {
		this.cartdaoImpl.add(count, book_img,book_name, book_price, us_id);
	}

}
