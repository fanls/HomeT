<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <link href="${pageContext.request.contextPath}/inc/whole.css" rel="stylesheet" type="text/css"> 
</head>  
 <body>
  	<div class="hero-unit">
		<h1>
			<a href="${pageContext.request.contextPath}/user/showUserNote?uid=${user.uid}">${user.name}的${user.password}日记</a>
		</h1>
		<p>
			这是一个可视化布局模板, 你可以点击模板里的文字进行修改, 也可以通过点击弹出的编辑框进行富文本修改. 拖动区块能实现排序.
		</p>
		<div class="clear"><hr size="1" /></div>
			<div class="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/user/showOwnNote"title="">个人中心</a></li>
					<li><a href="${pageContext.request.contextPath}/user/showGroupNote"title="">好友动态</a></li>
					<li><a href="${pageContext.request.contextPath}/user/writeNote"title="">写日记</a></li>
					<li><a href=""title="">关于我们</a></li>
				</ul>
			</div>
		<div class="clear"><hr size="1" /></div>
	</div>
</body>
</html>
