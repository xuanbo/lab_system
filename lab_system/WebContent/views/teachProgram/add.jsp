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

<!-- webuploader css -->
<link rel="stylesheet" type="text/css" href="assets/webuploader/webuploader.css">

<!-- webuploader js -->
<script type="text/javascript" src="assets/webuploader/webuploader.js"></script>

<!-- labClassList css -->
<link rel="stylesheet" type="text/css" href="assets/my/teacher/labClassList.css">

<!-- list -->
<link rel="stylesheet" type="text/css" href="assets/my/teachProgram/list.css">

<!-- add css -->
<link rel="stylesheet" type="text/css" href="assets/my/teachProgram/add.css">

<!-- add js -->
<script type="text/javascript" src="assets/my/teachProgram/add.js"></script>

<title>新增教学计划</title>
</head>
<body>
    <!-- 引入head jsp -->
    <c:import url="../template/head.jsp"></c:import>
    
    <div id="teachProgram" class="listDiv" data-id="${teacherId }" data-teachprogramid="">
        <p>新增教学计划</p>
        
        <!-- 选择专业班级 -->
        <div class="form-group row">
            <div class="col-md-3">
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
        
        <!-- 输入教学计划内容 -->
        <div class="form-group row"> 
            <div class="col-md-3">
                <label class="control-label" for="name">
                    输入教学计划内容：
                </label>   
            </div>            
            <div class="col-md-6">
                <textarea id="name" class="form-control" rows="3"></textarea>
            </div>           
        </div>     
        
        <div class="form-group">
            <p id="msg"></p>
            <button id="add" class="btn btn-default" style="margin-left: 45%; width: 10%;">提交</button>
            <button id="addTeachResource" class="btn btn-primary" style="margin-left: 45%; width: 10%;">添加</button>
        </div>
        
        <!-- 文件上传 -->
        <div id="uploader" class="wu-example form-group">           
             
            <!--用来存放文件信息-->
            <div id="thelist" class="uploader-list">
                
            </div>
                
            <div class="btns">
                <div id="picker">选择文件</div>
                <button id="ctlBtn" class="btn btn-success">上传</button>
            </div>
                     
        </div>    
    </div>   

</body>
</html>