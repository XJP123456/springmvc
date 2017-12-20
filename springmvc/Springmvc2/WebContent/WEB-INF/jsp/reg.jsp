<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
		<div align="center">
				<form action="save1.do" method="post" >
					<table>
						<tr>
							<td>用户名</td>
							<td><input type="text" name="userName" value="${user.userName }"/></td>
							<td><f:errors path="user.userName"/></td>
						</tr>
						<tr>
							<td>密码</td>
							<td><input type="text" name="userPassword" value="${user.userPassword }"/></td>
							<td><f:errors path="user.userPassword" stype="color:red"/></td>
						</tr>
							<tr>
							<td>邮箱</td>
							<td><input type="text" name="email" value="${user.email}"/></td>
							<td><f:errors path="user.email"/></td>
						</tr>
						<tr>
							<td>生日</td>
							<td><input type="text" name="birthday" value=""/></td>
							<td><f:errors path="user.birthday"/></td>
						</tr>
					</table>
					<input type="submit" value="注册"/>
				<div>
				<p>${msg}</p>
				<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
				</div>
				</form>
		
		</div>
</body>
</html>