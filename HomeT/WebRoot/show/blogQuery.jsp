<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示用户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="${pageContext.request.contextPath}/store/jquery.js" type="text/javascript"></script>
	<link href="<s:url value="/inc/whole.css"/>" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(document).ready(function(){
	var url ="${pageContext.request.contextPath}/user/queryNote";
	var blog;
	var title;
	$.ajax({
		type:"post",
 		url:url,
 		async:false,
 		success:function showResponse(response, status) {
			if (status == "success") {
			var str = eval('('+response+')');
//			alert(str.data.length);
//			alert(response);
			for ( var p in str.data){ // 方法 
				blog = str.data[p].blog;
				title = str.data[p].title;
				createDate=str.data[p].createDate;
				$(".content").append('<div class="blog_box"><h3>'+title+'</h3><p>'+blog.substring(0,230)+'</p>本文创建于'+createDate+'</p><hr size="1/"></div>');
    		}
			}
		}
	});
});

</script>
</head>
<body>
<div class="page">
	<div class="header">
		<div class="title">
			<h1 class="title"><a href="" title="响应式web" rel="home">响应式web开发</a></h1>
			<p class="introduce">根据设备环境进行相应的网页布局</p>
		</div>
	</div>
	<div class="clear"><hr size="1" /></div>
	<div class="menu">
		<ul>
			<li><a href=""title="">首页</a></li>
			<li><a href=""title="">友情链接</a></li>
			<li><a href=""title="">个人中心</a></li>
			<li><a href=""title="">联系我们</a></li>
		</ul>
	</div>
	<div class="clear"><hr size="1" /></div>
	<div class="main">
		<div class="content">
		</div>
		<div class="navigation">
			<div class="theme">	
					  
			</div>
			<div class="date">  
			</div>
		</div>
	</div>
	<div class="clear"><hr size="1" /></div>
	<div class="footer">Copyright W3School.com.cn</div>
</div>
<!-- 
	<jsp:include page="/inc/userlist.jsp"></jsp:include>
	<div>
	 	<s:iterator value="#request.bloglist" id="st">
    	<div class=blog_box>
    		<div><s:property value="#st.title"/></div>
      			<div class="t"><s:property value="#st.createDate"/></div>
      			<div class="b">
      				<s:property value="#st.blog" escape="false"/>
      			</div>
      		<div>
				<a href="${pageContext.request.contextPath}/user/showBlog?blog.bid=<s:property value='#st.bid'/>">查看详细</a>
				<a href="../update.jsp?id=<s:property value='#st.bid'/>">更新</a>
				<a href="<s:url value="/show/write_blog.jsp"/>">添加博文</a>   
    		</div>
    	<hr width="500" size="1" />
    	</div>
  		 </s:iterator>
	</div> -->
</body>
</html>
