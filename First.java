//buyer customer
package work;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class First implements ActionListener{
	
	private Second f2 = new Second();

	
			DefaultTableModel model;
			JFrame f;
			JLabel l;
			JLabel price,fuell;
			JTable jt;
			JRadioButton r1,r2,r3,r4;
			JComboBox<String> cb;
			static JTextField tf1;
			JButton b1,b2,b3;
			  
		
		First()
		{
			f = new JFrame("JDBC");
		    l = new JLabel("BMW WELCOME'S you ! ");
		    price=new JLabel("PRICE RANGE");
		    fuell=new JLabel("FUEL TYPE");
			r1= new JRadioButton("LESS THAN $60");
			r2= new JRadioButton("MORE THAN $60");
			r3= new JRadioButton("DIESEL");
			r4= new JRadioButton("PETROL");
			
			b1=new JButton("BUY");
			b2=new JButton("RESET");
			b3=new JButton("Filter data");
			
		    tf1=new JTextField("");
		    display();
		}
////////////////////////////////////////////////////////////////////////////////////		
		
		private void display() {
		
			price.setBounds(400, 70, 200, 30);
			r1.setBounds(400,90,200,30);    
			r2.setBounds(400,120,200,30);    
			ButtonGroup bg=new ButtonGroup();   
			bg.add(r1);bg.add(r2);   
			
			 r1.addActionListener(new ActionListener() {
			       
			       public void actionPerformed(ActionEvent e) {
			    	   model.setRowCount(0);
			        	for(int i=0;i<JDBC.count;i++){
			        		if(JDBC.price[i] < 60.00 && cb.getSelectedItem().equals(JDBC.mod[i]) )
			        		{
					    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});
			        		}
			        		else if(JDBC.price[i] < 60.00 && cb.getSelectedItem().equals("--NONE--") )
			        		{
					    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});

			        		}

			        	}
			        }
			    });
			 
			 r2.addActionListener(new ActionListener() {
			       
			       public void actionPerformed(ActionEvent e) {
			    	   model.setRowCount(0);
			        	for(int i=0;i<JDBC.count;i++){
			        		if(JDBC.price[i] >= 60.00 && cb.getSelectedItem().equals(JDBC.mod[i]))
			        		{
					    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});
			        		}
			        		else if(JDBC.price[i] >= 60.00 && cb.getSelectedItem().equals("--NONE--") )
			        		{
					    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});

			        		}
			        	}
			        }
			    });
			
			
			fuell.setBounds(600, 70, 200, 30);
			r3.setBounds(600,90,200,30);    
			r4.setBounds(600,120,200,30);    
			ButtonGroup bg2=new ButtonGroup();   
			bg2.add(r3);bg2.add(r4);
			
			 r3.addActionListener(new ActionListener() {
			       
			       public void actionPerformed(ActionEvent f) {
			    	   model.setRowCount(0);
			        	for(int i=0;i<JDBC.count;i++){
			        		if(JDBC.fuel[i].startsWith("D") && cb.getSelectedItem().equals(JDBC.mod[i]) )
			        		
			        		{
					    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});
			        		}
			        		else if(JDBC.fuel[i].startsWith("D") && cb.getSelectedItem().equals("--NONE--") )
			        		{
					    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});

			        			  	
			        		}	        	}
			        }
			    });
			r4.addActionListener(new ActionListener() {
			       
			       public void actionPerformed(ActionEvent f) {
			    	   model.setRowCount(0);
			        	for(int i=0;i<JDBC.count;i++){
			        		if(JDBC.fuel[i].startsWith("P") && cb.getSelectedItem().equals(JDBC.mod[i]) )
			        		
			        		{
					    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});
			        		}
			        		else if(JDBC.fuel[i].startsWith("P") && cb.getSelectedItem().equals("--NONE--") )
			        		{
					    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});

			        		}	
			        	}
			        }
			    });
			 
			
			
			//////////////////////////////////////////////////////////////////////////////
			l.setBounds(400,1, 200, 30);
			tf1.setBounds(600, 650, 200, 40);
			
			///////////////////////////////////////////////////////////////////////////////
			
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
		    
		    fetch(model);
		   
		    
		    JPanel tablePanel = new JPanel(new BorderLayout());
			tablePanel.add(jt, BorderLayout.CENTER);
			tablePanel.add(jt.getTableHeader(), BorderLayout.NORTH);
			tablePanel.setBounds(30,200, 1000, 400);
			
			
			jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				
				public void valueChanged(ListSelectionEvent arg0) {
					if (jt.getSelectedRow() > -1) {			            // print first column value from selected row
			            tf1.setText(jt.getValueAt(jt.getSelectedRow(), 1).toString());
				}
				
				}
				
				
			});
			
			
			////////////////////////////////////////////////////////////////////////////////
			
			
			////////////////////////////////////////////////////////////////////////////////
			
			
			String[] data = JDBC.mode;
			final DefaultComboBoxModel<String> cmodel = new DefaultComboBoxModel<String>();
			cmodel.addElement("--NONE--");
			for (int i = 0, n = data.length; i < n; i++) {
			      cmodel.addElement(data[i]);
			    }
			 cb=new JComboBox<String>(cmodel);
			 cb.setBounds(100, 100, 200, 50);
			 
			cb.addActionListener(this);
			
			//String s= (String) cmodel.getSelectedItem();
			//tf1.setText(s);
			 ///////////////////////////////////////////////////////////////////////////////////
			
			b1.setBounds(800, 650, 100, 30);
			
			b1.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					

		            String m = tf1.getText(); // variant name ja ra h 
		            
		            Second.newFrame2(m); 
					
				}
				
				
			});
			
			
			
			
			////////////////////////////////////////////////////////////////////////////////////
			//filter
			
			cb.setVisible(false);
			price.setVisible(false);
			fuell.setVisible(false);
			r1.setVisible(false);
			r2.setVisible(false);
			r3.setVisible(false);
			r4.setVisible(false);
			
			b3.setBounds(300, 80, 200, 50);
			b3.setBackground(Color.yellow);
			b3.setFont(new Font("Arial", Font.BOLD, 18));
			b3.addActionListener(new ActionListener() {
			
				
				public void actionPerformed(ActionEvent arg0) {
					cb.setVisible(true);
					price.setVisible(true);
					fuell.setVisible(true);
					r1.setVisible(true);
					r2.setVisible(true);
					r3.setVisible(true);
					r4.setVisible(true);
					b3.setVisible(false);
					//b3.setBackground(Color.red);
				}
				
			});
			
			f.add(b3);
			f.add(b1);
			f.add(price);
			f.add(r1);
			f.add(r2);
			f.add(fuell);
			f.add(r3);
			f.add(r4);
			f.add(tf1);
			f.add(tablePanel);
		    f.add(cb);
			f.add(l);
			f.setLayout(null);
			f.setVisible(true);
			f.setSize(2000, 1000);
		}
		
		
public static void fetch( DefaultTableModel model  ) {          
	        
			model.setRowCount(0);
			JDBC.validate();
		    	for(int i=0;i<JDBC.count;i++){ 
		    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});
					}                                                          	                                                                                                             
		}    
		          

	
	public void actionPerformed(ActionEvent e) {
		
		cb = (JComboBox)e.getSource();
	    String s = (String)cb.getSelectedItem();
	    
	    
	    model.setRowCount(0);
	    
	    for(int i=0;i<JDBC.count;i++){
	    	if(JDBC.mod[i].equals(s))
	    	{
    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});
			}
	    	if(s.equals("--NONE--"))
	    	{
	    		model.addRow(new Object[] { JDBC.mod[i],JDBC.variant[i],JDBC.type[i],JDBC.price[i],JDBC.fuel[i],JDBC.trans[i],JDBC.cc[i],JDBC.mil[i]});

	    	}
	    	
	    	
	    }
	    
	    ////////////
	    
	    
	    
	}	
}
