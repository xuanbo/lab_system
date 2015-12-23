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
<link rel="stylesheet" type="text/css" href="assets/my/score/list.css">

<title>成绩管理</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>
    
    <div class="labActivityList" data-teacherid="${TEACHERID }">
        <button class="btn btn-default" onclick="window.history.back()">返回</button>
        <c:if test="${empty pages.getList() }">
            <p>还没有信息 <a href="teacher/${TEACHERID }/labActivity/state/end">点我去评分！</a></p>
        </c:if>
      
        <c:if test="${not empty pages.getList() }">
            <h4 style="text-align: center;">实验记录</h4>
            <table class="table table-hover table-bordered table-condensed">
                <tr class="success">
                    <th>编号</th>
                    <th>实验开始时间</th>
                    <th>实验结束时间</th>
                    <th>实验科目</th>
                    <th>专业班级</th>
                    <th>成绩管理</th>
                </tr>
                <c:forEach items="${pages.getList() }" var="e" varStatus="s">
                    <tr>
                        <td>${s.getCount() }</td>
                        <td>${e.getBegin() }</td>
                        <td>${e.getEnd() }</td>
                        <td>${e.getCourse().getName() }</td>
                        <td>${e.getMajorClass().getName() }</td>
                        <td>
                            <c:if test="${not empty e.getScores() }">
                                <a class="glyphicon glyphicon-search" href="teacher/labActivity/${e.getId() }/score">查看此次成绩</a>
                            </c:if>
                            <c:if test="${empty e.getScores() }">
                                <a class="glyphicon glyphicon-pencil" href="teacher/labActivity/${e.getId() }/giveScore">还未评分，点我去评分哦</a>
                            </c:if>
                        </td>
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
        		var teacherid = $('.labActivityList').data("teacherid");
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
        				   url: "teacher/"+teacherid+"/labActivity/scoreByPage",
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