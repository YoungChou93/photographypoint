<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>摄影点</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/user/userInfo.css'/>">
<script type="text/javascript" src="<c:url value='/jsps/js/index/chinacity.js'/>" mce_src="<c:url value='jsps/js/index/chinacity.js'/>"></script>
</head>
<body>
<div id="divMain">
  <img src="<c:url value='/images/logintitle.png'/>" style="width:250px;"/>
  <div id="divTitle">
    <span id="spanTitle">用户信息</span>
    <button class="editTitle" id="edit">编辑</button>
  </div>
  <div id="divBody">
  <form action="">
    <table id="tableForm">
      <tr class="trLine">
        <td class="tdText">邮箱：</td>
        <td class="tdInput">
          <p>${sessionScope.sessionUser.email}</p>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
       <tr class="trLine">
        <td class="tdText">用户名：</td>
        <td class="tdInput">
         <p id="nickname">${sessionScope.sessionUser.nickname}</p>
        </td>
        <td>
         <label></label>
        </td>
      </tr>
      <tr>
        <td class="tdText">性别：</td>
        <td class="tdInput">
         <p id="gender">${sessionScope.sessionUser.gender}</p>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
     <tr class="trLine">
        <td class="tdText">简介：</td>
        <td class="tdInput">
          <p id="brief">${sessionScope.sessionUser.brief}</p>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
     <tr class="trLine">
        <td class="tdText">所在地：</td>
        <td class="tdInput">
          <p id="location">${sessionScope.sessionUser.location}</p>
        </td>
        <td>
        <label></label>
        </td>
      </tr>
      <tr class="trLine">
        <td class="tdText">注册时间：</td>
        <td class="tdInput">
          <p>${sessionScope.sessionUser.registerTime}</p>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
    <tr class="trLine">
        <td class="tdText">微博：</td>
        <td class="tdInput">
         <p id="weibo">${sessionScope.sessionUser.weibo}</p>
        </td>
        <td>
         <label></label>
        </td>
      </tr>
      <tr class="trLine">
        <td class="tdText">QQ：</td>
        <td class="tdInput">
         <p id="qqNumber">${sessionScope.sessionUser.qqNumber}</p>
        </td>
        <td>
        <label></label>
        </td>
     </tr>
     <tr>
        <td></td>
        <td>
          <input type="submit"  id="submitBtn" style="visibility:hidden;width:140px;height:35px;" value="保存"/>
        </td>
        <td>
          <label></label>
        </td>
      </tr>
    </table> 
     
    </form> 
  </div>
</div>
<script type="text/javascript">
document.getElementById("edit").onclick=function(){
   
	var text=document.getElementById("edit");
	var val=text.innerHTML;
	if(val=="编辑")
	{
		showEdit("nickname","nicknameInput");
	    showEdit("brief","briefInput");
        showEdit("weibo","weiboInput");
        showEdit("qqNumber","qqNumberInput");
        showSelect("gender","genderInput");
        showCity("location");
        text.innerHTML="取消";
        var divObj = document.getElementById("submitBtn");
        divObj.style.visibility = "visible";
	}
	else
	{
		text.innerHTML="编辑";
		var divObj = document.getElementById("submitBtn");
        divObj.style.visibility = "hidden";
		cancelEdit("nickname","${sessionScope.sessionUser.nickname}");
		cancelEdit("brief","${sessionScope.sessionUser.brief}");
		cancelEdit("weibo","${sessionScope.sessionUser.weibo}");
		cancelEdit("qqNumber","${sessionScope.sessionUser.qqNumber}");
		cancelEdit("gender","${sessionScope.sessionUser.gender}");
		cancelEdit("location","${sessionScope.sessionUser.location}");
	}
    
};
function cancelEdit(eleId,content){
	var text=document.getElementById(eleId);
    var val=text.innerHTML;
    text.innerHTML=content;
}
function showEdit(eleId,newId){
	var text=document.getElementById(eleId);
    var val=text.innerHTML;
    text.innerHTML="<input type='text' id='"+newId+"' value="+val+" name="+eleId+"/>";

}

function showSelect(eleId,newId){
	var text=document.getElementById(eleId);
    var val=text.innerHTML;
    text.innerHTML="<select id='"+newId+"'><option value ='2'>未知</option><option value ='0'>女</option><option value ='1'>男</option></select> ";
 
    document.getElementById(newId).value = val;
}

function showCity(eleId){
	var text=document.getElementById(eleId);
    var val=text.innerHTML;
    text.innerHTML="<select name='ddlProvince' id='ddlProvince' onchange='selectMoreCity(this)' value="+val+"><option selected value=''>城市</option></select><select name='ddlCity' id='ddlCity'><option selected value=''>城市</option></select>";
    BindCity(val);
}

</script>

</body>
</html>