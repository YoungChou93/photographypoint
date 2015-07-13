<%@page import="org.photography.service.PointService"%>
<%@ page language="java" import="java.util.*" import="org.photography.entity.Point" import="org.photography.entity.User" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uty-8">
<title>摄影点</title>
<style type="text/css">
body{width:100%;height:100%;}
.content{
width:650px;
position:absolute;
left:50%;
margin-left:-325px;
}

.point-column{
width:100%;
 margin-top:20px;
 box-shadow: 0px 2px 3px 0px rgb(60,60,60);
 border-radius:5px;
}
.point-user{
height:60px;
width:100%;
}
.point-photo{
width:450px;
height:300px;
float:left;
}
.point-word{
width:200px;
height:300px;
float:left;
}
.point-footer{
width:100%;
height:30px;
clear:both;
background-color:rgb(240,240,240);
}
.img-headpicture{
  width:50px;
  height:50px;
  margin-top:5px;
  margin-left:5px;
  float:left;
}
.footer-right{
float:right;
position:relative;
top:-9px;
margin-right:5px;
}
.footer-left-img{
float:left;
width:25px;
position:relative;
top:2px;
left:2px;
}
.footer-left-p{
float:left;
position:relative;
top:-9px;
left:2px;
}
</style>
</head>
<body>
<div class="content">
<s:iterator value="points">
<div class="point-column">
<div class="point-user">
<img alt="" src="/photography/file/headpicture/headpicture.jpg" class="img-headpicture"/>
<p style="position:relative;top:10px;left:5px;"><s:property value="nickname"/></p>
<h4 style="position:relative;top:-7px;left:5px;"><s:property value="title"/></h4>
</div>
<div class="point-photo">
<img alt="" src="/photography<s:property value="smallPhotoUrl"/>" style="width:450px;height:300px;"/>
</div>
<div class="point-word">
<s:property value="content"/>
</div>

<div class="point-footer">
<img alt="" src="/photography/img/location.png" class="footer-left-img"/>
<p class="footer-left-p">位置</p>
<p class="footer-right"><s:property value="createTime"/></p>
<p class="footer-right"><s:property value="praise"/></p>
<p class="footer-right">评论</p>
</div>

</div>
</s:iterator>
</div>
</body>
</html>