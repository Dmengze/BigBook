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
      <div class="content" style="background:#F8F8FF"><center>
        <span class="h1_book_title"><font size="6">添加图书</font></span><br /><br />
          <form action="${ctx}/book/add" >
          <table>
          <tr>
          <td><font size="5">书名</font></td>
          <td><input type="text" name="name"/></td>
          </tr>
          <tr><td  height="10"></td></tr>
          <tr>
          <td><font size="5">作者</font></td>
          <td><input type="text" name="auth"/></td>
          </tr>
          <tr><td  height="10"></td></tr>
          <tr>
          <td> <font size="5">出版日期</font></td>
          <td><input type="text" name="publish_data"/></td>
          </tr>
          <tr><td  height="10"></td></tr>
          <tr>
          <td><font size="5">出版社</font></td>
          <td><input type="text" name="publisher"/></td>
          </tr>
          <tr><td  height="10"></td></tr>
          <tr>
          <td><font size="5">价格</font></td>
          <td><input type="text" name="price"/></td>
          </tr>
          <tr><td  height="10"></td></tr>
          <tr>
          <td><font size="5">图片</font></td>
          <td><input type="file" name="img"/></td>
          </tr>
          <tr><td  height="10"></td></tr>
          <tr>
          <td><font size="5">类型</font></td>
          <td><select name="bookType"> 
                 <option value="1">情感</option> 
                 <option value="2">励志</option> 
                 <option value="3">科幻</option> 
                 <option value="4">教材</option> 
             </select></td>
          </tr>
          <tr><td  height="10"></td></tr>
          <tr>
          <td  colspan="2" style="padding-left:200px;"> <input type="submit" value="提交" style="font-family:'Tahoma';border:3px;
vertical-align:middle;margin:8px;line-height:18px;font-size:18px; background:#CDAA7D"></td>
          </tr>
        </table>
       </form></center>
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