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
	//����Ա��¼
	public String login(@RequestParam(value="name")String name,@RequestParam(value="password")String password,HttpSession session,Model model) {
		Admin admin = this.adminServiceImpl.login(name, password);
		if(admin != null){
			// ���û����浽HttpSession����
			session.setAttribute("admin", admin);
			return "redirect:../book/selectByPage?page=1";
			}else{
			// ���õ�¼ʧ����ʾ��Ϣ
			model.addAttribute("message", "��¼�����������!����������");
			// �������ڲ���ת����¼ҳ��
			return "forward:/admin/behandindex.jsp";
			}
	}
	@RequestMapping("/findAll")
	//��ѯ���й���Ա
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
	//�÷��������˳���¼
		 @RequestMapping("/toLogin")
		    public String execute(HttpSession session){
		        session.invalidate();
		        return "forward:/admin/behandindex.jsp";
		    }

}
