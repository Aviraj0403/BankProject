package AviBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    String cardno;
    Transactions transFrame;
    mbank mbankFrame;
    Pin pFrame;
    FastCash fcFrame;
    BalanceEnquiry beFrame;
    MiniStatement miniStatementFrame;
    Withdrawl withdrawalFrame;
    Deposit depositFrame;
    public Transactions(String pin){
        if (transFrame!= null) {
            transFrame.setVisible(false);
        }
        transFrame = this;
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);
        
        l1 = new JLabel("Please Select Your Transaction");
        l1.setBounds(235,400,700,35);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        image.add(l1);
        
       
        b1 = new JButton("DEPOSIT");
        b1.setBounds(170,499,150,35);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(390,499,150,35);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(170,543,150,35);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(390,543,150,35);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(170,588,150,35);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(390,588,150,35);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(390,633,150,35);
        b7.addActionListener(this);
        image.add(b7);
        
        setLayout(null);


        
        setSize(960,1080);
        setLocation(500,0);
//        5040936028997858
//        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            this.setVisible(false);
            if (depositFrame == null) {
                depositFrame = new Deposit("");
            }
            depositFrame.setVisible(true);
        }else if(ae.getSource()==b2){ 
            this.setVisible(false);
            if (withdrawalFrame == null) {
                withdrawalFrame = new Withdrawl(pin);
            }
            withdrawalFrame.setVisible(true);
        }else if(ae.getSource()==b3){ 
            this.setVisible(false);
            if(fcFrame==null)
            {
               fcFrame= new FastCash(pin);

            }

                fcFrame.setVisible(true);


        }else if(ae.getSource()==b4){
            this.setVisible(false);
//            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            if(miniStatementFrame==null)
            {
                miniStatementFrame=new MiniStatement(pin);
            }

                miniStatementFrame.setVisible(true);

        }else if(ae.getSource()==b5){ 
            this.setVisible(false);
            if(pFrame==null)
            {
                pFrame=new Pin(pin);
            }

                pFrame.setVisible(true);


        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            if(beFrame==null)
            {
                beFrame=new BalanceEnquiry(pin);
            }

                beFrame.setVisible(true);


//            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }else if(ae.getSource()==b7){ 
            this.setVisible(false);
            if (mbankFrame == null) {
                mbankFrame = new mbank(pin);
            }
                mbankFrame.setVisible(true);

//            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        }
    }
    
    public static void main(String[] args){
       Transactions transFrame= new Transactions("");
        transFrame.setVisible(true);
//        new mbank("").setVisible(true);
    }
}