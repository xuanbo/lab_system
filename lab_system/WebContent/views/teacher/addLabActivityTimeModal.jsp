<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="assets/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript" src="assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
        
        <!-- 选择实验时间 -->
        <div class="form-group row">
          <div class="col-md-2">
             <label class="control-label" for="begin">
                选择开始时间：
             </label>   
          </div>
          <div class="col-md-4">
              <input type="text" class="form-control" value="" id="begin" placeholder="请选择开始时间：" readonly>
          </div>
          
          <div class="col-md-2">
             <label class="control-label" for="end">
                选择结束时间：
             </label>   
          </div>
          <div class="col-md-4">
              <input type="text" class="form-control" value="" id="end" placeholder="请选择结束时间：" readonly>
          </div>
        </div>
	
<script type="text/javascript">
    ;(function(){
    	$(function(){
    	    $('#begin').datetimepicker({
    	    	language: 'zh-CN', //汉化 
    	    	autoclose:true, //选择日期后自动关闭
    	        format: 'yyyy-mm-dd hh:ii'
    	    });
    	    $('#end').datetimepicker({
    	    	language: 'zh-CN', //汉化 
    	    	autoclose:true, //选择日期后自动关闭
    	        format: 'yyyy-mm-dd hh:ii'
    	    });
    	});
    })(jQuery);		
</script>