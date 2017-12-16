package com.bookshop.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.entity.Users;
import com.bookshop.user.dao.UserDaoImpl;
import com.bookshop.util.Page;

@Service
@Transactional
//(readOnly=true)
public class UserSereviceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	//�÷������ڲ�ѯuser�˺�,�����ж��û����������Ƿ���ȷ���û���¼ʱʹ��
	public Users login(String userName,String password) {
		return this.userDaoImpl.login(userName, password);
	}
	//�÷��������ж��û����Ƿ����
	public Users judge(String userName){
		return this.userDaoImpl.judge(userName);
	}
	
	//�÷������ڲ���user�û��������û�ע��
	public void add(String name, String password,String email,String telephone,String address) {
		this.userDaoImpl.add(name, password, email, telephone, address);
	}
	//�÷������ڲ�ѯ���е�user�û�,admin���ô˷���
	public List<Users> selectAll(){
	 return this.userDaoImpl.selectAll();
	}
	//�÷�������ɾ��user�û���admin���ô˷���
	public void delet(int id) {
		this.userDaoImpl.delet(id);
	}
	//�÷������ڸ���user�˻���admin���ô˷���
	public void update(int id, String name, String password,String email,String telephone,String address) {
		this.userDaoImpl.update(id, name, password, email, telephone, address);
	}
	//�÷�������ͨ��id��ѯuser��Ϣ�ķ�����admin���ô˷���
	public List<Users> selectById(int id) {
		return this.userDaoImpl.selectById(id);
	}
	//��ѯ�����û���������admin���ô˷���
	public Long selectCount(){
		return this.userDaoImpl.selectCount();
	}
	//�÷������ڰ�ҳ��ѯ��admin��̨ʹ�ô˷���
	@SuppressWarnings("rawtypes")
	public List<Users> selectByPage(Page page){
		return this.userDaoImpl.selectByPage(page);
	}
	

}
