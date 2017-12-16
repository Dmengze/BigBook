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
                	<li class="sel"><a href="${ctx}/index.jsp">首页</a></li>
                	<li><a href="${ctx}/book/findAll">图书列表</a></li>
                	<li><a href="${ctx}/book/findByType">图书分类</a></li>
                	<li><a href="${ctx}/order/selectByUser">我的订单</a></li>
                	<li><a href="${ctx}/user/selectById">我的信息</a></li>
                	<li><a href="${ctx}/login.jsp">登录</a></li>
                	<li><a href="${ctx}/user/toLogin">退出登录</a></li>
                </ul>
            </div>
            <div class="content"  style="background:#F8F8FF"><center>
            <h1 class="h1_book_title"><font size="6">图书详细信息</font></h1><br /><br /><br />
            <c:forEach items="${findById}" var="book">
        	<table cellspacing="0" cellpadding="0" border="1" >
             <tr>
             <td rowspan="14" colspan="2"><img alt="图片" src="${ctx}/Images/${book.book_img}" alt="book" style="width:170px; height:230px"/></td>
             </tr>
             <tr>
             <td><input type="hidden" name="id" value="${book.book_id}"/></td>
             </tr>
             <tr>
             <td>书名</td>
             <td><font size="5">${book.book_name}</font></td>
             </tr>
             <tr><td  height="10"></td></tr>
             <tr>
             <td>价格</td>
             <td><font size="5">${book.book_price}</font></td>
             </tr>
             <tr><td  height="10"></td></tr>
             <tr>
             <td>作者</td>
             <td><font size="5">${book.book_auth}</font></td>
             </tr>
             <tr><td  height="10"></td></tr>
             <tr>
             <td>类型</td>
             <td><font size="5">${book.bookType.type_name}</font></td>
        	</tr>
             <tr><td  height="10"></td></tr>
             <tr>
             <td>出版日期</td>
             <td> <font size="5">${book.book_publish_data}</font></td>
             </tr>
             <tr><td  height="10"></td></tr>
             <tr>
             <td>出版社</td>
             <td><font size="5">${book.book_publisher}</font></td>
             </tr>
             <tr><td  height="10"></td></tr>
          <tr><td colspan="2" style="padding-left:240px;"></td>
          <td  colspan="2" style="padding-left:100px;"> 
			<form action="${ctx}/cart/add">
			<input type="hidden" name="count" value="1"/>
			<input type="hidden" name="book_img" value="${book.book_img}"/>
			<input type="hidden" name="book_name" value="${book.book_name}"/>
			<input type="hidden" name="book_price" value="${book.book_price}"/>
			<input type="submit" value="BUY" style="font-family:'Arial'; border:0;
            vertical-align:middle; margin:8px; line-height:18px; font-size:18px ;background:#EE6A50" />
			</form>
			</td>
          </tr>
            </table> 
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
