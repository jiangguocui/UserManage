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
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<style>
.erro {
	color: red;
}
</style>
<script type="text/javascript">
        function delete1(){
            if(confirm("确定删除？"))
               return true;
               else 
               return false;
        }
        
        function tomodifyDegree(id){
        	$("#degreeId").attr("value",$("#ta1_"+id).text());
        	$("#name").attr("value",$("#ta2_"+id).text());
        }
    </script>
</head>
<body>
	<div class="widget">
		<div class="widget-head">
				<a href="javascript:;" data-target="#mymodal" data-toggle="modal">添加</button>
			<div class="widget-icons pull-right">
				<a href="#" class="wminimize"><i class="icon-chevron-up"></i></a> <a
					href="#" class="wclose"><i class="icon-remove"></i></a>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="widget-content">

			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th style="width: 10%;">#</th>
						<th style="width: 50%;">政治面貌</th>
						<th style="width: 20%;">操作</th>
					</tr>
				</thead>
				<tbody>
					<%int i=1; %>
					<c:forEach items="${politicals}" var="items">
						<tr>
							<td><%=i++ %></td>
							<td id="ta2_${items.id}">${items.name}</td>
							<td style="display:none;" id="ta1_${items.id}">${items.id}</td>
							<td><a data-target="#modifymodal" data-toggle="modal" href="javascript:;" onclick="tomodifyDegree(${items.id})">修改</a>
								&nbsp;&nbsp;|&nbsp;&nbsp; <a
								href="<%=basePath%>manager/deletePolitical${items.id}.html?record=${record}"
								onclick="return delete1()">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="widget-foot">

				<ul class="pagination pull-right">
					<li><a href="<%=basePath%>manager/tolistPolitical?record=1">首页</a></li>
					<c:if test="${allPage<=5&&allPage>0}">
						<c:forEach begin="1" end="${allPage}" step="1" var="page">
							<li><a href="<%=basePath%>manager/tolistPolitical?record=${page}"
								<c:if test="${record==page}">style="color:#5CB85C;"</c:if>>${page}</a></li>
						</c:forEach>
					</c:if>

					<c:if test="${allPage>5&&record<allPage-1}">

						<c:forEach begin="${record}" end="${record+2}" step="1" var="page">
							<li><a href="<%=basePath%>manager/tolistPolitical?record=${page}"
								<c:if test="${record==page}">style="color:#5CB85C;"</c:if>>${page}</a></li>
						</c:forEach>
					</c:if>
					<c:if test="${allPage>5&&record==allPage}">

						<c:forEach begin="${record-2}" end="${record}" step="1" var="page">
							<li><a href="<%=basePath%>manager/tolistPolitical?record=${page}"
								<c:if test="${record==page}">style="color:#5CB85C;"</c:if>>${page}</a></li>
						</c:forEach>
					</c:if>
					<c:if test="${allPage>5&&record==allPage-1}">

						<c:forEach begin="${record-1}" end="${record+1}" step="1"
							var="page">
							<li><a href="<%=basePath%>manager/tolistPolitical?record=${page}"
								<c:if test="${record==page}">style="color:#5CB85C;"</c:if>>${page}</a></li>
						</c:forEach>
					</c:if>

					<li><a href="<%=basePath%>manager/tolistPolitical?record=${allPage}">尾页</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>

		</div>
	</div>
	
	
	<!-- 添加对话框开始 -->
		<div class="modal" id="mymodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">添加政治面貌</h4>
					</div>
					<form action="<%=basePath%>manager/addPolitical" id="addPolitical">
					<div class="modal-body">政治面貌名称：<input name="name" type="text" id="poname">
					 <span class="erro" id="pname"></span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="psave">保存</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		
			<!-- 修改对话框开始 -->
		<div class="modal" id="modifymodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title">修改政治面貌</h4>
					</div>
					<form action="<%=basePath%>manager/modifyPolitical.html" id="modifyPolitical">
					<input type="hidden" name="id" id="degreeId">
					<input type="hidden" name="record"  value="${record}">
					<div class="modal-body">政治面貌名称：<input name="name" type="text" id="name">
					<span class="erro" id="mpname"></span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" id="msave">保存</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				$("#psave").click(function(){
					var poname=$("#poname").val();
					if(poname==""){
						$("#pname").html("*不能为空");
					}else{
						$("#addPolitical").submit();
					}
				});
				$("#msave").click(function(){
					var poname=$("#name").val();
					if(poname==""){
						$("#mpname").html("*不能为空");
					}else{
						$("#modifyPolitical").submit();
					}
				});
				
			});
		</script>
</body>
</html>