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
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Css/reset.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Css/1024_768.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:861px) and (max-width:960px)" href="${pageContext.request.contextPath}/Css/pad_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:601px) and (max-width:860px)" href="${pageContext.request.contextPath}/Css/pad.css" />
<link type="text/css" rel="stylesheet" media="screen and (min-width:481px) and (max-width:600px)" href="${pageContext.request.contextPath}/Css/tel_heng.css" />
<link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="Css/tel.css" />
</head>

<body>
<div class="w_100_l top_title" style="background:#F0FFFF">
	<div class="main">
    	<p><a href="#">买优质好图书 </a><a href="#">更多内容</a></p>
    </div>
</div>

<div class="w_100_l" style="background:#F0FFFF" >
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
            <div class="top_shop_cur"><a href="${ctx}/cart/login"><img src="${ctx}/Images/top_shop_cur.jpg" alt="shopping car" /></a></div>
        </div>
        <span class="index_img"><img src="${ctx}/Images/banner7.jpg" alt="Dan Cederholm" border="0" usemap="#Map" />
        <map name="Map" id="Map">
          <area shape="rect" coords="857,230,930,269" href="#" alt="buy now" />
        </map>
        </span>
        <p class="index_hr"></p>
      <div class="content" style="background:#F0FFFF">
            <center><h1 class="h1_book_title"><span><font size="6">欢迎您来到我们的书屋</font></span></h1></center>
            <br/>
            <br/>
      </div>
        <p class="index_hr"></p>
        <div class="content_press">
        	<div class="press_porsen_01">
                <h1>读者反馈</h1>
            	<dl>
                	<dd><img src="${ctx}/Images/img_men.jpg" alt="person" /></dd>
                    <dt>
                    	<p class="date">2014年4月3日</p>
                        <p class="book_title"><a href="#" target="_blank">Design Is a Job</a></p>
                        <p class="book_intro">
                           我们都被这本书所吸引，<a href="#">《Design Is a Job》</a> 的作者 <a href="#">Audible.com</a> 和 <a href="#">Amazon.com</a>.根据他们自身的经验来告诉大家如何面对这些问题，以及如何解决，总之帮助很大
                        </p>
                    </dt>
                </dl>
            </div>
            <div class="press_porsen_02">
                <h1><span class="span_2"><a href="#">更多点评 →</a></span><span class="span_1"><a href="#">请查看</a></span></h1>
            	<dl>
                	<dd><img src="${ctx}/Images/img_lives.jpg" alt="book img" /></dd>
                    <dt>
                    	<p class="date">2014年5月23日</p>
                        <p class="book_title"><a href="#" target="_blank">A Few of Our Faves: March 31st</a></p>
                        <p class="book_intro">
                                                                                     通过读这本书，我们果真是收益匪浅啊，<a href="#">《Read for more》.</a> 这本书告诉我们读书的重要性，开拓眼见，充实自己！                       </p>
                         </p>
                    </dt>
                </dl>
            </div>
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