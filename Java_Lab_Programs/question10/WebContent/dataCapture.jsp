<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.* , java.text.*, java.util.HashMap, java.io.*, javax.servlet.http.HttpServletResponse"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%HashMap hm;
	String uname;
	String pwd;
	Map.Entry entry;
		boolean login = false;
		hm = new HashMap();
		uname = request.getParameter("username");
		pwd = request.getParameter("password");

		hm.put("abc", "pqr");
		hm.put("mno", "xyz");
		hm.put("def", "ghi");

		Set s = hm.entrySet();
		Iterator it = s.iterator();

		while (it.hasNext()) 
		{
			entry = (Map.Entry) it.next();
			if (uname.equals(entry.getKey())
					&& pwd.equals(entry.getValue())) 
			{
				login = true;
				break;
			}
		}//end while 

		if (login == true) 
		{
			out.println("<B><FONT COLOR = Blue>");
			out.println("Welcome </FONT></B>");
			out.println(uname);
			DateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(date);
			out.println("<BR><FONT COLOR = Green>");
			out.println("Today is </FONT>" + dateFormat.format(date));
	%>

	<form action="CalculateInterest.jsp" method="post">
		<FONT COLOR="Magenta"> First Name:</FONT> <input type="text" size="15"
			name="fname"> <br> <FONT COLOR="Brown">Last Name:
		</FONT> <input type="text" size="15" name="lname"> <br> <FONT
			COLOR="Purple">Select your Place of Work:</FONT> <br> <select
			name="profession" size="3">
			<option>IT Company</option>
			<option>Private Bank</option>
			<option>Insurance Company</option>
		</select> <br> <input type="radio" name="gender" value="Male">
		Male<br> <input type="radio" name="gender" value="Female" checked>Female<br>
		<br> <FONT COLOR="Red"> Annual Income(in Rupees):</FONT> <input
			type="text" size="15" name="income"> <br> <br> <input
			type="submit" value="Calculate Tax">
	</form>
	<%
		} 
		else 
		{
	%>
	<jsp:forward page="Login.jsp">
		<jsp:param name="FailReason" value="Wrong Username or Password" />
	</jsp:forward>
	<%
		}
	%>

</body>
</html>
