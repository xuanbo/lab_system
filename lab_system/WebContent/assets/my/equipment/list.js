(function($){
	
	$(function(){
		$('#taskThree').addClass('active');
		$('.list').addClass('btn-primary');
		
		/*
		 * 新增实验器材
		 */
		$('.add').on('click',function(){
			$('#addEquipmentModal').modal({backdrop: 'static', keyboard: false});
		});
		
		/**
		 * 新增实验器材确定事件
		 */
		$('#addSubmit').on('click',function(){
			var name = $('#name').val();
			var style = $('#style').val();
			var totalNumber = $('#totalNumber').val();
			
			if(name == '' || style == '' || totalNumber == ''){
				if(name == ''){
					$('#name').css({
						'border-color': 'red'
					});
					setTimeout(function(){
						$('#name').css({
							'border-color': 'gray'
						});
					},1000);
				};
				
				if(style == ''){
					$('#style').css({
						'border-color': 'red'
					});
					setTimeout(function(){
						$('#style').css({
							'border-color': 'gray'
						});
					},1000);
				};
				
				if(totalNumber == ''){
					$('#totalNumber').css({
						'border-color': 'red'
					});
					setTimeout(function(){
						$('#totalNumber').css({
							'border-color': 'gray'
						});
					},1000);
				};
				
			}else{
				var data = {
						name: name,
						style: style,
						totalNumber: totalNumber
				};
				data = JSON.stringify(data);
				$.ajax({
					type: "POST",
					contentType: "application/json",//必须有
		            dataType: "json",//返回值，不必须
					url: "labAdmin/equipment/add",
					data: data,
					success: function(msg){
						if(msg){
							var e = "实验器材新增成功！";
							closeAddEquipmentModal();

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
							var e = "该实验器材已存在，请勿重新添加！";
							closeAddEquipmentModal();
							
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
		});
		
		/**
		 * 关闭新增 modal
		 */
		function closeAddEquipmentModal(){
			$('#addReturn').click();
		};
		
		/**
		 * 关闭新增实验室是否成功提醒后，重新载入该页面
		 */
	    $('.close').on('click',function(){
//	    	window.location.reload(true);
	    	parent.location.reload();
	    });
	    
	    
	    /**
	     * 实验器材添加事件
	     */
	    $('.puls').on('click',function(){
	    	var id = $(this).data("id");
	    	$('#pulsModal').modal({backdrop: 'static', keyboard: false});
	    	$('#pulsModal').data("id",id);
	    });
	    $('#pulsSubmit').on('click',function(){
	    	var id = $('#pulsModal').data("id");
			var number = $('#number').val();
			if(number == ''){
				$('#number').css({
					'border-color': 'red'
				});
				setTimeout(function(){
					$('#number').css({
						'border-color': 'gray'
					});
				},1000);
			}else{
				var data = {
						id: id,
						number: number
				};
				data = JSON.stringify(data);
				$.ajax({
					type: "POST",
					contentType: "application/json",//必须有
		            dataType: "json",//返回值，不必须
					url: "labAdmin/equipment/puls",
					data: data,
					success: function(msg){
						if(msg){
							var e = "修改成功！";
							closePulsModal();

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
							var e = "修改失败，请稍后再试";
							closePulsModal();
							
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
	    });
	    
	    function closePulsModal(){
	    	$('#pulsReturn').click();
	    };
	    
	    
	    
	    /*
	     * 分页
	     */
	    $('.page a').on('click',function(){
			   var current = parseInt($('.current').text());
			   var totalPage = parseInt($('.totalPage').text());
			   var size = parseInt($('.size').text());
			   var state = $(this).text();
			   if(state == '首页'){
				   current = '1';
			   }else if(state == '上一页'){
				   current = current - 1;
			   }else if(state == '下一页'){
				   current = current + 1;
			   }else if(state == '尾页'){
				   current = totalPage ;
			   }
			   
			   var data = {
					current: current,
					size: size
			   };
			   data = JSON.stringify(data);
			   
			   $.ajax({
			       type: "POST",
				   contentType: "application/json",//必须有
	               dataType: "html",//返回值，不必须
				   url: "labAdmin/equipment/listByPage",
				   data: data,
				   success: function(msg){
					   //刷新整个body
				       $('body').html(msg);
				   }    			   
			   });
		   });
	});
	
})(jQuery)