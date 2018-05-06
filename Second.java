//bill
package work;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Second {
	static Float p = 0.0f;
	static Float t = 0.0f;
	static String n,v,date,ph;
	
	public static void newFrame2(String m) {
		JFrame f2=new JFrame();
		
				
		JLabel l,l1,l2,l3,l4,l5,l6,l7;
		JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
		
		JButton b,b2,b3;
		
		l=new JLabel("$$-- BILL --$$ ");
		l.setBounds(300, 20, 200, 30);
		
		l1=new JLabel("MODEL : ");
		l1.setBounds(50, 60, 150, 25);
		tf1=new JTextField();
		for(int i=0;i<JDBC.count;i++){
    		if(JDBC.variant[i].equals(m) )
    		
    		{
    			tf1.setText(JDBC.mod[i]);
    		}
		}
		tf1.setBounds(150, 60, 150, 25);
		tf1.setEditable(false);
		
		l2=new JLabel("VARIANT : ");
		l2.setBounds(50, 90, 150, 25);
		
		tf2=new JTextField(m);
		tf2.setBounds(150, 90, 150, 25);
		tf2.setEditable(false);
		v=tf2.getText();
		
		l3=new JLabel("PRICE : ");
		l3.setBounds(50, 120, 150, 25);
		tf3=new JTextField();
		for(int i=0;i<JDBC.count;i++){
    		if(JDBC.variant[i].equals(m) )
    		
    		{
    			p=JDBC.price[i];
    			tf3.setText(p.toString()+"  lakh");
    		}
		}
		tf3.setBounds(150, 120, 150, 25);
		tf3.setEditable(false);
		
		b2=new JButton("GST @ 28%");
		b2.setBounds(175, 160, 100, 30);
		
	
		
		
		
		l4=new JLabel("Total Amount : ");
		l4.setBounds(50, 200, 150, 25);
		
		
		tf4=new JTextField("");
		tf4.setBounds(150, 200, 150, 25);
		
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				t=(float) (p+(0.28*p));
				tf4.setText(t.toString()+"  lakh");
				
			}
			
		});
		
		
		l5=new JLabel("Customer's Name : ");
		l5.setBounds(400,120,150,25);
		
		tf5=new JTextField("");
		tf5.setBounds(550, 120, 150, 25);
		
		
		l6=new JLabel("Mobile no : ");
		l6.setBounds(400,150,150,25);
		
		tf6=new JTextField("");
		tf6.setBounds(550, 150, 150, 25);
		
		
		
		b= new JButton("__BUY__");
		b.setBounds(175, 300, 150, 30);
		
		b.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		           
		    	n=tf5.getText();
		    	ph=tf6.getText();
		    	JDBC2.validate();
		    	JOptionPane.showMessageDialog(b, "Thank You !");
		    	
		    	//Third.newFrame3();
		    }  
		});
		
		b3= new JButton("__CANCEL__");
		b3.setBounds(400, 300, 150, 30);
		
		b3.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		            f2.dispose();
		    }  
		});
		
		
		l7=new JLabel("Date : ");
		l7.setBounds(400,60,150,25);
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		date = simpleDateFormat.format(new Date());
	
		
		tf7=new JTextField("");
		tf7.setBounds(550, 60, 150, 25);
		tf7.setText(date);
		
		
	
		f2.add(l7);
		f2.add(tf7);
		f2.add(l);
		f2.add(b3);
		f2.add(l5);
		f2.add(tf5);
		f2.add(l6);
		f2.add(tf6);
		f2.add(l4);
		f2.add(tf4);
		f2.add(b2);
		f2.add(l1);
		f2.add(tf1);
		f2.add(l2);
		f2.add(tf2);
		f2.add(l3);
		f2.add(tf3);
		f2.add(b);
		f2.setLayout(null);
		f2.setVisible(true);
		f2.setSize(800, 400);
		
	}

}
