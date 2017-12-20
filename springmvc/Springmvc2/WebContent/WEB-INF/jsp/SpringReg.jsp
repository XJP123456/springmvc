<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form:form commandName="user" action="save2.do" method="post">
			用户名:<form:input path="userName" /><form:errors path="userName"/><br>
			密码:<form:password path="userPassword" /><form:errors path="userPassword"/><br>
			邮箱:<form:input path="email" /><form:errors path="email"/><br>
			生日:<form:input path="birthday" /><form:errors path="birthday"/><br>
			<form:button >提交</form:button>
		</form:form>
	</div>
</body>
</html>