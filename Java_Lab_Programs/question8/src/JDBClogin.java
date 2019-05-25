

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
 * Servlet implementation class JDBClogin
 */
@WebServlet("/JDBClogin")
public class JDBClogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBClogin() {
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
	        //out.print("Working");
	        
	          //boolean flag = false;
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;               
	    try {
	            Class.forName("com.mysql.jdbc.Driver");
	    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineDirectory","root","password");
	            stmt = conn.createStatement();
	            out.print("Working");            
	            long inp;
	                
	            try
	            {
	             inp =Long.parseLong(request.getParameter("phone"));
	             out.println(""+inp);
	             rs = stmt.executeQuery("SELECT * FROM Telephone_Directory where Phone_number="+inp+";");
	            }
	            catch(Exception e)
	            {
	                String name=request.getParameter("phone");
	                // out.println(""+name);
	                rs = stmt.executeQuery("SELECT * FROM Telephone_Directory where Name='"+name+"';");
	                
	            }
	            if(rs.next()) {
	                String name = rs.getString(2);
	                long phone = rs.getLong(1);
	                String address = rs.getString(3);
	                String company = rs.getString(4);
	                String pin =rs.getString(5);
	                out.println("name"+name);
	                out.println("contact:"+phone);
	                out.println("address:"+address);
	                out.println("company:"+company);
	                out.println("pin:"+pin);
	                } 
	            else
	            {
	                out.println("no contact found");
	            } 
	            
	            
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
	    
	    finally {
	        try {
	            stmt.close();
	            conn.close();        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
