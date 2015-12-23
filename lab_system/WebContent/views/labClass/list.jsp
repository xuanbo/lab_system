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

<!-- list css -->
<link rel="stylesheet" type="text/css" href="assets/my/labClass/list.css">

<!-- list js -->
<script type="text/javascript" src="assets/my/labClass/list.js"></script>

<title>实验室查看</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <!-- 引入实验室管理员的任务导航栏 jsp -->
   <c:import url="../labAdmin/navigate.jsp"></c:import>
   
   <!-- 引入新增实验室modal jsp -->
   <c:import url="addLabClassModal.jsp"></c:import>
   
   <!-- 引入新增实验室成功或失败提醒modal jsp -->
   <c:import url="../template/remindModal.jsp"></c:import>
   
   <button id="addLabClass" class="btn btn-default glyphicon glyphicon-plus">添加实验室</button>
   
   <div class="listDiv">
      <!-- 实验室为空 -->
      <c:if test="${empty pages.getList() }">
         <p>还没有添加实验室 <a>点我添加实验室信息哦！</a></p>
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
                     <td><a href="labClass?id=${e.getId() }">详情</a></td>
                 </tr>
             </c:forEach>
         </table>
      </c:if>
      
      <!-- 分页 jsp -->
      <c:import url="../template/page.jsp"></c:import>
   </div>
</body>
</html>