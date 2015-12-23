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
<link rel="stylesheet" type="text/css" href="assets/my/labActivity/list.css">

<!-- list js -->
<script type="text/javascript" src="assets/my/labActivity/list.js"></script>
<title>所需实验器材</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <!-- 引入实验室管理员的任务导航栏 jsp -->
   <c:import url="../labAdmin/navigate.jsp"></c:import>
   
   <!-- 引入实验室预约处理 jsp -->
   <c:import url="taskBar.jsp"></c:import>
   
   <div class="labActivityList">
       <c:if test="${empty equipments }">
           <p>暂无信息</p>
       </c:if>
       
       <c:if test="${not empty equipments }">
           <div class="title">
               所需器材详情&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <button class="btn btn-default" onclick="window.history.back()">返&nbsp;回</button>   
           </div>
           <table class="table table-hover table-bordered table-condensed">
             <tr class="info">
                 <th>实验器材</th>
                 <th>类型</th>
                 <th>器材数目</th>
             </tr>
             <c:forEach items="${equipments }" var="e">
                 <tr>
                     <td>${e.getName() }</td>
                     <td>${e.getStyle() }</td>
                     <td>${e.getTotalNumber() }</td>                     
                 </tr>
             </c:forEach>
           </table>
       </c:if>
   </div>
</body>
</html>