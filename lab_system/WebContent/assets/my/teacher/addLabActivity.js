;(function($){
	
	$(function(){
		var list = new Array();
		
		$('#three').addClass('active');
		$('#add').addClass('btn-primary');
	
		/*
		 * 选择实验器材input每次改变后记录需要的实验器材
		 */
		$('#equipment').on('change',function(){
			var name = $(this).val();
			if(name !== '请选择：'){
				setEquipment(name);
			}
			
		});
		
		/*
		 * 放将所需的实验器材入数组，并去掉重复
		 */
		function setEquipment(name){
			var isRepeat = false;
			
			for(var i = 0; i < list.length; i++){
				if(list[i] === name){
					isRepeat = true;
				}
			}
			if(isRepeat == false || list.length == 0){
				var span = $('<span class="spanClose glyphicon glyphicon-remove"></span>');				
				span.text(name);
				span.appendTo($('#equipmentList'));
				
				list.push(name);

			}
		};
		
		/*
		 * 由于span动态生成，将click时间委托为#equipmentList
		 */
		$('#equipmentList').delegate('span.spanClose','click',function(){
			var name = $(this).text();
			for(var i = 0; i < list.length; i++){
				if(list[i] === name){
					/*
					 * list删除下标为i的元素
					 * 如果删除下标为0的元素，那么shift（）
					 * 如果删除下标为i（i>0），那么splice(i, i);
					 */					
					if(i == 0){
						list.shift();
					}else{
						list.splice(i, i);
					}
				}
			}			
			/*
			 * 清空实验室记录的显示
			 */
			$(this).remove();		
		});
		
		
		/*
		 * 新增预约提交按钮点击事件
		 */
		$('#btnAdd').on('click',function(){
			/*
			 * 判断按钮是否被禁用，防止再次提交
			 */
			if($(this).hasClass('disabled')){
				return false;
			}else{
				$('.msg').empty();
				
				/*
				 * 获取数据
				 */
				var begin = $('#begin').val();
				var end = $('#end').val();
				var majorClass = $('#majorClass').val();
				var course = $('#course').val();
				var labClass = $('#labClass').val();
				
				/*
				 * 对表单进行验证
				 */
				if(begin == '' || end == '' || list.length == 0){
					if(begin == ''){
						$('.msg').text("请输入开始时间");
						return false;
					}
					if(end == ''){
						$('.msg').text("请输入结束时间");
						return false;
					}
					if(ckdate(begin,end) == false){
						$('.msg').text("请输入正确的开始时间和结束时间");
						return false;
					}
					if(list.length == 0){
						$('.msg').text("请输入选择所需的实验器材");
						return false;
					}
					
				}else{
					$('#btnAdd').addClass('disabled');
					
					var data = {
							begin: begin,
							end: end,
							majorClass: majorClass,
							course: course,
							labClass: labClass,
							equipments: list
					}
					data = JSON.stringify(data);
					alert(data);
					$.ajax({
						type: "POST",
						contentType: "application/json",//必须有
			            dataType: "json",//返回值，不必须
						url: "teacher/labActivity/add",
						data: data,
						success: function(msg){
							if(msg){
								var e = "实验预约申请已提交！";

								//新增成功提醒
								$('#info').text(e);
								$('#remindModalBody').css({
								    "height": "75px"
							    });
								$('#info').css({
							        "color": "#000000",
								    "text-align": "center",
									"font-size": "30px"
								});
							    $('#waringModal').modal({backdrop: 'static', keyboard: false});
							}else{
								var e = "实验预约申请提交失败，请稍后再试！";
								
								//新增失败提醒
								$('#info').text(e);
								$('#remindModalBody').css({
								    "height": "75px",
								    "background-color": "#ff0000"
							    });
								$('#info').css({
							        "color": "#ffffff",
								    "text-align": "center",
									"font-size": "30px"
								});
							    $('#waringModal').modal({backdrop: 'static', keyboard: false});
							}
						}
					});
				}
			}
			

		});
		
		/*
		 * 判断开始时间是否大于结束时间
		 */
		function ckdate(starttime,endtime) {
            var start = new Date(starttime.replace("-", "/").replace("-", "/"));
            var end = new Date(endtime.replace("-", "/").replace("-", "/"));
            if (end < start) {
                return false;
            }
            else {
                return true;
            }

        };
        
		/**
		 * 关闭实验预约是否成功提醒后，重新载入该页面
		 */
	    $('.close').on('click',function(){
	    	window.location.reload(true);
	    });
	    
	    
	     
	});
	
})(jQuery);