;(function($){
	
	$(function(){
		setInterval(function(){
			var date = new Date();
			$('#date').find('li').find('.showdata').text(date.getFullYear()+'/'+date.getMonth()+'/'+date.getDate()+'  '+
					date.getHours()+':'+date.getMinutes()+':'+date.getSeconds());
		}, 1000);
	});
	
})(jQuery);