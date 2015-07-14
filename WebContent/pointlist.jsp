<%@page import="org.photography.service.PointService"%>
<%@ page language="java" import="java.util.*"
	import="org.photography.entity.Point"
	import="org.photography.entity.User"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uty-8">
<title>摄影点</title>
<style type="text/css">
body {
	width: 100%;
	height: 100%;
	background-color: rgb(240, 240, 240);
}

.content {
	width: 650px;
	position: absolute;
	left: 50%;
	margin-left: -325px;
	top: 50px;
	font-size: 15px;
	font-famliy: "微软雅黑";
}

.top-bar {
	width: 100%;
	height: 50px;
	position: fixed;
	overflow: hidden;
	z-index: 5;
	background-color: white;
	text-align: center;
	top: -0px;
	left: -0px;
	box-shadow: 0px 2px 3px 0px rgb(190, 190, 190);
}

.point-column {
	width: 100%;
	margin-top: 20px;
	box-shadow: 0px 2px 3px 0px rgb(60, 60, 60);
	border-radius: 5px;
	background-color: white;
}

.point-user {
	height: 60px;
	width: 100%;
}

.point-photo {
	width: 450px;
	height: 298px;
	float: left;
}

.point-word {
	width: 200px;
	height: 300px;
	float: left;
}

.point-footer {
	width: 100%;
	height: 30px;
	clear: both;
	background-color: rgb(240, 240, 240);
}

.img-headpicture {
	width: 50px;
	height: 50px;
	margin-top: 5px;
	margin-left: 5px;
	float: left;
}

.footer-right {
	float: right;
	position: relative;
	top: -9px;
	margin-right: 5px;
}

.footer-left-img {
	float: left;
	width: 25px;
	position: relative;
	top: 2px;
	left: 2px;
}

.footer-left-p {
	float: left;
	position: relative;
	top: -9px;
	left: 2px;
}

td {
	width: 80px;
}

table {
	position: relative;
	left: 50%;
	top: 2px;
	margin-left: -290px;
}

a {
	text-decoration: none;
	font-size: 20px;
	font-family: 微软雅黑;
	color: gray;
}

p {
	font-size: 15px;
	font-family: 微软雅黑;
	color: black;
}

h4 {
	font-size: 15px;
	font-family: 微软雅黑;
	color: black;
}
</style>
</head>
<body>
	<div class="top-bar">
		<table style="float: left;">
			<tr>
				<td><img src="/photography/images/logintitle.png"
					style="height: 35px;" /></td>
				<td><a href="<c:url value='/searchPoint?view=list&label=人文'/>">人文</a></td>
				<td><a href="<c:url value='/searchPoint?view=list&label=人像'/>">人像</a></td>
				<td><a href="<c:url value='/searchPoint?view=list&label=城市'/>">城市</a></td>
				<td><a href="<c:url value='/searchPoint?view=list&label=风光'/>">风光</a></td>
				<td><a href="<c:url value='/searchPoint?view=list&label=纪实'/>">纪实</a></td>
				<td><a href="<c:url value='/searchPoint?view=map'/>"><img
						src="/photography/img/location.png" style="width: 25px;" /></a></td>
			</tr>
		</table>
	</div>
	<div class="content">
		<s:iterator value="points" id="point">
			<div class="point-column">
				<div class="point-user">
					<img alt="" src="/photography<s:property value="#point.user.head"/>"
						class="img-headpicture" />
					<p style="position: relative; top: 10px; left: 5px;">
						<s:property value="#point.user.nickname" />
					</p>
					<h4 style="position: relative; top: -7px; left: 5px;">
						<s:property value="title" />
					</h4>
				</div>
				<div class="point-photo">
					<img alt="" src="/photography<s:property value="smallPhotoUrl"/>"
						style="width: 447px; height: 289px;" />
				</div>
				<div class="point-word">
					<p>
						<s:property value="content" />
					</p>
				</div>

				<div class="point-footer">
					<img alt="" src="/photography/img/location.png"
						class="footer-left-img" />
					<p class="footer-left-p">位置</p>
					<p class="footer-right">
						<s:property value="createTime" />
					</p>
					<p class="footer-right">
						<s:property value="praise" />
					</p>
					<p class="footer-right">评论</p>
				</div>

			</div>
		</s:iterator>
	</div>
</body>
</html>