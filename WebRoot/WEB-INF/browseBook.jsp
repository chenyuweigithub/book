<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
		<title>网上书店</title>
		<link href="css/bookstore.css" rel="stylesheet" type="text/css"/>
</head>
<body>
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
					<s:iterator value="#request['books']" var="book">
						<table width="600" border="0">
							<tr>
								<td width="200" align="center">
									<img src="/bookstore/picture/<s:property value="#book. picture "/>" width="100"/>
								</td>
								<td valign="top" width="400">
									<table>
										<tr>
											<td>
								书名:<s:property value="#book.bookname"/><br>
											</td>
										</tr>
										<tr>
											<td>
								价格:<s:property value="#book.price"/>元
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/bookstore/picture/buy.gif"/>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</s:iterator>
				</div>
			</div>
		</div>
</body>
</html>
