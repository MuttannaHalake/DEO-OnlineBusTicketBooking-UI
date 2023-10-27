import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;

public class daoREGI {
	public void show(Regibean b) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/passenger","root","Mbhalake04@");
	String st="insert into registration values(?,?,?)";
	PreparedStatement pp=con.prepareStatement(st);
	
	String name=b.getName();
	String pass=b.getPass();
	String email=b.getEmail();
	
	
	pp.setString(1, name);
	pp.setString(2,pass);
	pp.setString(3,email);
	
	
	
	pp.execute();
	
	con.close();
	
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
}
