<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- navigate css -->
<link rel="stylesheet" type="text/css" href="assets/my/labAdmin/navigate.css">

<!-- navigate js -->
<script type="text/javascript" src="assets/my/labAdmin/navigate.js"></script>

      <ul class="nav nav-tabs nav-justified" id="navigate">      
         
         <li role="presentation" id="taskOne">
             <a href="labAdmin/labActivity/list">
                 实验室预约管理
                 <span class="count">
                     ${count }
                 </span>                
             </a>
         </li>
         
         <li role="presentation" id="taskTwo">
             <a href="labAdmin/labClass/list">
                 实验室管理
             </a>
         </li>
         
         <li role="presentation" id="taskThree">
             <a href="labAdmin/equipment/list">
                 实验室器材管理
             </a>
         </li>
         
         <li>
            <!-- flag为1显示，0隐藏 -->
            <span id="hide" class="glyphicon glyphicon-list" aria-hidden="true" data-flag="1"></span>
         </li>         
      </ul>
