package com.bookshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//创建图书实体类
@Entity
@Table(name="book")
public class Book {
		private Integer book_id;
		private String book_name;
		private String book_auth;
		private String book_publish_data;
		private String book_publisher;
		private Double book_price;
		private Integer type_id;
		private String book_img;
		private BookType bookType;//与图书类型建立多对一关联
		//private Set<orders> orderSet;//建立与订单的多对多
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public Integer getBook_id() {
			return book_id;
		}
		public void setBook_id(Integer book_id) {
			this.book_id = book_id;
		}
		
		
		public String getBook_name() {
			return book_name;
		}
		public void setBook_name(String book_name) {
			this.book_name = book_name;
		}
		public String getBook_auth() {
			return book_auth;
		}
		public void setBook_auth(String book_auth) {
			this.book_auth = book_auth;
		}
		public String getBook_publish_data() {
			return book_publish_data;
		}
		public void setBook_publish_data(String book_publish_data) {
			this.book_publish_data = book_publish_data;
		}
		public String getBook_publisher() {
			return book_publisher;
		}
		public void setBook_publisher(String book_publisher) {
			this.book_publisher = book_publisher;
		}
		public Double getBook_price() {
			return book_price;
		}
		public void setBook_price(Double book_price) {
			this.book_price = book_price;
		}
		public Integer getType_id() {
			return type_id;
		}
		public void setType_id(Integer type_id) {
			this.type_id = type_id;
		}
		public String getBook_img() {
			return book_img;
		}
		public void setBook_img(String book_img) {
			this.book_img = book_img;
		}
		@ManyToOne
		@JoinColumn(name="type_id",insertable=false,updatable=false)
		public BookType getBookType() {
			return bookType;
		}
		public void setBookType(BookType bookType) {
			this.bookType = bookType;
		}
		
		
//		@ManyToMany(mappedBy="bookSet")
//		public Set<orders> getOrderSet() {
//			return orderSet;
//		}
//		public void setOrderSet(Set<orders> orderSet) {
//			this.orderSet = orderSet;
//		}
		
		



}
