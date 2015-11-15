<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户登录</title>
		<!--<link rel="stylesheet" href="inc/base.css" />  -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/store/jquery.js"></script>
<style type="text/css">
body{
background: #DBD78A;
overflow-y: scroll;
}
div#box{
background: #fff url(${pageContext.request.contextPath}/images/bg.jpg) repeat top left;
padding:30px 0px 10px 0px;
width:450px;
height:250px;
border-radius:4%;
box-shadow: 3px 3px 5px #888888;
}
input{
margin: 2% 2% 2% 2% ;
}
input[type="text"],input[type="password"]{
width:50%;
height:13%;
border-radius:8%;
}
#insert{
background: #fff url(${pageContext.request.contextPath}/images/face.gif);
clear:both;
margin: 7% 0 3% 0;
width:100px;
height:100px;
border-radius:50%;
}
.footer {
clear:both;
text-align:center;
width:100%;
height:2%;
position: absolute;
bottom:0px;
z-index: 2;
}
#tokown{
line-height:100px;
text-align:center;
}
</style>
<script type="text/javascript">
$(document).ready(function(){ 
	$("#insert").mouseover(function(){
		$(this).fadeTo(0,0.7,function(){
			$("#tokown").html("<b>了解本站</b>");
			$("#tokown").show();
		});
	});
	$("#insert").mouseout(function(){
		$(this).fadeTo(0,1,function(){
			$("#tokown").hide();
		});
	});
}); 
function toshow(){
	location.href = "${pageContext.request.contextPath}/user/queryByUid_Resume";
}
</script>
</head>
<body>
	<div id="container">
		<center>
		<div id="insert" onclick="toshow()"><span id="tokown"></span></div>
		<div id="box">
			<form action="${pageContext.request.contextPath}/user/login" method="post">
				<label><input type="radio" name="usertype" value=0 /> 用户</label>
				<label><input type="radio" name="usertype" value=1 /> 管理员</label><br>
				<label>用户名：<input type="text" name="username"/></label><br>
				<label>密&nbsp码：<input type="password" name="password"/></label><br>
				<label><input type="checkbox"name="remember"/>记住密码&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label><br>
				<input type="submit" value="提交"></input>
				<a href=${pageContext.request.contextPath}/save.jsp >注册</a>
			</form>			
		</div>
		</center>
	</div>
	<div class="footer">Copyright W3School.com.cn</div>
	</body>
</html>
