 package AviBank;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.sql.ResultSet;


public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1, b2;
    JLabel l1,l4;
    static String pin;
    mbank mbankFrame;
    Transactions transFrame;
    MiniStatement miniStatementFrame;
  public  MiniStatement(String pin){
        super("Mini Statement");
      if (miniStatementFrame != null) {
          miniStatementFrame.setVisible(false);
      }
      miniStatementFrame = this;
      this.pin = pin;

        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
        l1 = new JLabel();
        add(l1);
        
        JLabel l2 = new JLabel("State Bank of India ");
        l2.setBounds(140, 20, 150, 20);
        add(l2);

        //transaction history
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);

        //showBalance below the page
        l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}

        l3.setBounds(20,40,400,200);
        try{
            int balance = 0;

            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank_det where pin = '"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date1")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
//                    l4.setText("Your total Balance is Rs "+balance);
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));

                }
            }
            l4.setText("Your total Balance is Rs "+balance);
//            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
//        try{
//            // Calculate the initial balance from the login table
//            Conn c1= new Conn();
//            ResultSet loginRs = c1.s.executeQuery("SELECT * FROM bank_det where pin = '"+pin+"'");
//            if (loginRs.next()) {
//                int initialBalance = Integer.parseInt(loginRs.getString("amount"));
////                balance += initialBalance;
//                l4.setText("Your total Balance is Rs "+initialBalance);
//            }
//
////            l4.setText("Your total Balance is Rs "+initialBalance);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        setLayout(null);
//        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        b1 = new JButton("Back To ATM");
        add(b1);

        b1.addActionListener(this);
        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 150, 25);

        b2 = new JButton("Back To Home");
        b2.setBounds(220,500,150,25);
        b2.addActionListener(this);
        add(b2);
    }
    public void actionPerformed(ActionEvent ae) {
//        String pin = null;
        if (ae.getSource() == b2) {
            this.setVisible(false);
            if(mbankFrame==null)
            {
            mbankFrame=new mbank(pin);
           }

                mbankFrame.setVisible(true);

        } else if (ae.getSource() == b1) {
            this.setVisible(false);
            if (transFrame == null) {
                transFrame = new Transactions(pin);
            }
                transFrame.setVisible(true);
        }
        }

    public static void main(String[] args){

        MiniStatement miniStatementFrame =new MiniStatement(pin);
        miniStatementFrame.setVisible(true);
    }
    
}
