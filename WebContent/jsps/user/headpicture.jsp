<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>摄影点</title>
<link rel="stylesheet" href="<c:url value='/jsps/css/user/style.css'/>" type="text/css" />
<script type="text/javascript" src="<c:url value='/jsps/js/user/jquery-1.11.1.min.js'/>"></script> 
<script type="text/javascript" src="<c:url value='/jsps/js/user/a.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jsps/js/user/cropbox.js'/>"></script>
</head>
<body>
<div class="croppedbody">
<div class="container">
  <div class="imageBox">
    <div class="thumbBox"></div>
    <div class="spinner" style="display: none">Loading...</div>
  </div>
  <div class="action"> 
    <!-- <input type="file" id="file" style=" width: 200px">-->
    <div class="new-contentarea tc"> <a href="javascript:void(0)" class="upload-img">
      <label for="upload-file">上传图像</label>
      </a>
      <input type="file" class="" name="upload-file" id="upload-file" />
    </div>
    <input type="button" id="btnCrop"  class="Btnsty_peyton" value="裁切">
    <input type="button" id="btnZoomIn" class="Btnsty_peyton" value="+"  >
    <input type="button" id="btnZoomOut" class="Btnsty_peyton" value="-" >
  </div>
  <div class="cropped"></div>
</div>
</div>
<script type="text/javascript">
$(window).load(function() {
	var options =
	{
		thumbBox: '.thumbBox',
		spinner: '.spinner',
		imgSrc: '/images/avatar.png'
	}
	var cropper = $('.imageBox').cropbox(options);
	$('#upload-file').on('change', function(){
		var reader = new FileReader();
		reader.onload = function(e) {
			options.imgSrc = e.target.result;
			cropper = $('.imageBox').cropbox(options);
		}
		reader.readAsDataURL(this.files[0]);
		this.files = [];
	})
	$('#btnCrop').on('click', function(){
		var img = cropper.getDataURL();
		$('.cropped').html('');
		$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
		$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
		$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
		
		$.ajax({
			url:"/photography/modifyHeadPicture",//要请求的servlet
			data:{headpictureString:img},//给服务器的参数
			type:"POST",
			dataType:"html",
			async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
			cache:false,
			success:function(result) {
				 alert("修改成功"); 
				//self.location='<c:url value='/jsps/user/userManager.jsp'/>'; 
				parent.location='<c:url value='/jsps/user/userManager.jsp'/>'; 
			},
			error:function() {  
		       alert("失败");  
		    }  
		});
		

	})
	$('#btnZoomIn').on('click', function(){
		cropper.zoomIn();
	})
	$('#btnZoomOut').on('click', function(){
		cropper.zoomOut();
	})
});

</script>

</body>
</html>