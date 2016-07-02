<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<style type="text/css">
		table{
			width:0px;
		}
	</style>
<script type="text/javascript">
	$(function(){
		$("#pwd").click(function(){
			var newpwd=$("#newPassword").val();
			var confirmPassword=$("#confirmPassword").val();
			if(newpwd==""){
				$("#newpwd").html("*不能为空");
			}else if(confirmPassword==""){
				$("#confirmpwd").html("*不能为空");
			}else if(confirmPassword!=newpwd){
				$("#confirmpwd").html("*两次密码不一样");
			}else{
				$("#mpwd").submit();
			}
		});
		
	});
</script>
</head>
<body>
	<div class="userinfo">
		<form action="<%=basePath%>web/modifypassword${loginUser.id}.do" id="mpwd">
		<table>
			<tbody>
				<tr>
					<td><span>原密码：</span></td><td><span><input type="text" name="oldPassword" value=""></span></td>
				</tr>
				<tr>
					<td><span>新密码：</span> </td><td><span><input type="text" name="newPassword" value="" id="newPassword"></span>
					<span class="erro" id="newpwd"></span>
					</td>
				</td>
				</tr>
					<td><span>确认密码：</span></td> <td><span><input type="text" name="confirmPassword" value="" id="confirmPassword">
					</span>
					<span class="erro" id=confirmpwd></span>
					</td>
				<tr>
				<tr>
				<td></td>
					<td><button class="btn" type="button" contenteditable="true" id="pwd">修改</button><span style="color:red;">${msg }</span></td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</body>
</html>