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

<!-- add css -->
<link rel="stylesheet" type="text/css" href="assets/my/lossEquipment/add.css">

<!-- add js -->
<script type="text/javascript" src="assets/my/lossEquipment/add.js"></script>

<title>器材损耗页面</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>
    
    <!-- 引入教师预约情况 jsp -->
    <c:import url="../teacher/labActivityStateBar.jsp"></c:import>
    
    <!-- 引入器材损耗提交提醒modal jsp -->
    <c:import url="../template/remindModal.jsp"></c:import>
    
    <c:if test="${empty flag }">
        <h2>已经填写过了哦！</h2>
    </c:if>
    
    <c:if test="${not empty flag }">
    <!-- 关于data-*属性，*是小写，如果是Id， 会变成id -->
    <div class="lossEquipmentList" data-labActivityId="${labActivityId }" data-teacherid="${TEACHERID }">       
        <c:if test="${not empty equipments }">
           <p>本次实验器材损耗</p>
           <table class="table table-hover table-bordered table-condensed">
             <tr class="warning">
                 <th>实验器材</th>
                 <th>损耗数目</th>
             </tr>
             <c:forEach items="${equipments }" var="e">
                 <tr class="equipment" data-id="${e.getId() }">
                     <td>${e.getName() }</td>  
                     <td>
                         <input type="text" class="lossNumber form-control" placeholder="请输入损耗数目：">
                     </td>                                    
                 </tr>
             </c:forEach>
         </table>
       </c:if>
       
       <div class="row">
           <div class="msg">
           
           </div>
           <button id="lossEquipmentSubmit" class="btn btn-default col-md-2 col-md-offset-5">提&nbsp;交</button>
       </div>
    </div>
    </c:if>
    
    
    
    
</body>
</html>