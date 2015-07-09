<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>摄影点</title>
<style type="text/css">
a{text-decoration:none;font-size:20px;font-family:微软雅黑; color:gray;}
tr{text-align:center;margin-left:10px;}
.userInfo-content{
width: 980px; 
height: 550px; 
position:absolute;
left:50%;
margin-left:-440px;
}
.userInfo-main{
width: 980px; 
height: 550px; 
border-left: 1px solid #d0d0d0;
border-bottom: 1px solid #d0d0d0;
border-right: 1px solid #d0d0d0;
}
.userInfo-title{
   line-height: 30px;
   width: 980px; 
   height: 30px;
   border: 1px solid #d0d0d0;
   background: url(/photography/images/bg_btns.png) repeat-x 0px -132px;
}

.userInfo-menu{
    
    width:180px;
    height:100%;
    float:left;
    text-aglin:center;

}
.userInfo-headpicture{
   width:100px;
   height:100px;
   margin-left:40px;
   margin-top:40px;
}
.userInfo-menubar{
margin-top:30px;
    width:100%;
    height:100%;
    text-aglin:center;
    
}
.userInfo-infocontent{
    width:800px;
    height:100%;
    float:left;

}
.userInfo-tablebar{
     width:100%;
     text-aglin:center;
}
.spanTitle {
margin-left: 18px;
 font-weight: 900;
 }
</style>
</head>
<body>

<div class="userInfo-content">
<div class="userInfo-title">
 <span class="spanTitle">用户信息</span>
</div>
<div class="userInfo-main">
<div class="userInfo-menu">
<img src="<c:url value='${sessionScope.sessionUser.head}'/>" class="userInfo-headpicture"/>
<div class="userInfo-menubar">
<table class="userInfo-tablebar">
      <tr >
         <td><a target="userModify" href="<c:url value='/jsps/user/userInfo.jsp'/>">个人信息</a></td>
      </tr>
       <tr >
         <td><a target="userModify" href="<c:url value='/jsps/user/modifyUserInfo.jsp'/>">修改信息</a></td>
      </tr>
       <tr >
         <td><a target="userModify" href="<c:url value='/jsps/user/pwd.jsp'/>">修改密码</a></td>
      </tr>
       <tr >
         <td><a target="userModify" href="<c:url value='/jsps/user/headpicture.jsp'/>">修改头像</a></td>
      </tr>
</table>
</div>
</div>
<div class="userInfo-infocontent">

<iframe frameborder="0" src="<c:url value='/jsps/user/userInfo.jsp'/>" name="userModify" style="width:100%;height:100%;"></iframe>
</div>

</div>
</div>


</body>
</html>