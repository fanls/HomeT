<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bese.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="inc/base.css" />
	<style type="text/css">
.global-top{
	height:3%;
	font-size: 18px;
	background: rgba(255, 255, 255, 0.4);
	text-transform: uppercase;
	z-index: 9999;
	position: relative;
	box-shadow: 1px 0px 2px rgba(0,0,0,0.2);
}
.global-top a{
	padding: 0px 10px;
	letter-spacing: 1px;
	color: #333;
	text-shadow: 0px 1px 1px #fff;
	display: block;
	float: left;
}
.global-top a:hover{
	background: #fff;
}
.global-top span.right{
	float: right;
}
.global-top span.right a{
	float: left;
	display: block;
}
.clr{
	clear: both;
}
	</style>
  </head>
  
  <body>
	<div class="global-top">
		<a href="">
            <strong>&laquo; Previous Demo: </strong>Responsive Content Navigator
        </a>
        <span class="right">
            <a href=" http://tympanus.net/codrops/2012/03/27/login-and-registration-form-with-html5-and-css3/">
               <strong>Back to the Codrops Article</strong>
            </a>
        </span>
       <div class="clr"></div>
	</div>
  </body>
</html>
