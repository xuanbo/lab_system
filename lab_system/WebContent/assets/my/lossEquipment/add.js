;(function($){
	
	$(function(){
		$('#lossEquipmentSubmit').on('click',function(){
			if($(this).hasClass('disabled')){
				return false;
			}else{
				clear();
				
				var lossEquipmentFlag = lossNumberValid();
				if(lossEquipmentFlag == 0){
					
				}else{
					$('#lossEquipmentSubmit').addClass('disabled');
					$('.msg').text('正在提交，请稍等...');
					
					/*
					 * 将每一条耗材信息存入数组
					 */
					var lossEquipmentArray = addLossEquipment();
					
					var labActivityId = $('.lossEquipmentList').data("labactivityid");
					
					var data = {
							labActivityId: labActivityId,
							lossEquipmentArray: lossEquipmentArray
					}
					data = JSON.stringify(data);
					$.ajax({
						type: "POST",
						contentType: "application/json",//必须有
			            dataType: "json",//返回值，不必须
						url: "teacher/labActivity/lossEquipment",
						data: data,
						success: function(msg){
							if(msg){
								var e = "实验器材损耗提交成功！";

								//成功提醒
								$('#info').text(e);
								$('#remindModalBody').css({
									"background-color": "#8080ff",
								    "height": "75px"
							    });
								$('#info').css({
							        "color": "#000000",
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
		 * 验证评价 lossEquipmentFlag=1，代表所有的不为空
		 */
		var lossNumberValid = function(){
			var lossEquipmentFlag = 1;
			$('.equipment').find('.lossNumber').each(function(){
				if($(this).val() == ''){
					$(this).css({
			    		"border-color": "red"
			    	});
					lossEquipmentFlag = 0;
				}
			});
			return lossEquipmentFlag;
		};
		
		/*
		 * 将器材耗材添加到数组
		 */
		var addLossEquipment = function(){
			var lossEquipmentArray = new Array();
			
			$('.equipment').each(function(){
				var id = $(this).data("id");
				var lossNumber = $(this).find('.lossNumber').val();
				var data = {
						id: id,
						lossNumber: lossNumber,
				}
				lossEquipmentArray.push(data);
			});
			return lossEquipmentArray;
		};
		
		/*
		 * 清空input输入为空是的提醒信息
		 */
		var clear = function(){
			$('.equipment').find('.lossNumber').each(function(){				
			    $(this).css({
			    	"border-color": "#ffffff"
			    });
			});
		};
		
		/*
		 * 关闭提醒框
		 */
	    $('.close').on('click',function(){
	    	var teacherId = $('.lossEquipmentList').data("teacherid");
		    window.location.assign('/lab_system/teacher/' + teacherId + '/labActivity/state/end');
		});
	});
	
})(jQuery);