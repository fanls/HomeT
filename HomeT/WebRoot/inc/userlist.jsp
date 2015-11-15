<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示用户信息</title>
    <style type="text/css">
.userlist{
background: #e8e8e8;
margin: 1% 1% 2% 1% ;
width:18%;
position: absolute;
z-index: 9999;
border-radius:1%;
box-shadow: 1px 1px 2px #888888;
}   
    </style>
  </head>
<body>
<div class="userlist">
	 <s:iterator value="#request.userlist" id="st">
	 <dl>
	 <dd><a href="${pageContext.request.contextPath}/user/queryBlog?user.id=<s:property value='#st.id'/>"><s:property value="#st.name"/></a></dd>  
	 </dl>
  	 </s:iterator>
</div>
</body>
</html>