package com.bookshop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//创建用户实体类
@Entity
@Table(name="users")
public class Users {
	private Integer user_id;
	private String user_name;
	private String user_password;
	private String user_email;
	private String user_telephone;
	private String user_address;
	private Set<Orders> orderSet = new HashSet<Orders>();//与订单建立一对多关联
	private Set<Cart_detial> carts = new HashSet<Cart_detial>();//与购物车细节建立一对多
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_telephone() {
		return user_telephone;
	}
	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)//设置懒加载
   // @JoinColumn(name="id",insertable=false,updatable=false)//指userid
	public Set<Orders> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Cart_detial> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart_detial> carts) {
		this.carts = carts;
	}
	
	
	
	
	
	

}
