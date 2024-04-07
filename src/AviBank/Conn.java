package AviBank;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","834");
            s=c.createStatement();

//         System.out.println("hello");
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  