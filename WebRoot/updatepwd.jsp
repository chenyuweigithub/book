<%@ page language="java" import="java.util.*,javax.servlet.http.*" pageEncoding="utf-8" %>
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
					 <form action="updatepwd.action" onsubmit="return validateForm()"  name="myForm" method="post">
					 <s:if test="#session.validated==false">
					 <h1>修改失败，请重新修改密码</h1><br/>
					 <%
		                 session.setAttribute("validated", true);
					  %>
					</s:if>
					<s:else>
					<h1>修改密码</h1><br/>
					</s:else>
						用户名:<input type="text" id=username name="user.username"/><br>
						原密码:<input type="password" name="user.password"/><br>
						新密码：<input type="password" id=password name="user.newpassword"/><br>
						确认密码:<input type="password" id=repassword size="20" /><br>
						<input type="submit" value="修改"/>
					</form>
				</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"/>
</body>
</html>
