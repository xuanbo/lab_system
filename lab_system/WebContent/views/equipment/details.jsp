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

<link rel="stylesheet" type="text/css" href="assets/my/equipment/list.css">
<script type="text/javascript" src="assets/my/equipment/details.js"></script>

<title>实验器材使用详情</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <!-- 引入实验室管理员的任务导航栏 jsp -->
   <c:import url="../labAdmin/navigate.jsp"></c:import>
   
   <div class="equipmentTask">
       <a onclick="window.history.back()">
           <button class="btn btn-default">返 回</button>
       </a> 
   </div>
   
   <div class="equipmentList" data-equipmentid="${equipmentId }">
       <c:if test="${empty pages.getList() }">
           <p>暂无信息</p>
       </c:if>
       
       <c:if test="${not empty pages.getList() }">
           <table class="table table-hover table-bordered table-condensed">
             <tr class="info">
                 <th>损耗数目</th>
                 <th>指导老师教师证</th>
                 <th>指导老师</th>
                 <th>实验专业班级</th>
                 <th>实验科目</th>
                 <th>实验开始时间</th>
                 <th>实验结束时间</th>
             </tr>
             <c:forEach items="${pages.getList() }" var="e">
                 <tr>
                     <td>${e.getLossNumber() }</td>
                     <td>${e.getLabActivity().getTeacher().getTeacherNumber() }</td>
                     <td>${e.getLabActivity().getTeacher().getUser().getName() }</td>
                     <td>${e.getLabActivity().getMajorClass().getName() }</td>
                     <td>${e.getLabActivity().getCourse().getName() }</td>
                     <td>${e.getLabActivity().getBegin() }</td>
                     <td>${e.getLabActivity().getEnd() }</td>
                 </tr>
             </c:forEach>
         </table>
       </c:if>
       
       <!-- 分页 -->
       <c:import url="../template/page.jsp"></c:import>
   </div>
</body>
</html>