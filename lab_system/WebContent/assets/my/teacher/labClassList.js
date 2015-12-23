;(function($){
	$(function(){
		$('#three').addClass('active');	
		
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
				   url: "teacher/labClass/listByPage",
				   data: data,
				   success: function(msg){
					   //刷新整个body
				       $('body').html(msg);
				   }    			   
			   });
		   });   
	});
})(jQuery);