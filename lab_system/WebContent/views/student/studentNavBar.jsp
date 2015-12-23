<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="assets/my/student/studentNavBar.css">

    <div id="studentNavBar">
       <ul class="nav nav-pills nav-stacked">
         <li id="NavBarOne" role="presentation">
             <a href="student/${STUDENTID }/index">主页</a>
         </li>
         <li id="NavBarTwo" role="presentation">
             <a href="student/${STUDENTID }/labActivity/list">实验预约</a>
         </li>
         <li id="NavBarThree" role="presentation">
             <a href="student/${STUDENTID }/teachProgram/list">教学计划</a>
         </li>
         <li id="NavBarFour" role="presentation">
             <a href="student/${STUDENTID }/score/list">实验成绩</a>
         </li>
       </ul>
   </div>