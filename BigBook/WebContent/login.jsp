<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>书屋</title>
<link type="text/css" rel="stylesheet" href="${ctx }/Css/reset.css" />
<link type="text/css" rel="stylesheet" href="${ctx }/Css/1024_768.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="${ctx }/Css/pad_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="${ctx }/Css/pad.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="${ctx }/Css/tel_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="${ctx }Css/tel.css" />
</head>

<body>
<div class="w_100_l top_title"  style="background:#F8F8FF">
	<div class="main">
    	<p><a href="#">Buy more than one book and save big! </a><a href="#">Read more</a></p>
    </div>
</div>

<div class="w_100_l"  style="background:#F8F8FF">
	<div class="main">
      <div class="top_banner">
            <div class="top_logo"><img src="${ctx }/Images/top_logo.jpg" alt="A BOOK APART LOGO" /></div>
            <div class="top_menu">
            	<ul>
                	<li ><a href="${ctx}/index.jsp">首页</a></li>
                	<li><a href="${ctx}/book/findAll">图书列表</a></li>
                	<li><a href="${ctx}/book/findByType">图书分类</a></li>
                	<li><a href="${ctx}/order/selectByUser">我的订单</a></li>
                	<li><a href="${ctx}/user/selectById">我的信息</a></li>
                	<li class="sel"><a href="#">登录</a></li>
                	<li><a href="${ctx}/user/toLogin">退出登录</a></li>
                </ul>
            </div><br /><br /><br />
        <p class="index_hr"></p>
      <div class="content" style="background:#F8F8FF" ><center><br />
            <span class="h1_book_title"><font size="6">账号登录</font></span><br /><br /> <br />
        	<form action="${ctx}/user/login">
        	<table>
        	<tr>
        	<td><font size="5">用户名:</font></td>
        	<td><input type="text" name="username" /></td>
        	</tr>
        	<tr><td  height="10"></td></tr>
        	<tr>
        	<td><font size="5">密码:</font></td>
        	<td><input type="password" name="password"/></td>
            </tr>
        	<tr><td  height="20"></td></tr>
            <tr>
        	<td colspan="2" style="padding-left:100px;"> <input type="submit" value="登录" style="font-family:'Tahoma';border:5px;
vertical-align:middle;margin:8px;line-height:28px;line-width:40px;font-size:28px"/></td>
        	</tr>
          </table>
          <br /> <br /> <br /> <br /> <br />
          <p><font size="4" color="red">还没有账号？点击<a href="${ctx}/add.jsp">注册</a></font></p>
           </form>
            <%
               Object o = request.getAttribute("message") ;
               if(o!=null){
            %>
           
            <p> <font color="red" size="2">${message}</font></p>
            <% } %>
            </center>
            <br /><br /><br /> <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
      </div>
      </div>
        <div class="footer">
          <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">联系我们</a>
            <a class="a1" href="#">登陆</a>
            <a class="a2" href="#">登录</a>
            <span class="span_2"><b>设计源自</b><img src="${ctx }/Images/icon_hg.jpg" /></span>
        </div>
    </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>