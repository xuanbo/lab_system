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

<!-- addLabActivity css -->
<link rel="stylesheet" type="text/css" href="assets/my/teacher/addLabActivity.css">

<!-- addLabActivity js -->
<script type="text/javascript" src="assets/my/teacher/addLabActivity.js"></script>
		
<title>新增实验记录页面</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>
    
    <!-- 引入教师预约情况 jsp -->
    <c:import url="labActivityStateBar.jsp"></c:import>
    
    <!-- 引入新增预约成功提醒modal jsp -->
    <c:import url="../template/remindModal.jsp"></c:import>
    
    <div class="addLabActivity">
        <!-- 引入选择时间modal jsp -->
        <c:import url="addLabActivityTimeModal.jsp"></c:import>
        
        <!-- 选择专业班级 -->
        <div class="form-group row">
          <div class="col-md-2">
             <label class="control-label" for="majorClass">
                选择专业班级：
             </label>   
          </div>
          <div class="col-md-4">
              <select id="majorClass" class="form-control">
                  <c:if test="${not empty majorClasses }">
                      <c:forEach items="${majorClasses }" var="e">
                          <option>${e.getName() }</option>
                      </c:forEach>
                  </c:if>                 
              </select>
          </div>
        </div>
        
        <!-- 选择科目 -->
        <div class="form-group row">
          <div class="col-md-2">
             <label class="control-label" for="course">
                选择科目：
             </label>   
          </div>
          <div class="col-md-4">
              <select id="course" class="form-control">
                  <c:if test="${not empty courses }">
                      <c:forEach items="${courses }" var="e">
                          <option>${e.getName() }</option>
                      </c:forEach>
                  </c:if>                 
              </select>
          </div>
        </div>
        
        <!-- 选择实验室 -->
        <div class="form-group row">
          <div class="col-md-2">
             <label class="control-label" for="labClass">
                选择实验室：
             </label>   
          </div>
          <div class="col-md-4">
              <select id="labClass" class="form-control">
                  <c:if test="${not empty labClasses }">
                      <c:forEach items="${labClasses }" var="e">
                          <option>${e.getName() }</option>
                      </c:forEach>
                  </c:if>                 
              </select>
          </div>
        </div>
        
        <!-- 选择实验器材 -->
        <div class="form-group row">
          <div class="col-md-2">
             <label class="control-label" for="equipment">
                选择实验器材：
             </label>   
          </div>
          <div class="col-md-4">
              <select id="equipment" class="form-control">
                  <c:if test="${not empty equipments }">
                      <option>请选择：</option>
                      <c:forEach items="${equipments }" var="e">                         
                          <option>${e.getName() }</option>
                      </c:forEach>
                  </c:if>                 
              </select>
          </div>
          <!-- 记录多个实验器材 -->
          <div class="col-md-6">
              <label>已添加：</label>
              <label id="equipmentList">
              
              </label>
          </div>
        </div>
        
        <!-- 提交错误显示 -->
        <div class="form-group row">
          <h3 class="msg">
          
          </h3>
        </div>
        <!-- 提交button -->
        <div class="form-group row">
          <button id="btnAdd" class="col-md-2 col-md-offset-5 btn btn-info">
              提&nbsp;交
          </button>
        </div>
    </div>
    

</body>
</html>