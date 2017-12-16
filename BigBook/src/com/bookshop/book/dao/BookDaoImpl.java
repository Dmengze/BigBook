package com.bookshop.book.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bookshop.entity.Book;
import com.bookshop.util.Page;



@Repository
public class BookDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	//查询所有图书
	@SuppressWarnings("unchecked")
	public List<Book> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Book");
		return q.list();
	}
	//实现按条件查询，按照名字查询的模糊查询
	@SuppressWarnings("unchecked")
	public List<Book> findByName( String name){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Book where book_name like ?");
		return q.setParameter(0,  "%"+name+"%").list();	
	}
   //实现按类别查询
	@SuppressWarnings("unchecked")
	public List<Book> findByType(Integer typeid){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Book  where type_id=?");
		return q.setParameter(0, typeid).list();	
	}
	//实现按id查询
	@SuppressWarnings("unchecked")
	public List<Book> findById(Integer id){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Book where  book_id=?");
		return q.setParameter(0, id).list();	
	}
	//删除图书
	public void delete(Integer id) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("delete from Book where book_id = ?");
		q.setInteger(0, id).executeUpdate();
	}
	//更新图书
	public void update(int id,String name,String auth,String publish_data,String publisher,double price,int type,String img) {
		Query q=this.sessionFactory.getCurrentSession().createQuery("update Book set book_name=? ,book_auth=? , book_publish_data=? ,book_publisher=?, book_price=?, type_id=?, book_img=? where book_id=?");
		q.setString(0, name);
		q.setString(1, auth);
		q.setString(2, publish_data);
		q.setString(3, publisher);
		q.setDouble(4, price);
		q.setInteger(5, type);
		q.setString(6, img);
		q.setInteger(7, id);
		q.executeUpdate();	
	}
	//新增图书
	public void add(String name,String auth,String publisher,String publish_data,double price,int type,String img) {
		Book book = new Book();
		book.setBook_name(name);
		book.setBook_auth(auth);
		book.setBook_publisher(publisher);
		book.setBook_publish_data(publish_data);
		book.setBook_price(price);
		book.setType_id(type);
		book.setBook_img(img);
		sessionFactory.getCurrentSession().save(book);
		
	}
   //查询所有图书的数量
	public Long selectCount(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("select count(*) as num from Book");
		return ((Long)q.uniqueResult());
	}	
   //按页查询
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<Book> selectByPage(Page page){
			Query q=this.sessionFactory.getCurrentSession().createQuery(" from Book");
			q.setFirstResult((page.getDpage().intValue()-1) *page.getPagecount().intValue());
			 q.setMaxResults(page.getPagecount().intValue());
			 return q.list();
			 
	
	}
}
