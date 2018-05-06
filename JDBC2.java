// customer info is inserting into customerr table
package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBC2 {


	static int count=0;
	  
	static Connection con;
	 
	public static void validate(){  
		try{  
			Class.forName("org.postgresql.Driver");  
			con=DriverManager.getConnection( "jdbc:postgresql://localhost:5432/bmw","postgres","pound");        
			
			
		
			}catch(Exception e){System.out.println(e);}  
			
		insert();
		}  
	

	public static void insert() {
			
		PreparedStatement ins;
		try {
			ins = con.prepareStatement("insert into customerr values(?,?,?,?,?)");
			
			ins.setString(1, Second.n);
			/*try {
			ins.setLong(2, Long.parseLong(Second.ph));
			}catch(Exception e) {}
			*/
			ins.setString(2,Second.ph);
			ins.setString(3,Second.v);
			ins.setFloat(4, Second.t);
			 Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(Second.date);
			
			/* try {
			 ins.setDate(5, (java.sql.Date) date1);
			 }catch(ClassCastException e) {}
			*/
			 ins.setString(5, Second.date);
			 
			ins.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}
	

}