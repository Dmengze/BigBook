package com.bookshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_detial")
public class Cart_detial {
	private Integer cart_detial_id;
	private String book_img;
	private String book_name;
	private Double book_price;
	private Integer count;
    private Integer us_id;
    private Users user;//与用户建立双向多对一
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCart_detial_id() {
		return cart_detial_id;
	}
	public void setCart_detial_id(Integer cart_detial_id) {
		this.cart_detial_id = cart_detial_id;
	}
	
	
	
	
	
	
	
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Double getBook_price() {
		return book_price;
	}
	public void setBook_price(Double book_price) {
		this.book_price = book_price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	public Integer getUs_id() {
		return us_id;
	}
	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}
	@ManyToOne
	@JoinColumn(name="us_id",insertable=false,updatable=false)
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
}
