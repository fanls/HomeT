<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>写简历</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/user/add_Resume" method="post">
  		<label>用户id<input type="text" name="resume.uid"/></label><br>
		<label>姓&nbsp&nbsp名<input type="text" name="resume.name"/></label><br>
		<label>电&nbsp&nbsp话<input type="text" name="resume.phone"/></label><br>
		<label>邮&nbsp&nbsp件<input type="text" name="resume.email"/></label><br>
		<label>概&nbsp&nbsp要<input type="text" name="resume.general"/></label><br>
		<label>项目经验<textarea name="resume.program"></textarea></label><br>
		<label>经验总结<textarea name="resume.sumPro"></textarea></label><br>
		<label>在校情况<textarea name="resume.inSchool"></textarea></label><br>
		<label>教育背景<textarea name="resume.edu"></textarea></label><br>
		<label>创建时间<textarea name="resume.createDate"></textarea></label><br>
		<label>其&nbsp&nbsp他<textarea name="resume.others"></textarea></label><br>
		<input type="submit" value="保存"></input>
  	</form>
  </body>
</html>
