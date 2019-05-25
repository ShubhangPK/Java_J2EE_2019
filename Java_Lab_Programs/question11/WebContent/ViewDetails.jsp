<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String fno1 = request.getParameter("fname");
		int fno = Integer.parseInt(fno1);
		String datea = request.getParameter("date");
		Random rand = new Random();
		int s = rand.nextInt(500);
		String seat = Integer.toString(s);
		String custname = request.getParameter("custname");
		String custno = request.getParameter("custno");
		int fno2 = Integer.parseInt(custno);
	%>

	<%
		String url = "jdbc:mysql://localhost:3306/flight";
		String user = "root";
		String password = "password";
		Connection connection = null;
		//boolean flag=false;
		String query2;
		boolean h = false;
		Statement stmt;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			if (connection != null)
			{
				out.println("Connection created");
				stmt = connection.createStatement();
				query2 = "select * from Flight where Flight_Number='" + fno+ "';";
				ResultSet rs = stmt.executeQuery(query2);
				while (rs.next())
				{
					h = true;
				}
				if (h) 
				{
					out.println("Flight Number:" + fno + "\nDate:" + datea
							+ "\nSeatNumber:" + seat + "\nCustomerName:"
							+ custname + "\nCustNumber:" + custno);
					String query = "insert into SeatReservation values('"
							+ fno + "','" + datea + "','" + seat + "','"
							+ custname + "','" + custno + "');";
					stmt.executeUpdate(query);
					out.println("\nDetails inserted");
				} 
				else 
				{
					out.println("flight number doesnot exist");
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
	<p>
		click for flight details <a href="flightdete.jsp">here</a>

</body>
</html>