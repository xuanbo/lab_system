(function($){
	//载入完成后才会调用此方法，只能有一个load方法
	$(window).load(function(){
	    //载入完成后清空动画和遮罩层
		$('#load').empty();
	});
	
	$(function(){
		//jquery自定义类封装
		$.ShowLoading = function(){	
			$('.mask').css({
			    "width": getWidth(),
		        "height": getHeight(),
		        "z-index": "888"
	        });	
			
			var name = "载入动画";
			
			this.getName = function(){
				return name;
			};
			
			//this.function是公有方法，外部可以访问
			this.loading = function(arg){			
				if(arg == 'showLoading'){
					showMask();
		    	    showLoading();
		        }else if(arg == 'stopLoading'){
		        	stopLoading();
		        }else{
		        	
		        };
			};
			
			function showMask(){
				$('.mask').css({
				    "width": getWidth(),
			        "height": getHeight(),
			        "z-index": "888"
		        });	
			};
			
			function getWidth(){
			    return $(document).width();
		    };
		    function getHeight(){
			    return $(document).height();
		    };
		
		
		    function showLoading(){
		    	$('#load').html('<div class="mask"></div><div class="loading"><div class="one"></div><div class="two"></div><div class="three"></div><div class="four"></div><div class="five"></div></div>');
		        showMask();
		    };		    
		    function stopLoading(){
		    	$('#load').empty();
		    };
	    };
	});
	
	
})(jQuery)
