<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>显示用户信息</title>
    <link href="<s:url value="/inc/base.css"/>" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/store/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//	var val = "${request.bloglist}";
//	alert(val);
});
</script>
</head>
<body>
<div class="container">
	<jsp:include page="/inc/logon.jsp"></jsp:include>
	<jsp:include page="/inc/header.jsp"></jsp:include>
	<div class="blog">
	<jsp:include page="/inc/userlist.jsp"></jsp:include>
	 <s:iterator value="#request.bloglist" id="st">
    	<div class=blog_box>
    	<dl>
    		<dt><s:property value="#st.title"/> </dt>
      			<dd><s:property value="#st.createDate"/> </dd>
      			<dd><s:property value="#st.article"/> </dd>
      			<dd><s:property value="#st.blog" escape="false"/> </dd>
      			<dd><s:property value="#st.lable"/> </dd>
			<dt><a href="${pageContext.request.contextPath}/user/showBlog?blog.bid=<s:property value='#st.bid'/>">查看详细</a>
			<a href="../update.jsp?id=<s:property value='#st.bid'/>">更新</a>
			<a href="<s:url value="/show/write_blog.jsp"/>">添加博文</a></dt>    
    	</dl>
    	<hr width="500" size="1" />
    	</div>
  	 </s:iterator>
	</div>
</div>
<div class="footer">Copyright W3School.com.cn</div>
</body>
</html>
