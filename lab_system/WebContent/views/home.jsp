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

<!-- jquery js -->
<script type="text/javascript" src="assets/jquery/jquery.min.js"></script>

<!-- bootstrap js -->
<script type="text/javascript" src="assets/bootstrap/js/bootstrap.min.js"></script>

<!-- home js -->
<script type="text/javascript" src="assets/my/home/home.js"></script>

<title>主页</title>
</head>
<body>
   <!-- 引入head jsp -->
   <c:import url="template/head.jsp"></c:import>
  
   <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">
      
        <div class="item active">
          <img src="resource/images/home/bg1.png">
          <div class="carousel-caption">
            <!-- 此处可添加文字或其他 -->  
            <div style="color: red; font-size: 200%;">
                厚德博学  追求卓越
            </div>         
          </div>
        </div>
        
        <div class="item">
          <img src="resource/images/home/bg2.jpg">
          <div class="carousel-caption">
            <!-- 此处可添加文字或其他 -->
            <div style="color: #ffffff; font-size: 200%;">
                武汉理工大学欢迎你
            </div>
          </div>
        </div>
        
        <div class="item">
          <img src="resource/images/home/bg3.jpg">
          <div class="carousel-caption">
            <!-- 此处可添加文字或其他 -->
            <div style="color: #000000; font-size: 200%;">
                实验室管理系统
            </div>
          </div>
        </div>
       
      </div>

      <!-- Controls -->
      <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  


    <script type="text/javascript">
        (function($){
        	$('.carousel').carousel({
        		  interval: 3000
        	});
        	
        })(jQuery)
    </script>
</body>
</html>