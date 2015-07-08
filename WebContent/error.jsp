<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>错误信息</title>
</head>
<style type="text/css">
.message-content{
    padding-top:20px;
    width:600px;
    height:320px;
    background-color:rgb(245,245,245);
    text-align:center;
    position:absolute;  
    left:50%;  
    top:50%;  
    margin:-200px 0 0 -300px;
    border: 1px solid #d0d0d0;
 }
 .message-title{
    width:100%;
    height:100px;
 }

</style>




<body>

<div class="message-content">

<img src="<c:url value='/img/error.png'/>" style="width:100px;"/>

<p style="font-size:50px;color:red;font-famliy:微软雅黑;">${errorMsg}</p>
<a href="<c:url value='/index.jsp'/>">进入主页</a>
</div>
<form action="<c:url value='/modifyPassword'/>">
<input type="password" name="oldpassword"/>
<input type="password" name="newpassword"/>
<input type="submit"/>
<s:fielderror/>
</form>
</body>
</html>