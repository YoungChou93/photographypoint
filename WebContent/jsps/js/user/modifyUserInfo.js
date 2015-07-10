$(function() {
	
	$("#modifyForm").submit(function(){
		$("#msg").text("");
		var bool = true;
		if(!validateLoginname())
		{

			bool = false;
		}
		return bool;
	});
	
	$(".nickname").focus(function() {
		$("#nicknameError").text("");//把label的内容清空！
	});
});


function validateLoginname() {
	
	var id = "nickname";
	var bool=true;
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
		$("#" + id + "Error").text("不能为空");
		//showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 2. 长度校验
	 */
	if(value.length < 2 || value.length > 12) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("长度不合法");
		//showError($("#" + id + "Error"));
		return false;
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
				$("#" + id + "Error").text("已存在！");
				
				bool=false;
				
			}
		}
	});
	return bool;
}