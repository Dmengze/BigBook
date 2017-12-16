package com.bookshop.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



//创建图书类型实体类
@Entity
@Table(name="booktype")
public class BookType {
	private Integer type_id;
	private String type_name;
	private Set<Book> bookSet = new HashSet<Book>();  //与图书建立一对多
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@OneToMany(mappedBy="bookType",targetEntity=Book.class,cascade=CascadeType.ALL)
	public Set<Book> getBookSet() {
		return bookSet;
	}
	
	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
	

}
