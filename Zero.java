package work;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Zero {

	public static void main(String args[])
	{
		JFrame f= new JFrame();
		
		JLabel l= new JLabel("BMW Innovation Tech.");
		l.setBounds(530, 80, 800, 60);
		l.setFont(new Font("Arial", Font.BOLD, 62));
		l.setForeground(Color.WHITE);

		
		JLabel l2= new JLabel(" Enter As :- ");
		l2.setBounds(50,100,200,40);
		l2.setFont(new Font("Arial", Font.BOLD, 26));
		l2.setForeground(Color.black);
		
		
		JButton b1=new JButton("SELLER");
		b1.setBounds(160, 150, 200, 50);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setFont(new Font("Arial", Font.BOLD, 22));
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String pass =JOptionPane.showInputDialog("Hello Admin, enter your password : ");
				if(pass.equals("anuj"))
				{
				new Fourth();
				}
				else {
					JOptionPane.showMessageDialog(f, "Wrong password");
				}
				}
		});
		
		JButton b2=new JButton("CUSTOMER, TO BUY");
		b2.setBounds(100, 250, 260, 50);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setFont(new Font("Arial", Font.BOLD, 22));
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new First();
			}
		});
		
		
		JLabel l3=new JLabel(" View :- ");
		l3.setBounds(50, 400, 200, 40);
		
		l3.setFont(new Font("Arial", Font.BOLD, 26));
		l3.setForeground(Color.white);
		
		JButton b3=new JButton("CUSTOMER INFO");
		b3.setBounds(140, 450, 220, 50);
		b3.setBackground(Color.white);
		b3.setForeground(Color.black);
		b3.setFont(new Font("Arial", Font.BOLD, 22));
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass =JOptionPane.showInputDialog("Hello Admin, enter your password : ");
				if(pass.equals("anuj"))
				{
					Third.newFrame3();
				}
				else {
					JOptionPane.showMessageDialog(f, "Wrong password");
				}
			}
		});
		
		
		JButton b4=new JButton(new ImageIcon("C:\\Users\\ANUJ JAIN\\Desktop\\a1.png"));
		b4.setBounds(500, 200, 200, 200);
		b4.setBackground(Color.white);
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
			}
		});
		
		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\ANUJ JAIN\\Desktop\\1.jpg")));
		//f.getContentPane().setBackground(Color.lightGray);
		
		//f.add(b4);
		f.add(l);
		f.add(l2);
		f.add(l3);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(2000, 2000);
		
	}
}
