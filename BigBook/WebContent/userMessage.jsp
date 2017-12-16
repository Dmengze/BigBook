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
<link type="text/css" rel="stylesheet" href="${ctx}/Css/reset.css" />
<link type="text/css" rel="stylesheet" href="${ctx}/Css/1024_768.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="${ctx}/Css/pad_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="${ctx}/Css/pad.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="${ctx}/Css/tel_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="Css/tel.css" />
</head>
<body>
<div class="w_100_l top_title"  style="background:#F0FFFF">
	<div class="main">
    	<p><a href="#">Buy more than one book and save big! </a><a href="#">Read more</a></p>
    </div>
</div>
<div class="w_100_l"  style="background:#F0FFFF">
	<div class="main">
      <div class="top_banner">
            <div class="top_logo"><img src="${ctx}/Images/top_logo.jpg" alt="A BOOK APART LOGO" /></div>
            <div class="top_menu">
            	<ul>
                	<li><a href="${ctx}/index.jsp">首页</a></li>
                	<li><a href="${ctx}/book/findAll">图书列表</a></li>
                	<li><a href="${ctx}/book/findByType">图书分类</a></li>
                	<li><a href="${ctx}/order/selectByUser">我的订单</a></li>
                	<li  class="sel"><a href="#">我的信息</a></li>
                	<li><a href="${ctx}/login.jsp">登录</a></li>
                	<li><a href="${ctx}/user/toLogin">退出登录</a></li>
                </ul>
            </div>
            <div class="content"  style="background:#F8F8FF"><center>
            <h1 class="h1_book_title"><font size="6">用户信息</font></h1><br /><br /><br />
             <c:forEach items="${selectById}" var="user">
             <form action="${ctx}/user/update" >
             <table>
             <tr>
             <td><font size="6">姓名</font></td>
             <td><input type="text" name="name" value="${user.user_name} " style="font-size:20px"/></td>
             </tr>
             <tr><td  height="15"></td></tr>
             <tr>
             <td><font size="6">密码</font></td>
             <td><input type="password" name="password" value="${user.user_password} " style="font-size:20px"/></td>
             </tr>
             <tr><td  height="15"></td></tr>
             <tr>
             <td> <font size="6">email</font></td>
             <td><input type="text" name="email" value="${user.user_email} " style="font-size:20px"/></td>
             </tr>
             <tr><td  height="15"></td></tr>
             <tr>
             <td><font size="6">电话</font></td>
             <td><input type="text" name="telephone" value="${user.user_telephone} " style="font-size:20px"/> </td>
             </tr>
             <tr><td  height="15"></td></tr>
             <tr>
             <td><font size="6">住址</font></td>
             <td><input type="text" name="address" value="${user.user_address} " style="font-size:20px"/></td>
             </tr>
             <tr><td  height="15"></td></tr>
             <tr>
             <td  colspan="2" style="padding-left:100px;"> <input type="submit" value="确认修改" style="font-family:'Tahoma';border:0;
              vertical-align:middle;margin:8px;line-height:18px;font-size:18px;background:#CDAA7D" /></td>
             </tr>
            </table> 
            </form>
	       </c:forEach>
	       
	       </center>   
           </div>
     </div>  
    
        <p class="index_hr"></p>
        <h1 class="news_title">Newsletter</h1>
        <p class="news_title_1"><span class="span_1">Keep up to date with new book releases and announcements with our newsletter.</span><span class="span_2"><img src="${ctx}/Images/img_inp.jpg" /></span></p>
        <p class="index_hr" style="margin-top:20px;"></p>
        <div class="footer">
           <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">Help and Contact us</a>
            <a class="a1" href="#">Press Room RSS feed</a>
            <a class="a2" href="#">abookapart on Twitter</a>
            <span class="span_2"><b>Published by</b><img src="${ctx}/Images/icon_hg.jpg"/></span>
        </div>
    </div>
</div>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>