<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>摄影点</title>
<script type="text/javascript" src="<c:url value='/jsps/js/index/chinacity.js'/>" mce_src="<c:url value='jsps/js/index/chinacity.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
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
  <form action="<c:url value='/modifyInfo'/>" id="modifyForm" target="_self">
    <table class="table-content">
      <tr>
        <td class="tdtitle"></td>
        <td class="tdtext">
         <s:fielderror/>
         ${errorMsg } 
        </td>
      </tr>
      <tr>
        <td class="tdtitle">邮箱：</td>
        <td class="tdtext">
         <p>${sessionScope.sessionUser.email}</p>
        </td>
      </tr>
       <tr >
        <td class="tdtitle">用户名：</td>
        <td class="tdtext">
         <p><input type="text" name="nickname" id="" value="${sessionScope.sessionUser.nickname}" maxlength="12"/></p>
        </td>
      </tr>
      <tr>
        <td class="tdtitle">性别：</td>
        <td class="tdtext">
         <p><select id="genderID" name="gender" >
            <option value ="2">未知</option>
            <option value ="0">女</option>
            <option value ="1">男</option>
         </select> </p>
        </td>
      </tr>
     <tr >
        <td class="tdtitle">简介：</td>
        <td class="tdtext">
          <p><input type="text" name="brief" id="" value="${sessionScope.sessionUser.brief}" maxlength="50"/></p>
        </td>
      </tr>
     <tr >
        <td class="tdtitle">所在地：</td>
        <td class="tdtext">
          <p><select name='ddlProvince' id='ddlProvince' onchange='selectMoreCity(this)' >
               <option selected >城市</option>
          </select>
          <select name='ddlCity' id='ddlCity'>
               <option selected value=''>城市</option>
          </select></p>
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
         <p> <input type="text" name="weibo" id="" value="${sessionScope.sessionUser.weibo}" maxlength="15"/></p>
        </td>
     
      </tr>
      <tr >
        <td class="tdtitle">QQ：</td>
        <td class="tdtext">
         <p> <input type="text" name="qqNumber" id="" value="${sessionScope.sessionUser.qqNumber}" maxlength="12"/></p>
        </td>
     </tr>
     <tr >
        <td class="tdtitle"></td>
        <td class="tdtext">
         <p> <input type="submit" value="确认"/></p>
        </td>
     </tr>
    </table> 
    </form> 
  </div>
<script type="text/javascript">
document.getElementById("genderID").value = ${sessionScope.sessionUser.gender};
var val="${sessionScope.sessionUser.location}";
var arrys = val.split(" ");
BindCity(arrys[1]);
</script>

</body>
</html>