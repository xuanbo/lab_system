;(function($){
	
	$(function(){
		
		/*
		 * 点击登录按钮
		 */
		$('.inputLogin').on('click', function(){
//			var msg = "";
//			if(validUsernameIsNull() == false){
//				msg = "用户名不能为空";
//				infoShow(msg);
//			}else{
//				if(validpasswordIsNull() == false){
//					msg = "密码不能为空";
//					infoShow(msg);
//				}else{
//					msg = "yes";
//					infoShow(msg);
//				}
//			}			
			if(validUsernameIsNull() == true && validpasswordIsNull() == true){
				
				var name = $('.inputUsername').val();
				var password = $('.inputPassword').val();
				var data = {
						name: name,
						password: password
				};
				data = JSON.stringify(data);
				$.ajax({
					type: "POST",
					contentType: "application/json",//必须有
		            dataType: "json",//返回值，不必须
					url: "validate",
					data: data,
					success: function(msg){
						if(msg){
							window.location.assign('home');
						}else{
							var m = "用户名不存在或密码错误！";
							infoShow(m);
						}
					}
			   });
			}
		});
		
		/*
		 * 点击警告框关闭按钮
		 */
		$('#infoRemove').on('click', function(){
			infoClose();
		});
		
		/*
		 * 显示警告框
		 */
		function infoShow(msg){
			$('#info').css({
				'display': 'block'
			});
			$('#warnInfo').text(msg);
		};
		/*
		 * 关闭警告框
		 */
		function infoClose(){
			$('#info').css({
				'display': 'none'
			});
		};
		
		/*
		 * 验证用户名是否为空
		 */
		function validUsernameIsNull(){
			var username = $('.inputUsername').val();
			if(username == ""){
				var msg = "用户名不能为空！";
				infoShow(msg);
				return false;
			}else{
				return true;
			}
		};
		/*
		 * 验证密码是否为空
		 */
		function validpasswordIsNull(){
			var password = $('.inputPassword').val();
			if(password == ""){
				var msg = "密码不能为空！";
     			infoShow(msg);
				return false;
			}else{
				return true;
			}
		};
	});
	
})(jQuery);