package ASimulatorSystem;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class Signup extends JFrame implements ActionListener {
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
JTextField t1,t2,t3,t4,t5,t6,t7;
JRadioButton r1,r2,r3,r4,r5;
JButton b;
@SuppressWarnings("rawtypes")
JComboBox c1,c2,c3;
Random ran=new Random();
long first4 =(ran.nextLong() & 9000L)+1000L;
long first=Math.abs(first4);
@SuppressWarnings({ "unchecked", "rawtypes" })
Signup(){
	super("                                                       NEW ACCOUNT APPLICATION FORM");

	l1=new JLabel("APPLICATION FORM NO. "+first);
	l2=new JLabel("Page 1: Personal Details");
	l3=new JLabel("Name :");
	l4=new JLabel("Father's Name :");
	l5=new JLabel("Date Of Birth");
	l6=new JLabel("Gender:");
	l7=new JLabel("Email Address:");
	l8=new JLabel("Martial Status :");
	l9=new JLabel("Address :");
	l10=new JLabel("City :");
	l11=new JLabel("Pin Code :");
	l12=new JLabel("State :");

	
	t1=new JTextField();
	t2=new JTextField();
	t3=new JTextField();
	t4=new JTextField();
	t5=new JTextField();
	t6=new JTextField();
	t7=new JTextField();
	
	b=new JButton("Next");
	b.setBackground(Color.BLACK);
	b.setForeground(Color.WHITE);
	
	r1=new JRadioButton("Male");
	r1.setBackground(Color.WHITE);
	r2=new JRadioButton("Female");
	r2.setBackground(Color.WHITE);
	r3=new JRadioButton("Married");
	r3.setBackground(Color.WHITE);
	r4=new JRadioButton("Unmarried");
	r4.setBackground(Color.WHITE);
	r5=new JRadioButton("Other");
	r5.setBackground(Color.WHITE);
	String date[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	c1=new JComboBox(date);
			String month[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};
			c2=new JComboBox(month);
			String  year[]= {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1998","1999","2000","2001","2002"};
			c3=new JComboBox(year);
			setLayout(null);
			c1.setBackground(Color.WHITE);
			c2.setBackground(Color.WHITE);
			c3.setBackground(Color.WHITE);
			l1.setFont(new Font("Raleway",Font.BOLD,14));
			l1.setBounds(270,20,250,50);
			l2.setBounds(300,60,200,50);
			l3.setBounds(60,120,200,50);
			l4.setBounds(60,180,200,40);
			l5.setBounds(60,230,200,40);
			l6.setBounds(60,280,200,40);
			l7.setBounds(60,330,200,40);
			l8.setBounds(60,380,200,40);
			l9.setBounds(60,430,200,40);
			l10.setBounds(60,480,200,40);
			l11.setBounds(60,530,200,40);
			l12.setBounds(60,580,200,30);
		
			
			t1.setBounds(200,120,300,40);
			t2.setBounds(200,170,300,40);
			r1.setBounds(200,270,80,50);
			r2.setBounds(300,270,80,50);
			c1.setBounds(200,220,100,40);

			c2.setBounds(320,220,100,40);

			c3.setBounds(450,220,100,40);


			t3.setBounds(200,320,300,40);
			
			t4.setBounds(200,420,300,40);
			r3.setBounds(200,370,80,40);
			r4.setBounds(300,370,100,40);
			r5.setBounds(420,370,80,40);
			t5.setBounds(200,470,300,40);
			t6.setBounds(200,520,300,40);
			t7.setBounds(200,570,300,40);
			b.setBounds(300,700,100,40);
			add(l1);
			add(l2);

			add(l3);

			add(l4);

			//add(l1);

			add(l5);

			add(l6);

		//	add(l1);

			add(l7);

			add(l8);

			add(l9);

			add(l10);

			add(l11);

			add(l12);

			
			//add(l1);
add(r1);
add(r2);
add(r3);
add(r4);
add(r5);
add(c1);
add(c2);
add(c3);
		
									add(t1);
									add(t2);
									add(t3);
									add(t4);
									add(t5);
									add(t6);
									add(t7);
									add(b);
									b.addActionListener(this);
getContentPane().setBackground(Color.white);
									setSize(700,900);
									setVisible(true);
									


}
public void actionPerformed(ActionEvent ae) {
	String a=t1.getText();
	String b=t2.getText();
	String ac=(String)c1.getSelectedItem();
	String bc=(String)c2.getSelectedItem();
	String cc=(String)c3.getSelectedItem();
	String d=null;
	if(r1.isSelected())
		d="Male";
	else 	if(r2.isSelected())
			d="Female";
	String e=t3.getText();
	String f=null;
		if(r3.isSelected())
		f="Married";
	else 	if(r4.isSelected())
		f="Unmarried";
	else 	if(r5.isSelected())
		f="Other";
	
	String g=t4.getText();
	String h=t5.getText();

	String j=t7.getText();
	String i=t6.getText();
	String k=""+first;
	try {
		if(t6.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Fill all the required fields");
		}else {
			conn c1=new conn();
			String q1="insert into Signup values('"+k+"','"+a+"','"+b+"','"+ac+"','"+bc+"','"+cc+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"')";
	c1.s.executeUpdate(q1);
	new Signup2(k).setVisible(true);
	setVisible(false);
		
		}
	}catch(Exception ex) {
		System.out.println(ex);
	}
}
public static void main(String[] args) {
	new Signup().setVisible(true);
}
}
