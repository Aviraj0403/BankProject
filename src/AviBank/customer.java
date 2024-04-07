package AviBank;

//import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class customer extends JFrame implements ActionListener{

    JTable table;
    Choice ch;
    JButton search, print, update, back;

//    String pin;
    UpdateCust upCFrame;
    mbank mbankFrame;
    customer customerFrame;
    String pin;
    public customer(String pin) {
        if (customerFrame!= null) {
            customerFrame.setVisible(false);
        }
        customerFrame = this;
        this.pin = pin;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchlbl = new JLabel("Search by Name");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);

        ch = new Choice();
        ch.setBounds(180, 20, 150, 20);
        add(ch);

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from signup");
            while(rs.next()) {
                ch.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from signup");
//            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1521, 725);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("PrintOut");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

//        setSize(900, 700);
        GraphicsDevice fullframe = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        fullframe.setFullScreenWindow(this);
        setLocation(0, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from signup where name = '"+ch.getSelectedItem()+"'";
            try {
                Conn c1 = new Conn();
                ResultSet rs = c1.s.executeQuery(query);
//                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            if(upCFrame==null)
            {
                new UpdateCust(ch.getSelectedItem());
            }
            upCFrame=new UpdateCust(ch.getSelectedItem());
        } else if(ae.getSource()==back)
        {
            this.setVisible(false);
            if(mbankFrame==null)
            {
                mbankFrame=new mbank(pin);
            }
            mbankFrame.setVisible(true);
        }

//        else {
//            setVisible(false);
//            if(mbankFrame==null)
//            {
//                mbankFrame=new mbank("");
//            }
//            mbankFrame.setVisible(true);
//        }
    }

    public static void main(String[] args) {

        customer customerFrame=new customer("");
        customerFrame.setVisible(true);
    }
}
