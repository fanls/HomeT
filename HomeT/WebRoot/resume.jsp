<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>简历</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
 *{margin:0px;padding:0px;}
#resume{
width:1366px;
background: #FCF3C5;
position: relative;
top:0px;
left:0px;
}
#header{
width:100%;
background: #fff;
height:160px;
}
#photo{
background: #fff url(${pageContext.request.contextPath}/images/photo.png);
width:140px;
height:140px;
border-radius:50%;
border: 10px solid #35A6D0;
z-index:2;
position: absolute;
margin: 0 0 0 6%;
float:left;
}
#baseMessage{
background:#35A6D0;
height:126px;
width:88%;
position: absolute;
margin: 0 0 0 12%;
z-index:1;
float:left;
}
#message{
position: absolute;
line-height:30px;
font-size:25px;
color:#fff;
margin: 2% 0 0 30%;
}
#split{
height:5px;
width:100%;
background:#E2DAA7;
}
#navigation{
background:#EAFA8F;
height:34px;
width:88%;
position: absolute;
margin: 126px 0 0 12%;
z-index:1;
float:left;
}
.line{
height:34px;
width:16%;
margin: 0 1px 0 0;
line-height:34px;
font-size:26px;
text-align: center;
color:#fff;
background:#202117;
float:left;
}
#black{
height:34px;
width:3.5%;
background:#202117;
float:left;
}
#catalog{
background:#35A6D0;
height:200px;
width:32%;
position: absolute;
margin: 110px 0 0 0;
z-index:1;
float:left;
line-height:200px;
font-size:50px;
text-align:center;
color:#fff;
}
#di{
background:#070E08;
height:340px;
width:2px;
position: absolute;
margin: 40px 0 0 35%;
z-index:1;
float:left;
}
#data{
position: absolute;
margin: 60px 0 0 40%;
z-index:1;
float:left;
line-height:30px;
font-size:30px;
}
.footer {
background:#070E08;
clear:both;
text-align:center;
width:100%;
height:22px;
position: absolute;
bottom:0px;
z-index: 9999;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/store/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//	var val = "${request.rs.phone}";
//	alert(val);
	$("#data").html("这是一个很屌很屌的程序");
});
function show(detilType){
	var url="${pageContext.request.contextPath}/user/resumeDetail_Resume?detilType="+detilType;
	$.ajax({
	type:"get",
 	dataType:"html",
 	url:url,
 	success:function showResponse(response, status) {
 		if (status == "success") {
				$("#data").html(response);
		}
 	}
	});
}
</script>
  </head>
  <body>
    <div id="resume">
    	<div id="header">
    		<div id="photo"></div>
    		<div id="baseMessage">
    			<dl id="message">
					<dt>${request.rs.name}</dt>
						<dd>电话：${request.rs.phone}</dd>
						<dd>邮箱：${request.rs.email}</dd>
				</dl>
    		</div>
    		<div id="navigation">
    			<div id="black"></div>
    			<div class="line" onclick="show(0)">概要</div>
  				<div class="line" onclick="show(1)">教育背景</div>
  				<div class="line" onclick="show(2)">项目经验</div>
  				<div class="line" onclick="show(3)">经验总结</div>
  				<div class="line" onclick="show(4)">在校情况</div>
  				<div class="line" onclick="show(5)">其他</div>
    		</div>
    	</div>
    	<div id="split"></div>
    	<div id="content">
    		<div id="catalog">
    			详细信息
    		</div>
    		<div id="di"></div>
    		<div id="data">
    		</div>
    	</div>
    </div>
    <div class="footer">Copyright W3School.com.cn</div>
  </body>
</html>
