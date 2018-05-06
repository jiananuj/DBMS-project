//seller 
package work;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Fourth {

	static DefaultTableModel model;
	static JDBC j1=new JDBC();
	
			JFrame f;
			static JTable jt;
			JButton fetch ,add,delete,clear,update,num;
			static JTextField tf1;
			  
		
		Fourth()
		{
			f = new JFrame("SELLER");
		     
			fetch=new JButton("Fetch data");
		    add = new JButton("add");   
		    delete=new JButton("Delete");
		    clear=new JButton("Clear ");
		    update=new JButton("update"); 
		    num=new JButton("No.of records =");
		    tf1=new JTextField("");
		    display();
		}
		
		private void display() {
		
			model    = new DefaultTableModel();
		    jt=new JTable(model);   
		    model.addColumn("model");
		    model.addColumn("variant");
		    model.addColumn("type");
		    model.addColumn("price");
		    model.addColumn("fuel type");
		    model.addColumn("transmission");
		    model.addColumn("cc");
		    model.addColumn("mileage");
		    
		    
		    JPanel tablePanel = new JPanel(new BorderLayout());
			tablePanel.add(jt, BorderLayout.CENTER);
			tablePanel.add(jt.getTableHeader(), BorderLayout.NORTH);
			tablePanel.setBounds(100,100, 600, 600);
			
			 fetch.setBounds(130, 11, 130, 23);              
			 fetch.addActionListener(new ActionListener() {     
			     public void actionPerformed(ActionEvent arg0) {  
			              fetch(model);
			              number();
			     }                                                
			 });        
		                                                      
			 add.setBounds(330, 11, 130, 23);                      
			 add.addActionListener(new ActionListener() {         
			     public void actionPerformed(ActionEvent e) {     

			    	 JDBC.insert();
			    	 
			    	 fetch(model);
			    	 number();
			     }                                                
			 });                                                  
			           
			 delete.setBounds(530, 11, 130, 23);                      
			 delete.addActionListener(new ActionListener() {         
			     public void actionPerformed(ActionEvent e) {     
			    	 String n= (String) jt.getValueAt(jt.getSelectedRow(), 1);
			    	 JDBC.delete(n);
			    	 
			    	 fetch(model);
			    	 number();
			     }                                                
			 });       
			 
			 clear.setBounds(130, 41, 130, 23);                      
			 clear.addActionListener(new ActionListener() {         
			     public void actionPerformed(ActionEvent e) {     
			        // JDBC.clear();       
			    	 
			    	 fetch(model);
			    	 number();
			     }                                                
			 });     
			 
			 update.setBounds(330, 41, 130, 23);                      
			 update.addActionListener(new ActionListener() {         
			     public void actionPerformed(ActionEvent e) {     
			    	 String n= (String) jt.getValueAt(jt.getSelectedRow(), 1);
			    	 JDBC.update(n);
			    	 fetch(model);
			     }                                                
			 });
			 
			 num.setBounds(750, 150, 150, 25);                      
			 num.addActionListener(new ActionListener() {         
			     public void actionPerformed(ActionEvent e) {     
			    	 number();
			     }                                                
			 });
			 
			 tf1.setBounds(900, 150, 30, 25);  
			
			 f.add(tablePanel);
			 f.add(fetch);
			 f.add(add);          
			 f.add(delete);
			 f.add(clear);
			 f.add(update);
			 f.add(num);
			 f.add(tf1);
			 f.setLayout(null);
				f.setVisible(true);
				f.setSize(1000, 1000);
		    
		    
		}
 
		
		public static void fetch( DefaultTableModel model  ) {          
	        
			model.setRowCount(0);
			JDBC.validate();
		    	for(int i=0;i<JDBC.count;i++){ 
		    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});
					}                                                          	                                                                                                             
		}    
		
		public static void number()
		{
			String c= Integer.toString(JDBC.count);
	    	tf1.setText(c);
		}
		 
}
