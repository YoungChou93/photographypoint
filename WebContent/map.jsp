<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>摄影小站</title>
   <link rel="stylesheet" href="jsps/css/index/dialog.css"  type="text/css"/>
   <script type="text/javascript" src="jsps/js/index/dialog.js"></script>
   <script type="text/javascript" src="jsps/js/index/chinacity.js" mce_src="jsps/js/index/chinacity.js"></script>
   <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ASLZn4DTgi2jUv4aCgBEIG1c"></script>
   
   <style type="text/css">
   html,body {
     width:100%;
     height:100%;
     overflow: hidden;	
	}
   
   </style>
</head>
<body>

    <img src="img/showdialog.png" style="position:absolute;z-index:3;left:50px;top:5px;" onclick="showdialog()"/>
<div style="position:absolute;z-index:3;left:85px;top:5px;">
<select  name="ddlProvince" id="ddlProvince" onchange="selectMoreCity(this)">


<option selected value="">城市</option>
 </select>
 <select name="ddlCity" id="ddlCity">
  <option selected value="">城市</option>
 </select>
<button onclick="searchcity()">确定</button>
</div>

<div class="dialog" id="dialog-add">

      <div class="dialog-title">添加

    <div class="dialog-close" onclick="closedialog()"></div>

	</div>

     <div class="dialog-content">


	<s:form action=""  method="post" id="AddPointForm" enctype="multipart/form-data" target="_self">
      <s:textfield key="名称" type="text" name="point.title" value="" size="34" maxlength="14" />
      <s:textfield key="经度" type="text" name="point.longitude" value="" size="10" maxlength="12" id="mapaddlng"/>
      <s:textfield key="纬度" type="text" name="point.latitude" value="" size="10" maxlength="12" id="mapaddlat"/>
      <s:textfield key="城市" type="text" name="point.city" value="" size="10" maxlength="12" />
	  <s:textarea  key="描述" type="text" name="point.content" rows="5" cols="30" ></s:textarea>
	  <s:textfield key="文件" type="file" name="file" size="35" />
      <s:submit type="submit" value="确定"  /> 
   </s:form>
                


            </div>
        </div>
        
   <div id="allmap" style="width:100%;height:100%;position:absolute;z-index:2;"> </div>
   <script type="text/javascript" src="jsps/js/index/baidumap.js" ></script>
</body>

</html>


