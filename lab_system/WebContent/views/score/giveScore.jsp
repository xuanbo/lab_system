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

<!-- giveScore css -->
<link rel="stylesheet" type="text/css" href="assets/my/score/giveScore.css">

<!-- giveScore js -->
<script type="text/javascript" src="assets/my/score/giveScore.js"></script>

<title>评分页面</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>
    
    <!-- 引入教师预约情况 jsp -->
    <c:import url="../teacher/labActivityStateBar.jsp"></c:import>
    
    <!-- 引入成绩提交提醒modal jsp -->
    <c:import url="../template/remindModal.jsp"></c:import>
    
    <c:if test="${empty flag }">
        <h2>已经评分过了哦！</h2>
    </c:if>
    
    <c:if test="${not empty flag }">
    <!-- 关于data-*属性，*是小写，如果是Id， 会变成id -->
    <div class="scoreList" data-labActivityId="${labActivityId }" data-teacherid="${TEACHERID }">       
        <c:if test="${not empty students }">
           <p>本次实验评分</p>
           <table class="table table-hover table-bordered table-condensed">
             <tr class="success">
                 <th>学号</th>
                 <th>姓名</th> 
                 <th>分数</th>
                 <th>表现</th>              
             </tr>
             <c:forEach items="${students }" var="e">
                 <tr class="student" data-id="${e.getId() }">
                     <td>${e.getStudentNumber() }</td>
                     <td>${e.getName() }</td>   
                     <td>
                         <input type="text" class="score form-control" placeholder="请输入分数：">
                     </td>
                     <td>
                         <input type="text" class="mark form-control" placeholder="表现：">
                     </td>               
                 </tr>
             </c:forEach>
         </table>
       </c:if>
       
       <div class="row">
           <div class="msg">
           
           </div>
           <button id="scoreSubmit" class="btn btn-default col-md-2 col-md-offset-5">提&nbsp;交</button>
       </div>
    </div>
    </c:if>
    
</body>
</html>