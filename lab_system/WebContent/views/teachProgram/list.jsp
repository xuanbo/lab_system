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

<!-- labClassList css -->
<link rel="stylesheet" type="text/css" href="assets/my/teacher/labClassList.css">

<!-- list css -->
<link rel="stylesheet" type="text/css" href="assets/my/teachProgram/list.css">

<!-- list js -->
<script type="text/javascript" src="assets/my/teachProgram/list.js"></script>

<title>教学计划</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>
    
    <!-- 引入添加教学资源modal jsp -->
    <c:import url="addTeachProgramModal.jsp"></c:import>
    
    <div class="listDiv" data-teacherid="${teacherid }">
        <a href="teacher/teachProgram/add">
            <button class="btn btn-danger">新增</button>
        </a>
        
        <button class="btn btn-default" onclick="window.history.back()">返 回</button>
        
        <c:if test="${empty pages }">
           <p>还没有制定教学计划哦！</p>
        </c:if>
      
        <c:if test="${not empty pages }">
           <p>教学计划列表</p>
           <table class="table table-hover table-bordered table-condensed">
               <tr class="success">
                   <th>制定时间</th>
                   <th>专业班级</th>
                   <th>计划内容</th>
                   <th>管理</th>
               </tr>
               <c:forEach items="${pages.getList() }" var="e">
                   <tr>
                       <td>${e.getTime() }</td>
                       <td>${e.getMajorClass().getName() }</td>
                       <td>
                           <span class="show glyphicon glyphicon-resize-full" tabindex="0" data-placement="top" data-toggle="popover" data-trigger="focus" data-content="${e.getName() }">点我显示详细内容</span>
                       </td>
                       <td>
                           <c:if test="${empty e.getTeachResource() }">
                               <span class="addTeachProgram glyphicon glyphicon-upload" data-id="${e.getId() }">还没有上传资料哦！点我上传资料吧！</span>
                           </c:if>
                           
                           <c:if test="${not empty e.getTeachResource() }">
                               <a href="teacher/teacherProgram/${e.getId()}/teachResource/list" class="glyphicon glyphicon-paperclip">查看上传的资料</a>
                               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                               <span class="addTeachProgram glyphicon glyphicon-plus" data-id="${e.getId() }">新增一个资源</span>                             
                           </c:if>
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