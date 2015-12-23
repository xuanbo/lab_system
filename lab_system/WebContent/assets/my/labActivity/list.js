;(function($){
	
	$(function(){
		$('#taskOne').addClass('active');
		
		/*
		 * 预约通过处理提交事件
		 */
		$('#stateOk').on('click',function(){
			var id = $(this).data('id');
			var data = {
					id: id,
					state: "预约成功"
			};
			data = JSON.stringify(data);
			$.ajax({
				type: "POST",
				contentType: "application/json",//必须有
	            dataType: "json",//返回值，不必须
				url: "labAdmin/labActivity/valid",
				data: data,
				success: function(msg){
					if(msg){
						window.location.reload(true);
					}else{
						alert("处理失败，请稍后重试！");
					}					
				}	
			});
		});
		
		/*
		 * 预约失败处理提交事件
		 */
		$('#stateFail').on('click',function(){
			var id = $(this).data('id');
			var data = {
					id: id,
					state: "预约失败"
			};
			data = JSON.stringify(data);
			$.ajax({
				type: "POST",
				contentType: "application/json",//必须有
	            dataType: "json",//返回值，不必须
				url: "labAdmin/labActivity/valid",
				data: data,
				success: function(msg){
					if(msg){
						window.location.reload(true);
					}else{
						alert("处理失败，请稍后重试！");
					}					
				}	
			});
		});
		
		
		/*
		 * 分页
		 */
		var state = $('.labActivityList').data("state");
		var url;
		if(state == "预约待处理"){
			url = 'labAdmin/labActivity/list/byPage';
		}else if(state == "预约成功"){
			url = 'labAdmin/labActivity/stateOk/byPage';
		}else if(state == "预约失败"){
			url = 'labAdmin/labActivity/stateFail/byPage';
		}else{
			url = 'labAdmin/labActivity/stateEnd/byPage';
		}
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
				   url: url,
				   data: data,
				   success: function(msg){
					   //刷新整个body
				       $('body').html(msg);
				   }    			   
			   });
		   });
	});
		
})(jQuery);