<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>sidebar</title>
<style type="text/css">
	html,body {
     width:100%;
     height:100%;
     overflow: hidden;	
	}
	a{
	 text-decoration:none;
	 font-size:30px;
	 font-family:微软雅黑;
	 color:white;
	}
	.p-position{
	position:relative;
	left:20%;
	}
	.top-user{
	position:relative;
	top:20px;
	left:-20px;
	text-align:center;
	margin:0 auto;
	}
	.top-user-name{
    font-family:微软雅黑;
    font-size:23px;
	}
	.bottom-login-register{
	width:100%;
	position:absolute;
	bottom:20px;
	text-align:center;
	}
	.bottom-login-a{
	float:left;
	font-family:微软雅黑;
	font-size:20px;
	margin-left:50px;
	}
    .bottom-register-a{
    float:left;
    font-family:微软雅黑;
    font-size:20px;
    margin-left:50px;
	}
	</style>
</head>
<body>

        <div style="width:100%;height:100%">
        <%
        if(session.getAttribute("sessionUser")==null){ %>
		
	    
		 <div class="bottom-login-register">
		 <a href="<c:url value='jsps/user/login.jsp'/>" target="main" class="bottom-login-a">登陆</a>
		 <a href="<c:url value='jsps/user/regist.jsp'/>" target="main" class="bottom-register-a">注册</a>
         </div>
	   <%} else{%>
		
		<div class="top-user">
		<img src="<c:url value='${sessionScope.sessionUser.head}'/>" style="width:100px;"/>
		<p><a href="<c:url value='jsps/user/userInfo.jsp'/>" target="main" class="top-user-a" >${sessionScope.sessionUser.nickname }</a></p>
		</div>
		
	   <%} %>
	   
		<div style="position:absolute;top:200px;width:100%;">
		<p class="p-position">
		<img src="img/index.png" style="width:45px;"/>
		<a href="<c:url value='welcome.jsp'/>" style="position:relative;top:-10px;left:10px;" target="main">首页</a>
		</p>
		
		<p class="p-position">
		<img src="img/map.png" style="width:45px;"/>
		<a href="<c:url value='map.jsp'/>" style="position:relative;top:-10px;left:10px;" target="main">地图</a>
		</p>
		
		<p class="p-position">
		<img src="img/photo.png" style="width:45px;"/>
		<a href="<c:url value='map.jsp'/>" style="position:relative;top:-10px;left:10px;" target="main">照片</a>
		</p>
		
		<p class="p-position">
		<img src="img/about.png" style="width:45px;"/>
		<a href="<c:url value='map.jsp'/>" style="position:relative;top:-10px;left:10px;" target="main">关于</a>
		</p>
		
		</div>
		</div>
		
	
		
</body>
</html>