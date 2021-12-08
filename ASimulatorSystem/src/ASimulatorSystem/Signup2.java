package ASimulatorSystem;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class Signup2 extends JFrame implements ActionListener {
	JRadioButton r1,r2,r3,r4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,t1;
	JButton b1,b2;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;

	String formNo;
	Signup2(String formNo){
		super("NEW ACCOUNT APPLICATION FORM-PAGE 2");
		this.formNo=formNo;
	r1	=new JRadioButton("Saving Account");
	r2	=new JRadioButton("Fixed Deposit Account");
	r3	=new JRadioButton("Current Account");
	r4	=new JRadioButton("Recurring Deposit Account");
	
	l1=new JLabel("Page 2: Account Details");
	l2=new JLabel("Account Type:");
	l3=new JLabel("Card Number:");
	l4=new JLabel("XXXX-XXXX-XXXX-4184");
	l5=new JLabel("(Your  16-digit card number)");
	l7=new JLabel("PIN:");
	l8=new JLabel("XXXX");
	l9=new JLabel("(4-digit Password)");
	l10=new JLabel("Services Required:");
	l11=new JLabel("Form No:");
	l6=new JLabel("It would appear on ATM card/cheque Book and Statements");
	
	r1.setBackground(Color.white);
	r2.setBackground(Color.white);
	r3.setBackground(Color.white);
	r4.setBackground(Color.white);
	b1=new JButton("Submit");
	b1.setBackground(Color.black);
	b1.setForeground(Color.white);
	
	b2=new JButton("Cancel");
	b2.setBackground(Color.black);
	b2.setForeground(Color.white);

	c1=new JCheckBox("ATM Card");
c1.setBackground(Color.white);
c2=new JCheckBox("Internet Banking");
c2.setBackground(Color.white);
c3=new JCheckBox("Mobile Banking");
c3.setBackground(Color.white);
c4=new JCheckBox("EMAIL Alerts");
c4.setBackground(Color.white);
c5=new JCheckBox("Cheque Book");
c5.setBackground(Color.white);
c6=new JCheckBox("E-Statements");
c6.setBackground(Color.white);
c7=new JCheckBox("I hereby declare that the above enter details correct to the best of my knowledge.",true);
c7.setBackground(Color.white);

t1=new JLabel (formNo);
setLayout (null);
add(r1);
add(r2);
add(r3);
add(r4);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(l9);
add(l10);
add(l11);

add(b1);
add(b2);

add(c1);
add(c2);
add(c3);
add(c4);
add(c5);
add(c6);
add(c7);

add(t1);
b1.addActionListener(this);
b2.addActionListener(this);

l1.setBounds(350,20,200,40);
l2.setBounds(60,60,200,40);
r1.setBounds(60,100,200,40);
r2.setBounds(280,100,200,40);
r3.setBounds(60,140,200,40);
r4.setBounds(280,140,300,40);
l3.setBounds(60,190,200,30);
l4.setBounds(280,190,200,30);
l5.setBounds(60,220,200,30);
l6.setBounds(280,220,200,30);
l7.setBounds(60,280,200,30);
l8.setBounds(280,280,200,40);
l9.setBounds(60,310,200,30);
l10.setBounds(60,360,200,40);
c1.setBounds(60,400,200,40);
c2.setBounds(280,400,200,40);
c3.setBounds(60,440,200,40);
c4.setBounds(280,440,200,40);
c5.setBounds(60,480,200,40);
c6.setBounds(280,480,200,40);
c7.setBounds(60,530,300,40);
b1.setBounds(150,580,150,50);
b2.setBounds(350,580,150,50);
l11.setBounds(740,10,60,40);

t1.setBounds(800,10,50,40);
getContentPane().setBackground(Color.white);
setSize(900,800);
setVisible(true);

}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String  a=null;
		if(r1.isSelected())
			a="Saving Account";
		else if(r2.isSelected())
			a="Fixed Deposit Account";
		else if(r3.isSelected())
			a="Current Account";
		else if(r4.isSelected())
			a="Recurring Deposit Account";
		
		Random ran=new Random();
		long first7=(ran.nextLong()&90000000L)+2034366000000000L;
		String first8=""+Math.abs(first7);
		long first3=(ran.nextLong()&9000L)+1000L;
		String  first4=""+Math.abs(first3);
		String b="";
		if(c1.isSelected())
			b=b+"ATM Card";
		else if(c2.isSelected())
			b=b+"Internet Banking";
		else if(c3.isSelected())
			b=b+"Mobile Banking";
		else if(c4.isSelected())
			b=b+"EMAIL Alerts";
		else if(c5.isSelected())
			b=b+"Cheque Book";
		else if(c6.isSelected())
			b=b+"E-Statements";
	
	try {
		if(ae.getSource()==b1) {
			if(b.equals("")) {
				JOptionPane.showMessageDialog(null,"Fill all the required Fields");
			}else {
				conn c1=new conn();
				String q1="insert into Signup2 values ('"+formNo+"','"+a+"','"+first8+"','"+first4+"','"+b+"')";
				String q2="insert into login values ('"+first8+"','"+first4+"')";
		
				c1.s.executeUpdate(q1);
				c1.s.executeUpdate(q2);
				JOptionPane.showMessageDialog(null,"Card number:"+first8+"\nPin:"+first4);
				new Deposit(first4).setVisible(true);
				setVisible(false);
				
			}
		}
			else if(ae.getSource()==b2)
			{
				System.exit(0);
			}
		
		
	}catch(Exception e) {
		System.out.println(e);
	}

		
	}
	public static void main(String[] args) {
		new Signup2("");
	}

}
