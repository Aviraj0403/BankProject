package AviBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    static String pin;
    static Login user;
    public Login(String pin){
        setTitle("Welcome the Atm");
        if (user != null) {
            user.setVisible(false);
        }
        user = this;
        this.pin = pin;

        //add icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(500, 20, 100, 100);
        add(l4);

        //cardicon
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(1330,700,200,150);
        add(iimage);


        //titile
        l1 = new JLabel("Laxmi Chit Fund");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setForeground(Color.WHITE);
        l1.setBounds(650,50,450,40);
        add(l1);

        //card
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setForeground(Color.WHITE);
        l2.setBounds(525,200,375,30);
        add(l2);

        //cardtf
        tf1 = new JTextField(15);
        tf1.setBounds(655,200,250,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);

        //pinlabel
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setForeground(Color.WHITE);
        l3.setBounds(525,260,375,30);
        add(l3);
        //passfield
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(655,260,250,30);
        add(pf2);

        //signButtton
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(655,330,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(805,330,100,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(655,380,250,30);
        b3.addActionListener(this);
        add(b3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(1560,880,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,1536,834);
        add(iiimage);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        GraphicsDevice fullframe = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        fullframe.setFullScreenWindow(this);
//        setSize(800,480);
        setLocation(0,0);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);

                    new mbank(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }
            //clear
            else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }
            //signup
            else if(ae.getSource()==b3){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        new Login(pin).setVisible(true);
    }

    
}



