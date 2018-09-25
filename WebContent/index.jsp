<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath %>">
<title>奖金发放信息管理系统</title>
<!-- Required meta tags -->
<meta name="viewport"
content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="js/jquery-3.2.1.min.js"></script>
<style> 
ul li{font-size:23px}/* 对这个网页中出现ul li标签内文字字体大小设置20px */ 
</style>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
<div class="row" style="height: 3rem;"></div>
<div class="row justify-content-center">
<!--如果要与手机屏幕匹配，则应把下一句的col-4改成col-->
<div class="col-6 text-center">
<div class="card">
<div class="card-header text-white bg-primary text-center">
<h4>
<b>奖金发放信息管理系统</b>
</h4>
</div>
<div class="card-body">
<ul>			
			<li><a href="userToList">奖金发放信息查询</a></li>
			<li><a href="userToAdd">添加奖金发放信息</a></li>
       </ul>
<!-- <a href="userToList">List All Information</a>
<br/>
<a href="userToAdd">UserToAdd</a> -->
</div>
</div>
</div>
</div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>