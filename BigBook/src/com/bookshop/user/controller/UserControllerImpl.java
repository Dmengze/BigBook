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
	//�÷������ڲ�ѯuser�˺�,�����ж��û����������Ƿ���ȷ���û���¼ʱʹ��
	public String login(@RequestParam(value="username")String username,@RequestParam(value="password")String password,HttpSession session,Model model) {
		Users us = this.userServiceImpl.login(username, password);
		if(us != null){
			// ���û����浽HttpSession����
			session.setAttribute("user", us);
			// �ͻ�����ת����ҳ��
			return "redirect:/index.jsp";
			}else{
			// ���õ�¼ʧ����ʾ��Ϣ
			model.addAttribute("message", "��¼�����������!����������");
			// �������ڲ���ת����¼ҳ��
			return "forward:/login.jsp";
			}

	}
	
	@RequestMapping("/add")
	//�÷������ڲ���user�û��������û�ע��
	public String adds(@RequestParam("name" )String name, @RequestParam("password" )String password,@RequestParam("email" )String email,@RequestParam("telephone" )String telephone,@RequestParam("address" )String address,Model model) {
		    this.userServiceImpl.add(name, password, email, telephone, address);
		    return "redirect:/login.jsp";
	
	}
	
	@RequestMapping("/judge")
	//����Ajax�ж��û����Ƿ����
	public void judge(@RequestParam("name" )String name ,HttpServletResponse response,Model model){		
		try {
			PrintWriter out = response.getWriter();
			Users us = this.userServiceImpl.judge(name);
			if(us != null){
				// ��ʾ�û��Ѿ�����
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
	
	//�÷��������˳���¼
	 @RequestMapping("/toLogin")
	    public String execute(HttpSession session){
	        session.invalidate();
	        return "login";
	    }

	
	
	@RequestMapping("/selectAll")
	//�÷������ڲ�ѯ���е�user�û�,admin���ô˷���
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
	//�÷�������ɾ��user�û���admin���ô˷���
		public void delet(@RequestParam("id")int id) {
		this.userServiceImpl.delet(id);
	}
	
	
	@RequestMapping("/update")
	//�÷������ڸ���user�˻����û��鿴�Լ�����Ϣ������
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
	//�÷�������ͨ��id��ѯuser��Ϣ�ķ������û��Լ��鿴�Լ���Ϣ
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
	//��ѯ�����û���������admin���ô˷���
    public String selectCount(Model model){
		Long count= this.userServiceImpl.selectCount();
		model.addAttribute("selectCount", count);
		return "list";	
	}
	  
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectByPage")
	//�÷������ڰ�ҳ��ѯ��admin��̨ʹ�ô˷���
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
