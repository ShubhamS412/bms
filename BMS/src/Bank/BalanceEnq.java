package Bank;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class BalanceEnq extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;

    BalanceEnq(String pin) {
    	 setTitle("BALANCE ENQUIRY");
    	 this.pin = pin;
    
         JLabel l3 = new JLabel();
         l3.setBounds(0, 0, 660, 880);
        add(l3);

         l1 = new JLabel();
         l1.setForeground(Color.BLACK);
         l1.setFont(new Font("System", Font.BOLD, 16));

         b1 = new JButton("BACK");
         
         setLayout(null);

         l1.setBounds(190, 350, 400, 35);
         add(l1);

         b1.setBounds(260, 633, 150, 35);
         add(b1);
         int balance = 0;
         try{
        	 String pinn=JOptionPane.showInputDialog("Enter Pin");
             Conn c1 = new Conn();
             ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinn+"'");
             while (rs.next()) {
                 if (rs.getString("mode").equals("Deposit")) {
                     balance += Integer.parseInt(rs.getString("amount"));
                 } else {
                     balance -= Integer.parseInt(rs.getString("amount"));
                 }
             }
         }catch(Exception e){}
         
         l1.setText("Your Current Account Balance is Rs "+balance);

         b1.addActionListener(this);
         
         
         setSize(660, 880);
        
         setLocation(300, 0);
        
         setVisible(true);
     }


    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnq("").setVisible(true);
    }
}
