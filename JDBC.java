package work;



import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;


public class JDBC {
	

	static String[] mode=new String[50];
	static String[] mod=new String[50];
	static String[] variant=new String[50];
	static String[] type=new String[50];
	static Float[] price=new Float[50];
	static String[] fuel=new String[50];
	static String[] trans=new String[50];
	static Integer[] cc=new Integer[50];
	static String[] mil=new String[50];
	
	// static String[] pass=new String[50];
	  static int count=0;
	  
	 static Connection con;
	 
	public static void validate(){  
		count=0;
		try{  
			Class.forName("org.postgresql.Driver");  
			con=DriverManager.getConnection( "jdbc:postgresql://localhost:5432/bmw","postgres","pound");        
			
			Statement st = con.createStatement();
			
			String sql = ("select * from car;");
			String c =("select distinct model from car;");
			
			
			int q=0;
			ResultSet rss=st.executeQuery(c);
			while(rss.next()) { 
				
				mode[q] = rss.getString("model");
				q++;
			}
			
			ResultSet rsmt=st.executeQuery(sql);
			while(rsmt.next()) {
			
				count++;
			
			}
			System.out.println(count);
			ResultSet rs=st.executeQuery(sql);  
	
			int i=0;
			while(rs.next()) { 
			
				mod[i] = rs.getString("model"); 
				variant[i] = rs.getString("variant");
				type[i] = rs.getString("type"); 
				price[i] = rs.getFloat("price"); 
				fuel[i] = rs.getString("fuel_type"); 
				trans[i] = rs.getString("transmission"); 
				cc[i] = rs.getInt("cc"); 
				mil[i] = rs.getString("mileage_kmperl"); 
				i++; 
				
			}
			
			
			
			for(int p=0;p<count;p++) { 
			
					System.out.println(mod[p] );
				}
				

			//System.out.println(name +" "+ pass);
			}catch(Exception e){System.out.println(e);}  
			  
		}  
	
	public static void lessthan() {
		
		PreparedStatement less;
		try {
			less=con.prepareStatement("select * from car where price<'$60.00' ;");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void insert() {
			
		PreparedStatement ins;
		try {
			ins = con.prepareStatement("insert into car values(?,?,?,?,?,?,?,?)");
			
			ins.setString(1, JOptionPane.showInputDialog("Insert model : "));
			ins.setString(2, JOptionPane.showInputDialog("Insert variant : "));
			ins.setString(3, JOptionPane.showInputDialog("Insert type(e.g. suv) : "));
			ins.setFloat(8, Float.parseFloat(JOptionPane.showInputDialog("Insert price : ")));
			ins.setString(4, JOptionPane.showInputDialog("Insert fuel type : "));
			ins.setString(5, JOptionPane.showInputDialog("Insert transmission : "));
			ins.setInt(6, Integer.parseInt(JOptionPane.showInputDialog("cc : ")));
			ins.setInt(7, Integer.parseInt(JOptionPane.showInputDialog("Insert mileage : ")));
			
			
			ins.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void delete(String n) {
		PreparedStatement del;
		try {
			del = con.prepareStatement("delete from car where variant =?");
			del.setString(1, n);
			
			del.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void update(String n) {
		PreparedStatement upd;
		try {
			upd=con.prepareStatement("UPDATE car SET price = ? WHERE variant = ?");
			
			upd.setFloat(1, Float.parseFloat(JOptionPane.showInputDialog("Insert new price")));
			upd.setString(2, n);
			
			upd.executeUpdate();
			// Fourth.fetch1(Fourth.model);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public static void clear() {
		
		PreparedStatement cl;
		try {
			cl=con.prepareStatement("delete * from car");
			
			cl.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
*/
}
