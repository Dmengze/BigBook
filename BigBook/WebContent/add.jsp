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
<link type="text/css" rel="stylesheet" media="screen and (max-width:480px)" href="${ctx }/Css/tel.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
 <script type="text/javascript">
	$(document).ready(function(){
		//检测密码
		$('input[name="password"]').blur(function(){
			$(this).nextAll().html("");
			if(this.value=="" || this.value.length < 6){
				$(this).parent().append('<font color="red" size="2">&nbsp;&nbsp;密码长度不能小于6</font>');
			}else{
				$(this).nextAll().html("");
			}
		})
		//检测确认密码
		$('input[name="repswd"]').blur(function(){
			$(this).nextAll().html("");
			if($(this).val() != $('input[name="password"]').get(0).value){
				$(this).parent().append('<font color="red" size="2">&nbsp;&nbsp;两次输入的密码必须一致</font>');
			}else{
				$(this).nextAll().html("");
			}
		});
		//判断邮箱格式是否正确
		$('input[name="email"]').blur(function(){
			$(this).nextAll().html("");
			var str = $('input[name="email"]').get(0).value;
			var reg =/^\w+((-\w+)|(\.\w+))*\@{1}\w+\.{1}\w{2,4}(\.{0,1}\w{2}){0,1}/ig;
			if(reg.test(str)){
				$(this).parent().append('<font color="green" size="2">&nbsp;&nbsp;邮箱格式正确 </font>');
				
			}else{
				$(this).parent().append('<font color="red" size="2">&nbsp;&nbsp;邮箱格式不正确  </font>');
				
			}
		});
		

	})
		//检测用户名
		window.onload=function()
    {

		$('input[name="name"]').blur(function(){
			$(this).nextAll().html("");
			if($(this).val() == ''){
				$(this).parent().append('<font color="red" size="2">&nbsp;&nbsp;用户名不能为空</font>');
			}else{
				 var req=getXMLHttpRequest();
				 req.onreadystatechange=function(){
			          if(req.readyState==4){//XMLHttpRequest对象读取成功
			            if(req.status==200){//服务器相应正常
			            	//var msg=document.getElementById("msg");
			              //根据返回的结果显示不同的信息
			              if(req.responseText=="true"){   
			            	  $('input[name="name"]').parent().append('<font color="red" size="2">&nbsp;&nbsp;用户名存在 </font>');
			              }else{
			            	  $('input[name="name"]').parent().append('<font color="green " size="2">&nbsp;&nbsp;可以使用</font>');
			              }
			            }
			          }
				
				 }
			
				 //2.建立一个连接
			      req.open("get","${pageContext.request.contextPath}/user/judge?name="+$(this).val());
			     //3.发送get请求
			      req.send(null);
			 }	
    })
    }	
		function getXMLHttpRequest(){
		    var xmlhttp;
		        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		            xmlhttp = new XMLHttpRequest();
		        } else {// code for IE6, IE5
		            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		        }
		        return xmlhttp;
		}
		
	
</script>
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
                	<li><a href="#">我的订单</a></li>
                	<li><a href="${ctx}/user/selectById">我的信息</a></li>
                	<li><a href="${ctx}/login.jsp">登录</a></li>
                	<li><a href="${ctx}/user/toLogin">退出登录</a></li>
                </ul>
            </div>
      <div class="content"><br /><center>
            <span class="h1_book_title"><font size="6">用户注册</font></span><br /><br />
            </center>
            <div style=" padding-left:40%">
            <form action="${ctx}/user/add" >
            <table>
        	<tr>
        	<td><font size="5">用户名:</font></td>
        	<td><input type="text" name="name"/></td>
        	</tr>
        	 <tr><td  height="10"></td></tr>
        	<tr>
        	<td><font size="5">密码:</font></td>
        	<td><input type="password" name="password"/></td>
        	</tr>
        	 <tr><td  height="10"></td></tr>
        	<tr>
        	<td><font size="5">确认密码：</font></td>
        	<td><input type="password" name="repswd"/></td>
        	</tr>
        	 <tr><td  height="10"></td></tr>
        	<tr>
        	<td><font size="5">emai:</font></td>
        	<td><input type="text" name="email"/></td>
        	</tr>
        	<tr ><td height="10"></td></tr>
        	<tr>
        	<td><font size="5">电话:</font></td>
        	<td><input type="text" name="telephone"/></td>
        	</tr>
        	<tr ><td height="10"></td></tr>
        	<tr>
        	<td><font size="5">地址:</font></td>
        	<td><input type="text" name="address"/></td>
        	</tr>
        	<tr><td  height="20s"></td></tr>
        	<tr>
        	<td colspan="2" style="padding-left:100px;"> <input type="submit" value="注册" style="font-family:'Tahoma';border:3px;
vertical-align:middle;margin:8px;line-height:40px;font-size:29px"/></td>
        	</tr>
			
			</table>
			</form></div>
			<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
			<br /><br /><br /><br />
			
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

</body>
</html>