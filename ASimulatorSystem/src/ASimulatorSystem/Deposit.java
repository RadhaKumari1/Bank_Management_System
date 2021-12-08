package ASimulatorSystem;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JButton b1,b2,b3;
	String pin;
	Deposit(String pin){
		super("                                                                                   DEPOSIT");
		this.pin=pin;
		
		l1=new JLabel("Enter Pin ");
		l2=new JLabel("ENTER AMOUNT YOU WANT");
		l3=new JLabel("TO DEPOSIT");
		
		t1=new JTextField();
		t2=new JTextField();
		 b1=new JButton("DEPOSIT");
		 b2=new JButton("BACK");
     b3=new JButton("EXIT");
     setLayout(null);
     add(l1);
     add(l2);
     add(l3);
     add(t1);
     add(t2);
   //  add(t3);
     add(b1);
     add(b2);
     add(b3);
     l1.setBounds(300,10,80,30);
     l2.setBounds(70,60,400,30);
  l3.setBounds(90,90,80,30);

     t2.setBounds(80,130,250,40);

     t1.setBounds(380,10,60,40);

     b1.setBounds(90,200,100,40);

     b2.setBounds(200,200,100,40);
     b3.setBounds(150,260,100,40);
     b1.addActionListener(this);
     b2.addActionListener(this);
     b3.addActionListener(this);
getContentPane().setBackground(Color.white);
     setSize(500,400);
     setVisible(true);
     

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			String a=t1.getText();
			
			String b=t2.getText();
			if(ae.getSource()==b1) {
				if(t2.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit");
				}
				else {
					conn c1=new conn();

					//double balance=0;
			//		double e=Double.parseDouble(b);
				//	String q3="insert into bank values('"+a+"','"+e+"',null,'"+balance+"')";
			//		c1.s.executeQuery(q3);
									ResultSet rs=c1.s.executeQuery("Select * from bank where pin ='"+a+"'");
									double t=0;
									 while (rs.next()) {
							             //   if (rs.getString("mode").equals("deposit")) {
										 if(rs.getString("deposit")!=null) {
							                    t+= Double.parseDouble(rs.getString("deposit"));
							                } 
										 if(rs.getString("withdraw")!=null){
							                    t -= Double.parseDouble(rs.getString("withdraw"));
							                }
									 }
				
			
				
					
						
				
						double d=Double.parseDouble(b);
						
						t+=d;
						
						String q1="insert into bank values('"+a+"','"+d+"',null,'"+t+"')";
						c1.s.executeUpdate(q1);
						
				
					
					JOptionPane.showMessageDialog(null,"Rs. "+b+" Deposited Successfully");
					new Transaction(pin).setVisible(true);
					setVisible(false);
				}
				}else if(ae.getSource()==b2) {
					new Transaction(pin).setVisible(true);
					setVisible(false);
				}else if(ae.getSource()==b3) {
				System.exit(0);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new Deposit("");
	}

}
