<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="dataCapture.jsp" method="post">
		User Name: <input type="text" size="15" name="username"> <br>
		Password: <input type="password" size="15" name="password"> <br>
		<input type="submit" value="Login">
	</form>
	<%
		String reason = request.getParameter("FailReason");
		if (reason != null)
			out.println(reason);
	%>
</body>
</html>
