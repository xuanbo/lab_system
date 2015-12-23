(function($){
	
	$(function(){
		$('#four').addClass('active');
		/**
		 * labAdmin 下的导航栏隐藏和显示事件
		 */
		$('#hide').on('click',function(){
			var flag = $(this).data("flag");
			if(flag == '0'){
				$(this).parent().prevAll().show();
				$(this).data("flag","1");
			}else{
				$(this).parent().prevAll().hide();
				$(this).data("flag","0");
			}			
		});		
		
	});
	
})(jQuery)