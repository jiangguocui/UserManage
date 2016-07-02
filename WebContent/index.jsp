<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息管理-登录</title>
<link href="<%=basePath%>css/register.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<!-- <script type="text/javascript">
	$(function(){
		$("#login").click(function(){
			var name=$("#username").val();
			var pwd=$("#password").val();
			if(name==""){
				$("#uname").html("*不能为空");
			}else if(pwd==""){
				$("#pwd").html("*不能为空");
			}else{
				$("#ologin").submit();
			}
		});
	});
</script> -->
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container container-fluid">
		<div class="navbar-header">
			<a href="javascript:;" class="navbar-brand" style="color:#35b558;font-size:14px;">信息管理系统</a>
		</div>
	</div>
	
	</nav>
	<div class="feg-header w-1000"></div>
	<!--feg-box-- -->
	<form id="myform" action="<%=basePath%>login" method="post" id="ologin">
	<div class="feg-box w-1000 cf" id="loginbox">
		<div class="feg-inputbox feg-tab">
			<div class="tabs">
				<ul>
					<li class="curr">信息管理登录</li>
					<!-- <li><a href="javascript：；">免注册登录</a> -->
					</li>
				</ul>
				<div style="margin-left:240px;"> <input type="radio" name="type" id="user" value="0"
					checked="" enabledclick="true"><span
					style="font-size: 14px;">普通用户</span>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
					name="type" id="user" value="1" enabledclick="true"><span
					style="font-size: 14px;">管理员</span>
				</div>
			</div>
			<div class="tabbed" style="margin-top:50px;">
				
					<input value="7" name="expire" id="expire" type="hidden"> <input
						name="referer" value="" type="hidden">
					<div class="feg-inputlist mar-t40">
						<div class="inputbox cf mar-b20">
							<span class="input-name">邮箱/用户名</span> <input name="uname"
								id="username" placeholder="邮箱/手机" class="input-one required"
								type="text"> <span class="warning" id="uname" style="color: red;"></span>
						</div>
						<div class="inputbox cf mar-b20 password">
							<span class="input-name">密码</span> <input name="password"
								class="input-one required" placeholder="密码" type="password" id="password">
							<!-- 	<span class="warning mar-r10"><a href="javascript:;">忘记密码</a> </span> -->
							<span class="warning" id=pwd style="color: red;"></span>
						</div>
						<button class="greenbtn" type="submit" id="login">登录</button>
						<span style="color: red; font-size: 14px;">${msg }</span>
					</div>
				
			</div>
		</div>

	</div>
	</form>
	<!--feg-box end-->
	<nav class="navbar navbar-default navbar-fixed-bottom"
		role="navigation">
	<div id="footer">
		<div style="text-align: center;" class="w-1000 copyright">
			<span> Copyright © 2015.7.22 jgc All Rights
				Reversed.QQ:1731805893@qq.com Tel:18202793832</span>
		</div>
	</div>
	</nav>
	<script type="text/javascript">
		var _Sjkxy = [];
		_Sjkxy['jPro'] = 'passport';
	</script>
</body>
</html>