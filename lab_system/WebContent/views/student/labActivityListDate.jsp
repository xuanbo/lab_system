<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!-- labActivityList js -->
<script type="text/javascript" src="assets/my/student/labActivityList.js"></script>

    <div id="studentInfo" data-studentid="${STUDENTID }">
       <c:if test="${empty pages.getList() }">
            <p>暂无实验预约信息</p>
        </c:if>
        
        <c:if test="${not empty pages.getList() }">
           <p>实验预约信息</p>
           <table class="table table-hover table-bordered table-condensed">
             <tr class="success">
                 <th>科目</th>
                 <th>开始时间</th>
                 <th>结束时间</th>
                 <th>实验室</th>
             </tr>
             <c:forEach items="${pages.getList() }" var="e">
                 <tr>
                     <td>${e.getCourse().getName() }</td>
                     <td>${e.getBegin() }</td>
                     <td>${e.getEnd() }</td>
                     <td>${e.getLabClass().getName() }</td>
                 </tr>
             </c:forEach>
         </table>
       </c:if>
       
       <!-- 分页 jsp -->
       <c:import url="../template/page.jsp"></c:import>
   </div>