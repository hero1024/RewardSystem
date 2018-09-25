<!-- package wsj.struts2.app; -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户信息</title>
<!-- Required meta tags -->
<meta name=”viewport”
 content=”width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes” />
<script src="js/jquery-3.2.1.min.js"></script>
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
<h3>修改用户信息</h3>
</div>
<div class="card-body">
<s:form action="userUpdate" method="post">
<table width="300"border="1" align="center"
bordercolor="#99CCFF"bgcolor="#FFFFEE" class="table table-striped table-hover table-bordered" >
<s:textfield name="user.id" label="ID号"/>
<s:textfield name="user.name" label="姓名"/>
<s:select list="sexs" name="user.sex" label="性别"/>
<s:textfield name="user.job" label="职称"/>
<s:textfield name="user.amount" label="奖金数额"/>
<s:textfield name="user.time" label="发放时间"/>
<s:textfield name="user.unit" label="单位"/>
<s:textfield name="user.header" label="负责人"/>
<s:submit value="修改" align="center"/>
</table>
</s:form>
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