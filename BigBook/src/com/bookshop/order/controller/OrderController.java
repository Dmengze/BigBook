package com.bookshop.order.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookshop.entity.Admin;
import com.bookshop.entity.Orders;
import com.bookshop.entity.Users;
import com.bookshop.order.service.OrderServiceImpl;
//import com.bookshop.util.Page;
import com.bookshop.util.Page;


@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource
	private OrderServiceImpl orderServiceImpl;
	
	@RequestMapping("/selectByUser")
	//该方法用于查询某个用户的所有订单
	public String selectByUser(HttpSession session,Model model){
		Users us =(Users) session.getAttribute("user");
		if(us!=null){
		int id = us.getUser_id();
		List<Orders> list = this.orderServiceImpl.selectByUser(id);
		model.addAttribute("selectByUser", list);
		return "forward:/orders.jsp";
		}else{
			return "forward:/login.jsp";
		}
	}
	
	@RequestMapping("/delete")
	//取消订单
	public String delete(@RequestParam("id")int order_id) {
		this.orderServiceImpl.delete(order_id);
		return "redirect:../order/selectByUser";
	}
	@RequestMapping("/add")
	//生成订单
	public String add(@RequestParam("count")int count,@RequestParam("book_img")String book_img,@RequestParam("book_name")String book_name,@RequestParam("book_price")Double book_price,HttpSession session,Model model) {
		Users us =(Users) session.getAttribute("user");
		 int user_id=us.getUser_id();
		 this.orderServiceImpl.add(count, book_img,book_name, book_price, user_id);
		 return "redirect:../order/selectByUser";
	}
	@RequestMapping("/selectByPage")
	@SuppressWarnings("rawtypes")
	//该方法用于按页查询，admin后台使用此方法
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
			page1.setTotalcount(orderServiceImpl.selectCount());
			page1.setTotalpage();
			page1.setDpage(dpage);
			List<Orders> list=this.orderServiceImpl.selectByPage(page1);	
			model.addAttribute("list", list);
			model.addAttribute("page", page1);
		    model.addAttribute("selectByPage", list);
		    return "forward:/admin/behandorderlist.jsp";}
		
	}
	
	

}
