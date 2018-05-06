//customer info
package work;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class Third {

	public static void newFrame3() {
		
		JFrame f3=new JFrame();
		JButton b=new JButton("*** CUSTOMER INFO. ***");
		b.setBounds(350, 20, 300, 70);
		b.setBackground(Color.WHITE);
		b.setFont(new Font("Arial", Font.BOLD, 22));
		b.disable();
		
		DefaultTableModel model;
		JTable jt;
	
		model    = new DefaultTableModel();
	   
		jt=new JTable(model);   
	    model.addColumn("name");
	    model.addColumn("phone");
	    model.addColumn("variant");
	    model.addColumn("price");
	    model.addColumn("date of purchase");
	
	    
	    fetch(model);
	   
	    
	    JPanel tablePanel = new JPanel(new BorderLayout());
		tablePanel.add(jt, BorderLayout.CENTER);
		tablePanel.add(jt.getTableHeader(), BorderLayout.NORTH);
		tablePanel.setBounds(10,100, 960, 700);
		
		f3.add(b);
		f3.add(tablePanel);
		f3.setLayout(null);
		f3.setVisible(true);
		f3.setSize(1000, 700);
		
	}
	
	public static void fetch( DefaultTableModel model  ) {          
        
		model.setRowCount(0);
		JDBC3.validate();
	    	for(int i=0;i<JDBC3.count;i++){ 
	    		model.addRow(new Object[] { JDBC3.name[i],JDBC3.ph[i],JDBC3.variant[i],JDBC3.price[i],JDBC3.date[i]});
				}                                                          	                                                                                                             
	}   
	
}
		