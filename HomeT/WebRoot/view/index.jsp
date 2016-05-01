<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/store/bootstrap/js/jquery-2.1.1.min.js"></script>
<link href="${pageContext.request.contextPath}/store/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${pageContext.request.contextPath}/store/bootstrap/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/inc/whole.css" rel="stylesheet" type="text/css"> 
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12 col-sm-3">
		</div>
		<div class="col-xs-12 col-sm-6">
			<blockquote>
				<h1>日记管理系统登录</h1> 
				<h2><small>作者 ：<cite>樊良锁</cite></small></h2>
			</blockquote>
			<div class="tabbable" id="tabs-805698">
				<ul class="nav nav-tabs">
					<li>
						<a href="#panel-734208" data-toggle="tab">登录</a>
					</li>
					<li class="active">
						<a href="#panel-976632" data-toggle="tab">注册</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane" id="panel-734208">
						<form class="form-horizontal" action="${pageContext.request.contextPath}/view/login" method="post">
							<div class="control-group">
							<legend>用户登录信息</legend>
								<label>用户名：</label>
								<div class="controls">
									<input id="inputEmail" type="text" name="username"/>
								</div>
							</div>
							<div class="control-group">
								<label>密码：</label>
								<div class="controls">
									<input id="inputPassword" type="password" name="password" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<br> <button class="btn" type="submit">登陆</button>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane active" id="panel-976632">
						<form action="${pageContext.request.contextPath}/view/registry" method="post">
							<fieldset>
								 <legend>用户注册信息</legend>
								 <label>用户名:</label>
								 <input type="text" name="username"/> 
								 <span class="help-block">乱七八糟的注册啊</span> 
								 <label>密&nbsp码：</label>
								 <input type="password" name="password"/><br>
								 <span></span>
								 <label>群&nbsp组：</label>
								 <input type="text" name="group"/>
								 <span></span>
								 <label class="checkbox">
								 	<input type="checkbox"/>认可网站
								 </label>
								 <button type="submit" class="btn">提交</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-12 col-sm-3">
		</div>
	</div>
</div>
</body>
</html>