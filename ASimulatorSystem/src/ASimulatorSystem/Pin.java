package ASimulatorSystem;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Pin extends JFrame implements ActionListener {
JLabel l1,l2,l3,l4;
JTextField t1,t2,t3;
JButton b1,b2;
String pin;
Pin(String pin){
	super("                                        PIN CHANGE");
	this.pin=pin;
	l1=new JLabel("CHANGE YOUR PIN");
	l2=new JLabel("Current PIN:");
	l3=new JLabel("New PIN:");
	l4=new JLabel("Re-Enter New PIN:");
	
	b1=new JButton("SAVE");
	b1.setBackground(Color.black);
	b1.setForeground(Color.white);
	b2=new JButton("BACK");
	b2.setBackground(Color.black);
	b2.setForeground(Color.white);
	
	t1=new JTextField();
	t2=new JTextField();
	t3=new JTextField();

	add(l1);
	add(l2);
	add(l3);
	add(l4);
	add(b1);
	add(b2);
	add(t1);
	add(t2);
	add(t3);
	l1.setBounds(100,40,200,40);
	l2.setBounds(60,90,100,40);
	t1.setBounds(280,90,100,40);
	l3.setBounds(60,140,200,40);
	t2.setBounds(280,140,100,40);
	l4.setBounds(60,190,200,40);
	t3.setBounds(280,190,100,40);
	b1.setBounds(80,300,80,40);
	b2.setBounds(180,300,80,40);
	b1.addActionListener(this);
	b2.addActionListener(this);
	setLayout(null);
	setSize(500,600);
	setVisible(true);

	
}
@Override
public void actionPerformed(ActionEvent ae) {
	try {
		String a=t1.getText();
		String b=t2.getText();
		String c=t3.getText();
		
	if(ae.getSource()==b1)	{
		if(t1.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Please enter correct PIN");
			
			} if(t2.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter New PIN");
			}
		 if(t1.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please Re-enter New PIN");
			} if(t2.getText().equals(t3.getText())) {
				conn c1=new conn();
			String q1="update bank set pin='"+b+"'where pin='"+a+"' ";
			String q2="update login set pin='"+b+"'where pin='"+a+"' ";
		//	String q3="update Signup set pin='"+b+"'where pin='"+a+"' ";
			c1.s.executeUpdate(q1);
			c1.s.executeUpdate(q2);
		//	c1.s.executeUpdate(q3);
			JOptionPane.showMessageDialog(null," PIN changed Successfully");
			new Transaction(b).setVisible(true);
			setVisible(false);
			
			}else {
				JOptionPane.showMessageDialog(null," PIN enter doesn't match");
			}
			
		
		
	}else if(ae.getSource()==b2)
	{
		new Transaction(pin).setVisible(true);
		setVisible(false);
	}
	}catch(Exception e) {
		System.out.println(e);
	}
}
public static void main(String[] args) {
	new Pin("");
}
}
