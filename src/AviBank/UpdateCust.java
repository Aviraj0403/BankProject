package AviBank;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCust extends JFrame implements ActionListener{

    JTextField tffno, tfname, tffname, tfdob,tfgender, tfpincode, tfmarital, tfaadhar, tfemail, tfcity, tfstate, tfaddress;
    JLabel lbFormno,labelname,labeldob;
    JButton add, back;
   static String name;
   JDateChooser dateChooser;
   UpdateCust upCFrame;
   Transactions transFrame;
   customer customerFrame;
   mbank mbankFrame;
   String pin;

//   String name;
   public UpdateCust(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        lbFormno = new JLabel("Form no.");
        lbFormno.setBounds(400, 100, 150, 30);
//        lbFormno.setFont(new Font(name "BOLD"));
        lbFormno.setFont(new Font("serif", Font.BOLD, 30));
        add(lbFormno);

//        tffno = new JTextField();
//        tffno.setBounds(200, 150, 150, 30);
//        add(tffno);


        labelname = new JLabel("Name");
        labelname.setBounds(50, 180, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 180, 150, 30);
        add(tfname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(50, 210, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(200, 210, 150, 30);
        add(tffname);


        dateChooser = new JDateChooser();


        labeldob = new JLabel("Date of Birth:");
        labeldob.setBounds(50,240,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        dateChooser.setBounds(200, 240, 150, 30);
        add(labeldob);
        add(dateChooser);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 270, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 270, 150, 30);
        add(tfaddress);



        JLabel labelcity = new JLabel("City");
        labelcity.setBounds(400, 150, 150, 30);
        labelcity.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcity);

        tfcity= new JTextField();
        tfcity.setBounds(500,150,150,30);
        add(tfcity);




        JLabel labelmar = new JLabel("Marital");
        labelmar.setBounds(400, 180, 150, 30);
        labelmar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelmar);

        tfmarital = new JTextField();
        tfmarital.setBounds(500, 180, 150, 30);
        add(tfmarital);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(400, 210, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(500, 210, 150, 30);
        add(tfemail);

        JLabel labelpc = new JLabel("PinCode");
        labelpc.setBounds(400, 240, 150, 30);
        labelpc.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpc);

        tfpincode = new JTextField();
        tfpincode.setBounds(500, 240, 150, 30);
        add(tfpincode);


        JLabel labelstate = new JLabel("State");
        labelstate.setBounds(400, 270, 150, 30);
        labelstate.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelstate);

        tfstate = new JTextField();

        tfstate.setBounds(500, 270, 150, 30);
        add(tfstate);




        try {
            Conn c1 = new Conn();
            String query = "select * from signup where name = '"+name+"'";
            ResultSet rs = c1.s.executeQuery(query);
            while(rs.next()) {
                lbFormno.setText(rs.getString("formno"));
                labelname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
//
                tfemail.setText(rs.getString("email"));
                tfmarital.setText(rs.getString("marital"));
                tfaddress.setText(rs.getString("address"));

                tfcity.setText(rs.getString("city"));
                tfpincode.setText(rs.getString("pincode"));
//
                tfstate.setText(rs.getString("State"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setBounds(250, 450, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 450, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String address = tfaddress.getText();
            String  dob= tfdob.getText();
            String email = tfemail.getText();
            String city = tfcity.getText();
            String pincode = tfpincode.getText();
            String marital=tfmarital.getText();

            try {
                Conn conn1 = new Conn();
                String query = "update signup set fname = '"+fname+"', dob = '"+dob+"', address = '"+address+"', city = '"+city+"', name =  '"+name+"',email =  '"+email+"', pincode = '"+pincode+"', marital = '"+marital+"' where formno = '"+name+"'";
                conn1.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                if(mbankFrame==null)
                {
                    mbankFrame=new mbank(pin);
                }
                mbankFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource()==back){
            setVisible(false);
            if(customerFrame==null)
            {
                customerFrame=new customer(pin);
            }
            customerFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        UpdateCust upCFrame=new UpdateCust("");
        upCFrame.setVisible(true);
    }
}
