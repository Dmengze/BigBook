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
	//��ѯ����ͼ��
	public List<Book> findAll(){
		return this.bookDaoImpl.findAll();
	}
	//ʵ�ְ�������ѯ���������ֲ�ѯ��ģ����ѯ
	public List<Book> findByName(String name){
		return this.bookDaoImpl.findByName(name);	
	}
    //ʵ�ְ�����ѯ
	public List<Book> findByType(Integer id){
		return this.bookDaoImpl.findByType(id);
	}
	//ʵ�ְ�id��ѯ
	public List<Book> findById(Integer id){
		return this.bookDaoImpl.findById(id);
	}
	//ɾ��ͼ��
	public void delete(Integer id) {
		this.bookDaoImpl.delete(id);
	}
	//����ͼ��
	public void update(int id,String name,String auth,String publish_data,String publisher,double price,int type,String img) {
		 this.bookDaoImpl.update(id, name, auth, publish_data, publisher, price, type, img);
	}
	//����ͼ��
	public void add(String name,String auth,String publisher,String publish_data,double price,int type,String img) {
	   this.bookDaoImpl.add(name, auth, publisher, publish_data, price, type, img);
	}
	//��ѯ����ͼ�������
	public Long selectCount(){
		return this.bookDaoImpl.selectCount();
	}
	//��ҳ��ѯ
	@SuppressWarnings("rawtypes")
	public List<Book> selectByPage(Page page){
		return this.bookDaoImpl.selectByPage(page);
	}
}
