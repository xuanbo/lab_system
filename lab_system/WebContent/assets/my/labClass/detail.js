;(function($){
	
	$(function(){
		$('#taskTwo').addClass('active');
		
		$('.labActivityState').on('change',function(){
			//获取实验室预约的状态信息
			var state = $(this).val();
			alert(state);
			var id = $(this).data("id");
			if(state == '预约待处理'){
				state = 'list';
			}else if(state == '预约成功'){
				state = 'stateOk';
			}else if(state == '预约失败'){
				state = 'stateFail';
			}else{
				state = 'stateEnd';
			}
			var href = "labClass/search?id="+id+'&state='+state;
			$('#search').attr('href',href);
		});
		
		
		/*
	     * 分页
	     */
		var labClassId = $('.labActivityState').data("id");
	    $('.page a').on('click',function(){
	    	   var state = $('.listDiv').data("labactivitystate");	    	   
	    	   if(state == 'all'){
	    		   url = 'labClassByPage?id=' + labClassId;
	    	   }else{
	    		   url = 'labClass/searchByPage?id=' + labClassId + '&state=' + state;
	    	   }
	    		   
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