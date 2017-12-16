<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
  <c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>后台管理系统</title>
<link type="text/css" rel="stylesheet" href="/Shop/Css/reset.css" />
<link type="text/css" rel="stylesheet" href="/Shop/Css/1024_768.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="${ctx}/Css/pad_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="${ctx}/Css/pad.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="${ctx}/Css/tel_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="/Shop/Css/tel.css" />
<style type="text/css">
	table{
		margin: auto;
	}
	table th{
		background-color: #FFBD9D;
		width: 100px;
	}
</style>
</head>
<body >
<div class="w_100_l" style="background:#F0FFFF">
	<div class="main">
      <div class="top_banner">
            <div class="top_logo"><img src="${ctx}/Images/top_logo.jpg" alt="A BOOK APART LOGO" /></div>
            <div class="top_menu">
            	<ul>
                	<li><a href="${ctx}/book/selectByPage?page=1">book管理</a></li>           	
                	<li><a href="${ctx}/admin/findAll">admin信息</a></li>
                	<li class="sel"><a href="#">user信息</a></li>
                	<li><a href="${ctx}/order/selectByPage?page=1">订单信息</a></li>
                	<li><a href="${ctx}/admin/toLogin">退出登录</a></li>
                </ul>
            </div>
            
        </div>
        <p class="index_hr"></p>
      <div class="content" style="background:#F8F8FF">
       <center><span class="h1_book_title"><font size="6">用户信息</font></span></center> <br />
       
        <table cellspacing="0" cellpadding="0" border="1" >
		<tr><th><font size="5">ID</font></th> <th><font size="5">用户名</font></th><th><font size="5">密码</font></th><th><font size="5">手机号</font></th><th><font size="5">email</font></th>
		<th><font size="5">用户地址</font></th></tr>
		<tr height="20"><td ></td></tr>
		<c:forEach items="${selectByPage}" var="user">
	    <tr> <td><font size="5">${user.user_id}</font></td>
	    <td width="100"><font size="5">${user.user_name}</font></td>
	    <td width="150"><font size="5">${user.user_password}</font></td>
	    <td width="180"><font size="5">${user.user_telephone}</font></td>
	    <td width="200"><font size="5">${user.user_email}</font></td>
	    <td width="200"><font size="5">${user.user_address}</font></td>
	    </tr>
	    <tr height="20"><td ></td></tr>
	    </c:forEach>
	    <tr></tr>
		<tr><td></td><td></td><td></td><td></td>
		<td colspan="2">
			<a href="${ctx}/user/selectByPage?page=1"><span><font size="4">首页</font></span></a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="${ctx}/user/selectByPage?page=${page.dpage-1 }"><span><font size="4">上一页</font></span></a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="${ctx}/user/selectByPage?page=${page.dpage+1}"><span><font size="4">下一页</font></span></a>&nbsp;&nbsp;&nbsp;
			
			</c:if>
			<a href="${ctx}/user/selectByPage?page=${page.totalpage}"><span><font size="4">尾页</font></span></a>
		</td>
		</tr>
	</table>
      </div>
        <p class="index_hr"></p>
        
        <div class="footer" style="background:#F0FFFF">
           <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">Help and Contact us</a>
            <a class="a1" href="#">Press Room RSS feed</a>
            <a class="a2" href="#">abookapart on Twitter</a>
            <span class="span_2"><b>Published by</b><img src="${ctx}/Images/icon_hg.jpg" /></span>
        </div>
            
        </div>
        
    </div>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>