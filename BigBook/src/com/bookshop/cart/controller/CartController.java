package com.bookshop.cart.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookshop.cart.service.CartServiceImpl;
import com.bookshop.entity.Cart_detial;
import com.bookshop.entity.Users;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource
	private CartServiceImpl cartserviceImlp;
	
	@RequestMapping("/login")
	//判断是否有用户登录,登陆后直接查看购物车所有图书
	public String login(HttpSession session,Model model){
		Users us =(Users) session.getAttribute("user");
		if(us==null){
			return "forward:/login.jsp";
		}
		else{
			int id = us.getUser_id();
			List<Cart_detial> list = this.cartserviceImlp.selectByUser(id);
			model.addAttribute("selectByUser", list);
			return "forward:/cart.jsp";
			}
		}
	@RequestMapping("/add")
	//向购物车中添加某种图书
	public String add(@RequestParam("count")int count,@RequestParam("book_img")String book_img,@RequestParam("book_name")String book_name,@RequestParam("book_price")Double book_price,HttpSession session,Model model) {
		Users us =(Users) session.getAttribute("user");
		if(us==null){
			return "forward:/login.jsp";
		}
		else{
		 int user_id=us.getUser_id();
		 this.cartserviceImlp.add(count, book_img,book_name, book_price, user_id);
		 return "redirect:../cart/login";
		}
	}
	 @RequestMapping("/update")
	 //修改当前用户的某种书的数量
		public void update( @RequestParam("count")int count,@RequestParam("cart_detial_id")int cart_detial_id) {
		  this.cartserviceImlp.update(count, cart_detial_id);
		}
	 @RequestMapping("/addNum") 
	  //增加当前图书数量(+1)
	 public String addNum(@RequestParam("id")int cart_detial_id){
		 this.cartserviceImlp.addNum(cart_detial_id);
		 return "redirect:../cart/login";
		  
	 }
	 @RequestMapping("/downNum")
	 //减去当前图书数量（—1）
	 public String downNum(@RequestParam("id")int cart_detial_id,@RequestParam("count")int count,HttpSession session){
		 if(count==1){
			session.setAttribute("id", cart_detial_id);
		    return "redirect:../cart/delete1";
		 }else{
		 this.cartserviceImlp.downNum(cart_detial_id);
		 return "redirect:../cart/login";}
	 }
	 @RequestMapping("/delete1")
	//删除购物车中某一种书籍（判断书籍数量被减为空时的删除）
	 public String delete1( HttpSession session) {
		 //int count = (int) session.getAttribute("count");
		 int id = (int) session.getAttribute("id");
		    this.cartserviceImlp.delete(id);
			return "redirect:../cart/login";
		 
		 
	 }
	 @RequestMapping("/delete")
	 //删除购物车中某一种书籍
	 public String delete( @RequestParam("id")int cart_detial_id,HttpSession session) {
		this.cartserviceImlp.delete(cart_detial_id);
		return "redirect:../cart/login";
	 }
	@RequestMapping("/deleteAll")
	//清空购物车
	public String deletecart(HttpSession session) {
		 Users us =(Users) session.getAttribute("user");
		 int user_id=us.getUser_id();
		 this.cartserviceImlp.deletecart(user_id);
		 return "redirect:../cart/login";
	
	}
	

	
	
	
	

}
