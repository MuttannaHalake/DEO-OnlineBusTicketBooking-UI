import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Daopro {
	public void show(beanpro b)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/passenger","root","Mbhalake04@");
			String st="insert into detils values(?,?,?,?,?,?)";
			PreparedStatement pp=con.prepareStatement(st);
			
			String name=b.getName();
			String start=b.getStart();
			String end=b.getEnd();
			String pref=b.getPref();
			String pgen=b.getPgen();
			long num=b.getNum();
			
			pp.setString(1, name);
			pp.setString(2, start);
			pp.setString(3, end);
			pp.setString(4, pref);
			pp.setString(5, pgen);
			pp.setLong(6, num);
			
			pp.execute();
			
			con.close();
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("inserted succesfully");
	}

}
