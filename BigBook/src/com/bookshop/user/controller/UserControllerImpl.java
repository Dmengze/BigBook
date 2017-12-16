package com.bookshop.user.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookshop.entity.Admin;
import com.bookshop.entity.Users;
import com.bookshop.user.service.UserSereviceImpl;
import com.bookshop.util.Page;

@Controller
@RequestMapping("/user")
public class UserControllerImpl {
	@Resource
	private UserSereviceImpl userServiceImpl;
	
	@RequestMapping("/login")
	//该方法用于查询user账号,用于判断用户名和密码是否正确，用户登录时使用
	public String login(@RequestParam(value="username")String username,@RequestParam(value="password")String password,HttpSession session,Model model) {
		Users us = this.userServiceImpl.login(username, password);
		if(us != null){
			// 将用户保存到HttpSession当中
			session.setAttribute("user", us);
			// 客户端跳转到主页面
			return "redirect:/index.jsp";
			}else{
			// 设置登录失败提示信息
			model.addAttribute("message", "登录名或密码错误!请重新输入");
			// 服务器内部跳转到登录页面
			return "forward:/login.jsp";
			}

	}
	
	@RequestMapping("/add")
	//该方法用于插入user用户，用于用户注册
	public String adds(@RequestParam("name" )String name, @RequestParam("password" )String password,@RequestParam("email" )String email,@RequestParam("telephone" )String telephone,@RequestParam("address" )String address,Model model) {
		    this.userServiceImpl.add(name, password, email, telephone, address);
		    return "redirect:/login.jsp";
	
	}
	
	@RequestMapping("/judge")
	//用于Ajax判断用户名是否存在
	public void judge(@RequestParam("name" )String name ,HttpServletResponse response,Model model){		
		try {
			PrintWriter out = response.getWriter();
			Users us = this.userServiceImpl.judge(name);
			if(us != null){
				// 表示用户已经存在
				System.out.println(name);
				out.print(true);
			}else{
				out.print(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  	
	}
	
	//该方法用于退出登录
	 @RequestMapping("/toLogin")
	    public String execute(HttpSession session){
	        session.invalidate();
	        return "login";
	    }

	
	
	@RequestMapping("/selectAll")
	//该方法用于查询所有的user用户,admin调用此方法
	public String selectAll(Model model,HttpSession session){
		Admin ad = (Admin) session.getAttribute("admin");
		if(ad==null){
			return "forward:/admin/behandindex.jsp";	
		}else{
		List<Users> list=this.userServiceImpl.selectAll();
		model.addAttribute("selectAll", list);
		return "forward:/admin/behanduserlist.jsp";
		}
	}
	
	
	@RequestMapping("/delete")
	//该方法用于删除user用户，admin调用此方法
		public void delet(@RequestParam("id")int id) {
		this.userServiceImpl.delet(id);
	}
	
	
	@RequestMapping("/update")
	//该方法用于更新user账户，用户查看自己的信息并更改
		public String update(@RequestParam("name") String name, @RequestParam("password")String password,@RequestParam("email")String email,@RequestParam("telephone")String telephone,@RequestParam("address")String address,HttpSession session) {
		   
		Users us =(Users) session.getAttribute("user");
		if(us!=null){
		   int id = us.getUser_id();        
		   this.userServiceImpl.update(id, name, password, email, telephone, address);	
		   return "index";
		 }else{
			return "forward:/login.jsp";
			   }
		}
	
	@RequestMapping("/selectById")
	//该方法用于通过id查询user信息的方法，用户自己查看自己信息
	public String selectById(Model model,HttpSession session) {
		Users us =(Users) session.getAttribute("user");
		if(us!=null){
		int id = us.getUser_id();
		List<Users> user = this.userServiceImpl.selectById(id);
		model.addAttribute("selectById", user);
		return "forward:/userMessage.jsp";
		}else{
			return "forward:/login.jsp";
		}
	}
	
	
	
	@RequestMapping("/selectCount")
	//查询所有用户的数量，admin调用此方法
    public String selectCount(Model model){
		Long count= this.userServiceImpl.selectCount();
		model.addAttribute("selectCount", count);
		return "list";	
	}
	  
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectByPage")
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
			page1.setTotalcount(userServiceImpl.selectCount());
			page1.setTotalpage();
			page1.setDpage(dpage);
			List<Users> list=this.userServiceImpl.selectByPage(page1);	
			model.addAttribute("list", list);
			model.addAttribute("page", page1);
		    model.addAttribute("selectByPage", list);
		    return "forward:/admin/behanduserlist.jsp";}
		
	}
	
	
}
