<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
.header {
	width:100%;
	height: 15%;
	z-index: 1;
	position: absolute;
	background:#808040;
}
.header ul{
	text-align: center;
}
.header li{
	display: inline-block;
	margin:0% 3%;
	font-size: 20px;
}
.current{
	width:60%;
	height:45%;
	background:#fff;
	margin:0% 20% 0px 20%;
	z-index: 9999;
	position: absolute;
	float:left;
}
p{
	padding:2px 1px 0px 1px;
}</style>
  </head>  
  <body>
  	<div class="header">
  	<div>
  	<ul>
  		<li>广场</li>
  		<li>主页</li>
  		<li>好友</li>
  		<li>留言</li>
  	</ul>
  	</div>
  	<div class="current">
		<p>当前时间：2015-10-23 22:28:49星期五</p>
	</div>
  	</div>
  </body>
</html>
