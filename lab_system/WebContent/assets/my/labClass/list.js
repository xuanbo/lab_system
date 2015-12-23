;(function($){
	$(function(){
		$('#taskTwo').addClass('active');
		
		/**
		 * 新增实验室弹出modal事件
		 */
		$('#addLabClass').on('click',function(){
			$('#addLabClassModal').modal({backdrop: 'static', keyboard: false});
		});
		
		/**
		 * 新增实验室确定事件
		 */
		$('#addSubmit').on('click',function(){
			var name = $('#name').val();
			if(name == ''){
				$('#name').css({
					'border-color': 'red'
				});
				setTimeout(function(){
					$('#name').css({
						'border-color': 'gray'
					});
				},1000);
			}else{
				$.ajax({
					type: "POST",
					contentType: "application/json",//必须有
		            dataType: "json",//返回值，不必须
					url: "labClass/add?name="+name,
					success: function(msg){
						if(msg){
							var e = "实验室新增成功！";
							closeAddLabClassModal();

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
							var e = "该实验室已存在，请勿重新添加！";
							closeAddLabClassModal();
							
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
		 * 关闭新增实验室modal
		 */
		function closeAddLabClassModal(){
			$('#addReturn').click();
		};
		
		/**
		 * 关闭新增实验室是否成功提醒后，重新载入该页面
		 */
	    $('.close').on('click',function(){
	    	window.location.reload(true);
	    });
		
	    
	    
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
				   url: "labAdmin/labClass/listByPage",
				   data: data,
				   success: function(msg){
					   //刷新整个body
				       $('body').html(msg);
				   }    			   
			   });
		   });
	});
})(jQuery);