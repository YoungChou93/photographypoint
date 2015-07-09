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
body{width:100%;height:100%; overflow: hidden;}
.content{
  width:500px;
  height:400px;
  margin:20px auto 0 auto;
}
.table-content{
width:100%;
height:100%;
}
.tdtitle{
width:200px;
text-align:right;
font-family:微软雅黑;
}
.tdtext{
width:300px;
text-align:left;
font-family:微软雅黑;
}
</style>
</head>
<body>

<div class="content">
    <table class="table-content">
      <tr>
        <td class="tdtitle">邮箱：</td>
        <td class="tdtext">
          <p>${sessionScope.sessionUser.email} </p>
        </td>
      </tr>
       <tr >
        <td class="tdtitle">用户名：</td>
        <td class="tdtext">
         <p>${sessionScope.sessionUser.nickname}</p>
        </td>
      </tr>
      <tr>
        <td class="tdtitle">性别：</td>
        <td class="tdtext">
         <p >${sessionScope.sessionUser.gender}</p>
        </td>
      </tr>
     <tr >
        <td class="tdtitle">简介：</td>
        <td class="tdtext">
          <p >${sessionScope.sessionUser.brief}</p>
        </td>
      </tr>
     <tr >
        <td class="tdtitle">所在地：</td>
        <td class="tdtext">
          <p >${sessionScope.sessionUser.location}</p>
        </td>
      </tr>
      <tr >
        <td class="tdtitle">注册时间：</td>
        <td class="tdtext">
          <p>${sessionScope.sessionUser.registerTime}</p>
        </td>
      </tr>
    <tr >
        <td class="tdtitle">微博：</td>
        <td class="tdtext">
         <p >${sessionScope.sessionUser.weibo}</p>
        </td>
     
      </tr>
      <tr >
        <td class="tdtitle">QQ：</td>
        <td class="tdtext">
         <p >${sessionScope.sessionUser.qqNumber}</p>
        </td>
     </tr>
    </table> 
</div>


</body>
</html>