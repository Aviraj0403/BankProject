package AviBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mbank extends JFrame implements ActionListener {

    MiniStatement miniStatementFrame;
    Withdrawl withdrawalFrame;
    Deposit depositFrame;
    BalanceEnquiry beFrame;
    FastCash fcFrame;
    Pin pFrame;
    Signup sFrame;
    Signup2 s2Frame;
    Signup3 s3Frame;
    UpdateCust upCFrame;
    BankBot bankBotFrame;
    customer customerFrame;
    Login loginFrame;
    mbank mbankFrame;
    Transactions transFrame;

 JButton atm;
 JButton c1;
 JButton c2;
 JButton c3;
 JButton chatBot;
 JButton custDet;
 JButton  exitToBank ,user,signout,signin;
 JTextField tf1;
 JPasswordField pf2;
 String pin;
// MiniStatement ms= new MiniStatement("");
// Withdrawl w=new Withdrawl("");
// Deposit d= new Deposit("");

    public mbank(String pin) {
        if (mbankFrame != null) {
            mbankFrame.setVisible(false);
        }
        mbankFrame = this;
        this.pin = pin;

        setTitle("Laxmi chit Fund");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AviBank/icons/mbank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1860, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1536, 864);
        add(image);
//        setLayout(null);

        atm = new JButton("ATM");
        atm.setBackground(Color.BLACK);
        atm.setForeground(Color.WHITE);
        atm.setFont(new Font("Arial", Font.BOLD, 14));
        atm.setBounds(20,480,100,30);
        atm.addActionListener(this);
        image.add(atm);

        custDet = new JButton("Customer Details");
        custDet.setBackground(Color.BLACK);
        custDet.setForeground(Color.WHITE);
        custDet.setFont(new Font("Arial", Font.BOLD, 14));
        custDet.setBounds(210,445,270,30);
        custDet.addActionListener(this);
        image.add(custDet);

        c1 = new JButton("Transaction ");
        c1.setBackground(Color.BLACK);
        c1.setForeground(Color.WHITE);
        c1.setFont(new Font("Arial", Font.BOLD, 14));
        c1.setBounds(563,720,167,40);
        c1.addActionListener(this);
        image.add(c1);

        c2 = new JButton(" Withdrawal ");
        c2.setBackground(Color.BLACK);
        c2.setForeground(Color.WHITE);
        c2.setFont(new Font("Arial", Font.BOLD, 14));
        c2.setBounds(743,720,167,40);
        c2.addActionListener(this);
        image.add(c2);

        c3 = new JButton("Deposit ");
        c3.setBackground(Color.BLACK);
        c3.setForeground(Color.WHITE);
        c3.setFont(new Font("Arial", Font.BOLD, 14));
        c3.setBounds(921,720,167,40);
        c3.addActionListener(this);
        image.add(c3);

        chatBot = new JButton("HelpDesk ");
        chatBot.setBackground(Color.BLACK);
        chatBot.setForeground(Color.WHITE);
        chatBot.setFont(new Font("Arial", Font.BOLD, 14));
        chatBot.setBounds(1250,516,150,30);
        chatBot.addActionListener(this);
        image.add(chatBot);

        exitToBank = new JButton("Exit TO BANK ");
        exitToBank.setBackground(Color.BLACK);
        exitToBank.setForeground(Color.WHITE);
        exitToBank.setFont(new Font("Arial", Font.BOLD, 14));
        exitToBank.setBounds(1370,85,150,30);
        exitToBank.addActionListener(this);
        image.add( exitToBank);

        signin = new JButton("Login User ");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setFont(new Font("Arial", Font.BOLD, 14));
        signin.setBounds(2,85,150,30);
        signin.addActionListener(this);
        image.add(signin);

        signout = new JButton("Log-Out ");
        signout.setBackground(Color.BLACK);
        signout.setForeground(Color.WHITE);
        signout.setFont(new Font("Arial", Font.BOLD, 14));
        signout.setBounds(1370,120,150,30);
        signout.addActionListener(this);
        image.add(signout);


//        user = new JButton(" ");
//        exitToBank.setBackground(Color.BLACK);
//        exitToBank.setForeground(Color.WHITE);
//        exitToBank.setFont(new Font("Arial", Font.BOLD, 14));
//        exitToBank.setBounds(1370,85,150,30);
//        exitToBank.addActionListener(this);
//        image.add( exitToBank);

        getContentPane().setBackground(Color.WHITE);

        GraphicsDevice fullframe = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        fullframe.setFullScreenWindow(this);
//        setSize(850,800);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setDefaultCloseOperation(HIDE_ON_CLOSE);
//        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try{    if(ae.getSource()==chatBot)
               {

                   this.setVisible(false);
                   if (bankBotFrame == null) {
                       bankBotFrame = new BankBot(pin);
                   }
                   bankBotFrame.setVisible(true);
               }
               else if(ae.getSource()==atm){
                    this.setVisible(false);
                    if(transFrame==null)
                      {
                        transFrame= new Transactions(pin);
                      }
                      transFrame.setVisible(true);
                    }
                else if(ae.getSource()==custDet) {
            this.setVisible(false);
            if (customerFrame == null) {
                customerFrame = new customer(pin);
            }
            customerFrame.setVisible(true);
            }
                else if(ae.getSource()==signout) {
                  this.setVisible(false);
//                  this.dispose();
                  }
                else if(ae.getSource()==c1){
                     this.setVisible(false);
            if (miniStatementFrame == null) {
                miniStatementFrame = new MiniStatement(pin);
            }
            miniStatementFrame.setVisible(true);
              }
        else if (ae.getSource() == c2) {
            this.setVisible(false);
            if (withdrawalFrame == null) {
                withdrawalFrame = new Withdrawl(pin);
            }
            withdrawalFrame.setVisible(true);
        }
        else if (ae.getSource() == c3) {
            this.setVisible(false);
            if (depositFrame == null) {
                depositFrame = new Deposit(pin);
            }
            depositFrame.setVisible(true);
        }
                else if(ae.getSource()==signin) {
                   this.setVisible(false);
                   new Login(pin).setVisible(true);
                  }
                  else if(ae.getSource()==exitToBank) {
                    System.exit(0);
                }
            }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

       mbank mbankFrame= new mbank("");
        mbankFrame.setVisible(true);


    }
}