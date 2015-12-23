<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 尾部样式css -->
<link rel="stylesheet" type="text/css" href="assets/my/template/tail.css">

    <div id="tail">
       @2015&nbsp;&nbsp;四大名捕&nbsp;&nbsp;&nbsp;&nbsp;版权所有，翻版必究&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span></span>
    </div>
    
    <script type="text/javascript">
       ;(function($){
    	   
    	   $(function(){
    		   var date = new Date();
    		   $('#tail').find('span').text(date.getFullYear()+'/'+date.getMonth()+'/'+date.getDate());
    	   });
    	   
       })(jQuery);
    </script>