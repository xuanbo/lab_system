(function($){
	
	$(function(){
		$('#three').addClass('active');
		
		$('#uploader').fadeOut();
		$('#addTeachResource').fadeOut();
		
		/*
		 * 教学计划提交
		 */
		$('#add').on('click',function(){
			var majorClass = $('#majorClass').val();
			var name = $('#name').val();
			var teacherId = $('#teachProgram').data("id");
			
			if(majorClass == '' || name == ''){
				
			}else{
				//$('#uploader').fadeIn();
				var teachProgramData = {
						majorClass: majorClass,
						name: name,
						tId: teacherId
				};
				teachProgramData = JSON.stringify(teachProgramData);			
				
				$.ajax({
					type: "POST",
					contentType: "application/json",//必须有
		            dataType: "json",//返回值，不必须
					url: "teacher/teachProgram/add",
					data: teachProgramData,
					success: function(msg){
						if(msg.flag){
							var teachprogramid = msg.teachProgramId;
							$('#teachProgram').data("teachprogramid", teachprogramid);
							alert(teachprogramid);
							$('#msg').text('教学计划上传成功，你可以选择是否上传教学资源');
							$('#add').fadeOut();
							$('#addTeachResource').fadeIn();
						}else{
							alert("教学计划上传失败，请稍后再试");
						}
					}
			   });
			}
		});
		
		$('#addTeachResource').on('click',function(){
			$('#uploader').fadeIn();
		});
		
		
		/*
		 * 文件上传 
		 */
		var uploader = WebUploader.create({
			pick: {
                id: '#picker',
            },        
            
            //文件在上传时也有个id，formData里的附加参数不能为id，重要的事说三遍！！！
            formData: {
            	teachProgramId: 123
            },
            
			// 选完文件后，是否自动上传。
		    //auto: true,
		    
		    // swf文件路径
		    swf: '/assets/webuploader/Uploader.swf',

		    // 文件接收服务端。
		    server: 'http://localhost:8080/lab_system/teacher/teachResource/add',

		    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		    resize: false,
		    
		    fileNumLimit: 5,  
		});

		// 当有文件被添加进队列的时候
		uploader.on( 'fileQueued', function( file ) {
			var $list = $('#thelist');
		    $list.append( '<div id="' + file.id + '" class="item">' +
		        '<span class="info">' + file.name + '</span>' +
		        '<span class="state" style="margin-left:100px;">等待上传...</span>' +
		    '</div>' );
		});

		// 文件上传过程中创建进度条实时显示。
		uploader.on( 'uploadProgress', function( file, percentage ) {
		    var $li = $( '#'+file.id ),
		        $percent = $li.find('.progress .progress-bar');

		    // 避免重复创建
		    if ( !$percent.length ) {
		        $percent = $('<div class="progress progress-striped active">' +
		          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
		          '</div>' +
		        '</div>').appendTo( $li ).find('.progress-bar');
		    }

		    $li.find('span.state').text('上传中');

		    $percent.css( 'width', percentage * 100 + '%' );
		});

		uploader.on( 'uploadSuccess', function( file ) {
		    $( '#'+file.id ).find('span.state').text('已上传');
		});

		uploader.on( 'uploadError', function( file ) {
		    $( '#'+file.id ).find('span.state').text('上传出错');
		});

		uploader.on( 'uploadComplete', function( file ) {
		    $( '#'+file.id ).find('.progress').fadeOut();
		});
		
		
		/*
		 * 由于未设置选择文件后自动上传，所以需要调用uploader.upload()进行文件上传;
		 */
		$('#ctlBtn').on('click',function(){
			var teachprogramid = $('#teachProgram').data("teachprogramid");
			//文件上传时的附加formData
			uploader.options.formData.teachProgramId = teachprogramid;
			uploader.upload();
		})

	});
	
})(jQuery)