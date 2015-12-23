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

<!-- 登录样式css -->
<link rel="stylesheet" type="text/css" href="assets/my/login/loginPage.css">

<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css">

<script type="text/javascript" src="assets/jquery/jquery.min.js"></script>

<!-- bootstrap js -->
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>

<!-- 登录信息验证、提交js -->
<script type="text/javascript" src="assets/my/login/loginPage.js"></script>

<title>登录页面</title>
</head>
<body>   
       
       <!-- 登录信息验证提醒div -->
       <div id="info">
          <div class="alert alert-danger" role="alert">          
             <span id="warnInfo">  </span>
             <span id="infoRemove" class="glyphicon glyphicon-remove" aria-hidden="true"></span>
          </div>       
       </div>
       
    <div id="div_center">
       
       <!-- 标题信息 -->   
       <p>欢&nbsp;迎&nbsp;登&nbsp;录&nbsp;实&nbsp;验&nbsp;室&nbsp;系&nbsp;统</p>
       
       <!-- 用户名和密码输入框 -->   
       <div class="inputUP">
           <span id="spanUsername" class="glyphicon glyphicon-user" aria-hidden="true"></span>
           <input class="inputUsername" type="text" name="username" placeholder="&nbsp;请输入账号：">
           <br> 
           <span id="spanPassword" class="glyphicon glyphicon-lock" aria-hidden="true"></span>
           <input class="inputPassword" type="password" name="password" placeholder="&nbsp;请输入密码：">
       </div>
       <!-- 登录按钮 -->
       <div class="inputSubmit">
           <input class="inputLogin" type="button" value="登&nbsp;&nbsp;录">
       </div>
    </div>
    <br>
    <br>
    <hr>
    
    <!-- 引入尾部jsp -->
    <c:import url="template/tail.jsp"></c:import>
    
</body>
</html>