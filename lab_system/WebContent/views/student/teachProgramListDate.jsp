<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<!-- teachProgramList js -->
<script type="text/javascript" src="assets/my/student/teachProgramList.js"></script>

    <div id="studentInfo" data-studentid="${STUDENTID }">
       <c:if test="${empty pages.getList() }">
            <p>暂无教学计划信息</p>
        </c:if>
        
        <c:if test="${not empty pages.getList() }">
           <p>教学计划信息</p>
           <table class="table table-hover table-bordered table-condensed">
             <tr class="success">
                 <th>时间</th>
                 <th>教师</th>
                 <th>教学计划</th>
                 <th>教学资源</th>
             </tr>
             <c:forEach items="${pages.getList() }" var="e">
                 <tr>
                     <td>${e.getTime() }</td>
                     <td>${e.getTeacher().getName() }</td>
                     <td>        
                         <span class="show" tabindex="0" data-placement="top" data-toggle="popover" data-trigger="focus" data-content="${e.getName() }">
                             <span class="name"></span>...&nbsp;&nbsp;&nbsp;
                             <span class="more">更多</span>
                         </span>                      
                     </td>
                     <td>
                         <c:if test="${empty e.getTeachResource() }">
                             <span class="null glyphicon glyphicon-option-horizontal" data-id="${e.getId() }">教师暂无上传资料</span>
                         </c:if>
                           
                         <c:if test="${not empty e.getTeachResource() }">
                             <a href="student/teacherProgram/${e.getId()}/teachResource/list" class="glyphicon glyphicon-paperclip">查看上传的资料</a>                                                        
                         </c:if>
                     </td>
                 </tr>
             </c:forEach>
         </table>
       </c:if>
       
       <!-- 分页 jsp -->
       <c:import url="../template/page.jsp"></c:import>
   </div>