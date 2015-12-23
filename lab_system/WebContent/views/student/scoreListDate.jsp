<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<!-- scoreList js -->
<script type="text/javascript" src="assets/my/student/scoreList.js"></script>

    <div id="studentInfo" data-studentid="${STUDENTID }">
       <c:if test="${empty pages.getList() }">
            <p>暂无实验成绩信息</p>
        </c:if>
        
        <c:if test="${not empty pages.getList() }">
           <p>实验成绩信息</p>
           <table class="table table-hover table-bordered table-condensed">
             <tr class="success">
                 <th>实验开始时间</th>
                 <th>实验结束时间</th>
                 <th>实验室</th>
                 <th>科目</th>
                 <th>分数</th>
                 <th>评价</th>
             </tr>
             <c:forEach items="${pages.getList() }" var="e">
                 <tr>
                     <td>${e.getLabActivity().getBegin() }</td>
                     <td>${e.getLabActivity().getEnd() }</td>
                     <td>${e.getLabActivity().getLabClass().getName() }</td>
                     <td>${e.getLabActivity().getCourse().getName() }</td>
                     <td>${e.getGrade() }</td>
                     <td>${e.getMark() }</td>
                     
                 </tr>
             </c:forEach>
         </table>
       </c:if>
       
       <!-- 分页 jsp -->
       <c:import url="../template/page.jsp"></c:import>
   </div>