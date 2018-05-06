//customer info retrieving 
package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC3 {

	
	static String[] name=new String[50];
	static String[] ph=new String[50];
	static String[] variant=new String[50];
	static String[] date=new String[50];
	static Float[] price=new Float[50];
	
	
	// static String[] pass=new String[50];
	  static int count=0;
	  
	 static Connection con;
	 
	public static void validate(){  
		
		System.out.println("JDBC3 ----------->");
		
		try{  
			Class.forName("org.postgresql.Driver");  
			con=DriverManager.getConnection( "jdbc:postgresql://localhost:5432/bmw","postgres","pound");        
			
			Statement st = con.createStatement();
			
			String sql = ("select * from customerr;");
			
			ResultSet rsmt=st.executeQuery(sql);
			while(rsmt.next()) {
			
				count++;
			
			}
			System.out.println(count);
			ResultSet rs=st.executeQuery(sql);  
	
			int i=0;
			while(rs.next()) { 
			
				name[i] = rs.getString("name"); 
				ph[i] = rs.getString("phone");
				variant [i] = rs.getString("variant"); 
				date[i] = rs.getString("date"); 
				price[i] = rs.getFloat("price"); 
			
				 i++; 
				}
				
			//System.out.println(name +" "+ pass);
			}catch(Exception e){System.out.println(e);}  
			  
		}  
	
}
