<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>摄影点</title>
     <link rel="stylesheet" href="jsps/css/index/lib/fontello.css" />
     <link rel="stylesheet" href="jsps/css/index/index.css" />
     <link rel="stylesheet" href="jsps/css/index/sidebar.css" />
    		
</head>
<body>

<div class="wrapper jsc-sidebar-content jsc-sidebar-pulled"  style="width:100%;height:100%;">
<a href="#" target="_top" class="icon-menu link-menu jsc-sidebar-trigger" style="position:absolute;z-index:10;top:3px;"></a>
<div style="width:100%;height:100%;">
 
<iframe frameborder="0" src="<c:url value='welcome.jsp'/>" name="main" style="width:100%;height:100%;"></iframe>

</div>
</div>

		<nav class="sidebar jsc-sidebar" id="jsi-nav" data-sidebar-options="">
		<div style="width:100%;height:100%;">
		<iframe frameborder="0" src="<c:url value='sidebar.jsp'/>" name="sidebar" style="width=100%;height:100%;"></iframe>
        </div>
        </nav>


		<script src="jsps/js/index/jquery.min.js"></script>
		
		<script src="jsps/js/index/sidebar.js"></script>
		
		
		<script>
			$('#jsi-nav').sidebar({
				trigger: '.jsc-sidebar-trigger',
				pullCb: function () { console.log('pull'); },
				pushCb: function () { console.log('push'); }
			});
		</script>
         

</body>
</html>