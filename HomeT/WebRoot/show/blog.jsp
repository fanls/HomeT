<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示用户信息</title>
    <link href="<s:url value="/inc/base.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
	<jsp:include page="/inc/logon.jsp"></jsp:include>
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<div class="blog">
	 <s:iterator value="#request.blog" id="st">
      			<dd><s:property value="#st.blog" escape="false"/> </dd>    
  	 </s:iterator>
	</div>
</div>
<div class="footer">Copyright W3School.com.cn</div>
</body>
</html>
