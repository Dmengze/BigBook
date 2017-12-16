package com.bookshop.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.book.dao.BookDaoImpl;
import com.bookshop.entity.Book;
import com.bookshop.util.Page;

@Service
@Transactional
public class BookServiceImpl {
	@Resource
	private BookDaoImpl bookDaoImpl;
	//查询所有图书
	public List<Book> findAll(){
		return this.bookDaoImpl.findAll();
	}
	//实现按条件查询，按照名字查询的模糊查询
	public List<Book> findByName(String name){
		return this.bookDaoImpl.findByName(name);	
	}
    //实现按类别查询
	public List<Book> findByType(Integer id){
		return this.bookDaoImpl.findByType(id);
	}
	//实现按id查询
	public List<Book> findById(Integer id){
		return this.bookDaoImpl.findById(id);
	}
	//删除图书
	public void delete(Integer id) {
		this.bookDaoImpl.delete(id);
	}
	//更新图书
	public void update(int id,String name,String auth,String publish_data,String publisher,double price,int type,String img) {
		 this.bookDaoImpl.update(id, name, auth, publish_data, publisher, price, type, img);
	}
	//新增图书
	public void add(String name,String auth,String publisher,String publish_data,double price,int type,String img) {
	   this.bookDaoImpl.add(name, auth, publisher, publish_data, price, type, img);
	}
	//查询所有图书的数量
	public Long selectCount(){
		return this.bookDaoImpl.selectCount();
	}
	//按页查询
	@SuppressWarnings("rawtypes")
	public List<Book> selectByPage(Page page){
		return this.bookDaoImpl.selectByPage(page);
	}
}
