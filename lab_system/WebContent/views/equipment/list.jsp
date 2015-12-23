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
<script type="text/javascript" src="assets/my/equipment/list.js"></script>

<title>实验器材查看</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="../template/head.jsp"></c:import>
   
   <!-- 引入实验室管理员的任务导航栏 jsp -->
   <c:import url="../labAdmin/navigate.jsp"></c:import>
   
   <!-- 引入新增实验器材modal jsp -->
   <c:import url="addEquipmentModal.jsp"></c:import>
   
   <!-- 引入提醒modal jsp -->
   <c:import url="../template/remindModal.jsp"></c:import>\
   
   <!-- 引入增加实验器材modal jsp -->
   <c:import url="pulsModal.jsp"></c:import>
   
   <div class="equipmentTask">
     <a>
         <button class="btn btn-default add glyphicon glyphicon-plus">&nbsp;新&nbsp;增</button>
     </a>
   </div>
   
   <!-- 显示实验器材 -->
   <div class="equipmentList">
       <c:if test="${empty pages.getList() }">
           <p>暂无信息</p>
       </c:if>
       
       <c:if test="${not empty pages.getList() }">
           <table class="table table-hover table-bordered table-condensed">
             <tr class="info">
                 <th>实验器材名称</th>
                 <th>数目</th>
                 <th>损耗数目</th>
                 <th>器材类型</th>                 
                 <th>管理</th>
             </tr>
             <c:forEach items="${pages.getList() }" var="e">
                 <tr>
                     <td>${e.getName() }</td>
                     <td>${e.getTotalNumber() }</td>
                     <td>${e.getLossNumber() }</td>
                     <td>${e.getStyle() }</td>
                     <td>
                         <a href="labAdmin/equipment?id=${e.getId() }" class="glyphicon glyphicon-paperclip">使用详情</a>
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <span data-id="${e.getId() }" class="puls glyphicon glyphicon-plus">添加</span>
                     </td>
                 </tr>
             </c:forEach>
         </table>
       </c:if>
       
       <!-- 分页 -->
       <c:import url="../template/page.jsp"></c:import>
   </div>
</body>
</html>