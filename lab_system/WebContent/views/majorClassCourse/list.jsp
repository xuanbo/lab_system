<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>     
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">

<script type="text/javascript" src="assets/jquery/jquery.min.js"></script>

<!-- bootstrap js -->
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>

<!-- list css -->
<link rel="stylesheet" type="text/css" href="assets/my/majorClassCourse/list.css">

<title>教师授课信息</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>
    
    <div class="teacherInfoList" data-teacherid="${TEACHERID }">
        <c:if test="${empty pages.getList() }">
            <p>
                暂无授课信息              
            </p>         
        </c:if>
        <c:if test="${not empty pages.getList() }">
            <button class="btn btn-default" onclick="window.history.back()">返回</button>
            <p>我的授课信息</p>
            <table class="table table-hover table-bordered table-condensed">
                <tr class="info">
                    <th>所授科目</th>
                    <th>专业班级</th>                  
                 </tr>
                 <c:forEach items="${pages.getList() }" var="e">
                     <tr>
                         <td>${e.getCourseName() }</td>
                         <td>${e.getMajorClassName() }</td>
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
        		
        		var teacherid = $('.teacherInfoList').data("teacherid");
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
     				   url: "teacher/"+teacherid+"/majorClassCourse/listByPage",
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