package BackEnd;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
public static Connection getConnection() {
	Connection con = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
	}catch(Exception e) {System.out.println(e);}
	return con;
}
public static int save (Emp e) {
	int status =0;
	try{
		Connection con =EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into pmp(name,password,email,country,id)values(?,?,?,?,?)");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getCountry());
		ps.setInt(5, e.getId());
		
		 status=ps.executeUpdate();  
         
         con.close();  
     }catch(Exception ex){ex.printStackTrace();}  
 
     return status;  
}
public static int update(Emp e) {
	int status = 0;
	try {
		
		Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("update pmp set name=?,password=?,email=?,country=? where id=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getCountry());
		ps.setInt(5, e.getId());
		
		status =ps.executeUpdate();
		con.close();
	}catch(Exception ex) {ex.printStackTrace();}
	return status;
}
public static int delete(int id) {
	int status =0;
	try {
		Connection con =EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("Delete from pmp where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex) {ex.printStackTrace();}
    return status;
}
public static Emp getEmployeeById(int id) {
	Emp e = new Emp();
	try {
		Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from pmp where id=?");
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setPassword(rs.getString(3));
			e.setEmail(rs.getString(4));
			e.setCountry(rs.getString(5));
		}
		con.close();
		
		
	}catch(Exception ex) {ex.printStackTrace();}
	return e;
}
public static List<Emp>getAllEmployee(){
	List<Emp>list=new ArrayList<Emp>();
	try {
		Connection con = EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from pmp");
		
		ResultSet rs =ps.executeQuery();
		System.out.println(rs);
		while (rs.next()) {
			
			 Emp e=new Emp();  
             e.setId(rs.getInt(1));  
             e.setName(rs.getString(2));  
             e.setPassword(rs.getString(3));  
             e.setEmail(rs.getString(4));  
             e.setCountry(rs.getString(5));  
             list.add(e);  
		}
		
	}catch (Exception ex) {ex.printStackTrace();}
	return list;
}
public static boolean valid(String name,String pass)
{
	try {
		Connection con =EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from pmp where name=? and password=?");
		ps.setString(1, name);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		
		System.out.println();
		
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

}