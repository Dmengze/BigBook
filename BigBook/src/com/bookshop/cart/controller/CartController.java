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
	//�ж��Ƿ����û���¼,��½��ֱ�Ӳ鿴���ﳵ����ͼ��
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
	//���ﳵ�����ĳ��ͼ��
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
	 //�޸ĵ�ǰ�û���ĳ���������
		public void update( @RequestParam("count")int count,@RequestParam("cart_detial_id")int cart_detial_id) {
		  this.cartserviceImlp.update(count, cart_detial_id);
		}
	 @RequestMapping("/addNum") 
	  //���ӵ�ǰͼ������(+1)
	 public String addNum(@RequestParam("id")int cart_detial_id){
		 this.cartserviceImlp.addNum(cart_detial_id);
		 return "redirect:../cart/login";
		  
	 }
	 @RequestMapping("/downNum")
	 //��ȥ��ǰͼ����������1��
	 public String downNum(@RequestParam("id")int cart_detial_id,@RequestParam("count")int count,HttpSession session){
		 if(count==1){
			session.setAttribute("id", cart_detial_id);
		    return "redirect:../cart/delete1";
		 }else{
		 this.cartserviceImlp.downNum(cart_detial_id);
		 return "redirect:../cart/login";}
	 }
	 @RequestMapping("/delete1")
	//ɾ�����ﳵ��ĳһ���鼮���ж��鼮��������Ϊ��ʱ��ɾ����
	 public String delete1( HttpSession session) {
		 //int count = (int) session.getAttribute("count");
		 int id = (int) session.getAttribute("id");
		    this.cartserviceImlp.delete(id);
			return "redirect:../cart/login";
		 
		 
	 }
	 @RequestMapping("/delete")
	 //ɾ�����ﳵ��ĳһ���鼮
	 public String delete( @RequestParam("id")int cart_detial_id,HttpSession session) {
		this.cartserviceImlp.delete(cart_detial_id);
		return "redirect:../cart/login";
	 }
	@RequestMapping("/deleteAll")
	//��չ��ﳵ
	public String deletecart(HttpSession session) {
		 Users us =(Users) session.getAttribute("user");
		 int user_id=us.getUser_id();
		 this.cartserviceImlp.deletecart(user_id);
		 return "redirect:../cart/login";
	
	}
	

	
	
	
	

}
