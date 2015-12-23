<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 自定义head css -->
<link rel="stylesheet" type="text/css" href="assets/my/template/head.css">
<!-- head js -->
<script type="text/javascript" src="assets/my/template/head.js"></script>
	 
<!-- 导航栏 --> 
<div id="head">
 <nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand">
           厚德博学  追求卓越
       </a> 
       <!-- 
         <a class="navbar-brand"></a>
        -->
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      
        <li id="one" ><a href="home">实验室管理系统</a> </li>
        
        <!--  
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">二手交易 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        -->
        
        <li id="two"><a href="student/${STUDENTID }/index">学生登入</a></li>
        
        <li id="three"><a href="teacher/index">教师登入</a></li>
        
        <li id="four"><a href="labAdmin/index">实验室管理员登入</a></li>
        
      </ul>
   <!-- 屏蔽了搜索框 -->
   <!--  
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
   --> 
      
      <ul id="date" class="nav navbar-nav navbar-right">
         <!-- 
         <li>
             <img src="resource/images/home/whutlogo.png" style="width: 250px; background-color: white;margin-right: 20px;">
         </li>
         -->
         
         <li>
           <span class="showdata"></span>
           <br>
           <span>
              欢迎&nbsp;${Role }&nbsp;&nbsp;&nbsp;${SPRING_SECURITY_CONTEXT.getAuthentication().getName() }
           </span> 
        </li>
        
        <li>
            <a href="j_spring_security_logout">
                退出系统
            </a>                   
        </li>
        
        <!-- 
        <li>          
           <img src="resource/images/user.png" class="img-circle">
        </li>
         -->              
      </ul> 
        
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</div>