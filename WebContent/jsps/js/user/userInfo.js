$(function() {
	
	
	$("#modifyForm").submit(function(){
		var bool = true;
		if(!validateLoginname()) {
			bool = false;
		}
		return bool;
	});
			
    	$(".nickname").blur(function() {
         	eval(validateLoginname());//执行函数调用
    	});
    	
    	/*
    	 * 3. 输入框得到焦点隐藏错误信息
    	 */
    	$(".nickname").focus(function() {
    		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
    		$("#" + labelId).text("");//把label的内容清空！
    		showError($("#" + labelId));//隐藏没有信息的label
    	});
    	
});

function validateLoginname() {
	var id = "nicknameInput";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("用户名不能为空！");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 3 || value.length > 20) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("用户名长度必须在3 ~ 20之间！");
		showError($("#" + id + "Error"));
		false;
	}
	/*
	 * 3. 是否注册校验
	 */
	$.ajax({
		url:"/photography/ajaxValidateNickname",//要请求的servlet
		data:{nickname:value},//给服务器的参数
		type:"POST",
		dataType:"html",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(result=="fail"){//如果校验失败
				$("#" + id + "Error").text("用户名已被注册！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}

