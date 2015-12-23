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

<!-- labClassList css -->
<link rel="stylesheet" type="text/css" href="assets/my/teacher/labClassList.css">

<title>教学资源</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>

    <div class="listDiv" data-role="${Role }">
        <button class="btn btn-default" onclick="window.history.back()">返 回</button>
      
        <c:if test="${not empty teachResources }">
           <p>教学资源</p>
           <table class="table table-hover table-bordered table-condensed">
               <tr class="info">
                   <th>文件名称</th>
                   <th>管理</th>
               </tr>
               <c:forEach items="${teachResources }" var="e">
                   <tr>
                       <td>${e.getName() }</td>
                       <td>
                           <a href="teacherProgram/teachResource/download?fileName=${e.getUrl() }" class="glyphicon glyphicon-save">下载</a>
                       </td>
                   </tr>
               </c:forEach>
           </table>
        </c:if>
    </div>
    
    <script type="text/javascript">
    
        (function($){
        	
        	$(function(){
        		var roleName = $('.listDiv').data("role");
        		if(roleName == "教师"){
        			$('#three').addClass('active');
        		}else if(roleName == "学生"){
        			$('#two').addClass('active');
        		}else{
        			
        		}
        		
        	});
        	
        })(jQuery); 
    
    </script>
</body>
</html>