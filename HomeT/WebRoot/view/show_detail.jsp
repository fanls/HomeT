<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/store/bootstrap/js/jquery-2.1.1.min.js"></script>
<link href="${pageContext.request.contextPath}/store/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${pageContext.request.contextPath}/store/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
var page = 1;
$(document).ready(function(){
	loadComment();
})
function getMore(){
	page++;
	loadComment();
}
function loadComment(){
	var url = "${pageContext.request.contextPath}/user/queryByNidComment?nid="+${note.nid}+"&page="+page;
	$.ajax({
		type:"get",
 		url:url,
 		success:function showResponse(response, status) {
			if(status =="success"){
				var data = eval('('+response+')');
				$.each(data ,function(idx,comm){
					var showComment ="<b><a>"+comm.author+"</a></b>_评论："+comm.data
									+"(创建于<a>"+comm.createDate+"</a>)"
									+"<div class=\"clear\"><hr size=\"1\" /></div>"
					$(".comment").append(showComment);
					//alert(item.cid);
				})
				$(".more").empty();
				$(".more").append("<button class=\"btn\" onclick=\"getMore()\">↓加载跟多</button>");
			}
		}
	})
}
function addComment(){
	var nid = $("#nid").val();
	var data =$("#data").val();
//	var paramJson = "{nid:"+nid+",data:"+data+"}";
	$.ajax({
		type:"post",
		url:"${pageContext.request.contextPath}/user/addComment",
		data:{
			nid:nid,
			data:data,
		},
		success:function(){
			$(".comment").empty();
			page=1;
			loadComment();
			$("#data").val("");
		}
	})
}
</script>
</head>
  
<body>
<div class="container-fluid" id="LG">
	<div class="row-fluid">
		<div class="span12">
			<jsp:include page="/inc/header.jsp"></jsp:include>
		</div>
	</div>
	<div class="row-fluid">
		<div class="form-group">
			<div class="note-box">
				<h3><b>标题：${note.title}</b></h3>
				<div id ="title">${note.article}</div>
				<br>
				<p>本文创建于<a>${note.createDate}</a>属于<a>${note.label}</a></p>
			</div>
			<div class="clear"><hr size="1" /></div>
			<div class="comment">
				
			</div>
			<div class="more" style="text-align:center;">
				
			</div>
			<div>
			<h4><b>创建评论：</b></h4>
				<div class="form-inline">
					<fieldset>
					<input type="hidden" id="nid" name="comment.nid" value="${note.nid}"/>
   					<textarea class="form-control" id="data" name="comment.data" rows="8" cols=100%></textarea><br><br>
					<button type="submit" class="btn" onclick="addComment()">提交</button>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	<div class="row-fluid footer">
		<div class="col-xs-12 col-sm-12">
			<div class="clear"><hr size="1" /></div>
			<p>就职于网易杭州研究院移动应用部门。 负责网易云阅读安卓平台的策划工作。</p>
		</div>
	</div>
</div>
</body>
</body>
</html>
