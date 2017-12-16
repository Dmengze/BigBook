package com.bookshop.book.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookshop.book.service.BookServiceImpl;
import com.bookshop.entity.Admin;
import com.bookshop.entity.Book;
import com.bookshop.util.Page;
@Controller("/book")
@RequestMapping("/book")
public class BookController {
	
		@Resource
		private BookServiceImpl bookServiceImpl;
		
		@RequestMapping("/findAll")
	   //查询所有图书
		public String findAll(Model model){
			List<Book> list=this.bookServiceImpl.findAll();
			model.addAttribute("findAll", list);
			return "booklist";
		}
		@RequestMapping("/findByName")
		//实现按条件查询，按照名字查询的模糊查询
		public String findByName(@RequestParam("name" )String name, Model model){
			//System.out.println(name);
			List<Book> list=this.bookServiceImpl.findByName(name);
			model.addAttribute("findByName", list);
			return "booklist";
		}
		@RequestMapping("/findByType")
		//实现按类别查询
		public String findByType(@RequestParam(value="typeid",required=false)Integer typeid, Model model){
			List<Book> list1=this.bookServiceImpl.findByType(1);
			model.addAttribute("list1", list1);
			List<Book> list2=this.bookServiceImpl.findByType(2);
			model.addAttribute("list2", list2);
			List<Book> list3=this.bookServiceImpl.findByType(3);
			model.addAttribute("list3", list3);
			List<Book> list4=this.bookServiceImpl.findByType(4);
			model.addAttribute("list4", list4);
			return "typelist";
		}
		@RequestMapping("/findById")
		//实现按id查询
		public String findById(@RequestParam("id")Integer id, Model model){
			List<Book> list=this.bookServiceImpl.findById(id);
			model.addAttribute("findById", list);
			return "book_detail";	
		}
		@RequestMapping("/findByIdHand")
		//实现按id查询,后台使用
		public String findByIdHand(@RequestParam("id")Integer id, Model model){
			List<Book> list=this.bookServiceImpl.findById(id);
			model.addAttribute("findByIdHand", list);
			return "forward:/admin/behandbookupdate.jsp";	
		}
		@RequestMapping("/delete")
		//删除图书
		public String delete(@RequestParam("id")int id) {
			this.bookServiceImpl.delete(id);
		    return "redirect:../book/selectByPage?page=1";
		}
		@RequestMapping("/update")
		//更新图书
		public String update(@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("auth")String auth,@RequestParam("publish_data")String publish_data,@RequestParam("publisher")String publisher,@RequestParam("price")double price,@RequestParam("bookType")int type,@RequestParam("img")String img){
			this.bookServiceImpl.update(id, name, auth, publish_data, publisher, price, type, img);
			 return "redirect:../book/selectByPage?page=1";
		}
		@RequestMapping("/add")
		//新增图书
		public String add(@RequestParam("name")String name,@RequestParam("auth")String auth,@RequestParam("publisher")String publisher,@RequestParam("publish_data")String publish_data,@RequestParam("price")double price,@RequestParam("bookType")int type,@RequestParam("img")String img){
			this.bookServiceImpl.add(name, auth, publisher, publish_data, price, type, img);
			return "redirect:../book/selectByPage?page=1";
		}
		@RequestMapping("/selectCount")
		//查询所有图书的数量
		public String selectCount(Model model){
			Long count= this.bookServiceImpl.selectCount();
			model.addAttribute("selectCount", count);
			return "list";
		}
		@RequestMapping("/selectByPage")
		//按页查询
		@SuppressWarnings("rawtypes")
		public String selectByPage(@RequestParam("page")Long page, HttpSession session,Model model){
			Admin ad = (Admin) session.getAttribute("admin");
			if(ad==null){
				return "forward:/admin/behandindex.jsp";	
			 }else{
				long dpage=1;
				if(page!=null) {
					dpage=page;
				}	
				Page page1 = new Page();
				page1.setTotalcount(bookServiceImpl.selectCount());
				page1.setTotalpage();
				page1.setDpage(dpage);
				List<Book> list=this.bookServiceImpl.selectByPage(page1);	
				model.addAttribute("list", list);
				model.addAttribute("page", page1);
			    model.addAttribute("selectByPage", list);
			    return "forward:/admin/behandbooklist.jsp";}
			
		}
	
}