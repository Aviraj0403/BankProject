
package AviBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    Transactions transFrame;
    mbank mbankFrame;
    Withdrawl withdrawalFrame;
    public Withdrawl(String pin){
        if (withdrawalFrame!= null) {
            withdrawalFrame.setVisible(false);
        }
        withdrawalFrame = this;
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190,350,400,20);
        l3.add(l1);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(190,450,330,30);
        l3.add(t1);
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(190,400,400,20);
        l3.add(l2);

        
        b1 = new JButton("WITHDRAW");
        b1.setBounds(390,588,150,35);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(390,633,150,35);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("Back to Home");
        b3.setBounds(190,633,150,35);
        b3.addActionListener(this);
        l3.add(b3);
        setLayout(null);
        

        
        setSize(960,1080);
        setLocation(500,0);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date1 = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    ResultSet rs = c1.s.executeQuery("select * from bank_det where pin = '"+pin+"'");
                    int bal = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit"))
                       {
                           bal=bal+ Integer.parseInt(rs.getString("amount"));
                       }
                       else{
                            bal=bal-Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(bal < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                     }
                    
                    c1.s.executeUpdate("insert into bank_det values('"+pin+"', '"+date1+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    this.setVisible(false);
                    if (transFrame == null) {
                        transFrame = new Transactions(pin);
                    }
                        transFrame.setVisible(true);
                     }
               }  else if (ae.getSource() == b2) {
                this.setVisible(false);
                if (transFrame == null) {
                    transFrame = new Transactions(pin);
                }
                    transFrame.setVisible(true);

                }
                else if(ae.getSource()==b3) {
                this.setVisible(false);
                if (mbankFrame == null) {
                    mbankFrame = new mbank(pin);
                }
                    mbankFrame.setVisible(true);

            }

        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){

       Withdrawl withdrawalFrame= new Withdrawl("");
        withdrawalFrame.setVisible(true);
    }
}
