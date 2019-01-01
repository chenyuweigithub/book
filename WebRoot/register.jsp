<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册页面</title>

<script type="text/javascript">
function validateForm() {
    var x = document.forms["myForm"]["username"].value;
    if (x == null || x == "") {
        alert("需要输入名字。");
        return false;
    }
    var y = document.forms["myForm"]["password"].value;
    var z = document.forms["myForm"]["repassword"].value;
    if (y!=z) {
        alert("密码和确认密码不一样。");
        return false;
    }
}
</script>
</head>
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
					<form action="register.action" onsubmit="return validateForm()"  name="myForm" method="post">
						<h1>用户注册</h1><br> 
						用户名:<input type="text"  name="user.username" id=username size="20" /><br>
						密码:<input type="password" name="user.password" id=password size="20" /><br>
						确认密码:<input type="password" id=repassword size="20" /><br>
						性别:<!-- <input type="text" name="user.sex" size="20" />  -->
						<input type="radio" name="user.sex" value="男"/>男
						<input type="radio" name="user.sex" value="女"/>女<br>
						年龄:<input type="text" name="user.age" size="20" /><br>
						<input type="submit"  value="提交" />
					</form>
				</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>