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
	//该方法用于查询当前用户的购物车
	public List<Cart_detial> selectByUser(int us_id){
		return this.cartdaoImpl.selectByUser(us_id);
	}
	//修改当前用户购物车中的某种书的数量
	public void update( int count ,int cart_detial_id) {
		this.cartdaoImpl.update(count, cart_detial_id);
	}
	//增加当前图书数量(+1)
	public void addNum(int cart_detial_id){
		this.cartdaoImpl.addNum(cart_detial_id);
	}
	//减去当前图书数量（—1）
	public void downNum(int cart_detial_id){
		this.cartdaoImpl.downNum(cart_detial_id);			
	}
	//删除购物车中的某一种书籍
	public void delete(int cart_detial_id) {
		this.cartdaoImpl.delete(cart_detial_id);
	}
	//清空当前购物车
	public void deletecart(int us_id) {
		this.cartdaoImpl.deletecart(us_id);
	}
	//将图书加入到当前用户的购物车
	public void add(int count,String book_img,String book_name,Double book_price,int us_id) {
		this.cartdaoImpl.add(count, book_img,book_name, book_price, us_id);
	}

}
