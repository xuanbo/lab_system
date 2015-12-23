;(function($){
	
	$(function(){
		$('#three').addClass('active');
		
		var img0 = new Image();
	    var img1 = new Image();
	    var img2 = new Image();
		img0.src = "resource/images/bg1.jpg";
		img1.src = "resource/images/bg2.jpg";
		img2.src = "resource/images/bg3.jpg";
		var i = 1;
		setBg(3);
		setInterval(function(){           
			setBg(i);
		    i ++ ;
		    
			if(i>3){
				i = 1;
			}
		}, 7000);
		
		function setBg(i){
			$('body').css({
				"background-image": "url('resource/images/bg"+ i +".jpg')"
			});
		};
	});
	
})(jQuery);