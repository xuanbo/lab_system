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

<!-- labClassList css -->
<link rel="stylesheet" type="text/css" href="assets/my/teacher/labClassList.css">

<!-- labClassList js -->
<script type="text/javascript" src="assets/my/teacher/labClassList.js"></script>

<title>实验室查看</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <div class="listDiv">
      <button class="btn btn-default" onclick="window.history.back()">返 回</button>
      <p>
          实验室列表
      </p>
      <!-- 实验室为空 -->
      <c:if test="${empty pages.getList() }">
         <p>暂无实验室信息</p>
      </c:if>
      
      <!-- 实验室不为空 -->
      <c:if test="${not empty pages.getList() }">
         <table class="table table-hover table-bordered table-condensed">
             <tr class="info">
                 <th>实验室编号</th>
                 <th>实验室预约情况</th>
             </tr>
             <c:forEach items="${pages.getList() }" var="e">
                 <tr>
                     <td>${e.getName() }</td>
                     <td><a href="teacher/labClass?id=${e.getId() }">详情</a></td>
                 </tr>
             </c:forEach>
         </table>
      </c:if>
      
      <!-- 分页 jsp -->
      <c:import url="../template/page.jsp"></c:import>
      
   </div>
</body>
</html>