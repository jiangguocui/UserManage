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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/user.css">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#modifyu").click(function(){
				var  rephone=/^(13|15|18)\d{9}$/;
				var remail= /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				var phone=$("#userPhone").val();
				var email=$("#userEmail").val();
				if(phone==""){
					$("#phone").html("*电话不能为空");
				}else if(!rephone.test(phone)){
					$("#phone").html("*电话格式不对");
				}
				else if(email==""){
					$("#email").html("*邮箱不能为空");
				}else if(!remail.test(email)){
					$("#email").html("*邮箱格式不对");
				}
				else{
					$("#modifyinfo").submit();
				}
			});
		})
	</script>
</head>
<body>
	<div class="userinfo">
		<form action="<%=basePath%>modifyinfo${tuser.id}.do" id="modifyinfo">
		<table>
			<tbody>
				<tr>
					<td><span>姓名：</span> <span>${tuser.userName }</span></td>
					<td><span>生日：</span><span>${tuser.userBirthday }</span></td>
				</tr>
				<tr>
					<td><span>性别：</span> <span>${tuser.userGender }</span></td>
					<td><span>政治面貌：</span><span>
					<select name="politicals" id="politicals">
					<c:forEach items="${politicals }" var="item">
					<option value="${item.id }" <c:if test="${tuser.political.id==item.id }">selected</c:if>>${item.name}</option>
					</c:forEach>
				
				</select>
					</span></td>
				</tr>
				<tr>
					<td><span>学历：</span> <span>
					<select name="degrees" id="degrees">
					<c:forEach items="${degrees }" var="item">
					<option value="${item.id }" <c:if test="${tuser.degree.id==item.id }">selected</c:if>>${item.name}</option>
					</c:forEach>
				
				</select></span></td>
					<td><span>学校：</span><span><input type="text" name="userSchool"  value="${tuser.userSchool}"></span>
					<span class="erro" id="school"></span></td>
				</tr>
				<tr>
					<td><span>电话：</span> <span><input type="text" name="userPhone" id="userPhone" value="${tuser.userPhone }"></span>
					<span class="erro" id="phone"></span>
					</td>
					<td><span>邮箱：</span><span><input type="text" name="userEmail" id="userEmail" value="${tuser.userEmail }"></span>
					<span class="erro" id="email"></span>
					</td>
				</tr>
					<td><span>工作：</span> <span><input type="text" name="job" value="${tuser.job }"></span>
					<span class="erro" id="job"></span>
					</td>
					<td><span>公司：</span><span><input type="text" name="company" value="${tuser.company }"></span>
					<span class="erro" id="company"></span>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><button class="btn" type="button" contenteditable="true" id="modifyu">修改</button><span style="color:red;">${msg }</span></td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</body>
</html>