import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJDBC {
	static Connection con;
	public static void main(String[] args) {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/first?useSSL=false", "root", "Mm12345,");  
			getAll();
//			ResultSet rs=stmt.executeQuery("");  
//			while(rs.next())  
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);  
		}  

	}
	public static void add(int id,String name,String phoneNumber) throws SQLException {
		PreparedStatement stmt=con.prepareStatement("insert into employee(id,name,phone_number) values (?,?,?)");  
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3,phoneNumber);
		stmt.executeUpdate();
		
	}
	public static void update(int id,String name,String phoneNumber) throws SQLException {
		PreparedStatement stmt=con.prepareStatement("update employee set id =? ,name=? ,phone_number=? where id=?");  
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setString(3,phoneNumber);
		stmt.setInt(4, id);
		stmt.executeUpdate();
		
	}
	public static void delete(int id) throws SQLException {
		PreparedStatement stmt=con.prepareStatement("delete from employee where id=?");  
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
	}
	public static void search(String name) throws SQLException {
		PreparedStatement stmt=con.prepareStatement("select * from employee where name=?");
		stmt.setString(1, name);
		ResultSet rs=stmt.executeQuery();
		if(!rs.next()) {
			System.out.println("Not Found");
		}
		rs.beforeFirst();
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	}
	public static void getAll() throws SQLException {
		PreparedStatement stmt=con.prepareStatement("select * from employee");
		
		ResultSet rs=stmt.executeQuery();
		if(!rs.next()) {
			System.out.println("Empty");
		}
		rs.beforeFirst();
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	}

}
