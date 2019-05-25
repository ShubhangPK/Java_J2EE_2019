

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insert1
 */
@WebServlet("/insert1")
public class insert1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
        // out.print("Working");

        boolean flag = false;
        //Connection conn = null;
        //Statement stmt = null;
        //ResultSet rs = null;

        try {
            // conn = getConn();
            //String driver = "com.mysql.jdbc.Driver";
            //String url = "jdbc:mysql://localhost:3306/OnlineDirectory";
            //String username = "root";
            //String password = "password";
        	
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineDirectory","root","password");
            if (conn != null)
                System.out.println("Successful");
            Statement stmt = conn.createStatement();

            out.println("Working");
            
            long contact = Long.parseLong(request.getParameter("cnt"));
            String name = request.getParameter("nam");
            String address = request.getParameter("address");
            String company = request.getParameter("company");
            String pin = request.getParameter("pin");

            out.println("name" + name);
            out.println("contact:" + contact);
            out.println("address:" + address);
            out.println("company:" + company);
            out.println("pin:" + pin);

            stmt.executeUpdate("insert into Telephone_Directory values("+contact+",'" + name + "','" + address + "','" + company + "','" + pin + "');");
            out.println("updated the records");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: failed to load MySQL driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: failed to create a connection object.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: unknown");
            e.printStackTrace();
        }
//         finally {
//            try {
//                stmt.close();
//                conn.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
