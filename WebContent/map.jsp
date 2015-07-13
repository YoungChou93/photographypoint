<%@page import="org.photography.service.PointService"%>
<%@ page language="java" import="java.util.*" import="org.photography.entity.Point" import="org.photography.entity.User" contentType="text/html; charset=utf-8"
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
	.menu{
	width:40px;
	height:300px;
	position:absolute;
	top:30px;
	left:10px;
	z-index:10;
	}
	.menu-botton{
	width:30px;
	margin-top:10px;
	}
   
   </style>
</head>
<body>

  <div class="menu">
   <img src="img/showdialog.png" onclick="showdialog()" class="menu-botton"/>
  
   <a href="<c:url value='/searchPoint?view=list'/>"><img src="img/pointlist.png" class="menu-botton"/></a>
   
     <a href="<c:url value='/searchPoint'/>"><img src="img/refresh.png" class="menu-botton"/></a>
  </div>

<div style="position:absolute;z-index:3;left:55px;top:5px;">
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


	<s:form action="addPoint"  method="post" id="AddPointForm" enctype="multipart/form-data" target="_self" >
      <s:textfield key="名称" type="text" name="point.title" value="" size="30" maxlength="14" />
      <s:textfield key="经度" type="text" name="point.longitude" value="" size="10" maxlength="12" id="mapaddlng"/>
      <s:textfield key="纬度" type="text" name="point.latitude" value="" size="10" maxlength="12" id="mapaddlat"/>
      <s:textfield key="城市" type="text" name="point.city" id="city" value="" size="10" maxlength="12" />
	  <s:textarea  key="描述" type="text" name="point.content" rows="5" cols="30" ></s:textarea>
	  <s:textfield key="照片" type="file" name="pointPhoto" size="35" />
      <s:submit type="submit" value="确定"  /> 
   </s:form>
               
            </div>
        </div>
        
     
   <div id="allmap" style="width:100%;height:100%;position:absolute;z-index:2;"> </div>
   <script type="text/javascript" src="jsps/js/index/baidumap.js" ></script>

<script type="text/javascript">
<%List<Point> points=(List<Point>) request.getAttribute("points");
     if(points!=null)
     {
	 for(int i=0;i<points.size();i++)
	 {
		 Point point=(Point) points.get(i);
	 
	 //创建信息窗口
	 String content="<div style='width:310px;'><h4 style='margin:0 0 5px 0;padding:0.2em 0'>"+ point.getTitle()+"</h4>" + 
				"<img style='float:right;margin:4px' id='"+point.getPointId()+"' src='/photography"+point.getSmallPhotoUrl()+"' width='300' height='200' />" + 
				"<p style='margin:0;line-height:1.5;font-size:13px;text-indent:2em'>"+point.getContent()+"</p>"+
				"<button onclick=''>路线</button></div>";
	 %>
	 var <%="sContent"+i%> ="<%=content%>"+"<p style='float:right;'>${point.user.nickname}</p>";
			
	 var marker = new BMap.Marker(new BMap.Point(<%=point.getLongitude() %>,  <%=point.getLatitude() %>));
		map.addOverlay(marker); 
		var label = new BMap.Label("<%=point.getTitle() %>",{offset:new BMap.Size(20,-10)});
		marker.setLabel(label);
		var <%="infoWindow"+i%> = new BMap.InfoWindow(<%="sContent"+i%>); 
		marker.addEventListener("click", function(){          
			   this.openInfoWindow(<%="infoWindow"+i%>);
			  <%--图片加载完毕重绘infowindow--%>
			   document.getElementById('<%=point.getTitle()%>').onload = function (){
				   <%="infoWindow"+i%>.redraw();   <%--防止在网速较慢，图片未加载时，生成的信息框高度比图片的总高度小，导致图片部分被隐藏--%>
			   }
			});

		
	<%} }%>

</script>


</body>

</html>


