<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/store/bootstrap/js/jquery-2.1.1.min.js"></script>
<link href="${pageContext.request.contextPath}/store/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${pageContext.request.contextPath}/store/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
var param="";
var op= 0;
var page=1;
function setParam(data,no){
	op = no;
	param=data;
	page=1;
	$(".content").empty();
	loadMain();
}
function getMore(){
	page++;
	loadMain();
}
function gotoNote(data,uid){
	window.location.href="${pageContext.request.contextPath}/user/queryByNidNote?nid="+data+"&uid="+uid;
}
function loadMain(){
	var url1 ="${pageContext.request.contextPath}/user/queryGroupNote?param="+param+"&op="+op+"&page="+page;
	var blog;
	var title;
	var nid;
	//加载主页面的种种
	$.ajax({
		type:"post",
 		url:url1,
 		async:false,
 		success:function showResponse(response, status) {
			if (status == "success") {
			var str = eval('('+response+')');
//			alert(str.data.length);
//			alert(response);
			for ( var p in str.data){ // 方法 
				blog = str.data[p].article;
				title = str.data[p].title;
				nid = str.data[p].nid;
				name = str.data[p].label;
				uid = str.data[p].uid;
				createDate=str.data[p].createDate;
				var note_box ="<div class='blog_box'>"
							 +"<h3><a href =\"${pageContext.request.contextPath}/user/showUserNote?uid="+uid+"\">"+name+"</a>_<apan onclick='gotoNote("+nid+","+uid+")'>"+title+"</span></h3>"
				 			 +"<p>"+blog.substring(0,230)+"</p>"
				 			 +"本文创建于"   +createDate+"</p><hr size='1/'></div>"
				$(".content").append(note_box);
    		}
			$(".more").empty();
			$(".more").append("<button class=\"btn\" onclick=\"getMore()\">↓加载跟多</button>");
			}
		}
	});
}
function loadUsers(data){
//获取文章分类
	var flabel;
	var fno;
	var num =0;
	var url2 ="${pageContext.request.contextPath}/user/userInGroupNote";
	$.ajax({
		type:"post",
		url:url2,
		success:function showResponse(response,status){
			if(status =="success"){
				var str = eval('('+response+')');
				//alert(str);
				if(data != 1){
					num = str.length;
				}
				$(".h").empty();
				$(".f").empty();
				$(".h").append("<p>好友列表("+str.length+")</p>")
				if(num>10){
					for(var i=0;i<=10;i++ ){
						name = str[i].name;
						uid = str[i].uid;
						var html ="<dd><a href =\"${pageContext.request.contextPath}/user/showUserNote?uid="+uid+"\">"+name+"</a></dd>"
						$(".f").append(html)
					}
					$(".f").append("<span onclick='loadUsers(\"1\")'>显示更多>></span>");
				}else{
					for(var p in str){
						name = str[p].name;
						uid = str[p].uid;
						var html ="<dd><a href =\"${pageContext.request.contextPath}/user/showUserNote?uid="+uid+"\">"+name+"</a></dd>"
						$(".f").append(html)
					}
				}
			}
		}
	});
}
function loadActor(){
//获取文章归档
	var author;
	var gno;
	var url3 ="${pageContext.request.contextPath}/user/getNearlyComment";
	$.ajax({
		type:"post",
		url:url3,
		success:function showResponse(response,status){
			if(status =="success"){
				var str = eval('('+response+')');
				//alert(str);
					for(var p in str){
						author = str[p].author;
						createDate = str[p].createDate;
						data = str[p].data;
						nid = str[p].nid;
						uid = str[p].uid;
//						var html ="<dd><span onclick='setParam(\""+gdate+"\",2)'><a>"+gdate+"("+gno+")</a></span></dd>"
						var html ="<dd><a onclick='gotoNote(\""+nid+"\",\""+uid+"\")'>"+author+"评论了《"+data+"》</a></dd>";
						$(".g").append(html)
					}
			}
		}
	});
}
$(document).ready(function(){
	loadMain();
	loadUsers();
	loadActor();
});

</script>
</head>
<body>
<div class="container-fluid" id="LG">
	<div class="row-fluid">
		<div class="span12">
			<jsp:include page="/inc/header.jsp"></jsp:include>
			<div class="carousel slide" id="carousel-717076">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-717076">
					</li>
					<li data-slide-to="1" data-target="#carousel-717076">
					</li>
					<li data-slide-to="2" data-target="#carousel-717076">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="../images/note/1.jpg" />
						<div class="carousel-caption">
							<h4>
								棒球
							</h4>
							<p>
								棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="../images/note/2.jpg" />
						<div class="carousel-caption">
							<h4>
								冲浪
							</h4>
							<p>
								冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="../images/note/3.jpg" />
						<div class="carousel-caption">
							<h4>
								自行车
							</h4>
							<p>
								以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。
							</p>
						</div>
					</div>
				</div> <a data-slide="prev" href="#carousel-717076" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-717076" class="right carousel-control">›</a>
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="col-xs-12 col-sm-9">
			<div class="content">

			</div> 
			<div class="more" style="text-align:center;">

			</div> 
		</div>
		<div class="col-xs-12 col-sm-3">
			<div class="accordion" id="accordion-2558">
				<div class="accordion-group">
					<div class="accordion-heading h">
						
					</div>
					<div class="accordion-inner f">
					</div>
				</div><br>
				<div class="accordion-group">
					<div class="accordion-heading">
					<p>最新评论</p>
					</div>
					<div class="accordion-inner g">
					<p></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="col-xs-12 col-sm-12">
			<div class="clear"><hr size="1" /></div>
			<p>就职于网易杭州研究院移动应用部门。 负责网易云阅读安卓平台的策划工作。</p>
		</div>
	</div>
</div>
</body>
</html>