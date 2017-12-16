<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
  <c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
                	<li class="sel"><a href="${ctx}/book/selectByPage?page=1">book管理</a></li>           	
                	<li><a href="${ctx}/admin/findAll">admin信息</a></li>
                	<li><a href="${ctx}/user/selectByPage?page=1">user信息</a></li>
                	<li><a href="${ctx}/order/selectByPage?page=1">订单信息</a></li>
                	<li><a href="${ctx}/admin/toLogin">退出登录</a></li>
               
                </ul>
            </div>
            
        </div>
        <p class="index_hr"></p>
      <div class="content" style="background:#F8F8FF">
        <table cellspacing="0" cellpadding="0" border="1" >
	<tr>
	    <th><font size="5">图片</font></th><th><font size="5">ID</font></th> <th><font size="5">书名</font></th><th><font size="5">作者</font></th><th><font size="5">出版社</font></th><th><font size="5">日期</font></th><th><font size="5">价格</font></th>
		<th><font size="5">类型</font></th><th colspan="2"><font size="5">操作</font></th></tr>
		<c:forEach items="${selectByPage}" var="book">
	 <tr> 
	 <td><img alt="图片" src="${ctx}/Images/${book.book_img}" alt="book" style="width:110px; height:150px"></td>
	  <td>${book.book_id}</td>
	  <td>${book.book_name}</td>
	  <td>${book.book_auth}</td>
	  <td>${book.book_publisher}</td>
	  <td>${book.book_publish_data}</td>
	  <td>${book.book_price}</td>
	  <td>${book.bookType.type_name}</td>
	
	<td><a href="${ctx}/book/findByIdHand?id=${book.book_id}">修改</a></td>
	<td><a href="${ctx}/book/delete?id=${book.book_id}">删除</a></td>
	</tr>
	</c:forEach>
	    <tr height="20"><td ></td></tr>
		<tr><td colspan="7"></td><td colspan="3">
			<a href="${ctx}/book/selectByPage?page=1">首页</a>&nbsp;&nbsp;&nbsp;
			<c:if test="${page.dpage!=1}">
			<a href="${ctx}/book/selectByPage?page=${page.dpage-1 }">上一页</a>&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${page.dpage!=page.totalpage}">
			<a href="${ctx}/book/selectByPage?page=${page.dpage+1}">下一页</a>&nbsp;&nbsp;&nbsp;
			
			</c:if>
			<a href="${ctx}/book/selectByPage?page=${page.totalpage}">尾页</a>
		</td>
		</tr>
		<tr height="20"><td ></td></tr>
		<tr><td colspan="7"></td><td colspan="5"><a href="${ctx}/admin/behandbookadd.jsp">增加图书</a></td></tr>	
	</table>
	</div>    
      </div>
        <p class="index_hr"></p>
        <h1 class="news_title">Newsletter</h1>
        <p class="news_title_1"><span class="span_1">Keep up to date with new book releases and announcements with our newsletter.</span><span class="span_2"><img src="${ctx}/Images/img_inp.jpg" /></span></p>
        <p class="index_hr" style="margin-top:20px;"></p>
        <div class="footer" style="background:#F0FFFF">
           <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">Help and Contact us</a>
            <a class="a1" href="#">Press Room RSS feed</a>
            <a class="a2" href="#">abookapart on Twitter</a>
            <span class="span_2"><b>Published by</b><img src="${ctx}/Images/icon_hg.jpg" /></span>
        </div>
        
            
        
    </div>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>

</body>
</html>