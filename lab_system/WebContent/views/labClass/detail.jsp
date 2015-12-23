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

<!-- detail css -->
<link rel="stylesheet" type="text/css" href="assets/my/labClass/detail.css">

<!-- detail js -->
<script type="text/javascript" src="assets/my/labClass/detail.js"></script>

<title>实验室详情</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <!-- 引入实验室管理员的任务导航栏 jsp -->
   <c:import url="../labAdmin/navigate.jsp"></c:import>
   
   <div class="title">
       <select class="labActivityState" data-id="${labClass.getId() }">
           <option></option>
           <option>预约待处理</option>
           <option>预约成功</option>
           <option>预约失败</option>
           <option>实验已结束</option>
       </select>
       &nbsp;
       <a id="search" href="labClass?id=${labClass.getId() }">
           <span class="btn btn-default glyphicon glyphicon-search"></span>
       </a>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <span>实验室${labClass.getName() }的详情</span>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <button class="btn btn-default" onclick="window.history.back()">返回上一页</button>
   </div>
   
   <div class="listDiv" data-labactivitystate="${labActivityState }">
       <c:if test="${empty pages.getList() }">
           <p>暂无信息</p>
       </c:if>
       
       <c:if test="${not empty pages.getList() }">
          <table class="table table-hover table-bordered table-condensed">
              <tr class="success">
                  <th>预约状态</th>
                  <th>开始时间</th>
                  <th>结束时间</th>
                  <th>课程名称</th>
                  <th>专业班级</th>
                  <th>预约的老师名</th>
              </tr>
                 
              <c:forEach items="${pages.getList() }" var="e">
                  <tr>
                      <td>${e.getState() }</td>
                      <td>${e.getBegin() }</td>
                      <td>${e.getEnd() }</td>
                      <td>${e.getCourse().getName() }</td>
                      <td>${e.getMajorClass().getName() }</td>
                      <td>${e.getTeacher().getUser().getName() }</td>                 
                  </tr>          
              </c:forEach>        
          </table>
          
       </c:if>
       
       <!-- 分页 jsp -->
       <c:import url="../template/page.jsp"></c:import>
   </div>
</body>
</html>