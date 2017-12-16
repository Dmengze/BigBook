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
<div class="w_100_l top_title"  style="background:#F0FFFF">
	<div class="main">
    	<p><a href="#">Buy more than one book and save big! </a><a href="#">Read more</a></p>
    </div>
</div>

<div class="w_100_l" style="background:#F0FFFF">
	<div class="main">
      <div class="top_banner">
            <div class="top_logo"><img src="${ctx }/Images/top_logo.jpg" alt="A BOOK APART LOGO" /></div>
            <div class="top_menu">
            	<ul>
                	<li ><a href="${ctx}/index.jsp">首页</a></li>
                	<li><a href="${ctx}/book/findAll">图书列表</a></li>
                	<li class="sel"><a href="#">图书分类</a></li>
                	<li><a href="${ctx}/order/selectByUser">我的订单</a></li>
                	<li><a href="${ctx}/user/selectById">我的信息</a></li>
                	<li><a href="${ctx}/login.jsp">登录</a></li>
                	<li><a href="${ctx}/user/toLogin">退出登录</a></li>
                </ul>
            </div>
            <div class="top_shop_cur"><a href="${ctx}/cart/login"><img src="${ctx}/Images/top_shop_cur.jpg" alt="shopping car" /></a></div>
        </div>
        
        <p class="index_hr"></p>
      <div class="content" style="background:#F8F8FF">
            <h1 class="h1_book_title">情感类图书</h1>

        	<ul>
        	<c:forEach items="${list1}" var="book">
        	<form action="${ctx}/cart/add">
            	<li>
                	<dl>
                    	<dd><a href="#"><img src="${ctx}/Images/${book.book_img}" alt="book" style="width:110px; height:150px"/></a></dd>
                        <dt>
                        	<p class="book_title"><a href="${ctx}/book/findById?id=${book.book_id}">${book.book_name}</a></p>
                            <p class="book_inline">${book.book_price}</p>
                            <input type="hidden" name="count" value="1"/>
			                <input type="hidden" name="book_img" value="${book.book_img}"/>
			                <input type="hidden" name="book_name" value="${book.book_name}"/>
			                <input type="hidden" name="book_price" value="${book.book_price}"/>
			                <input type="submit" value="BUY" style="background:#4EEE94" />
                           <!-- <a class="book_buy" href="book_detail1?id=${book.book_id} style="background:#ff7575" " >BUY</a> --> 
                        </dt>
                    </dl>
                </li>
                </form>
            	</c:forEach>
            </ul>
           </div>
           <div class="content" style="background:#F8F8FF">
            <h1 class="h1_book_title">励志类图书</h1>

            
        	<ul>
        	<c:forEach items="${list2}" var="book">
        	<form action="${ctx}/cart/add">
            	<li>
                	<dl>
                    	<dd><a href="#"><img src="${ctx}/Images/${book.book_img}" alt="book" style="width:110px; height:150px"/></a></dd>
                        <dt>
                        	<p class="book_title"><a href="${ctx}/book/findById?id=${book.book_id}">${book.book_name}</a></p>
                            <p class="book_inline">${book.book_price}</p>
                            <input type="hidden" name="count" value="1"/>
			                <input type="hidden" name="book_img" value="${book.book_img}"/>
			                <input type="hidden" name="book_name" value="${book.book_name}"/>
			                <input type="hidden" name="book_price" value="${book.book_price}"/>
			                <input type="submit" value="BUY" style="background:#4EEE94" />
                           <!--<a class="book_buy" href="book_detail1?id=${book.book_id} style="background:#ff7575" " >BUY</a> --> 
                        </dt>
                    </dl>
                </li>
                </form>
            	</c:forEach>
            </ul>
            </div>
            <div class="content" style="background:#F8F8FF">
            <h1 class="h1_book_title">科幻类图书</h1>


        	<ul>
        	<c:forEach items="${list3}" var="book">
        	<form action="${ctx}/cart/add">
            	<li>
                	<dl>
                    	<dd><a href="#"><img src="${ctx}/Images/${book.book_img}" alt="book" style="width:110px; height:150px"/></a></dd>
                        <dt>
                        	<p class="book_title"><a href="${ctx}/book/findById?id=${book.book_id}">${book.book_name}</a></p>
                            <p class="book_inline">${book.book_price}</p>
                            <input type="hidden" name="count" value="1"/>
			                <input type="hidden" name="book_img" value="${book.book_img}"/>
			                <input type="hidden" name="book_name" value="${book.book_name}"/>
			                <input type="hidden" name="book_price" value="${book.book_price}"/>
			                <input type="submit" value="BUY" style="background:#4EEE94" />
                           <!--  <a class="book_buy" href="${ctx}/book/findById?id=${book.book_id} style="background:#ff7575" " >BUY</a> --> 
                        </dt>
                    </dl>
                </li>
                </form>
            	</c:forEach>
            </ul>

            </div>
            <div class="content" style="background:#F8F8FF">
            <h1 class="h1_book_title">教材</h1>
        	<ul>
        	<c:forEach items="${list4}" var="book">
        	<form action="${ctx}/cart/add">
            	<li>
                	<dl>
                    	<dd><a href="#"><img src="${ctx}/Images/${book.book_img}" alt="book" style="width:110px; height:150px"/></a></dd>
                        <dt>
                        	<p class="book_title"><a href="${ctx}/book/findById?id=${book.book_id}">${book.book_name}</a></p>
                            <p class="book_inline">${book.book_price}</p>
                            <input type="hidden" name="count" value="1"/>
			                <input type="hidden" name="book_img" value="${book.book_img}"/>
			                <input type="hidden" name="book_name" value="${book.book_name}"/>
			                <input type="hidden" name="book_price" value="${book.book_price}"/>
			                <input type="submit" value="BUY" style="background:#4EEE94" />
                           <!-- <a class="book_buy" href="book_detail1?id=${book.book_id} style="background:#ff7575" " >BUY</a> --> 
                        </dt>
                    </dl>
                </li>
                </form>
            	</c:forEach>
            </ul>
      </div>
        <p class="index_hr"></p>
        <h1 class="news_title">读者来信</h1>
        <p class="news_title_1"><span class="span_1">欢迎您投稿，我们期待着您的到来</span><span class="span_2"><img src="${ctx}/Images/img_inp.jpg" /></span></p>
        <p class="index_hr" style="margin-top:20px;"></p>
        <div class="footer">
          <span class="span_1">&copy; Copyright 2014, A Book Apart, LLC</span>&nbsp;&nbsp;
            <a href="#">联系我们</a>
            <a class="a1" href="#">登陆</a>
            <a class="a2" href="#">登录</a>
            <span class="span_2"><b>设计源自</b><img src="${ctx}/Images/icon_hg.jpg" align="absmiddle" /></span>
        </div>
    </div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>