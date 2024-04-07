
package AviBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1;
    JButton b1,b2,b3;
    JLabel l1;
    String pin;
    mbank mbankFrame;
    Transactions transFrame;
    Deposit depositFrame;
    public Deposit(String pin){
        if (depositFrame!= null) {
            depositFrame.setVisible(false);
        }
        depositFrame = this;
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190,350,400,35);
        l3.add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(190,420,320,25);
        l3.add(t1);


        b1 = new JButton("DEPOSIT");
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
        
        setLayout(null);

        setSize(960,1080);
//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date1 = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bank_det values('"+pin+"', '"+date1+"',  'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    this.setVisible(false);
                    if (transFrame == null) {
                        transFrame = new Transactions(pin);
                    }
                        transFrame.setVisible(true);
                }
            }else if(ae.getSource()==b2){
                this.setVisible(false);
                if (transFrame == null) {
                    transFrame = new Transactions(pin);
                }
                    transFrame.setVisible(true);

            }
            else if(ae.getSource()==b3) {
                this.setVisible(false);
                if(mbankFrame==null)
                {
                    mbankFrame=new mbank(pin);
                }
                    mbankFrame.setVisible(true);

            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){

        Deposit depositFrame=new Deposit("");
        depositFrame.setVisible(true);
    }
}