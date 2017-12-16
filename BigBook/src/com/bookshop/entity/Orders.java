package com.bookshop.entity;
//创建订单实体类
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	    
		private int order_id;
		private String book_img;
		private String book_name;
		private Double book_price;
		private Integer count;
		private int user_id;
		private Users user;//与用户建里多对一
	
		//private Set<Book> bookSet;//建立与图书的多对多
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public int getOrder_id() {
			return order_id;
		}
		public void setOrder_id(int order_id) {
			this.order_id = order_id;
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
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		@ManyToOne
		@JoinColumn(name="user_id",insertable=false,updatable=false)
		public Users getUser() {
			return user;
		}
		public void setUser(Users user) {
			this.user = user;
		}


}
