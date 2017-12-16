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
<div class="w_100_l top_title" style="background:#F8F8FF">
	<div class="main">
    	<p><a href="#">Buy more than one book and save big! </a><a href="#">Read more</a></p>
    </div>
</div>

<div class="w_100_l" style="background:#F8F8FF">
	<div class="main">
      <div class="top_banner">
            <div class="top_logo"><img src="${ctx }/Images/top_logo.jpg" alt="A BOOK APART LOGO" /></div>
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
              <p class="index_hr"></p>
      <div class="content"><center><br /> 
            <span class="h1_book_title"><font size="6">我的购物车</font></span><br /><br />  
            <div class="content" style="background:#F5FFFA	">
          
           <table width="800" border="3">
		   <tr>
		   <th><font size="5">图书</font></th>
		   <th><font size="5">书名</font></th>
		   <th><font size="5">价格</font></th>
		   <th><font size="5">数量</font></th>
		   <th><font size="5">总价格</font></th>
		   <th colspan="3"><font size="5">操作</font></th>
		   <th></th><th></th><th></th>
		   </tr>
        	<c:forEach items="${selectByUser}" var="cart">
            <tr> 
            <td width="200"><img alt="图片" src="${ctx}/Images/${cart.book_img}" style="width:110px; height:150px"/></td>		
			<td width="150"><font size="5">${cart.book_name}</font></td>			
            <td width="75"><font size="5">${cart.book_price}</font></td>
            <td width="75"><font size="5">${cart.count}</font></td>
            <td width="100"><font size="5">${cart.book_price * cart.count}</font></td>
            <td width="50"><a href="${ctx}/cart/addNum?id=${cart.cart_detial_id}"><font size="5">[+]</font></a> </td>
            <td width="50"><a href="${ctx}/cart/downNum?id=${cart.cart_detial_id}&&count=${cart.count}"><font size="5">[-]</font></a> </td>
            <td width="100"><a href="${ctx}/cart/delete?id=${cart.cart_detial_id}"><font size="5">删除</font></a> </td>
            <td>
            <form action="${ctx}/order/add">
            <input type="hidden" name="count" value="${cart.count}"></input>
			<input type="hidden" name="book_img" value="${cart.book_img}"/>
			<input type="hidden" name="book_name" value="${cart.book_name}"/>
			<input type="hidden" name="book_price" value="${cart.book_price}"/>
			<input type="submit" value="购买" style="background:	#FF7F00" />
            </form>
            </td>
            </tr>
            </c:forEach>
            <tr>
            <td></td> <td></td> <td></td> <td></td> <td></td> <td></td><td></td>
            <td ><font size="6" color="red"><a href="${ctx}/cart/deleteAll">清空</a></font> </td>
		    </tr>
         </table>
        </div>
        </center>
      </div>
      </div>
            
           <div class="footer"style="background:#F8F8FF">
          <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">联系我们</a>
            <a class="a1" href="#">登陆</a>
            <a class="a2" href="#">登录</a>
            <span class="span_2"><b>设计源自</b><img src="${ctx }/Images/icon_hg.jpg"  /></span>
        </div>
    </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>