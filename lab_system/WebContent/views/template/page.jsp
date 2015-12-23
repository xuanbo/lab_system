<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" type="text/css" href="assets/my/page/page.css">

       <c:if test="${not empty pages.getList() }">
           <div class="page" style="text-align: center;">
               <div>
                    每页显示<span class="size">${pages.getSize() }</span>条记录 
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    第<span class="current">${pages.getCurrent() }</span>页/
                    共<span class="totalPage">${pages.getTotalPage() }</span>页                     
               </div>
     
               <ul class="pagination">
                   <c:if test="${pages.getTotalPage() != 1 && pages.getCurrent() != 1}">
                       <li>
                           <a>首页</a>
                       </li>                       
                   </c:if>
                   <c:if test="${pages.getCurrent() != 1}">
                       <li>
                           <a>上一页</a>
                       </li>                       
                   </c:if>
                   <c:if test="${pages.getCurrent() < pages.getTotalPage()}">
                       <li> 
                           <a>下一页</a>
                       </li>                  
                   </c:if>                     
                   <c:if test="${pages.getTotalPage() != 1 && pages.getCurrent() != pages.getTotalPage()}">
                       <li>
                           <a>尾页</a>
                       </li>                       
                   </c:if>
               </ul>                        
           </div>
       </c:if>