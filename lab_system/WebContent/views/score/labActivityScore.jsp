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

<!-- labActivityScore css -->
<link rel="stylesheet" type="text/css" href="assets/my/score/labActivityScore.css">

<title>评分页面</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>  
    
    <!-- 关于data-*属性，*是小写，如果是Id， 会变成id -->
    <div class="scoreList" data-labActivityId="${labActivityId }">       
        <c:if test="${not empty scores }">
           <button class="btn btn-default" onclick="window.history.back()">返回</button>
           <p>实验评分结果如下</p>
           <table class="table table-hover table-bordered table-condensed">
             <tr class="info">
                 <th>编号</th>
                 <th>学号</th>
                 <th>姓名</th> 
                 <th>分数</th>
                 <th>表现</th> 
                 <th>管理<span style="color: red;">目前暂未允许修改实验成绩</span></th>             
             </tr>
             <c:forEach items="${scores }" var="e" varStatus="s">
                 <tr>
                     <td>${s.getCount() }</td>
                     <td>${e.getStudent().getStudentNumber() }</td>
                     <td>${e.getStudent().getName() }</td>   
                     <td>${e.getGrade() }</td>
                     <td>${e.getMark() }</td>  
                     <td>
                         <span class="glyphicon glyphicon-tag">修改</span>
                     </td>             
                 </tr>
             </c:forEach>
         </table>
       </c:if>
    </div>
    
    <script type="text/javascript">
        (function($){
        	$(function(){
        		$('#three').addClass('active');
        	});
        })(jQuery)
    </script>
</body>
</html>