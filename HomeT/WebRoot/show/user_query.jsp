<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示用户信息</title>
    <link href="<s:url value="/inc/base.css"/>" rel="stylesheet" type="text/css">
    <script type="text/javascript">
$(document).ready(function(){
	alert("fsadgas");
})
    </script>
</head>
<body>
<div class="container">
	<jsp:include page="/inc/logon.jsp"></jsp:include>
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<div class="blog">
	<jsp:include page="/inc/userlist.jsp"></jsp:include>
		 <s:iterator value="#request.userlist" id="st">
    	<div class=blog_box>
    	<dl>
    		<dt><s:property value="#st.id"/> </dt>
      			<dd><s:property value="#st.name"/> </dd>
      			<dd><s:property value="#st.password"/> </dd>
      			<dd><s:property value="#st.type"/> </dd>
			<dt><a href="userdelete.action?user.id=<s:property value='#st.id'/>">删除</a>
			<a href="../update.jsp?id=<s:property value='#st.id'/>">更新</a>
			<a href="<s:url value="/save.jsp"/>">添加用户</a></dt>    
    	</dl>
    	<hr width="95%" size="1" />
    	</div>
  	 </s:iterator>
	</div>
</div>
<div class="footer">Copyright W3School.com.cn</div>
</body>
</html>