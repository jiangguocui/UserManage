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
	href="<%=basePath%>css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
<script type="text/javascript"
	src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
        function delete1(){
            if(confirm("确定删除？"))
               return true;
               else 
               return false;
        }
    </script>
</head>
<body>
	<div class="widget">
		<div class="widget-head">
			<div class="pull-left">
				<a href="<%=basePath%>manager/toAdduserInfo">添加</a>
			</div>
			<div class="widget-icons pull-right">
				<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a> <a
					href="#" class="wclose"><i class="icon-remove"></i></a>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="widget-content">

			<table class="table table-striped table-bordered 
		table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 5%;">#</th>
						<th style="width: 7%;">姓名</th>
						<th style="width: 12%;">性别</th>
						<th style="width: 12%;">政治面貌</th>
						<th style="width: 12%;">学历</th>
						<th style="width: 12%;">工作</th>
						<th style="width: 20%;">公司</th>
						<th style="width: 20%;">操作</th>
					</tr>
				</thead>
				<tbody>
					<%int i=1; %>
					<c:forEach items="${tusers}" var="items">
						<tr>
							<td><%=i++ %></td>
							<td>${items.userName}</td>
							<td>${items.userGender }</td>
							<td>${items.political.name}</td>
							<td>${items.degree.name}</td>
							<td>${items.job}</td>
							<td>${items.company}</td>
							<td><a href="<%=basePath%>manager/toUserinfoBy${items.id}">修改</a>
								&nbsp;&nbsp;|&nbsp;&nbsp; <a
								href="<%=basePath%>manager/deleteUser${items.id}.html?record=${record}"
								onclick="return delete1()">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="widget-foot">

				<ul class="pagination pull-right">
					<li><a href="<%=basePath%>manager/tolistUser?record=1">首页</a></li>
					<c:if test="${allPage<=5&&allPage>0}">
						<c:forEach begin="1" end="${allPage}" step="1" var="page">
							<li><a href="<%=basePath%>manager/tolistUser?record=${page}"
								<c:if test="${record==page}">style="color:#5CB85C;"</c:if>>${page}</a></li>
						</c:forEach>
					</c:if>

					<c:if test="${allPage>5&&record<allPage-1}">

						<c:forEach begin="${record}" end="${record+2}" step="1" var="page">
							<li><a href="<%=basePath%>manager/tolistUser?record=${page}"
								<c:if test="${record==page}">style="color:#5CB85C;"</c:if>>${page}</a></li>
						</c:forEach>
					</c:if>
					<c:if test="${allPage>5&&record==allPage}">

						<c:forEach begin="${record-2}" end="${record}" step="1" var="page">
							<li><a href="<%=basePath%>manager/tolistUser?record=${page}"
								<c:if test="${record==page}">style="color:#5CB85C;"</c:if>>${page}</a></li>
						</c:forEach>
					</c:if>
					<c:if test="${allPage>5&&record==allPage-1}">

						<c:forEach begin="${record-1}" end="${record+1}" step="1"
							var="page">
							<li><a href="<%=basePath%>manager/tolistUser?record=${page}"
								<c:if test="${record==page}">style="color:#5CB85C;"</c:if>>${page}</a></li>
						</c:forEach>
					</c:if>

					<li><a href="<%=basePath%>manager/tolistUser?record=${allPage}">尾页</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>

		</div>
	</div>
</body>
</html>