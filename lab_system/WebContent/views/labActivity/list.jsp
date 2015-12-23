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

<title>实验室预约页面</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <!-- 引入实验室管理员的任务导航栏 jsp -->
   <c:import url="../labAdmin/navigate.jsp"></c:import>
   
   <!-- 引入实验室预约处理 jsp -->
   <c:import url="taskBar.jsp"></c:import>
   
   <div class="labActivityList" data-state="${title }">
       <c:if test="${empty pages.getList() }">
           <p>暂无信息</p>
       </c:if>
       
       <c:if test="${not empty pages.getList() }">
           <div class="title">
               ${title }
           </div>
           <table class="table table-hover table-bordered table-condensed">
             <tr class="info">
                 <th>预约开始实验时间</th>
                 <th>预约结束实验时间</th>
                 <th>预约实验室</th>
                 <th>预约老师教师证号</th>
                 <th>预约老师</th>
                 <th>专业班级</th>
                 <th>科目</th>
                 <th>预约实验器材</th>
                 <th>管理</th>
             </tr>
             <c:forEach items="${pages.getList() }" var="e">
                 <tr>
                     <td>${e.getBegin() }</td>
                     <td>${e.getEnd() }</td>
                     <td>${e.getLabClass().getName() }</td>
                     <td>${e.getTeacher().getTeacherNumber() }</td>
                     <td>${e.getTeacher().getUser().getName() }</td>
                     <td>${e.getMajorClass().getName() }</td>
                     <td>${e.getCourse().getName() }</td>
                     <td>
                         <a href="labAdmin/labActivity/${e.getId() }/equipments">
                             <span class="glyphicon glyphicon-wrench">查看所需器材</span>
                         </a>
                     </td>
                     <td>
                         <span id="stateOk" class="glyphicon glyphicon-ok" title="批准通过" data-id="${e.getId() }" ></span>
                         &nbsp;&nbsp;
                         <span id="stateFail" class="glyphicon glyphicon-remove" title="通过失败" data-id="${e.getId() }"></span>
                     </td>
                 </tr>
             </c:forEach>
           </table>
       </c:if>
       
       <!-- 分页 jsp -->
       <c:import url="../template/page.jsp"></c:import>
   </div>
</body>
</html>