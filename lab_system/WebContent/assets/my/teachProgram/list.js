;(function($){
	
	$(function(){
		$('#three').addClass('active');
		/*
		 * 添加教学资源
		 */
		$('.addTeachProgram').on('click',function(){
			var teachProgramId = $(this).data("id");
			
			$('#addTeachProgramModal').modal({backdrop: 'static', keyboard: false});
			
			/*
			 * 文件上传
			 */
			
			$('#file').on('click',function(){
				$('#fileupload').click();
			});		
			$('#fileupload').fileupload({
				dataType: 'json',
				//autoUpload: true,//是否自动上传
				url: 'teacher/teachResource/add?teachProgramId='+teachProgramId,
				maxNumberOfFiles : 1,
				//formData: {id:teachProgramId},//如果需要额外添加参数可以在这里添加
		        add: function (e, data) {		        	
		        	
		        	$('#showFileName span').text(data.files[0].name);
		        	
		        	/*
		        	 * 上传文件点击按钮
		        	 */
		        	$('#add').click(function() {
	                    data.submit();
	                });
		           
		        },	          
		        progressall: function (e, data) {
		            var progress = parseInt(data.loaded / data.total * 100, 10);
		            $('#progress .bar').css(
		                'width',
		                progress + '%'
		            );
		        },	        
		        done: function (e, data) {
		        	var name = $('#fileupload').val();
		        	//console.log(JSON.stringify(data.result));
		        	var e = data.result.ur;
		        	if(e == "null"){
		        		$('#warn').text('上传失败.');
		        	}else{
		        		$('#warn').text('上传成功!');
		        		
		        		$('#state').remove();
		        	}
		        	
		        }, 
		        
		    });		
		    
			$('#add').on('mouseover',function(){
				var fileName = $('#showFileName span').text();
				if(fileName == '请选择文件'){
					$('#add').addClass('disabled');
				}else{
					$('#add').removeClass('disabled');
				}
			});
		});
		
		
		
		$('#addReturn').on('click',function(){
			window.location.reload(true);
		});
		
		
		$('.show').on('click',function(){
			$(this).popover('toggle');
		});
		
		
		/*
		 * 分页
		 */
		var teacherid = $('.listDiv').data("teacherid");
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
				   url: "teacher/"+teacherid+"/teachProgram/listByPage",
				   data: data,
				   success: function(msg){
					   //刷新整个body
				       $('body').html(msg);
				   }    			   
			   });
		   });   
		
	});
	
})(jQuery);