import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/varifyyy1")
public class varifyyy1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public varifyyy1() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/passenger","root","Mbhalake04@");
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			PreparedStatement ps = con.prepareStatement("SELECT name FROM registration WHERE name=? AND pass=? AND email=?");

			ps.setString(1,name);
			ps.setString(2,pass);
			ps.setString(3, email);
		    ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("projectt.html");
				rd.forward(request,response);
				
			}
			else
			{
				out.println("<h2 style=\"text-align: center; color: red; font-size: x-large;\">Login Failed</h2>");

				response.setContentType("text/html");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request,response);
				
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}