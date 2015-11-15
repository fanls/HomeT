<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="ck" uri="http://ckeditor.com"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'write_blog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="fckeditor/fckeditor.js"></script>
  </head>  
  <body>
  <div>
	<form action="${pageContext.request.contextPath}/user/addBlog" method="post">
  		<label>用户id<input type="text" name="blog.uid"/> 用户</label>
		<label>博文id<input type="text" name="blog.bid"/> 管理员</label>
		<label>标&nbsp题<input type="text" name="blog.title"/></label>
		<label>内&nbsp容<input type="text" name="blog.article"/></label>
		<label>标&nbsp签<input type="text" name="blog.label"/></label><br>
		<textarea rows="10" cols="10" id="my_txt"name="blog.blog"></textarea>  
   		<ck:replace replace="my_txt" basePath="ckeditor"></ck:replace> 
		<input type="submit" value="保存"></input>
  	</form>
  </div>
  </body>
</html>
