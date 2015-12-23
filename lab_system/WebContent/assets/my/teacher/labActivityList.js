;(function($){
 
	$(function(){
		$('#three').addClass('active');
		/*
		 * 根据所在页面设置相应的按钮响应
		 */
		var title = $('title').text();
		var teacherid = $('.labActivityList').data("teacherid");
		var url;
		if(title == '预约待处理'){
			$('#process').addClass('btn-primary');
			url = 'teacher/'+teacherid+'/labActivity/state/process';
		}else if(title == '预约失败'){
			$('#fail').addClass('btn-primary');
			url = 'teacher/'+teacherid+'/labActivity/state/fail';
		}else if(title == '预约成功'){
			$('#success').addClass('btn-primary');
			url = 'teacher/'+teacherid+'/labActivity/state/success';
		}
		
		 /*
		 * 分页
		 */
		var teacherid = $('.labActivityList').data("teacherid");
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