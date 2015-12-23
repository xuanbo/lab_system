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

<!-- index css -->
<link rel="stylesheet" type="text/css" href="assets/my/student/index.css">

<title>实验预约</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <!-- 引入studentNavBar jsp -->
   <c:import url="studentNavBar.jsp"></c:import>
   
   <div id="DateFull">
       <!-- 引入数据div 实现局部刷新DateFull div -->
       <c:import url="labActivityListDate.jsp"></c:import>
   </div>
</body>
</html>