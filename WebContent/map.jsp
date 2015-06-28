<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


	<form action="addpoint"  method="post" id="form_addppoi" enctype="multipart/form-data">
    
    <p class="dialog-p">名称：<input type="text" name="ppoiname" value="" size="34" maxlength="14"/></p>
   
    <p class="dialog-p">经度：<input type="text" id="mapaddlng" name="longitude" value=""size="10" maxlength="12"/>
    纬度：<input type="text" id="mapaddlat" name="latitude" value=""size="10" maxlength="12"/></p>
    
     <p class="dialog-p">备注：</p>
	 <textarea rows="5" cols="37" form="form_addppoi" name="ppoicontent"></textarea>
	 <input type="file" name="file" size="35" />

     <p><input type="submit" value="确定" class="dialog-sumbit"></p>
</form>
                


            </div>
        </div>
        
   <div id="allmap" style="width:100%;height:100%;position:absolute;z-index:2;"> </div>
   <script type="text/javascript" src="jsps/js/index/baidumap.js" ></script>
</body>

</html>


