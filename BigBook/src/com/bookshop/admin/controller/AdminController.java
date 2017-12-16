package com.bookshop.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bookshop.admin.service.AdminServiceImpl;
import com.bookshop.entity.Admin;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminServiceImpl adminServiceImpl;
	
	@RequestMapping("/login")
	//管理员登录
	public String login(@RequestParam(value="name")String name,@RequestParam(value="password")String password,HttpSession session,Model model) {
		Admin admin = this.adminServiceImpl.login(name, password);
		if(admin != null){
			// 将用户保存到HttpSession当中
			session.setAttribute("admin", admin);
			return "redirect:../book/selectByPage?page=1";
			}else{
			// 设置登录失败提示信息
			model.addAttribute("message", "登录名或密码错误!请重新输入");
			// 服务器内部跳转到登录页面
			return "forward:/admin/behandindex.jsp";
			}
	}
	@RequestMapping("/findAll")
	//查询所有管理员
	public String findAll( Model model,HttpSession session){
		Admin ad = (Admin) session.getAttribute("admin");
		if(ad==null){
			return "forward:/admin/behandindex.jsp";
		}else{
		List<Admin> list=this.adminServiceImpl.findAll();
		model.addAttribute("findAll", list);
		return "forward:/admin/behandadminlist.jsp";
		}
		
	}
	//该方法用于退出登录
		 @RequestMapping("/toLogin")
		    public String execute(HttpSession session){
		        session.invalidate();
		        return "forward:/admin/behandindex.jsp";
		    }

}
