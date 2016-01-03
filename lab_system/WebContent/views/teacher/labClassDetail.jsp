<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>     
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">

<script type="text/javascript" src="assets/jquery/jquery.min.js"></script>

<!-- bootstrap js -->
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>

<!-- labClassDetail css -->
<link rel="stylesheet" type="text/css" href="assets/my/teacher/labClassDetail.css">

<title>实验室详情</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <div class="title">
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <span>实验室${labClass.getName() }的详情</span>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <button class="btn btn-default" onclick="window.history.back()">返回上一页</button>
   </div>
   
   <div class="listDiv" data-labclassid="${labClass.getId() }">
       <c:if test="${empty pages.getList() }">
           <p>暂无信息</p>
       </c:if>
       
       <c:if test="${not empty pages.getList() }">
          <table class="table table-hover table-bordered table-condensed">
              <tr class="info">
                  <th>预约状态</th>
                  <th>开始时间</th>
                  <th>结束时间</th>
                  <th>课程名称</th>
                  <th>专业班级</th>
                  <th>预约的老师名</th>
              </tr>
                 
              <c:forEach items="${pages.getList() }" var="e">
                  <tr>
                      <td>${e.getState() }</td>
                      <td>${e.getBegin() }</td>
                      <td>${e.getEnd() }</td>
                      <td>${e.getCourse().getName() }</td>
                      <td>${e.getMajorClass().getName() }</td>
                      <td>${e.getTeacher().getUser().getName() }</td>                 
                  </tr>          
              </c:forEach>        
          </table>
          
       </c:if>
       
       <!-- 分页 jsp -->
       <c:import url="../template/page.jsp"></c:import>
       
   </div>
   
   <script type="text/javascript">
       (function($){
    	   $(function(){
    		   $('#three').addClass('active');
    		   
    		   /*
    			 * 分页
    			 */
    			var id = $('.listDiv').data("labclassid");
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
    					   url: "teacher/labClassByPage?id="+id,
    					   data: data,
    					   success: function(msg){
    						   //刷新整个body
    					       $('body').html(msg);
    					   }    			   
    				   });
    			   });   
    	   });
       })(jQuery)
   </script>
</body>
</html>