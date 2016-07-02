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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息管理-欢迎${ loginUser.userName }来到个人信息页面</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.min.css">
<link href="<%=basePath%>css/register.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/welcome.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<style>
a:hover{
	text-decoration:none;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container container-fluid">
		<div class="navbar-header">
			<a href="javascript:;" class="navbar-brand"
				style="color: #35b558; font-size: 14px;">信息管理系统</a>
		</div>
	</div>
	</nav>
	<!-- 中间部分 -->
	<div class="feg-box w-1000 cf" id="loginbox" style="margin-top: 80px;">
		<div class="w-1000 mar-t30 cf ucenter-block">
			<div class="ucenter-left account-left-border">
				<div class="ucneter-l-head cf">
					<div class="ulhead-headicon">
						<%-- <img src="${ loginUser.userPicture}" id="avatar_img" width="50px"
							height="50px" onerror="images/1.jpg" alt=""> --%>
					</div>
					<div class="ulhead-info">
						<p class="ulhead-info-uname">欢迎${loginUser.userName }</p>
						<!-- 姓名 -->
						<p class="ulhead-info-vip">
							<i class="icon icon-vip-lost"></i>
						</p>
						<div class="ulhead-info-tool" style="margin-top: 10px;">
							<i><a href="<%=basePath%>logout.do">注销</a></i>
						</div>
					</div>
				</div>
				<div class="ucenter-l-list">
					<ul class="ullist-ul">
						<li class="active" id="index_menu_1"><a
							onclick="loadBodyFrame(1,'<%=basePath %>web/toUserInfo${loginUser.id}.do?t=0')">个人中心</a>
						</li>
						<li class="" id="index_menu_2"><a
							onclick="loadBodyFrame(2,'<%=basePath %>web/toUserInfo${loginUser.id}.do?t=1')">修改信息</a></li>
						<li class="" id="index_menu_3"><a
							onclick="loadBodyFrame(3,'<%=basePath %>web/modifypassword.jsp')">修改密码</a></li>
					</ul>
				</div>
			</div>
			<div class="ucenter-right cf">
				<iframe onload="this.height=100" id="iframepage"
					class="main_content shadow"
					src="<%=basePath %>web/toUserInfo${loginUser.id}.do?t=0" scrolling="no"
					frameborder="0" width="100%" height="100%"> </iframe>

			</div>
		</div>


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
			    function reinitIframe(){
			    var iframe = document.getElementById("iframepage");
			    try{
			    var bHeight = iframe.contentWindow.document.body.scrollHeight;
			    var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
			    var height = Math.max(bHeight, dHeight);
			    iframe.height =  height;
			    }catch (ex){}
			    }
			    window.setInterval("reinitIframe()", 200);
			    function loadBodyFrame(i,url) {
			    	for (var n=1; n<=3; n++) {
						$('#index_menu_'+n).removeAttr("class", "active");
					//	$('#index_menu_'+n).attr("class", "memuBT");
					}
					$('#index_menu_'+i).attr("class", "active");
					$('#iframepage').get(0).src=url;
				}
		    </script>
</body>
</html>