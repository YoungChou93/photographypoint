 var addppoint=false;
    //打开
	function showdialog(){
		divObj = document.getElementById("dialog-add");
        divObj.style.visibility = "visible";
        addppoint=true;
	}
    //关闭
	function closedialog(){
		divObj = document.getElementById("dialog-add");
        divObj.style.visibility = "hidden";
        addppoint=false;
		
	}


	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.404, 39.915);
	map.centerAndZoom(point, 13);
	var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT});// 左上角，添加比例尺
	var top_right_navigation = new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}); //右上角，仅包含平移和缩放按钮
	/*缩放控件type有四种类型:
	BMAP_NAVIGATION_CONTROL_SMALL：仅包含平移和缩放按钮；BMAP_NAVIGATION_CONTROL_PAN:仅包含平移按钮；BMAP_NAVIGATION_CONTROL_ZOOM：仅包含缩放按钮*/
	map.addControl(top_left_control);             
	map.addControl(top_right_navigation);   
	
	var navigationControl = new BMap.NavigationControl({
	    // 靠左上角位置
	    anchor: BMAP_ANCHOR_TOP_LEFT,
	    // LARGE类型
	    type: BMAP_NAVIGATION_CONTROL_LARGE,
	    // 启用显示定位
	    enableGeolocation: true
	  });

	 map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
	 map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
	 
	 var geolocationControl = new BMap.GeolocationControl();
	  geolocationControl.addEventListener("locationSuccess", function(e){
	    // 定位成功事件
	    var address = '';
	    address += e.addressComponent.province;
	    address += e.addressComponent.city;
	    address += e.addressComponent.district;
	    address += e.addressComponent.street;
	    address += e.addressComponent.streetNumber;
	    alert("当前定位地址为：" + address);
	  });
	  geolocationControl.addEventListener("locationError",function(e){
	    // 定位失败事件
	    alert(e.message);
	  });
	  map.addControl(geolocationControl);
	  function myFun(result){
			var cityName = result.name;
			map.setCenter(cityName);
		}
		var myCity = new BMap.LocalCity();
		myCity.get(myFun);

      BindCity("武汉");

      function searchcity()
	  {
		  var cityname=document.getElementById("ddlCity").value
		  map.centerAndZoom(cityname,15);
	  }

      map.addEventListener("click",function(e){
  		if(addppoint==true){
  		map.clearOverlays();
  		var marker = new BMap.Marker(new BMap.Point(e.point.lng,  e.point.lat));
  		map.addOverlay(marker); 
  		document.getElementById("mapaddlng").value=e.point.lng;
  		document.getElementById("mapaddlat").value=e.point.lat;
  	    }
  	});