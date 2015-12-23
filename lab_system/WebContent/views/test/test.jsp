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

<title>测试页面</title>
</head>
<body>
   <p style="text-align: center; font-size: 150%;">${title }</p>
   
   <div class="userList">
       <c:if test="${not empty pages}">
           <table class="table table-hover table-bordered table-condensed">
             <tr class="success">
                 <th>username</th>
                 <th>password</th>              
             </tr>
             <c:forEach items="${pages.getList() }" var="e">
                 <tr>
                     <td>${e.getName() }</td>
                     <td>${e.getPassword() }</td>                               
                 </tr>
             </c:forEach>
           </table>
           
           <div class="page" style="text-align: center;">
               <div>
                    每页显示<span class="size">${pages.getSize() }</span>条记录 
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span class="current">${pages.getCurrent() }</span>/
                    <span class="totalPage">${pages.getTotalPage() }</span>                     
               </div>
     
               <ul class="pagination">
                   <li>
                       <a>首页</a>
                   </li>
                   <c:if test="${pages.getCurrent() != 1}">
                       <li><a>上一页</a></li>                       
                   </c:if>
                   <c:if test="${pages.getCurrent() < pages.getTotalPage()}">
                       <li> <a>下一页</a></li>                  
                   </c:if>                     
                   <li> <a>尾页</a></li>
               </ul> 
                        
           </div>
       </c:if>
   </div>
   
   <script type="text/javascript">
       (function(){
    	   
    	   $(function(){
    		   
    		   $('.page a').on('click',function(){
    			   var current = parseInt($('.current').text());
    			   var totalPage = parseInt($('.totalPage').text());
    			   var size = parseInt($('.size').text());
    			   var state = $(this).text();
    			   if(state == '首页'){
    				   current = '1';
    			   }else if(state == '上一页'){
    				   current = current - 1;
    			   }else if(state == '下一页'){
    				   current = current + 1;
    			   }else if(state == '尾页'){
    				   current = totalPage ;
    			   }
    			   
    			   var data = {
   						current: current,
   						size: size
   				   };
   				   data = JSON.stringify(data);
   				   
    			   $.ajax({
   				       type: "POST",
   					   contentType: "application/json",//必须有
   		               dataType: "html",//返回值，不必须
   					   url: "test/user/listByPage",
   					   data: data,
   					   success: function(msg){
   						   //刷新整个body
   					       $('body').html(msg);
   					   }    			   
    			   });
    		   });
    	   });
    	   
       })(jQuery)
   </script>
</body>
</html>