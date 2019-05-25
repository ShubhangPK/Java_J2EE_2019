<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate Interest JSP</title>
</head>
<body>
	<%
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String profession = request.getParameter("profession");
		String prefix = " ";

		if (gender.equals("Male"))
		{
			prefix = "Mr.";
		} else if (gender.equals("Female")) 
		{
			prefix = "Ms.";
		}
	%>
	<FONT COLOR="Blue">Hello <%=prefix%>&nbsp;<%=fname%>&nbsp;<%=lname%>
		&nbsp; who works in a <%=profession%></FONT>

	<%
		String sincome = request.getParameter("income");
		float income = Float.parseFloat(sincome);
		out.println("<BR>Your Annual Income is " + income);

		float tax;
		float diff;

		if (income <= 100000)
		{
			out.println("<BR>You are below the Tax Bracket!!");
		} 
		else if (income > 100000 && income <= 500000)
		{
			out.println("Your Tax Bracket is between Rs.1,00000 to Rs.5,00000");
			out.println("<BR>Tax to be paid is 15% of income above 1Lakh");
			//diff = income - 100000;
			tax = (float) 0.1 * income;
			out.println("<BR>Tax to be paid is " + tax);
		}
		else
		{
			out.println("<BR>You fall in the tax bracket greater than Rs.5,00000");
			//diff = income - 400000;
			//tax = diff + (float) 0.3 * 300000 + (float) 0.2 * 200000
			//		+ (float) 0.1 * 100000;
			tax = (float) 0.2 * income;
			//out.println("<BR>Tax to be paid is 10% of income upto 1Lakh 20% of income upto 3Lakh, 30% of income upto 4 lakh and 100% of rest of income");
			out.println("<BR>Tax to be paid is " + tax);
		}//end if
	%>
</body>
</html>
