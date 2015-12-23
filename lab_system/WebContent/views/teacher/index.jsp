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

<!-- index css -->
<link rel="stylesheet" type="text/css" href="assets/my/teacher/index.css">

<!-- index js -->
<script type="text/javascript" src="assets/my/teacher/index.js"></script>

<title>教师页面</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>
    
    <div class="task">
        <div>
            <a href="teacher/${TEACHERID }/labActivity/state/process">我的预约</a>
        </div>
        <div>
            <a href="teacher/${TEACHERID }/majorClassCourse/list">授课信息</a>
        </div>
        <div>
            <a href="teacher/labClass/list">实验室查看</a>
        </div>
        <div>
            <a href="teacher/${TEACHERID }/teachProgram/list">教学计划</a>
        </div>
        <div>
            <a href="teacher/${TEACHERID }/labActivity/score">实验成绩</a>
        </div>
    </div>
 
</body>
</html>