package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		}catch(Exception e) {System.out.println(e);}
		return con;
}
	public static boolean valid(Admin e) {
	int status =0;
	try{
		System.out.println("jdbc Starting.....");
		Connection con =EmpDao.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select * from pubg where name=? and password=?");
		
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		
        int executeUpdate = ps.executeUpdate();
        return true;  
     }catch(Exception ex){ex.printStackTrace();}  
 
     return false;
	
}
	
	
	}
