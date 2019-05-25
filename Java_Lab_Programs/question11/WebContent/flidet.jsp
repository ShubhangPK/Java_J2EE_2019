<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String fldate = request.getParameter("fdate");
		String url = "jdbc:mysql://localhost:3306/flight";
		String user = "root";
		String password = "password";
		Connection connection = null;
		Statement stmt;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			out.println("hi, Flight details=");
			if (connection != null) 
			{
				stmt = connection.createStatement();
				String query = " select * from Flight where Weekdays='"+ fldate + "';";
				ResultSet re = stmt.executeQuery(query);
				while (re.next()) 
				{
					out.println(re.getString("Flight_Number") + "\n"
							+ re.getString("Airline_Name") + "\n"
							+ re.getString("Weekdays") + "\n");
				}
			} 
			else
				out.println("Connection refused");
		} 
		catch (Exception e) 
		{
			out.println(e.getMessage());
		}
	%>

</body>
</html>