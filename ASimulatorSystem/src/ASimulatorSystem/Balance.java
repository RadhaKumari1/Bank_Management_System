package ASimulatorSystem;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
class Balance extends JFrame implements ActionListener {

    
    JButton b1;
    JLabel l1,  l3;
    String pin;

    Balance(String pin) {
        this.pin = pin;

    
        JLabel l3 = new JLabel();
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        l1 = new JLabel();
     //   l1.setForeground(Color.WHITE);
    //    l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);
        b1.addActionListener(this);
        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);

        b1.setBounds(390, 633, 150, 35);
        l3.add(b1);
   //     int balance1 = 0;
        try{
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
            double t=0;
       	 while (rs.next()) {
             
			 if(rs.getString("deposit")!=null) {
                    t+= Double.parseDouble(rs.getString("deposit"));
                } 
			 if(rs.getString("withdraw")!=null){
                    t -= Double.parseDouble(rs.getString("withdraw"));
                }
		 }
            
       
          l1.setText("Your Current Account Balance is Rs "+t);

            
                }catch(Exception e){}
        

     

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new Balance("").setVisible(true);
    }
}

