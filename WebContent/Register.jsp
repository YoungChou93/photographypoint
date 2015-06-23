<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="s" uri="/struts-tags"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>注册</title>  
</head>  
<body>  
    <s:form action="register">  
        <s:textfield id="email" name="user.email" label="账号"><span id="errorSpan"></span></s:textfield>
        
        <s:password name="user.password" label="密码"></s:password> 
        <s:textfield name="user.nickname" label="用户名"></s:textfield>   
        <s:select list="#{'2':'未知','1':'男','0':'女'}" listKey="key" listValue="value"  
            name="user.gender" label="性别" value="2"></s:select> 
        <s:textfield name="user.brief" label="简介"></s:textfield>
        <s:textfield name="user.location" label="地区"></s:textfield>   
        <s:textfield name="user.head" label="头像"></s:textfield>   
        <s:textfield name="user.weibo" label="微博"></s:textfield>   
        <s:textfield name="user.qqNumber" label="QQ"></s:textfield>         
            
        <s:submit value="注册"></s:submit>   
    </s:form>  
  
</body>  
<script type="text/javascript">
function createXMLHttpRequest() {
    try {
        return new XMLHttpRequest();
    } catch(e) {
        try {
	      return new ActiveXObject("Msxml2.XMLHTTP");
	  } catch(e) {
	      try {
	          return new ActiveXObject("Microsoft.XMLHTTP");
	      } catch(e) {
	          alert("好累，你用的是什么浏览器啊？");
	          throw e;
	      }
	  }
    }
}

window.onload=function(){
	var userEle=document.getElementById("email");
	userEle.onblur=function(){
		var xmlHttp = createXMLHttpRequest();
		xmlHttp.open("Post", "<c:url value='/ValidateUsername'/>", true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		//4.发送请求，给出请求体
		xmlHttp.send("email=" + userEle.value);

		xmlHttp.onreadystatechange = function() {//xmlHttp的5种状态都会调用本方法
		    if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {//双重判断：判断是否为4状态，而且还要判断是否为200
		    	var text = xmlHttp.responseText;
				var span = document.getElementById("errorSpan");
				
					//得到span元素
					span.innerHTML = text;
				
		    }
		};
		
	}
}



</script>
</html>  