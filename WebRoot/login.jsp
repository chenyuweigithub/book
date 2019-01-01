<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head><title>登录页面</title></head>
	<body>
	<jsp:include page="head.jsp"/>
	<div class="content">
		<div class="left">
			<div class="list_box">
				<div class="list_bk">
					<s:action name="browseCatalog" executeResult="true"/>
				</div>
			</div>
		</div>
		<div class="right">
			<div class="right_box">
				<font face="宋体"></font><font face="宋体"></font><font face="宋体"></font><font face="宋体"></font>
				<div class="banner"></div>
				<div class="info_bk1">
				<div align="center">
				<form action="login.action" method="post">
				<table width="309" border="0">
					<h1>用户登录</h1>
					 <tr>
						  <td>姓名：</td>
						  <td><input type="text" name="user.username"/></td>
					 </tr>
					 <tr>
						 <td>密码：</td>
						 <td><input type="password" name="user.password"/></td>
					 </tr>
					 <tr>
					    <td><input type="submit" value="登录"/></td>
					    <td><a href="register.jsp">注册</a></td>
					  </tr>	
					
				</table>
				</form>
				</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>

