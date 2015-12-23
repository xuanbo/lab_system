;(function($){
	
	$(function(){
		$('#three').addClass('active');
		
		/*
		 * 评分提交事件
		 */
		$('#scoreSubmit').on('click',function(){
			if($(this).hasClass('disabled')){
				return false;
			}else{
				clear();
				var scoreFlag = scoreValid();
				var markFlag = markValid();
				if(scoreFlag == 0 || markFlag == 0){
					
				}else{
					$('#scoreSubmit').addClass('disabled');
					$('.msg').text('正在提交，请稍等...');
					var scoreArray = scoreAdd();
					
					var labActivityId = $('.scoreList').data("labactivityid");

					var data = {
							labActivityId: labActivityId,
							scoreArray: scoreArray
					}
					data = JSON.stringify(data);
					$.ajax({
						type: "POST",
						contentType: "application/json",//必须有
			            dataType: "json",//返回值，不必须
						url: "teacher/labActivity/giveScore",
						data: data,
						success: function(msg){
							if(msg){
								var e = "分数提交成功！";

								//成功提醒
								$('#info').text(e);
								$('#remindModalBody').css({
									"background-color": "#8080ff",
								    "height": "75px"
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
		 * 验证分数 scoreFlag=1，代表所有的不为空
		 */
		var scoreValid = function(){
			var scoreFlag = 1;
			$('.student').find('td').find('.score').each(function(){
				if($(this).val() == ''){
					$(this).css({
			    		"border-color": "red"
			    	});
					scoreFlag = 0;
				}
			});
			return scoreFlag;
		};
			
		/*
		 * 验证评价 markFlag=1，代表所有的不为空
		 */
		var markValid = function(){
			var markFlag = 1;
			$('.student').find('td').find('.mark').each(function(){
				if($(this).val() == ''){
					$(this).css({
			    		"border-color": "red"
			    	});
					markFlag = 0;
				}
			});
			return markFlag;
		};
		
		/*
		 * 清楚input为空提醒
		 */
		var clear = function(){
			$('.student').find('td').find('.score').css({
				"border-color": "#ffffff"
			});
			$('.student').find('td').find('.mark').css({
				"border-color": "#ffffff"
			});
		};
		
		/*
		 * 把所填写的成绩表单添加到数组
		 * return scoreArrwy
		 */
		var scoreAdd = function(){
			var scoreArray = new Array();
			$('.student').each(function(){
				var id = $(this).data("id");
				var score = $(this).find('.score').val();
				var mark = $(this).find('.mark').val();
				var data = {
						id: id,
						score: score,
						mark: mark
				}
				scoreArray.push(data);
			});
			return scoreArray;
		};
		
		/*
		 * 关闭提醒框
		 */
	    $('.close').on('click',function(){
	    	var teacherId = $('.scoreList').data("teacherid");
		    window.location.assign('/lab_system/teacher/' + teacherId + '/labActivity/state/end');
		});
	});
	
})(jQuery);