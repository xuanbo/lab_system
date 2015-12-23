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
<title>测试文件下载</title>
</head>
<body>
    <p>文件下载测试</p>
    <a href="test/fileDownload/download?fileName=通信原理评分表.doc">通信原理大作业论文评分表.doc</a>
    <br>
    <br>
    <a href="test/fileDownload/download?fileName=image.rar">rar下载.doc</a>
</body>
</html>