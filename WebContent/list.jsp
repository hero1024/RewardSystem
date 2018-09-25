<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<title>显示用户信息</title>
<!-- Required meta tags -->
<meta name=”viewport”
 content=”width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes” />
<script src="js/jquery-3.2.1.min.js"></script>
<style type="text/css">
.br_BR{background-color:exprssion(this.rowIndex%2==0?"#CCFFFF":"FFFFCC");
cursor:hand;
}
.br_head{
background-color:#DDFFCC;
}
</style>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container-fluid">
<div class="row" style="height: 3rem;"></div>
<div class="row justify-content-center">
<!--如果要与手机屏幕匹配，则应把下一句的col-4改成col-->
<div class="col-8 text-center">
<div class="card">
<div class="card-header text-white bg-primary text-center">
<h3>奖金发放信息管理系统</h3>
</div>
<div class="card-body">
<table width="640">
<tr>
<td align="right"><a href="index.jsp">返回首页</a></td>
<td align="right"><a href="userToAdd">添加信息</a></td>
</tr>
</table>
<table width="640" border="1" align="center"
bordercolor="#99CCFF">
<tr class="br_head">
<td>ID号</td>
<td>姓名</td>
<td>性别</td>
<td>职称</td>
<td>奖金数额</td>
<td>发放时间</td>
<td>单位</td>
<td>负责人</td>
<td>删除</td>
<td>修改</td>
</tr>
<s:iterator value="list">
<tr class="br_TR">
<td><s:property value="id"/></td>
<td><s:property value="name"/></td>
<td><s:property value="sex"/></td>
<td><s:property value="job"/></td>
<td><s:property value="amount"/></td>
<td><s:property value="time"/></td>
<td><s:property value="unit"/></td>
<td><s:property value="header"/></td>
<td><a href="javascript:location.replace('userDelete?user.id=<s:property value='id'/>')">删除</a></td>
<td><input type="button" name="Submit" value="修改" onclick="javascript:location.replace('userToUpdate?user.id=<s:property value='id'/>')"></td>
 </tr>
 </s:iterator>
 </table>
 </div>
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


















