package ASimulatorSystem;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {
JLabel l;
JButton b1,b2,b3,b4,b5,b6,b7;
String pin;
Transaction(String pin){
	super("Transaction");
	this.pin=pin;
	
	l=new JLabel("Please Select Your Transaction");
	b1=new JButton("DEPOSIT");
	b2=new JButton("CASH WITHDRAWL");
//	b3=new JButton("FAST CASH");
	//b4=new JButton("MINI STATEMENT");
	b5=new JButton("PIN CHANGE");
	b6=new JButton("BALANCE ENQUIRY");
	b7=new JButton("EXIT");
	add(l);
	add(b1);
	add(b2);
//	add(b3);
//	add(b4);
	add(b5);
	add(b5);
	add(b6);
	add(b7);
	l.setBounds(170,40,300,40);
	b1.setBounds(60,120,200,40);

	b2.setBounds(280,120,200,40);

	//b3.setBounds(60,140,200,40);

//	b4.setBounds(280,140,200,40);

	b5.setBounds(60,170,200,40);

	b6.setBounds(280,170,200,40);
	b7.setBounds(220,250,100,40);
	b1.addActionListener(this);
	b7.addActionListener(this);
	b5.addActionListener(this);
	b2.addActionListener(this);
	b6.addActionListener(this);
setLayout (null);
setSize(500,600);
setVisible(true);

	
}

@Override
public void actionPerformed(ActionEvent ae) {
try {
	if(ae.getSource()==b7) {
		System.exit(0);
	}else if(ae.getSource()==b1) {
		new Deposit(pin).setVisible(true);
		setVisible(false);
	
	}else if(ae.getSource()==b2) {
		new Withdrawl(pin).setVisible(true);
		setVisible(false);
	}else if(ae.getSource()==b6) {
		new Balance(pin).setVisible(true);
		setVisible(false);
	}else if(ae.getSource()==b5) {
		new Pin(pin).setVisible(true);
		setVisible(false);
	}
}catch(Exception e) {
	System.out.println(e);
}
}
	public static void main(String[] args) {
		new Transaction("");
	
}
}
