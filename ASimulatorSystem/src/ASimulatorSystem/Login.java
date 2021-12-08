package ASimulatorSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	JFrame f;
	JTextField tf1;
	JPasswordField pf2;
	JLabel l1,l2,l3;
	JButton b1,b2,b3;
	Login(){
		super("                                                                                             Automated Taller Machine");
		l1=new JLabel("WELCOME TO ATM");
		l2=new JLabel("Card No:");
		l3=new JLabel("PIN:");
		b1=new JButton(new ImageIcon("C:\\Users\\Rahul Kumar\\Dropbox\\My PC (DESKTOP-J4QDAT5)\\Downloads\\signIn.jpg"));
		b2=new JButton(new ImageIcon("C:\\Users\\Rahul Kumar\\Dropbox\\My PC (DESKTOP-J4QDAT5)\\Downloads\\clear.jpg"));
		b3=new JButton(new ImageIcon("C:\\Users\\Rahul Kumar\\Dropbox\\My PC (DESKTOP-J4QDAT5)\\Downloads\\signUp.jpg"));
		tf1=new JTextField(15);
		pf2=new JPasswordField(15);
		add(b1);
		add(b2);
		add(b3);
		add(l1);
		add(l2);
		add(l3);
		add(tf1);
		add(pf2);
		l1.setBounds(300,40,500,40);
		l2.setBounds(100,90,100,40);
		l3.setBounds(100,140,100,40);
		tf1.setBounds(220,90,300,40);
		pf2.setBounds(220,140,300,40);
		b1.setBounds(80,230,180,100);
		b2.setBounds(300,230,180,100);
		b3.setBounds(200,370,150,100);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

		setSize(800,600);
		setLayout(null);
		setLocation(500,200);
		setVisible(true);

	}
public void actionPerformed(ActionEvent ae) {
	try {
		conn c1=new conn();
		String a=tf1.getText();
		@SuppressWarnings("deprecation")
		String b=pf2.getText();
	
		if(ae.getSource()==b1) {
			String q="Select * from login where cardno='"+a+"' and pin ='"+b+"'";
			ResultSet rs=c1.s.executeQuery(q);
			if(rs.next()) {
			new Transaction(b).setVisible(true);
				setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(null,"Incorrect card Number or Password");
		}
		}
		else if(ae.getSource()==b2) {
			
			
			
			
			
			tf1.setText("");
			pf2.setText("");
		}
		else  if(ae.getSource()==b3) {
		new Signup().setVisible(true);
			setVisible(false);
		}
		
		
		
		
	}catch(Exception e) {
		
		System.out.println(e);
	}
		
	}

	
	public static void main(String[] args ) {
		new Login();
	}

	
		

}
