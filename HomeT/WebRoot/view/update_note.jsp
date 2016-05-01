<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/store/bootstrap/js/jquery-2.1.1.min.js"></script>
<link href="${pageContext.request.contextPath}/store/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${pageContext.request.contextPath}/store/bootstrap/js/bootstrap.min.js"></script>
</head>
  
<body>
<div class="container-fluid" id="LG">
	<div class="row-fluid">
		<div class="span12">
			<jsp:include page="/inc/header.jsp"></jsp:include>
		</div>
	</div>
	<div class="row-fluid">
			<form class="form-inline"action="${pageContext.request.contextPath}/user/doUpdateNote" method="post">
				<div class="form-group">
				<fieldset>
					<legend>表单项</legend>
					<label contenteditable="true">主题</label><br>
						<input type="text" name="note.title"placeholder="给此时此刻的想法做个总结" value="${note.title}"><br>
					<label for="name">想要说些什么</label><br>
    					<textarea class="form-control" name="note.article" rows="10" cols="60" value="${note.article}"></textarea><br>
    					<span class="help-block">您可以使用这些HTML标签和属性： < a href="" title="" > < abbr title=""> < acronym title=""> < b> < blockquote cite=""> < cite> < code> < del datetime=""> < em> < i> < q cite=""> < s> < strike> < strong></span>
					<label contenteditable="true">标签</label><br>
						<input type="text" name="note.label" value="${note.label}"><br><br>
					<button type="submit" class="btn">更新</button>
				</fieldset>
				</div>
			</form>
	</div>
</div>
</body>
</body>
</html>
