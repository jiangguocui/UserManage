<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/user.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/bootstrap-datetimepicker.min.js"></script>
</head>
<body>
	<div class="userinfo">
		<form action="<%=basePath%>manager/addinfo${tuser.id}" id="addinfo">
			<table>
				<tbody>
					<tr>
						<td><span>姓名：</span> <span><input type="text"
								name="userName" value="" id="userName"></span> <span
							class="erro" id="name"></span></td>
						<td><span >生日：</span>
									<input class="form-control input-group date form_date col-md-5" type="text" value="" 
										readonly name="userBirthday" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
									data-link-format="yyyy-mm-dd" 
									 style="background-color: white;width:200px;margin-left:40px;margin-top:-45px;" >
						</td>
					</tr>
					<tr>
						<td><span>性别：</span> <span> <select name="userGender"
								id="userGender">
									<option value="男">男</option>
									<option value="女">女</option>
							</select>
						</span></td>
						<td><span>政治面貌：</span><span> <select name="politicals"
								id="politicals">
									<c:forEach items="${politicals }" var="item">
										<option value="${item.id }">${item.name}</option>
									</c:forEach>

							</select>
						</span></td>
					</tr>
					<tr>
						<td><span>学历：</span> <span> <select name="degrees"
								id="degrees">
									<c:forEach items="${degrees }" var="item">
										<option value="${item.id }">${item.name}</option>
									</c:forEach>

							</select></span></td>
						<td><span>学校：</span><span><input type="text"
								name="userSchool" value="" id="userSchool"></span></td>
					</tr>
					<tr>
						<td><span>电话：</span> <span><input type="text"
								name="userPhone" value="" id="userPhone"></span> <span
							class="erro" id="phone"></span></td>
						<td><span>邮箱：</span><span><input type="text"
								name="userEmail" value="" id="userEmail"></span> <span
							class="erro" id="email"></span></td>
					</tr>
					<td><span>工作：</span> <span><input type="text"
							name="job" value=""></span></td>
					<td><span>公司：</span><span><input type="text"
							name="company" value=""></span></td>
					</tr>
					<tr>
						<td></td>
						<td><button class="btn" type="button" contenteditable="true"
								id="addi">添加</button> <span style="color: red;">${msg }</span></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#addi")
					.click(
							function() {
								var rephone = /^(13|15|18)\d{9}$/;
								var remail = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
								var userName = $("#userName").val();
								var phone = $("#userPhone").val();
								var email = $("#userEmail").val();
								if (userName == "") {
									$("#name").html("*姓名不能为空");
								} else if (phone == "") {
									$("#phone").html("*电话不能为空");
								} else if (!rephone.test(phone)) {
									$("#phone").html("*电话格式不对");
								} else if (email == "") {
									$("#email").html("*邮箱不能为空");
								} else if (!remail.test(email)) {
									$("#email").html("*邮箱格式不对");
								} else {
									$("#addinfo").submit();
								}
							});
		})
		$('.form_date').datetimepicker({
			language : 'zh-CN',/*加载日历语言包，可自定义*/
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
	</script>
</body>
</html>