<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>�������</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="head">
		<div class="head_left">
			<a href="#">
				<img hspace="11" src="picture/logo_dear.gif" vspace="5">
			</a>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����ṩרҵ����
		</div>
		<div class="head_right">
			<div class="head_right_nei">
				<div class="head_top">
					<div class="head_buy">
						<strong>
							<a href="updateCart.action">
								<img height="15" src="picture/buy01.jpg" width= "16"> &nbsp;���ﳵ
							</a>
						</strong> |
						
						<s:if test="#session.user==null">
						<a href="login.jsp">δ��¼</a>
						</s:if>
						<s:else>
								<a href="#"><s:property value="#session.user.username"/></a>
						</s:else>
					</div>
				</div>
				<div class="head_middle">
					<a class="title01" href="index.action">
						<span>&nbsp;&nbsp;��ҳ&nbsp;&nbsp;</span>
					</a>
					<s:if test="#session.user==null">
						<a class="title01" href="loginjsp.action">
							<span>&nbsp;&nbsp;��¼&nbsp;&nbsp;</span>
						</a>
					</s:if>
					<s:else>
						<a class="title01" href="logout.action">
							<span>&nbsp;&nbsp;ע��&nbsp;&nbsp;</span>
						</a>
					</s:else>
					<a class="title01" href="registerjsp.action">
						<span>&nbsp;&nbsp;ע��&nbsp;&nbsp;</span>
					</a>
					<a class="title01" href="updatepwdjsp.action">
						<span>&nbsp;�޸�����&nbsp;&nbsp;&nbsp;</span>
					</a>
					<a class="title01" href="updateMessagejsp.action">
						<span>&nbsp;�޸ĸ�����Ϣ&nbsp;&nbsp;&nbsp;</span>
					</a>
					<a class="title01" href="#">
						<span>&nbsp;��ϵ����&nbsp;&nbsp;&nbsp;</span>
					</a>
					<a class="title01" href="#">
						<span>&nbsp;��վ��ͼ&nbsp;&nbsp;&nbsp;</span>
					</a>
				</div>
				<div class="head_bottom">
					<form action="searchBook.action?currentPage=1" method="post">
						<input type="text" name="bookname" size="50" align="middle"/>
						<input type="image" name="submit" src="picture/search02.jpg" align= "top" style="width: 48px; height: 22px"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
