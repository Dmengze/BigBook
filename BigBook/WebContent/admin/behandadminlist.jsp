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
                	<li class="sel"><a href="#">admin信息</a></li>
                	<li><a href="${ctx}/user/selectByPage?page=1">user信息</a></li>
                	<li><a href="${ctx}/order/selectByPage?page=1">订单信息</a></li>
                	<li><a href="${ctx}/admin/toLogin">退出登录</a></li>
                </ul>
            </div>
            
        </div>
        <div class="content" style="background:#F8F8FF" ><center><br />
            <span class="h1_book_title"><font size="6">管理员信息</font></span><br /><br />
            
        	 <table cellspacing="0" cellpadding="0" border="1" >
        	 
		     <tr><th><font size="5">ID</font></th> <th><font size="5">姓名</font></th><th><font size="5">密码</font></th></tr>
		     <tr height="20"><td ></td></tr>
		     <c:forEach items="${findAll}" var="admin">
	         <tr> <td><font size="5">${admin.admin_id}</font></td>
	         <td><font size="5">${admin.admin_name}</font></td>
	         <td><font size="5">${admin.admin_password}</font></td>
	         <tr height="20"><td ></td></tr>
	         </c:forEach>	         
	         </table>
	           
             </center>
      </div>
         <p class="index_hr"></p>
        
        <div class="footer" style="background:#F0FFFF">
           <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">Help and Contact us</a>
            <a class="a1" href="#">Press Room RSS feed</a>
            <a class="a2" href="#">abookapart on Twitter</a>
            <span class="span_2"><b>Published by</b><img src="${ctx}/Images/icon_hg.jpg"  /></span>
        </div>
            
        </div>
       
    </div>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>