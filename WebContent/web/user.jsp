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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/user.css">
<title>Insert title here</title>
</head>
<body>
	<div class="userinfo">
		<table>
			<tbody>
				<tr>
					<td><span>姓名：</span> <span>${tuser.userName }</span></td>
					<td><span>生日：</span><span>${tuser.userBirthday }</span></td>
				</tr>
				<tr>
					<td><span>性别：</span> <span>${tuser.userGender }</span></td>
					<td><span>政治面貌：</span><span>${tuser.political.name }</span></td>
				</tr>
				<tr>
					<td><span>学历：</span> <span>${tuser.degree.name }</span></td>
					<td><span>学校：</span><span>${tuser.userSchool}</span></td>
				</tr>
				<tr>
					<td><span>电话：</span> <span>${tuser.userPhone }</span></td>
					<td><span>邮箱：</span><span>${tuser.userEmail }</span></td>
				</tr>
					<td><span>工作：</span> <span>${tuser.job }</span></td>
					<td><span>公司：</span><span>${tuser.company }</span></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>